package learn.algorithm.playstruct.linkList;

/**
 * 链表结构
 * 虚拟头节点
 */
public class MyLinkedList<E> {

    /**
     * 节点
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    // 虚拟头节点
    private Node dummyHead;

    // 多少个元素
    private int size;

    public MyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }


    // 指定索引添加 需找到待添加索引的前一个索引
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        // 找到位置 前一个 dummyHead 不算
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        // 插入
        prev.next = new Node(e, prev.next);
        size++;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e) {
        add(0, e);
    }

    // 在链表末尾添加新的元素e
    public void addLast(E e) {
        add(size, e);
    }

    // 获得链表的第index(0-based)个位置的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    // 获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    // 获得链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改链表的第index(0-based)个位置的元素为e
    // 在链表中不是一个常用的操作，练习用：）
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除index(0-based)位置的元素, 返回删除的元素
    // 在链表中不是一个常用的操作，练习用：）
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++)
            prev = prev.next;

        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;

        return retNode.e;
    }

    // 从链表中删除第一个元素, 返回删除的元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后一个元素, 返回删除的元素
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        // 不涉及 size 的话

//        Node cur = dummyHead.next;
//        while(cur != null){
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            res.append(cur + "->");
        res.append("NULL");

        return res.toString();
    }

}
