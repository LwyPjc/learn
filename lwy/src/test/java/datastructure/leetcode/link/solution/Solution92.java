package datastructure.leetcode.link.solution;

import datastructure.leetcode.link.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || right < left) {
            throw new IllegalArgumentException("the parameters are wrong~");
        }



        ListNode leftNode = head;
        ListNode node = head;
        for (int i = 1; i < left; i++) {
            node = leftNode = leftNode.next;

        }

        List<Integer> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {

            list.add(leftNode.val);
            leftNode = leftNode.next;
        }
        int size = list.size();
        for (int i = 0, j = size - 1; i < j; i++, --j) {
            int leftTemp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, leftTemp);
        }
        for (int i = 0; i < size; i++) {
            node.val = list.get(i);
            node = node.next;

        }

        return head;
    }


    public static void main(String[] args) {
        // [1,2,3,4,5
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        ListNode temp = new ListNode(3);
        ListNode temp2 = new ListNode(5);
        temp.next = temp2;

        Solution92 solution = new Solution92();

        System.out.println(solution.reverseBetween(node1, 2, 4));
        System.out.println(solution.reverseBetween(temp, 1, 2));

    }

    public ListNode reverseBetween02(ListNode head, int left, int right) {
        if (left >= right) {
            return null;
        }


        ListNode node = head;
        while (left < right) {
            reverseBetween02(head.next, left + 1, right - 1);
//            if ()
        }

        //TODO
        return null;
    }
}
