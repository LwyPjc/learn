package groupId;

/**
 * 双向循环列表
 *
 * @param <E>
 */
public class LoopList<E> {
    private class Node {
        private E e;
        private Node prior, next;

        public Node(E e) {
            this.e = e;
            prior = next = null;
        }

        public Node() {

        }
    }

    private Node head;
    private int size;



    public int size() {
        return size;
    }

    public void add(E e) {
        if (head == null) {
            head = new Node(e);
            head.prior = head;
            head.next = head;
        } else {
            Node node = head;
            //使用尾插法
            Node target = new Node(e);

            target.prior = head.prior;

            head.prior.next = target;
            head.prior = target;
            target.next = head;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node node = head;
        while (node.next != head) {
            res.append(node.e + "->");
            node = node.next;
        }
        res.append(node.e + "-> NULL");
        return res.toString();
    }


    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index illegal~");
        }
        Node node = head;
        if (index == 0) {
            head = head.next;
        }
        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        node.prior.next = node.next;
        node.next.prior = node.prior;
        node.prior = null;
        node.next = null;
        size--;

        return node.e;

    }

    public E get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.e;
    }

    public int quit(int startIndex, int targetIndex, int freq, int[] nums) {
        LoopList<Integer> list = new LoopList<>();
        //因为nums[]数组从0开始，所以将传入的 startIndex-1
        int index = startIndex - 1;
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
//            index = (index+1)/
        }
        int i = 1;
        int count = 0;
        while (!list.isEmpty()) {
            if (i % freq == 0) {

                index = (index + freq - 1) % list.size();
                if (list.get(index) == targetIndex - 1) {
//                    list.remove(index);
                    count++;
                    System.out.println("第 "+count+"次 移除 "+(list.remove(index)+1));
                    break;
                }
                count++;
                System.out.println("第 "+count+"次 移除 "+(list.remove(index)+1));

            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[20];
        for (int i = 0; i < 20; i++) {
            nums[i] = i;
        }
        LoopList<Integer> list = new LoopList<>();
        System.out.println(list.quit(13, 19, 3, nums));
    }
}
