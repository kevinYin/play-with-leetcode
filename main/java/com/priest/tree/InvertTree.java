package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 翻转二叉树
 * <p>
 * 详细 : https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * @author liangguanglong 2018/9/5
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }

}
