package learn.algorithm.playstruct.linkedAndRecursive;

class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
        val = x;
    }

    // 链表节点的构造函数
    // 使用arr为参数，创建一个链表，当前的ListNode为链表头结点
    public ListNode(int[] arr){

        if(arr == null || arr.length == 0)
            throw new IllegalArgumentException("arr can not be empty");

        this.val = arr[0];
        ListNode cur = this;
        for(int i = 1 ; i < arr.length ; i ++){
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    // 以当前节点为头结点的链表信息字符串
    @Override
    public String toString(){

        StringBuilder s = new StringBuilder();
        ListNode cur = this;
        while(cur != null){
            s.append(cur.val + "->");
            cur = cur.next;
        }
        s.append("NULL");
        return s.toString();
    }
}

/**
 * 探寻递归
 * 打桩的方式查看递归的调用
 *
 */
public class Solution {

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);

        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val)
            ret = res;
        else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6, 0);
        System.out.println(res);
    }

}
