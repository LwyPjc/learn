package learn.algorithm.playstruct.binTree;

import java.util.ArrayDeque;
import java.util.Queue;
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
     * 层序遍历
     * 借用队列
     */
    public void layerOrder() {
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Node remove = queue.remove();
            System.out.println(remove.e);
            if (remove.left != null) {
                queue.add(remove.left);
            }
            if (remove.right != null) {
                queue.add(remove.right);
            }
        }
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
    public void midOrderUseLoop() {
    }

    /**
     * 后序遍历 非递归写法
     * TODO
     *
     * @return
     */
    public void afterOrderUseLoop() {
    }

    /**
     * 寻找二分搜索树的最小元素
     *
     * @return
     */
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        Node minNode = minimum(root);
        return minNode.e;
    }

    /**
     * 返回以node为根的二分搜索树的最小值所在的节点
     *
     * @param node
     * @return
     */
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    /**
     * 寻找二分搜索树的最大元素
     *
     * @return
     */
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    /**
     * 返回以node为根的二分搜索树的最大值所在的节点
     *
     * @param node
     * @return
     */
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    /**
     * 删除最小元素
     *
     * @return
     */
    public E removeMin() {
        E minimum = this.minimum();
        // 带一个上层节点
//        removeMin(root, root.left);

        removeMin(root);

        return minimum;
    }

    /**
     * 递归删除 最小元素
     * 这种方式不是很好吧
     *
     * @param upNode 上层节点
     * @param node
     * @return
     * @Version 1
     */
    private void removeMin(Node upNode, Node node) {
        if (node.left == null) {
            // 要删的节点
            if (node.right != null) {
                upNode.left = node.right;
            } else {
                upNode.left = null;
            }
            return;
        }
        upNode = node;
        removeMin(upNode, node.left);
    }

    /**
     * 递归删除最小元素
     * 返回删除节点后新的二分搜索树的根
     *
     * @param node
     * @return
     * @Version 2
     */
    @SuppressWarnings("all")
    private Node removeMin(Node node) {
        // 要删的节点
        if (node.left == null) {
            Node ret = node.right;
            node.right = null;
            size--;
            return ret;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大元素
     *
     * @return
     */
    public E removeMax() {
        E maximum = this.maximum();
        removeMax(root);

        return maximum;
    }

    /**
     * 递归删除 最大元素
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            size--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除元素
     * 既有左孩子，也有右孩子，则找出比被删除节点大一点的节点替换上来
     * 只有左孩子
     * 只有右孩子
     *
     * @return
     */
    public E remove(E e) {
        Node remove = remove(root, e);
        return remove == null ? null : remove.e;
    }

    /**
     * 递归删除某节点
     *
     * @return
     */
    private Node remove(Node node, E e) {
        if (node == null) {
            // 找不到要删的元素
            return null;
        }
        if (e.compareTo(node.e) == 0) {
            // 找到了要删的元素
            Node ret = null;
            // 只有左子树
            if (node.right == null) {
                ret = node.left;
                node.left = null;
            } else if (node.left == null) {
                // 只有右子树
                ret = node.right;
                node.right = null;
            } else {
                // 左右都有子树 在比要删的元素要大中找出最小的 subRoot 是要移动的前一个节点， 使用其后继
                //不用递归
//                Node subRoot = node.right;
//                if (subRoot.left != null) {
//                    while (subRoot.left.left != null) {
//                        subRoot = subRoot.right;
//                    }
//                }
//                Node needMove = subRoot.left;
//                subRoot.left = needMove.right;
//                needMove.right = node.right;
//                needMove.left = node.left;
//                return needMove;

                // 递归写法
                // 找出最小值所在节点
                Node minimum = minimum(node.right);
                // 删除最小值送在节点
                removeMin(node.right);
                size++;// 多减了
                minimum.right = node.right;
                minimum.left = node.left;
                node.left = node.right = null;
                return minimum;
            }

            size--;
            return ret;
        } else if (e.compareTo(node.e) < 0) {
            // 比节点小
            node.left = remove(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            // 比节点大
            node.right = remove(node.right, e);
        }
        return node;
    }

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

