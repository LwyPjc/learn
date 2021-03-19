package datastructure.tree;


public class TestTree<E extends Comparable<E>> {
    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e, Node left, Node right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }

        public Node(E e) {
            this(e, null, null);
        }

        public Node() {

        }
    }

    private Node root;
    private int size;

    public TestTree() {
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
     */
    public void add(E e) {
        root = add(root, e);
    }

    private Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);

        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 是否包含元素e
     *
     * @param e
     * @return
     */
    public boolean contain(E e) {

        return contain(root, e);
    }

    private boolean contain(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) < 0) {
            return contain(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contain(node.right, e);
        } else {
            return true;
        }
    }

    /**
     * 查找二叉树中最小值结点
     *
     * @return
     */
    public E minimum() {
        E e = minimum(root).e;
        return e;
    }

    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    /**
     * 查找二叉树中最大结点
     *
     * @return
     */
    public E maximum() {
        E e = maximum(root).e;
        return e;
    }

    private Node maximum(Node node) {
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    /**
     * 删除二叉树中最小结点值
     *
     * @return
     */
    public E removeMin() {
        E e = minimum();
        removeMin(root);
        return e;
    }

    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            size--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E e = maximum();
        removeMax(root);
        return e;
    }

    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            size--;
            node.left = null;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除指定元素
     *
     * @param e
     */
    public boolean remove(E e) {
        //如果没有该元素
        if (remove(root, e) == null) {
            return false;
        }
        return true;
    }

    private Node remove(Node node, E e) {

        if (!contain(e)) {
            return null;
        }
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
        } else { //e.compareTo(node.e)==0
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
            //如果左右子树都不为空
            //查找右子树左边最后一个结点作为待删除元素节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if (node==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }
    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    public void afterOrder(){
        afterOrder(root);
    }

    private void afterOrder(Node node){
        if (node==null){
            return;
        }
        afterOrder(node.left);
        afterOrder(node.right);
        System.out.println(node.e);

    }




    public static void main(String[] args) {
        TestTree<Integer> tree = new TestTree();
        int[] arr = {5, 4, 3, 8, 2};
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }
        System.out.println(tree.minimum());
        System.out.println(tree.removeMax());
        System.out.println(tree.maximum());

    }

}
