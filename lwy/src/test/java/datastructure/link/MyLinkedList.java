package datastructure.link;

/**
 * 不带头节点的链表
 */
public class MyLinkedList<E> {
    private class Node {
        E node;
        Node next;

        public Node(E node, Node next) {
            this.node = node;
            this.next = next;
        }

        public Node(E node) {
            this(node, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "node=" + node +
                    ", next=" + next +
                    '}';
        }
    }

    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    /**
     * 使用尾插法添加节点
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在指定位置添加节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index illegal");
        }

        Node node = new Node(e);
        if (index == 0) {
            if (head != null) {
                node.next = head;
            }
            head = node;
        } else {
            Node pre = head;
            for (int i = 0; i < index - 1; i++) {
                pre = pre.next;
            }
            node.next = pre.next;
            pre.next = node;

        }
        size++;
    }

    /**
     * 删除链表中所有等于e的节点
     *
     * @param e
     * @return
     */
    public void removeByElement(E e) {
        while (head != null && head.node == e) {
            Node delNode = head;
            head = head.next;
            delNode.next = null;
        }
        Node cur = head;
        Node pre = new Node();
        while (cur != null) {
            if (cur.node == e) {
                pre.next = cur.next;
                Node delNode = cur;

                cur = delNode.next;
                delNode.next = null;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
    }

    /**
     * 根据下标删除元素
     *
     * @param index
     * @return
     */
    public E removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        //如果是第一个节点
        if (index == 0) {
            E e = head.node;
            head = head.next;
            return e;
        }
        Node pre = new Node();
        Node cur = head;
        for (int i = 0; i < index; i++) {
            pre = cur;
            cur = cur.next;
        }

        pre.next = cur.next;
        cur.next = null;

        return cur.node;

    }

    public void removeByElementPlus(E e){

    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("linkedList ");
        Node cur = head;
        while (cur != null) {
            result.append(cur.node);
            result.append("->");
            cur = cur.next;
        }
        result.append("NULL");
//        result.delete(result.length()-2,result.length());

        return result.toString();
    }




    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        myLinkedList.addFirst(1);
        myLinkedList.addFirst(2);
        myLinkedList.addFirst(6);
        myLinkedList.addFirst(3);
        myLinkedList.addFirst(4);
        myLinkedList.addFirst(5);
        myLinkedList.addFirst(6);
        System.out.println(myLinkedList);
    }
}
