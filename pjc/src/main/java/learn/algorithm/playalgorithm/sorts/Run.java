package learn.algorithm.playalgorithm.sorts;

import org.junit.Test;
import tools.MathTool;
import tools.RandomUtils;

/**
 * 测试
 */
@SuppressWarnings("all")
public class Run {

    // 判断arr数组是否有序
    public static boolean isSorted(Comparable[] arr) {

        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i].compareTo(arr[i + 1]) > 0)
                return false;
        return true;
    }

    /**
     * 测试
     */
    @Test
    public void testTime() {
        int n = 2_0000;
        long startTime, endTime;
        int[] arr = RandomUtils.randomArrays(n, n + 1, 2);

        startTime = System.currentTimeMillis();
        // 调用排序函数
        chooseSort(arr);
        endTime = System.currentTimeMillis();
        System.out.println("chooseSort" + " : " + (endTime - startTime) + "ms");

//        startTime = System.currentTimeMillis();
//        // 调用排序函数
//        insertSort(arr);
//        endTime = System.currentTimeMillis();
//        System.out.println("insertSort 很多" + " : " + (endTime - startTime) + "ms");


        startTime = System.currentTimeMillis();
        // 调用排序函数
        insertSort2(arr);
        endTime = System.currentTimeMillis();
        System.out.println("insertSort2" + " : " + (endTime - startTime) + "ms");

    }

    public void chooseSort(int[] unSortNumbers) {
        for (int i = 0; i < unSortNumbers.length; i++) {
            int temp = i;
            for (int j = i; j < unSortNumbers.length; j++) {
                // 或者直接把条件放在for里
                if (unSortNumbers[i] > unSortNumbers[j]) {
                    temp = j;
                } else {
                    // 一旦没交换就说明找到位置了
                    break;
                }

            }
            MathTool.swapWithArray(i, temp, unSortNumbers);
        }
    }

    /**
     * 交换次数多，就慢了
     *
     * @param unSortNumbers
     */
    public void insertSort(int[] unSortNumbers) {
        // 0 默认有序
        for (int i = 1; i < unSortNumbers.length; i++) {

            // 寻找当前i的应插入的位置
            for (int j = i; j > 0; j--) {
                if (unSortNumbers[j] < unSortNumbers[j - 1]) {
                    MathTool.swapWithArray(j, j - 1, unSortNumbers);
                }
            }
        }
    }

    /**
     * 少做交换
     *
     * @param unSortNumbers
     */
    public void insertSort2(int[] unSortNumbers) {
        // 0 默认有序
        int length = unSortNumbers.length;
        for (int i = 0; i < length; i++) {
            int temp = unSortNumbers[i];
            // 寻找当前i的应插入的位置
            int j;
            for (j = i; j > 0&&temp < unSortNumbers[j - 1]; j--) {
                unSortNumbers[j] = unSortNumbers[j - 1];
            }
            // 退出来的j是它的位置
            unSortNumbers[j] = temp;
        }
    }
}
