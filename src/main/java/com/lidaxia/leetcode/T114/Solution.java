package com.lidaxia.leetcode.T114;

import com.lidaxia.leetcode.common.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/20 10:32（
 */
public class Solution {

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null)
            root = root.right;

        root.right = tmp;
    }


}
