package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 详情 : 二叉树的层次遍历 II
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/description/
 *
 * @author liangguanglong 2018/9/15
 */
public class LevelOrderBottom {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        LinkedList<List<Integer>> list = new LinkedList<List<Integer>>();

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> nums = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode remove = queue.remove();
                nums.add(remove.val);
                if (remove.left != null) {
                    queue.addLast(remove.left);
                }
                if (remove.right != null) {
                    queue.addLast(remove.right);
                }
            }
            list.addFirst(nums);
        }

        return list;

    }


}
