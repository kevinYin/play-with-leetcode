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
        // 左节点 先序遍历
        String left = leftErgodic(root.left);
        // 右节点 后序遍历
        String right = rightErgodic(root.right);
        // 比较是否一致
        return left.equals(right);
    }

    private String leftErgodic(TreeNode root) {
        if (root == null) {
            return ",";
        }

        String str = "";
        if (root.left != null) {
            str = str + leftErgodic(root.left) + ",";
        } else {
            str = str + ",";
        }

        str = str + root.val;

        if (root.right != null) {
            str = str + leftErgodic(root.right)  + ",";
        } else {
            str = str + ",";
        }

        return str;
    }

    private String rightErgodic(TreeNode root) {
        if (root == null) {
            return ",";
        }
        String str = "";

        if (root.right != null) {
            str = str + rightErgodic(root.right) + ",";
        } else {
            str = str + ",";
        }

        str = str + root.val;

        if (root.left != null) {
            str = str + rightErgodic(root.left)  + ",";
        } else {
            str = str + ",";
        }

        return str;
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


