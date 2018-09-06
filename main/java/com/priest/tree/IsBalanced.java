package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 平衡二叉树
 * <p>
 * 详细 : https://leetcode-cn.com/problems/balanced-binary-tree/description/
 *
 * @author liangguanglong 2018/9/6
 */
public class IsBalanced {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }

        return Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDepth(TreeNode node) {

        if (node == null) {
            return 0;
        }
        int leftDepth = getDepth(node.left);
        int rightDepth = getDepth(node.right);
        if (leftDepth > rightDepth) {
            return 1 + leftDepth;
        }
        return 1 + rightDepth;
    }
}
