package learn.algorithm.playstruct.segment;

/**
 * 线段树
 * 使用数组表示
 * 看成满二叉树，空的位置为null
 * 如何 划分区间呢？ 依照业务而定，如求和
 * 更新
 */
public class SegmentTree<E> {

    private Merge<E> merge;

    private E[] data;

    // 满二叉树
    private E[] segmentTree;

    public SegmentTree(E[] arr, Merge<E> merge) {
        this.merge = merge;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        // 线段树 4倍 大约这么多
        segmentTree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 递归 创建treeIndex 表示区间 [l..r]
     * 递归求其左右子树的值
     *
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            segmentTree[treeIndex] = data[l];
        } else {
            // 中间位置
//            int mid = (l + r) / 2;
            int mid = l + (r - l) / 2;
            // 左右子树的值
            int leftChildIndex = leftChild(treeIndex);
            int rightChildIndex = rightChild(treeIndex);
            buildSegmentTree(leftChildIndex, l, mid);
            buildSegmentTree(rightChildIndex, mid + 1, r);
            segmentTree[treeIndex] = merge.merge(segmentTree[leftChildIndex], segmentTree[rightChildIndex]);
        }
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal ");
        }
        return data[index];
    }

    /**
     * 获取左孩子下标
     */
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    /**
     * 获取右孩子下标
     */
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 显然应该从根节点开始寻找
     * segmentTree data
     * <p>
     * 返回区间[queryL, queryR]的值
     *
     * @param queryL 相对data来说
     * @param queryR 相对data来说
     * @return
     */
    public E query(int queryL, int queryR) {

        if (queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");

        E query = query(0, 0, data.length - 1, queryL, queryR);
        return query;
    }

    /**
     * 递归 节点所表示的区间
     * 1. 要去哪里找
     * 2. 找啥
     * 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param queryL
     * @param queryR
     * @return
     */
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        // 根节点的子节点
        int leftTree = leftChild(treeIndex);
        int rightTree = rightChild(treeIndex);

        // 左节点存放区间
        int dataMid = l + (r - l) / 2;

        if (queryL == l && queryR == r) {
            return segmentTree[treeIndex];
        } else if (dataMid >= queryR) {
            // 在左边
            return query(leftTree, l, dataMid, queryL, dataMid);
        } else if (dataMid + 1 <= queryL) {
            // 在右边
            return query(rightTree, dataMid + 1, r, dataMid + 1, queryR);
        } else {
            // 左右都有
            E leftE = query(leftTree, l, dataMid, queryL, dataMid);
            E rightE = query(rightTree, dataMid + 1, r, dataMid + 1, queryR);
            return this.merge.merge(leftE, rightE);
        }
    }

    // 在以treeIndex为根的线段树中[l...r]的范围里，搜索区间[queryL...queryR]的值
    private E queryVersion2(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR)
            return segmentTree[treeIndex];

        int mid = l + (r - l) / 2;
        // treeIndex的节点分为[l...mid]和[mid+1...r]两部分

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1)
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        else if (queryR <= mid)
            return query(leftTreeIndex, l, mid, queryL, queryR);

        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        return merge.merge(leftResult, rightResult);
    }

    /**
     * 将index位置的值，更新为e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal");
        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * 在以treeIndex为根的线段树中更新index的值为e
     *
     * @param treeIndex
     * @param l
     * @param r
     * @param index
     * @param e
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            segmentTree[treeIndex] = e;
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightThreeIndex = rightChild(treeIndex);

        if (mid > index) {
            // 在左子树
            set(leftTreeIndex, l, mid, index, e);
        } else {
            // 在右子树
            set(rightThreeIndex, mid + 1, r, index, e);
        }

        /**
         * 更新此节点的值
         * 顺序问题，跟新 treeIndex 节点时，其子节点已经更新好了
         */
        segmentTree[treeIndex] = merge.merge(segmentTree[leftTreeIndex],segmentTree[rightThreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < segmentTree.length; i++) {
            if (segmentTree[i] != null)
                res.append(segmentTree[i]);
            else
                res.append("null");

            if (i != segmentTree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

}
