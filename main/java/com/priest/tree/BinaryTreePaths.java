package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 详情 : 二叉树的所有路径
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-paths/description/
 *
 * @author liangguanglong 2018/9/6
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        if (root.left == null && root.right == null) {
            List<String> newList = new ArrayList<String>();
            newList.add(root.val + "");
            return newList;
        }

        List<String> newList = new ArrayList<String>();
        List<String> leftStr = binaryTreePaths(root.left);
        for (String s : leftStr) {
            newList.add(root.val + "->" + s);
        }
        List<String> rightStr = binaryTreePaths(root.right);
        for (String s : rightStr) {
            newList.add(root.val + "->" + s);
        }

        return newList;
    }

}
