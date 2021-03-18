package datastructure.leetcode.link;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr cannot empty");
        }
        this.val = arr[0];
        ListNode head = this;
        for (int i = 1; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }
    }



    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode(int val) {
        this(val,null);
    }
    public ListNode(){

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        ListNode head = this;
        while(head!=null){
            result.append(head.val+"->");
            head = head.next;
        }
        result.append("NULL");
        return result.toString();
    }
}
