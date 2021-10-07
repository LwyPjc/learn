package datastructure.tree;

import java.util.*;

/**
 * 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        E e;
        Node left, right;

        public Node(E e) {
            this.e = e;
            left = right = null;
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

   /* public void add(E e){
        if (root == null){
            root.e = e;
            size++;
            return;
        }
        add(root,e);
    }*/

   /* private void add(Node node,E e){
        if (e.equals(node.e)){
            return;
        }
        if (e.compareTo(node.e)<0){
            if (node.left==null){
                node.left=new Node(e);
                return;
            }
            add(node.left,e);
        }else{
            if(node.right==null){
                node.right=new Node(e);
                return;
            }
        }
        size++;
    }*/


    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);
        return node;
    }

    /**
     * 查看二分搜索树中是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contain(E e) {
        return contain(root, e);
    }

    private boolean contain(Node node, E e) {
        if (node == null)
            return false;
        if (e.compareTo(node.e) < 0) {
            return contain(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contain(node.right, e);
        } else {
            return true;
        }
    }

    /**
     * 前序遍历二叉搜索树
     */
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    /**
     * 中序遍历(排序树)
     */
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    /**
     * 后续遍历
     */
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    /**
     * 非递归方法实现前序遍历
     */
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);

        }
    }


    //TODO:非递归实现中序遍历和后序遍历

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

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
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    /**
     * 广度优先遍历（层次遍历）
     */
    public void levelOrder() {
        //使用队列实现
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.println(temp.e);
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
        }

    }

    /**
     * 查找二分搜索树中最小结点值
     *
     * @return
     */
    public E minimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node) {

        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    /**
     * 查找二分搜索树中最大结点值
     *
     * @return
     */
    public E maximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node) {
        if (node.right == null)
            return node;
        return maximum(node.right);
    }

    /**
     * 删除二分搜索树中最小值结点
     *
     * @return
     */
    public E removeMin() {
        E e = minimum();
        root = removeMin(root);
        return e;
    }

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

    public E removeMax() {
        E e = maximum();
        root = removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除指定元素结点
     *
     * @param e
     */
    public void remove(E e) {
        remove(root, e);
    }

    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            //TODO 漏写
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            //TODO 漏写
            return node;
        } else { //e.compareTo(node.e)==0
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            //如果待删除结点的左右结点都不为空，
            //查找该结点右子树的最小结点，把该最小结点作为右子树的根结点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);

            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST();
        Random random = new Random(100);
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }

        List<Integer> list = new ArrayList<>();
        list.add(bst.removeMin());
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                throw new IllegalArgumentException("ERROR");
            }
        }
        System.out.println("removeMin is completed!");

        //test removeMax
        for (int i = 0; i < 1000; i++) {
            bst.add(random.nextInt(10000));
        }
        List<Integer> list2 = new ArrayList<>();
        list2.add(bst.removeMax());
        for (int i = 1; i < list2.size(); i++) {
            if (list2.get(i - 1) < list2.get(i)) {
                throw new IllegalArgumentException("removeMAx error");
            }

        }
        System.out.println("removeMax completed!");
    }
}
