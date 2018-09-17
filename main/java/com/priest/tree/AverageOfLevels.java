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

    /**
     * 思路：采用BFS（广度优先搜索）
     * 先把父节点入栈，然后在一级子节点入栈之前，先将stack全pop出来实现层级遍历
     */
    public List<Double> averageOfLevels(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        // 使用队列，先进先出，在子节点入队列的时候可以 一边 pop 父节点，一边写入子节点，从而节省空间
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        List<Double> avgArr = new ArrayList<>();

        while (!treeNodes.isEmpty()) {
            int num = treeNodes.size();
            double sum = 0;
            for (int i = 0; i < num; i++) {
                TreeNode pop = treeNodes.remove();
                if (pop.left != null) {
                    treeNodes.add(pop.left);
                }
                if (pop.right != null) {
                    treeNodes.add(pop.right);
                }
                sum = sum + pop.val;
            }
            avgArr.add(sum / num);
        }

        return avgArr;
    }
}
