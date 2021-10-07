package datastructure.leetcode.tree.solution;

import datastructure.leetcode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树中序遍历
 */
public class Solution94 {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root != null) {

            if (root.left != null) {
                result.addAll(inorderTraversal(root.left));
            }

            result.add(root.val);
            if (root.right != null) {
                result.addAll(inorderTraversal(root.right));
            }
        }
        return result;

    }
}
