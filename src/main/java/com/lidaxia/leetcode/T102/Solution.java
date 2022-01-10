package com.lidaxia.leetcode.T102;

import com.lidaxia.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 102. 二叉树的层序遍历
 *
 * @author lidaxia
 * @desc
 * @date 2022/1/10 15:58（
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

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
            result.add(integerList);
        }

        return result;
    }
}
