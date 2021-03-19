package datastructure.leetcode.link.solution;

import datastructure.leetcode.link.ListNode;

/**
 * 203、删除链表中元素
 * (递归方法)
 */
public class Solution203 {
    /**
     * 使用递归删除链表中指定元素
     *
     * @param head
     * @param val
     * @param depth
     * @return
     */
    public ListNode removeElement(ListNode head, int val, int depth) {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return null;
        }
        ListNode res = removeElement(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " : " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next =res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);
        //        head.setNext(removeElement(head.getNext(), val,depth+1));
        //        return head.getVal() == val ? head.getNext() : head;
        return ret;
    }

    private String generateDepthString(int deepth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < deepth; i++) {
            res.append("--");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 4, 5, 6, 7};
        ListNode head = new ListNode(arr);
        ListNode res = new Solution203().removeElement(head, 6, 0);
        System.out.println(res);


    }
}
