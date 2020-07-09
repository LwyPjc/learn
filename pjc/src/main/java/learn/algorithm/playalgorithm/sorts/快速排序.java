package learn.algorithm.playalgorithm.sorts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tools.MathTool;
import tools.PrintStreamUtil;
import tools.RandomUtils;

/**
 * 快速排序
 * Partition
 * <p>
 * 情况1：待排数组基本有序---》随机选取元素
 * 情况2：待排数组重复元素多，分的区差别可能极大---》双路排序，两边都可以有等于选取的元素 难啊
 */
@SuppressWarnings("all")
public class 快速排序 {

    // 待排数组
    private int[] unSortNumbers;

    /**
     * 每日一练
     */
    @Test
    public void test() {

    }


    @Before
    public void init() {
        unSortNumbers = RandomUtils.randomArrays(10, 20, 100);
        System.out.println("待排数组");
        PrintStreamUtil.printObject(unSortNumbers);
    }

    @After
    public void after() {
        System.out.println("排序后 ");
        PrintStreamUtil.printObject(unSortNumbers);
    }

    @Test
    public void testQuickSort() {
        quickSort(unSortNumbers, 0, unSortNumbers.length - 1);
    }

    /**
     * 快速排序
     */
    public void quickSort(int[] arr, int l, int r) {
        // 递归终止条件
        if (l >= r) {
            return;
        }
        int p = partitionVersion4(unSortNumbers, l, r);
        quickSort(unSortNumbers, l, p - 1);
        quickSort(unSortNumbers, p + 1, r);
    }

    /**
     * 失败！！！！
     * 分区过程
     * Partition
     * 返回分区的位置
     */
    private int partitionVersion1(int[] arr, int l, int r) {
        int temp = arr[l];
        int i = l;
        int j = r;
        while (i < j) {
            while (temp >= arr[i] && i < j) {
                i++;
            }
            while (temp < arr[j] && j > i) {
                j--;
            }
            MathTool.swapWithArray(i, j, arr);
        }
        if (arr[i] > arr[j]) {
            MathTool.swapWithArray(l, i, arr);
        }
        return i;
    }

    /**
     * 分区 单路
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partitionVersion2(int[] arr, int l, int r) {
        int temp = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < temp) {
                MathTool.swapWithArray(j + 1, i, arr);
                j++;
            }
        }
        MathTool.swapWithArray(l, j, arr);
        return j;
    }

    /**
     * 分区 单路
     * 随机选取值
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partitionVersion3(int[] arr, int l, int r) {
        // 假如选了中间的 与l交换一下即可
        MathTool.swapWithArray(l, (r - l) / 2 + l, arr);
        int temp = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < temp) {
                MathTool.swapWithArray(j + 1, i, arr);
                j++;
            }
        }
        MathTool.swapWithArray(l, j, arr);
        return j;
    }

    /**
     * 分区 双路
     * 两头都可以有等于标准元素，从而使分的区不会差距太大
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private int partitionVersion4(int[] arr, int l, int r) {
        // 假如选了中间的 与l交换一下即可
        MathTool.swapWithArray(l, (r - l) / 2 + l, arr);
        int temp = arr[l];
        // arr[l+1...i)<=v  ; arr(j...r]>=v
        int i = l + 1, j = r;

        while (true) {
            while (i <= r && arr[i] < temp) {
                i++;
            }
            while (j > l + 1 && arr[j] > temp) {
                j--;
            }
            if (i > j) {
                break;
            }
            MathTool.swapWithArray(i, j, arr);
            // TODO 交换完后记得+1
            i++;
            j--;
        }
        // 跳出循环，j为最后一个小于temp的元素下标
        MathTool.swapWithArray(j, l, arr);
        return j;
    }

}
