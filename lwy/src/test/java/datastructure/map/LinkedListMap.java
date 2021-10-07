package datastructure.map;

import datastructure.map.service.MyMap;

import java.util.Random;

public class LinkedListMap<K, V> implements MyMap<K, V> {

    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {

        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    /**
     * 通过key 找到node结点
     *
     * @param key
     * @return
     */
    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            size++;
            dummyHead.next = new Node(key, value, dummyHead.next);
        } else {
            //如果已经存在包含该key的结点， 则修改value
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("doesn't exist~");
        }
        Node pre = dummyHead;
        while (pre != null) {
            if (pre.next.key == key) {
                break;
            }
            pre = pre.next;
        }
        pre.next = node.next;
        node.next = null;
        size--;
        return node.value;

    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException("The key didn't exist~");
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
        return getNode(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node node = dummyHead.next;
        while (node != null) {
            res.append("[" + node.key + ", " + node.value + "]" + "->");
            node = node.next;
        }
        res.append("NULL");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedListMap<Integer,Integer> map = new LinkedListMap<>();
        Random random = new Random(47);
        for (int i = 0;i<10;i++){
            map.add(i,random.nextInt(10));
        }
        System.out.println(map);
        map.remove(2);
        System.out.println(map);
    }
}
