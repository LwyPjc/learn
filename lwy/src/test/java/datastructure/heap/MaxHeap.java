package datastructure.heap;

import datastructure.array.Array;

/**
 * 最大堆 -- 完全二叉树
 * 根节点值大于左右结点
 * 使用数组实现最大堆，给定下标 index, 如果下标从0开始，则 左孩子下标为 index * 2 + 1;
 * 右孩子下标为 index * 2 + 2;
 * 父节点 下标为  (index - 1) / 2
 * <p>
 * 如果下标从 1 开始， 则左孩子下标为 index * 2; 右孩子下标为 index * 2 + 1; 父节点下标为 index / 2
 *
 * @param <E>
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> array;

    public MaxHeap() {
        array = new Array<>();
    }

    public MaxHeap(int capacity) {
        array = new Array<>(capacity);
    }

    /** Heapify方法
     * 将普通数组转化为最大堆数组
     *从最后一个叶子结点的根节点开始（即数组最后一个节点的parent结点 parentIndex(size-1)）
     *下沉
     * 方法二：遍历要转化的数组，逐个添加
     * @param arr
     */
    public MaxHeap(E[] arr) {
        array = new Array<>(arr);
        for (int i = parentIndex(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public int size() {
        return array.getSize();
    }

    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 查找父节点位置
     *
     * @param index
     * @return
     */
    public int parentIndex(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doean't have parent");
        }

        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return index * 2 + 1;
    }

    public int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 添加元素，做上浮操作（先在末尾添加，然后和该元素的根节点比较，如果比根节点大，就和根节点元素交换，
     * 直到下标为0 或者 比根节点小 停止）
     *
     * @param e
     */
    public void add(E e) {
        array.add(e);
        siftUp(array.getSize() - 1);
    }

    private void siftUp(int k) {
        //如果k > 0 且 k的父节点值 小于 k中结点的值，k上浮
        while (k > 0 && array.getElementByIndex(parentIndex(k)).
                compareTo(array.getElementByIndex(k)) < 0) {

            array.swap(k, parentIndex(k));
            k = parentIndex(k);
        }
    }

    public E getMax() {
        if (array.getSize() == 0) {
            throw new IllegalArgumentException("The heap is empty~");
        }
        return array.getFirst();
    }

    /**
     * 取出堆中最大元素
     *
     * @return
     */
    public E extractMax() {
        E ret = getMax();
        array.swap(0, size() - 1);
        array.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k) {
        //k所指位置不是叶子结点
        while (leftChild(k) < array.getSize()) {
            int j = leftChild(k);
            //如果k结点有右结点，比较左右节点值大小
            if (j + 1 < array.getSize() &&
                    array.getElementByIndex(j + 1)
                            .compareTo(array.getElementByIndex(j)) > 0) {
                j++;
                //rightChild(k);
                //保证j指向较大结点下标
            }
            //如果左右子树最大结点值 也比根节点值下 不下沉
            if (array.getElementByIndex(j).compareTo(array.getElementByIndex(k)) < 0) {
                break;
            }
            //否则交换值
            array.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最大元素，放入一个新的元素
     *
     * @param e
     */
    private E replace(E e) {
        E ret = getMax();
        array.set(0, e);
        siftDown(0);
        return ret;
    }


    @Override
    public String toString() {
        return "MaxHeap{" +
                "array=" + array +
                '}';
    }


}
