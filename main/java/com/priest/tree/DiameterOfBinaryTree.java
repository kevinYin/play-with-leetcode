package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 二叉树的直径
 * <p>
 * 详细 :https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
 *
 * @author liangguanglong 2018/9/10
 */
public class DiameterOfBinaryTree {

    private int maxLength = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        nodeMaxLength(root.left);

        nodeMaxLength(root.right);

        return maxLength;
    }

    private void nodeMaxLength(TreeNode node) {
        int length = maxLength(node.left) + maxLength(node.right);
        if(maxLength < length) {
            maxLength = length;
        }
    }

    private int maxLength(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 1 + maxLength(root.left);

        int right = 1 + maxLength(root.right);

        return left > right ? left : right;
    }
}
