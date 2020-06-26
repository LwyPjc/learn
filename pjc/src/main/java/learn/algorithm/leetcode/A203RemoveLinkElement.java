package learn.algorithm.leetcode;


//删除链表中等于给定值 val 的所有节点。
//
// 示例:
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class A203RemoveLinkElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dumyHead = new ListNode(-1);
        dumyHead.next = head;
        ListNode pre = dumyHead;
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }
        return dumyHead.next;
    }

    public ListNode removeElementsUseRecursive(ListNode head, int val) {

        if (head == null) {
            return null;
        }
        ListNode listNode = removeElementsUseRecursive(head.next, val);
        if (head.val == val) {
            return listNode;
        } else {
            head.next = listNode;
            return head;
        }

    }

}
