package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 详情 : 先序遍历 (非递归)
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * @author liangguanglong 2018/9/23
 */
public class PreorderTraversal {

//    ArrayList<Integer> result = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            if (root !=null) {
                result.add(root.val);
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                root = pop.right;
            }
        }
    //    addNode(root);
        return result;
    }

    private void addNode(TreeNode root) {
        if (root != null) {
       //     result.add(root.val);
            addNode(root.left);
            addNode(root.right);
        }
    }
}
