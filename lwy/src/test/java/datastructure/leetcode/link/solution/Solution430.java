package datastructure.leetcode.link.solution;

import datastructure.leetcode.link.Node;

/**
 * 430. 扁平化多级双向链表
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。
 * 这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 */
public class Solution430 {
    public Node flatten(Node head) {
//        Node res = new Node();
        Node modNode = head;
        while (modNode != null) {

            if (modNode.child != null) {
                Node temp = modNode.child;
                while (temp != null) {
                    temp.next = modNode.next;
                    modNode.prev = temp;
                    modNode.next = temp;
                    temp.prev = modNode;
                    temp = temp.next;
                }
            }
            modNode = modNode.next;
        }
        return head;
    }

    /**
     * 递归方法实现,
     *
     *
     * @param head
     * @return
     */
    public Node flatten02(Node head) {
        Node modNode = head;
        while (modNode != null) {
            if (modNode.child != null) {
                Node temp = flatten02(modNode.child);
                Node moveTemp = temp;
                while (moveTemp.next != null) {
                    moveTemp = moveTemp.next;
                }
                moveTemp.next = modNode.next;
                if (modNode.next != null)
                    modNode.next.prev = moveTemp;
                //TODO: 没有将这一步置为null 会导致死循环
                modNode.child = null;
                modNode.next = temp;
                temp.prev = modNode;
            }
            modNode = modNode.next;
        }

        return head;
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node.next = node2;
        node2.prev = node;
        node2.next = node3;
        node3.prev = node2;
        node3.next = node4;
        node4.prev = node3;
        node4.next = node5;
        node5.prev = node4;
        node5.next = node6;
        node6.prev = node5;
        node3.child = node7;
        node7.next = node8;
        node8.prev = node7;
        node8.child = node11;
        node8.next = node9;
        node9.prev = node8;
        node9.next = node10;
        node10.prev = node9;
        node11.next = node12;
        node12.prev = node11;

        System.out.println(node);
        Solution430 s = new Solution430();
        s.flatten02(node);


    }


}
