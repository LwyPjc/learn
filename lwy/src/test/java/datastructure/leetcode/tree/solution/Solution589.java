package datastructure.leetcode.tree.solution;

import datastructure.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 */
public class Solution589 {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root != null) {
            result.add(root.val);
            //如果包含有子树
            for (Node node : root.children)
                result.addAll(preorder(node));
        }
        return result;
    }

    private void preOrder(Node node, List<Integer> list) {

    }

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();

        for (Object obj:list){
            System.out.println(obj);
        }
//        System.out.println(list);
    }
}
