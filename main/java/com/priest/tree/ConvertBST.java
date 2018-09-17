package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 把二叉搜索树转换为累加树
 * <p>
 * 详细 : https://leetcode-cn.com/problems/convert-bst-to-greater-tree/description/
 *
 * @author liangguanglong 2018/9/9
 */
public class ConvertBST {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root.right);
        root.val = root.val + sum;
        sum = root.val;
        helper(root.left);
    }
}
