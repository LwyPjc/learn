package datastructure.link;


/**
 * 带头结点的链表
 */
public class MyLinkedListWithHead<E> {
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

    private Node dummyHead = new Node(null, null);
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
        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        pre.next = new Node(e, pre.next);
        size++;
    }

    /**
     * 获取第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 根据下标查找元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }
        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.node;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * 是否包含某元素
     *
     * @param e
     * @return
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.node.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 修改指定下标处的元素
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {

        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal.");
        }

        Node node = dummyHead.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.node = e;
    }

    public E removeFirst() {
        return remove(0);
    }


    /**
     * 根据下标删除元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("index is illegal");
        }

        Node pre = dummyHead;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        Node cur = pre.next;
        pre.next = cur.next;
        cur.next = null;
        size--;
        return cur.node;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format("LinkedList size = %d\n", size));
        for (Node cur = dummyHead.next; cur != null; cur = cur.next)
            result.append(cur.node + "->");
        result.append("NULL");
        return result.toString();
    }

    public static void main(String[] args) {
        MyLinkedListWithHead<Integer> node = new MyLinkedListWithHead<>();
        for (int i = 0; i < 5; i++) {
            node.addFirst(i);
            System.out.println(node);
        }
        System.out.println("get() " + node.get(node.size - 1));
        node.remove(0);
        System.out.println(node);
    }
}

