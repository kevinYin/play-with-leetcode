package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.*;

/**
 * 详情 : 二叉树的层次遍历
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * @author liangguanglong 2018/9/8
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> nums = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                nums.add(remove.val);

                if(remove.left != null) queue.add(remove.left);
                if(remove.right != null) queue.add(remove.right);
            }
            lists.add(nums);
        }

        return lists;
    }
}
