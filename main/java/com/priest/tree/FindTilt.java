package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 二叉树的坡度
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-tilt/description/
 *
 * @author liangguanglong 2018/9/5
 */
public class FindTilt {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.abs(nodeSum(root.right) - nodeSum(root.left)) + findTilt(root.left) +findTilt(root.right);
    }

    private int nodeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + nodeSum(node.left) + nodeSum(node.right);
    }

}
