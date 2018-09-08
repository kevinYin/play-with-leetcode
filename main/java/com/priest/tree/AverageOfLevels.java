package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.*;

/**
 * 详情 : 二叉树的层平均值
 * <p>
 * 详细 : https://leetcode-cn.com/problems/average-of-levels-in-binary-tree/description/
 *
 * @author liangguanglong 2018/9/8
 */
public class AverageOfLevels {

    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        List<Double> avgArr = new ArrayList<Double>();
        if (stack.isEmpty()) {
            return Collections.emptyList();
        }
        while (!stack.isEmpty()) {
            ArrayList<TreeNode> subNodes = new ArrayList<TreeNode>();

            double num = 0, sum = 0;
            while (!stack.isEmpty()) {
                TreeNode pop = stack.pop();
                num++;
                sum = sum + pop.val;

                // 处理子节点
                if (pop.left != null) {
                    subNodes.add(pop.left);
                }
                if (pop.right != null) {
                    subNodes.add(pop.right);
                }
            }
            for (TreeNode subNode : subNodes) {
                stack.push(subNode);
            }
            avgArr.add(sum /num);
        }

        return avgArr;
    }

}
