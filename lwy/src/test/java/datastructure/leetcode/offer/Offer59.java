package datastructure.leetcode.offer;


import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 */
public class Offer59 {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int size = nums.length;
        //如果是空数组
        if (size == 0) {
            return new int[0];
        }
        Queue<Integer> res = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int i = 0;

        for (i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        for (; i <= size; i++) {
            int max = queue.element();
            Iterator<Integer> it = queue.iterator();
            while (it.hasNext()) {
                int temp = it.next();
                if (max < temp) {
                    max = temp;
                }
            }

            res.add(max);
            queue.remove();
            if (i == size) {
                break;
            }
            queue.add(nums[i]);

        }
        int length = res.size();
        int[] maxArray = new int[length];
        for (int t = 0; t < length; t++) {
            maxArray[t] = res.remove();
        }
        return maxArray;


    }

    public static void main(String[] args) {
//        int nums[] = {1, 3, -1, -3, 5, 3, 6, 7};
        int nums[] = {1, -1};
        int k = 1;
        int res[] = new Offer59().maxSlidingWindow(nums, k);
//        int size = res.length;
        System.out.println(Arrays.toString(res));
//        for (int i = 0; i < size; i++) {
//            System.out.print(res[i] + " ");
//        }
//        System.out.println(res.toString());
    }
}
