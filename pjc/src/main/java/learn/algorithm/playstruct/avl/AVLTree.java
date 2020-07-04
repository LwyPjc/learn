package learn.algorithm.playstruct.avl;

import constants.CommonConstants;
import learn.algorithm.playstruct.setAndMap.BSTMap;
import learn.algorithm.playstruct.setAndMap.demo.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * AVL 树
 * 不平衡了
 * 1. 左侧的左侧 LL 进行右旋转
 * 2. 右侧的右侧 RR 进行左旋转
 * 3. 左侧的右侧 LR 其左节点 进行左旋转 变成 LL
 * 4. 右侧的左侧 RL 其右节点 进行右旋转 变成RR
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("all")
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        // 当前节点的高度
        public int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            // 叶子节点为1
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获得节点node的高度
     */
    private int getHeight(Node node) {
        if (node == null)
            return 0;
        return node.height;
    }

    /**
     * 获得节点node的平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    // 向二分搜索树中添加新的元素(key, value)
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    // 向以node为根的二分搜索树中插入元素(key, value)，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, K key, V value) {

        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0)
            node.left = add(node.left, key, value);
        else if (key.compareTo(node.key) > 0)
            node.right = add(node.right, key, value);
        else // key.compareTo(node.key) == 0
            node.value = value;

        // 更新height
        // 会先计算其子节点的高度
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            // 平衡因子大于1 需要做调整
//            System.out.println("unbalanced : " + balanceFactor);
            // 右旋 左旋

            // LL
            if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
                // 右旋 左侧的左侧多添加了一个节点
//                node = rightRotate(node);
                return rightRotate(node);
            }

            // RR
            if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
                // 左旋转 右侧的右侧
                return leftRotate(node);
            }

            // LR
            if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
                // 其左节点先进行左旋转 变成 LL这种情况
                node.left = leftRotate(node.left);
                // 再进行右旋转
                return rightRotate(node);
            }

            // RL
            if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
                // 其右节点先进行右旋转 变成 RR
                node.right = rightRotate(node.right);
                // 左旋转
                return leftRotate(node);
            }
        }

        return node;
    }

    /**
     * LL
     * 右旋转
     * // 对节点y进行向右旋转操作，返回旋转后新的根节点x
     * //        y                              x
     * //       / \                           /   \
     * //      x   T4     向右旋转 (y)        z     y
     * //     / \       - - - - - - - ->    / \   / \
     * //    z   T3                       T1  T2 T3 T4
     * //   / \
     * // T1   T2
     *
     * @param y
     * @return
     */
    private Node rightRotate(Node y) {
        // 节点位置变化
        Node result = y.left;
        y.left = result.right;
        result.right = y;
        // 高度 变化 更新x,y 的高度 先y 再 x
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        result.height = Math.max(getHeight(result.left), getHeight(result.right)) + 1;
        return result;
    }

    // RR
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T2 = x.left;

        // 向左旋转过程
        x.left = y;
        y.right = T2;

        // 更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node getNode(Node node, K key) {

        if (node == null)
            return null;

        if (key.equals(node.key))
            return node;
        else if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else // if(key.compareTo(node.key) > 0)
            return getNode(node.right, key);
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {

        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");

        node.value = newValue;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove(K key) {

        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key) {

        if (node == null)
            return null;

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else {   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode = rightNode;
            } else if (node.right == null) {
                // 待删除节点右子树为空的情况

                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode = leftNode;
            } else {
                // 待删除节点左右子树均不为空的情况

                // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
                // 用这个节点顶替待删除节点的位置
                Node successor = minimum(node.right);
                // removeMin 可能导致AVL平衡被破坏
            successor.right = remove(node.right,successor.key);
//                successor.right = removeMin(node.right);
                successor.left = node.left;

                node.left = node.right = null;

                retNode = successor;
            }
        }

        // 自平衡判断 操作 与添加操作一样

        // 当删除了叶子节点，retNode 为null了
        if (retNode == null)
            return null;
        // 更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        // 平衡维护
        // LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0)
            return rightRotate(retNode);
        // RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0)
            return leftRotate(retNode);
        // LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        // RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }

        return retNode;
    }

    /**
     * 判断一颗树是否是二分搜索树
     * 中序遍历 元素是有序的、
     *
     * @param args
     */
    public boolean isBST() {
        List<K> keys = new ArrayList<>();
        midOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param args
     */
    private void midOrder(Node node, List<K> list) {
        if (node == null) {
            return;
        }
        midOrder(node.left, list);
        list.add(node.key);
        midOrder(node.right, list);
    }

    /**
     * 是否为平衡二叉树
     *
     * @return
     */
    public boolean isBalanced() {
        return isBalancedVersion2(root);
    }

    /**
     * 递归
     * 判断node及其子节点的平衡因子是否大于1
     *
     * @param node
     */
//    private boolean isBalanced(Node node) {
//        boolean flag;
//        if (getBalanceFactor(node) > 1) {
//            return false;
//        } else if (isBalanced(node.left) && isBalanced(node.right)) {
//            return true;
//        }
//        return true;
//    }

    /**
     * 递归不容易啊
     *
     * @param node
     * @return
     */
    private boolean isBalancedVersion2(Node node) {
        // 递归到底的情况
        if (node == null) {
            // 空树，肯定为二叉树
            return true;
        }
//        if (getBalanceFactor(node) == 0) {
//            return true;
//        }
        if (Math.abs(getBalanceFactor(node)) > 1) {
            return false;
        }

        return isBalancedVersion2(node.left) && isBalancedVersion2(node.right);
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(CommonConstants.Algorithm.TEXT_01 + "pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
            System.out.println("是否为二分搜索树 " + map.isBST());
            System.out.println("是否为平衡二叉树 " + map.isBalanced());
            // 测试删除情况
            for(String word: words){
                map.remove(word);
                if(!map.isBST() || !map.isBalanced())
                    throw new RuntimeException();
            }
        }

        System.out.println();
    }

    @Test
    public void wordCount() {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(CommonConstants.Algorithm.TEXT_01 + "pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // 先排序 会变成链表吗？
            Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BSTMap<String, Integer> bst = new BSTMap<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL Tree
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");
        }

        System.out.println();
    }
}
