package learn.algorithm.playstruct.trie;

import java.util.TreeMap;

/**
 * 677 号问题
 */
public class MapSum {

    private class Node {

        public int value;// 单词的值 表明是个单词
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {

        root = new Node();
    }

    @SuppressWarnings("all")
    public void insert(String key, int val) {

        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null)
                cur.next.put(c, new Node());
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return 0;
            cur = cur.next.get(c);
        }
        // 此时cur 为prefix 最后一个字符，
        return sum(cur);
    }

    /**
     * 找到所有表示单词的路径节点
     *
     * @param node
     * @return
     */
    private int sum(Node node) {
        // 下面的内容可以不用写
//        if (node.next.size() == 0) {
//            return node.value;
//        }
        int res = node.value;
        for (char c : node.next.keySet())
            res += sum(node.next.get(c));
        return res;
    }
}
