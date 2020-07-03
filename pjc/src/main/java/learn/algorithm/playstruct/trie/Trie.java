package learn.algorithm.playstruct.trie;

import java.util.TreeMap;

/**
 * 字典树
 * 默认节点存储的都是Character 对象
 * 添加，查找复杂度只与字符串长度有关
 * 前缀搜索 路径即前缀
 */
public class Trie {

    private class Node {
        // 此节点是否为单词
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    // 单词数量
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * Trie 中单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 给Trie 添加单词
     */
    public void add(String word) {
        Node cur = root;
        // 组装单词
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        // 标记单词
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词word 是否在Trie 中
     */
    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (!cur.next.containsKey(word.charAt(i))) {
                return false;
            }
            cur = cur.next.get(word.charAt(i));
        }
        // 不能直接返回 true，有一个单词 为 nicer,nice 并不存在
//        return true;
        return cur.isWord;
    }

    /**
     * 前缀搜索
     * 是否存在此前缀
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }


}
