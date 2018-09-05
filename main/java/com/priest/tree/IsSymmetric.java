package com.priest.tree;


import com.priest.common.TreeNode;

/**
 * 详情 : 对称二叉树
 * <p>
 * 详细 : https://leetcode-cn.com/problems/symmetric-tree/description/
 *
 * @author liangguanglong 2018/9/3
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        // 左右都不为空，递归处理
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        treeNode.left = left;
        IsSymmetric symmetric = new IsSymmetric();
        boolean symmetricSymmetric = symmetric.isSymmetric(treeNode);
        System.out.println(symmetricSymmetric);
    }
}


