package learn.algorithm.sorts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tools.PrintStreamUtil;
import tools.RandomUtils;


/**
 * 冒泡排序 自然排序 从小到大
 */
public class BubbleSort {
    // 待排数组
    private int[] unSortNumbers;

    public int[] getUnSortNumbers() {
        return unSortNumbers;
    }

    public void setUnSortNumbers(int[] unSortNumbers) {
        this.unSortNumbers = unSortNumbers;
    }

    /**
     * 每日一练
     */
    @Test
    public void test(){

    }


    @Before
    public void init() {
        unSortNumbers = RandomUtils.randomArrays(10, 20, 100);
        System.out.println("待排数组");
        PrintStreamUtil.printObject(unSortNumbers);
    }

    @After
    public void after() {
        System.out.println("冒泡排序后 ");
        PrintStreamUtil.printObject(unSortNumbers);
//        Arrays.stream(unSortNumbers).forEach(PrintStreamUtil::printObject);
    }

    /**
     * 从小到大
     * 从后往前遍历,把最小的元素移动最头
     *
     * @Version 1 java.lang.ArrayIndexOutOfBoundsException
     */
    @Test
    @SuppressWarnings("all")
    public void bubbleSortSmallInFisrtOne() {
        for (int i = 0; i < unSortNumbers.length; i++) {
            for (int j = unSortNumbers.length - i; j > i; j--) {
                if (unSortNumbers[j] < unSortNumbers[j - 1]) {
                    // 交换两个元素
                    int temp = unSortNumbers[j - 1];
                    unSortNumbers[j - 1] = unSortNumbers[j];
                    unSortNumbers[j] = unSortNumbers[temp];
                }
            }
        }
    }

    /**
     * 没成功 排了一半
     *
     * @Version 2
     * 待排数组
     * [72,50,61,75,53,8,28,81,64,39,23,68,55,88,90,53,16,62,11,70]
     * 冒泡排序后
     * [8,11,16,23,28,39,50,53,53,61,72,75,55,81,64,68,88,90,62,70]
     */
    @Test
    @SuppressWarnings("all")
    public void bubbleSortSmallInFisrtTwo() {
        for (int i = 0; i < unSortNumbers.length; i++) {
            for (int j = unSortNumbers.length - i - 1; j > i; j--) {
                if (unSortNumbers[j] < unSortNumbers[j - 1]) {
                    // 交换两个元素
                    int temp = unSortNumbers[j - 1];
                    unSortNumbers[j - 1] = unSortNumbers[j];
                    unSortNumbers[j] = temp;
                }
            }
        }
    }

    /**
     * 每次都从最后一个元素开始遍历
     *
     * @Version 3
     * TODO 优化
     */
    @Test
    @SuppressWarnings("all")
    public void bubbleSortSmallInFisrtThree() {
        for (int i = 0; i < unSortNumbers.length; i++) {
            for (int j = unSortNumbers.length - 1; j > i; j--) {
                if (unSortNumbers[j] < unSortNumbers[j - 1]) {
                    // 交换两个元素
                    int temp = unSortNumbers[j - 1];
                    unSortNumbers[j - 1] = unSortNumbers[j];
                    unSortNumbers[j] = temp;
                }
            }
        }
    }


    /**
     * @Version 1
     * ArrayIndexOutOfBoundsException
     */
    @Test
    @SuppressWarnings("all")
    public void bubleSortMaxInLastOne() {
        for (int i = 0; i < unSortNumbers.length; i++) {
            for (int j = 0; j < unSortNumbers.length - i; j++) {
                if (unSortNumbers[j] > unSortNumbers[j + 1]) {
                    // 交换
                    int temp = unSortNumbers[j+1];
                    unSortNumbers[j+1] = unSortNumbers[j];
                    unSortNumbers[j] = temp;
                }
            }
        }
    }

    /**
     * @Version 2
     * ArrayIndexOutOfBoundsException
     * 最外层循环 一共有多少个元素要排
     */
    @Test
    @SuppressWarnings("all")
    public void bubleSortMaxInLastTwo() {
        for (int i = 1; i < unSortNumbers.length; i++) {
            for (int j = 0; j < unSortNumbers.length - i; j++) {
                if (unSortNumbers[j] > unSortNumbers[j + 1]) {
                    // 交换
                    int temp = unSortNumbers[j+1];
                    unSortNumbers[j+1] = unSortNumbers[j];
                    unSortNumbers[j] = temp;
                }
            }
        }
    }

}
