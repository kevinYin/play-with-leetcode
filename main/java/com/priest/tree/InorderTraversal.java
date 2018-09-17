package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 详情 : 中序遍历
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * @author liangguanglong 2018/9/16
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            // 先将左节点入栈
            TreeNode leftNode = root.left;
            if (leftNode != null) {
                stack.push(root);
                root = leftNode;
            } else {
                // 左节点为空，则出栈，root指向当前pop节点
                result.add(root.val);
                if (root.right == null) {
                    if (stack.isEmpty()) {
                        break;
                    }
                    root = stack.pop();
                    root.left = null;
                } else {
                    root = root.right;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);

        right.left = rightLeft;
        root.right = right;

        InorderTraversal traversal = new InorderTraversal();
        List<Integer> list = traversal.inorderTraversal(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
