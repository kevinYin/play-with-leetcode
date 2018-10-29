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
            if (root !=null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                result.add(pop.val);
                root = pop.right;
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
