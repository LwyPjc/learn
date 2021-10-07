package datastructure.map;

import datastructure.map.service.MyMap;

import java.util.Random;

public class BSTMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;

        }

        public Node() {

        }

    }

    private Node root;
    private int size;


    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (node.key.compareTo(key) < 0) {
            return getNode(node.right, key);
        } else if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else {
            return node;
        }
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (node.key.compareTo(key) < 0) {
            node.right = add(node.right, key, value);

        } else if (node.key.compareTo(key) > 0) {
            node.left = add(node.left, key, value);
        } else {
            //如果已经存在该键，则更新value值
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("doesn't exist~");
        }
        root = remove(node, key);
        return node.value;
    }

    private Node remove(Node node, K key) {
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            return node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            return node;
        } else {//key.compareTo(node.key) == 0
            if (node.left == null) {
                Node rightNode = node.right;
                size--;
                node.right = null;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                size--;
                node.left = null;
                return leftNode;
            }

            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    /**
     * 查找map中键 最小元素
     *
     * @param node
     * @return
     */
    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);

    }

    public Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            size--;
            node.right = null;
            return rightNode;
        }
       node.left = removeMin(node.left);
        return node;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException("doesn't exist~");
        }
        node.value = newValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contain(K key) {
        return getNode(root, key) != null;
    }

   public void preOrder(){
        preOrder(root);
   }
   private void preOrder(Node node){
        if (node==null){
            return;
        }
       System.out.println("key = "+node.key+", value = "+node.value);
        preOrder(node.left);
        preOrder(node.right);
   }

    public static void main(String[] args) {
        BSTMap<Integer, Integer> map = new BSTMap<>();
        int[] arr = {5, 4, 8, 3, 2};

        for (int i = 0; i < 5; i++) {
            map.add(arr[i], new Random().nextInt(10));
        }
       map.preOrder();
        map.removeMin(map.root);
        System.out.println("----------------");
        map.preOrder();

    }
}
