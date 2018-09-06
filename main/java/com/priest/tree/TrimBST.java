package com.priest.tree;

import com.priest.common.TreeNode;

/**
 * 详情 : 修剪二叉搜索树
 * <p>
 * 详细 : https://leetcode-cn.com/problems/trim-a-binary-search-tree/description/
 *
 * @author liangguanglong 2018/9/5
 */
public class TrimBST {

    public TreeNode trimBST(TreeNode root, int L, int R) {

        if (root == null) {
            return root;
        }

        if (root.val < L) {
            return trimBST(root.right, L, R);
        }
        if (root.val > R) {
            return trimBST(root.left, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
