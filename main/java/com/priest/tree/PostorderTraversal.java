package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.*;

/**
 * 详情 : 后序遍历
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * @author liangguanglong 2018/9/23
 */
public class PostorderTraversal {


    List<Integer> nums = new ArrayList<Integer>();

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        addNode(root);
        return nums;
    }

    private void addNode(TreeNode node) {
        if (node != null) {
            addNode(node.left);
            addNode(node.right);
            nums.add(node.val);
        }
    }

    /**
     * 非递归写法1 ，会破坏树结构，不好
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                TreeNode pop = stack.pop();
                // 右节点为空 证明是个叶子节点了，可以pop
                if (pop.right == null) {
                    result.add(pop.val);
                } else {
                    // 右节点不为空，把pop出来的根节点再次返回去，然后指向右节点
                    stack.push(pop);
                    root = pop.right;
                    // 避免pop出来后再次处理右节点，把右节点清了
                    pop.right = null;
                }
            }
        }
        return result;
    }

    /**
     * 最佳答案
     * @param root
     * @return
     */
     public List<Integer> postorderTraversal3(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        LinkedList<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        while (!stack.isEmpty() || root != null) {
            if (root != null) {
                stack.push(root);
                result.addFirst(root.val);
                root = root.right;
            } else {
                TreeNode pop = stack.pop();
                root = pop.left;
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

        PostorderTraversal traversal = new PostorderTraversal();
        List<Integer> list = traversal.postorderTraversal3(root);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
