package learn.algorithm.leetcode;

public class A链表反转 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode listNode = reverseBetween(head, 2, 4);
        print(listNode);
    }

    private static void print(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode leftNode = null;
        ListNode cusr = head;
        ListNode temp = null;
        ListNode temp2 = null;

        for (int i = 1; i <= right; i++) {
            if (i == left) {
                leftNode = cusr;
                i++;
            }

            if (i >= left && i <= right) {
                temp = leftNode.next;
                temp2 = cusr.next.next;
                leftNode.next = cusr.next;
                cusr.next.next = temp;
                cusr.next = temp2;
                cusr = cusr.next;
                if (i == right) {
                    break;
                }
            } else {
                cusr = cusr.next;
            }
        }
        return head;
    }

}
