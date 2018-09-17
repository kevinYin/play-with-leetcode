package com.priest.tree;

import com.priest.common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 详情 : 二叉搜索树中的众数
 * <p>
 * 详细 : https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/description/
 *
 * @author liangguanglong 2018/9/15
 */
public class FindMode {

    private Map<Integer, Integer> map = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        iterate(root);

        int maxNum = 0;
        for (Integer num : map.values()) {
            if (num > maxNum) {
                maxNum = num;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxNum) {
                list.add(entry.getKey());
            }
        }

        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    private void iterate(TreeNode root) {
        if (root == null) {
            return;
        }
        iterate(root.right);
        iterate(root.left);

        if (map.get(root.val) == null) {
            map.put(root.val, 1);
        } else {
             map.put(root.val, map.get(root.val) + 1);
        }
    }
}
