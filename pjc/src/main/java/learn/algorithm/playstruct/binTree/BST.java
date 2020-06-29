package learn.algorithm.playstruct.binTree;

import java.util.Stack;

/**
 * 二分搜索树
 * 不包含重复元素
 */
public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 添加元素
     *
     * @Version 1
     */
    public void addVersionOne(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {

        }
    }

    /**
     * 添加元素
     *
     * @Version 2
     */
    public void addVersionTwo(E e) {
        root = addRecursiveVersionTwo(root, e);
    }

    /**
     * 递归插入元素
     *
     * @param node
     * @param e
     * @Versiion 1
     */
    private void addRecursiveVersionOne(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) < 0) {
            addRecursiveVersionOne(node.left, e);
        } else {
            addRecursiveVersionOne(node.right, e);
        }


    }

    /**
     * 简化终止条件版递归
     * 返回插入新节点后，二叉搜索树的根
     *
     * @Version 2
     */
    private Node addRecursiveVersionTwo(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        } else if (e.compareTo(node.e) < 0) {
            node.left = addRecursiveVersionTwo(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addRecursiveVersionTwo(node.right, e);
        }
        // 这里是必要操作吗？
        return node;
    }

    /**
     * 看二分搜索树中是否包含元素e
     */
    public boolean contains(E e) {
        return contains(root, e);
    }

    /**
     * 递归查找 某元素是否存在
     *
     * @param node
     * @param e
     * @return
     */
    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }


    /**
     * 前序遍历
     */
    public void preOrder() {
        preOrder(root);
    }

    /**
     * 递归 前序遍历
     */
    private void preOrder(Node root) {
        if (root != null) {
            System.out.println(root.e);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    /**
     * 中序遍历
     */
    public void midOrder() {
        midOrder(root);
    }

    /**
     * 递归 中序遍历
     */
    private void midOrder(Node node) {
        if (node == null) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void afterOrder() {
        afterOrder(root);
    }

    /**
     * 递归 后续遍历
     */
    private void afterOrder(Node node) {
        if (node == null) {
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 先写终止条件的递归
     *
     * @param root
     */
    private void preOrderVersionTwo(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 前序遍历非递归写法
     * 借用栈
     *
     * @return
     */
    public void preOrderUseLoop() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (pop != null) {
                System.out.println(pop.e);
                // 后入先出的 根左右
                stack.push(pop.right);
                stack.push(pop.left);
            }
        }
    }

    /**
     * 中序遍历 非递归写法
     * TODO
     *
     * @return
     */
    public void midOrderUseLoop() {}

    /**
     * 后序遍历 非递归写法
     * TODO
     *
     * @return
     */
    public void afterOrderUseLoop() {}

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");
        return res.toString();
    }

}

