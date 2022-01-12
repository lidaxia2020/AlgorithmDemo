package com.lidaxia.leetcode.T110;

import com.lidaxia.leetcode.common.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/11 17:54（
 */
public class Solution {

    public boolean isBalanced(TreeNode root) {

        return height(root) >= 0;
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null)
            return 0;
        int lh = height(treeNode.left);
        int rh = height(treeNode.right);
        if (lh >= 0 && rh >= 0 && Math.abs(lh - rh) <= 1) {
            return Math.max(lh, lh) + 1;
        }
        return -1;
    }
}
