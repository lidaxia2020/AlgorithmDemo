package com.lidaxia.leetcode.T100;

import com.lidaxia.leetcode.common.TreeNode;

/**
 * @author lidaxia
 * @desc
 * @date 2022/1/18 15:49（
 */
public class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null) {
            if (q == null) {
                return true;
            } else {
                return false;
            }
        } else {
            if (q == null)
                return false;
            else if (p.val != q.val)
                return false;
        }

        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));

    }


}
