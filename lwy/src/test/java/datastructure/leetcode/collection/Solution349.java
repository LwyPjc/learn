package datastructure.leetcode.collection;

import java.util.*;

public class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new TreeSet<>();
        int length = nums1.length;
        for (int i = 0; i < length; i++) {
            set.add(nums1[i]);
        }
        List<Integer> list = new ArrayList<>();
        int length2 = nums2.length;
        for (int i = 0; i < length2; i++) {
            if (set.contains(nums2[i])) {
                list.add(nums2[i]);
                set.remove(nums2[i]);
            }
        }
        int size = list.size();
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
        int [] res = new Solution349().intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
