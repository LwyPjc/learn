package learn.algorithm.playalgorithm.sorts;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import tools.MathTool;
import tools.PrintStreamUtil;
import tools.RandomUtils;

/**
 * O(n^2)算法
 * 选择排序
 * 插入排序
 */
@SuppressWarnings("all")
public class O平方算法 {
    // 待排数组
    private int[] unSortNumbers;


    /**
     * 每日一练
     * 对 unSortNumbers 排序
     * 选择排序
     * 插入排序
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
        System.out.println("冒泡排序后 ");
        PrintStreamUtil.printObject(unSortNumbers);
    }


    /**
     * 选择排序
     * <p>
     * unSortNumbers
     */
    @Test
    public void chooseSort() {
        for (int i = 0; i < unSortNumbers.length; i++) {
            int temp = i;
            for (int j = i; j < unSortNumbers.length; j++) {
                // 或者直接把条件放在for里
                if (unSortNumbers[i] > unSortNumbers[j]) {
                    temp = j;
                }

            }
            MathTool.swapWithArray(i, temp, unSortNumbers);
        }
    }

    /**
     * 插入排序
     * 是可以提前结束的 多交换？
     * unSortNumbers
     */
    @Test
    public void insertSort() {
        // 0 默认有序
        for (int i = 1; i < unSortNumbers.length; i++) {

            // 寻找当前i的应插入的位置
            for (int j = i; j > 0; j--) {
                if (unSortNumbers[j] < unSortNumbers[j - 1]) {
                    MathTool.swapWithArray(j, j - 1, unSortNumbers);
                } else {
                    // 一旦没交换就说明找到位置了
                    break;
                }
            }
        }
    }

    /**
     * 插入排序
     * 少做交换操作
     * unSortNumbers
     */
    @Test
    public void insertSort2() {
        // 0 默认有序
        for (int i = 1; i < unSortNumbers.length; i++) {
            int temp = unSortNumbers[i];
            // 寻找当前i的应插入的位置
            int j;
            for (j = i; j > 0; j--) {
                if (temp < unSortNumbers[j - 1]) {
                    unSortNumbers[j] = unSortNumbers[j - 1];
                } else {
                    // 一旦没交换就说明找到位置了
                    break;
                }
            }
            // 退出来的j是它的位置
            unSortNumbers[j] = temp;
        }
    }

    /**
     * 测试引用
     */
    public void testReference() {
        int[] a = {3, 4};
        tes(a);
        PrintStreamUtil.printObject(a);
    }

    // 改变地址？？
    private void tes(int[] b) {
        int[] c = {1};
        b = c;

    }

}
