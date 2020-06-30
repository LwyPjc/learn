package learn.algorithm.playstruct.heap;

import learn.algorithm.playstruct.arrays.Array;

/**
 * 最大堆 数组实现
 * 0号位置开始放
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    // 返回堆中的元素个数
    public int size() {
        return data.getSize();
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素
     * 先成为完全二叉树，再调整: 上浮
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 查看堆中最大元素
     */
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data.get(0);
    }

    /**
     * 取出元素，即根节点
     * 涉及下浮操作
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDownVersion2(0);
        return ret;
    }

    /**
     * 取出堆中的最大元素，并且替换成元素e
     * 配合下浮/沉操作
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDownVersion2(0);
        return max;
    }

    /**
     * heapify 做成构造函数
     *
     * 将一个数组转化为堆
     * 从倒数第一个非叶子节点开始做下沉操作
     *  也就是保证每一个子树也是一个最大堆
     */
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
            siftDownVersion2(i);
    }

    /**
     * 下浮： 先把最后一个元素挪到根位置，使变为一颗完全二叉树
     * 然后在左右两个子节点中找出最大值，替换
     * 这if else 用的不好啊
     */
    private void siftDownVersion1(int k) {
        // 循环结束，当没有左子节点时 或者 leftChild(k)<data.getSize()
        while (data.get(leftChild(k)) != null) {
            if (data.get(rightChild(k)) != null) {
                if (data.get(leftChild(k)).compareTo(data.get(rightChild(k))) >= 0) {
                    // 左节点大于/等于右节点
                    if (data.get(leftChild(k)).compareTo(data.get(k)) > 0) {
                        // 左节点大于/等于右节点
                        data.swap(k, leftChild(k));
                        k = leftChild(k);
                    } else {
                        break;
                    }
                } else {
                    // 左节点小于右节点
                    if (data.get(rightChild(k)).compareTo(data.get(k)) < 0) {
                        // 左节点大于/等于右节点
                        data.swap(k, leftChild(k));
                        k = rightChild(k);
                    } else {
                        break;
                    }
                }
            } else if (data.get(leftChild(k)).compareTo(data.get(k)) > 0) {
                // 左节点大于/等于右节点
                data.swap(k, leftChild(k));
                k = leftChild(k);
            } else {
                break;
            }
        }
    }

    /**
     * 下浮 操作 第二版
     *
     * @param k
     */
    private void siftDownVersion2(int k) {
        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置 默认先为左孩子
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                // 可能要交换的可能为右孩子
                j++;
            }

            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 添加元素使用的上浮过程
     * 与父节点相比
     *
     * @param k 下标
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }


}
