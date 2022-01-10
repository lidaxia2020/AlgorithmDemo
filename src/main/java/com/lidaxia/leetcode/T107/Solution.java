package com.lidaxia.leetcode.T107;

import com.lidaxia.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 107. 二叉树的层序遍历 II
 * @author lidaxia
 * @desc
 * @date 2022/1/10 16:50（
 */
public class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();

        if (root == null)
            return result;

        LinkedBlockingQueue<LinkedList<TreeNode>> queue = new LinkedBlockingQueue<>();
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        queue.add(list);
        List<Integer> integerList;
        while (!queue.isEmpty()) {
            LinkedList<TreeNode> l = queue.poll();
            list = new LinkedList<TreeNode>();
            integerList = new ArrayList<>();
            for (TreeNode treeNode : l) {
                if (treeNode.left != null)
                    list.add(treeNode.left);
                if (treeNode.right != null)
                    list.add(treeNode.right);
                integerList.add(treeNode.val);
            }

            if (list.size() > 0) {
                queue.add(list);
            }
            result.addFirst(integerList);
        }

        return result;
    }
}
