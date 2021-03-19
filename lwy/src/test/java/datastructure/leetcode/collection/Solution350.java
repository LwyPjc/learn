package datastructure.leetcode.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution350 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        for (int i = 0; i < length1; i++) {
            list.add(nums1[i]);
        }
        List<Integer> intersectionList = new ArrayList<>();
        for (int i = 0;i<length2;i++){
            if (list.contains(nums2[i])){
                intersectionList.add(nums2[i]);
                list.remove((Integer)nums2[i]);
            }
        }

        int size = intersectionList.size();
        int[] res = new int[size];
        for (int i = 0;i<size;i++){
            res[i] = intersectionList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
//     int[] nums1 = {4,9,5}, nums2 = {9,4,9,8,4};
        int[] nums1 = {1,2,2,1}, nums2 = {2,2};
     int[] res = new Solution350().intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }
}
