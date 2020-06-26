package learn.algorithm.playstruct.linkedAndRecursive;

import org.junit.Test;

/**
 * 递归求和
 * int[] arr
 */
public class Sum {

    @Test
    public void testSum() {
        int[] arr = {1, 4, 5, 3, 2, 1, 4, 3};
        int sum = sum(arr, 0);
        System.out.println(sum);
    }

    /**
     * 计算 index 到n 的和
     *
     * @param arr
     * @param index
     * @return
     */
    private int sum(int[] arr, int index) {
        if (index == arr.length - 1)
            return arr[index];
        return sum(arr, index + 1) + arr[index];
    }

}
