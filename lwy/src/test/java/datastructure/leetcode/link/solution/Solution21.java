package datastructure.leetcode.link.solution;

import datastructure.leetcode.link.ListNode;

/**
 * 21、合并两个有序链表
 */
public class Solution21 {
    /**
     * 方法一
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists01(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;

        return listNode.next;
    }

    /**
     * 方法二
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (l1 != null && l2 != null) {
            ListNode q;
            if (l1.val < l2.val) {
                q = l1;
                l1 = q.next;
            } else {
                q = l2;
                l2 = q.next;
            }
            q.next = null;
            temp.next = q;
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        }
        if (l2 != null) {
            temp.next = l2;
        }

        return listNode.next;

    }

    /**
     * 方法三： 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists03(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode();
        ListNode temp = listNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp = mergeTwoLists03(l1.next, l2);
            } else {
                temp = mergeTwoLists03(l1, l2.next);
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return listNode.next;
    }


    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4};
        ListNode l1 = new ListNode(arr1);
        int[] arr2 = {1, 3, 4};
        ListNode l2 = new ListNode(arr2);

        ListNode listNode = new Solution21().mergeTwoLists03(l1, l2);
        System.out.println(listNode);
//        System.out.println(l2);
    }
}
