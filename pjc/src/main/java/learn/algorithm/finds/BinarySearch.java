package learn.algorithm.finds;

import learn.algorithm.sorts.BubbleSort;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;

/**
 * 二分查找法
 * 对已经排好序的数组进行查找
 */
public class BinarySearch {

    private int[] sortedArray;

    @Before
    public void init() {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.init();
        bubbleSort.bubbleSortSmallInFisrtThree();
        sortedArray = bubbleSort.getUnSortNumbers();
        PrintStreamUtil.printObject(sortedArray);
    }


    /**
     * 使用递归版二分查找
     */
    @Test
    public void useRecursiveOne() {

    }

}
