package com.lidaxia.leetcode.T94;

import com.lidaxia.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/5 16:16（
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.right == null && root.left == null) {
            result.add(root.val);
            return;
        }

        if (root.left != null)
            inorderTraversal(root.left, result);

        result.add(root.val);

        if (root.right != null)
            inorderTraversal(root.right, result);

    }


}
