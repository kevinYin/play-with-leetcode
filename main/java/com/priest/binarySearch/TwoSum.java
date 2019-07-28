package com.priest.binarySearch;

import java.util.HashMap;

/**
 * 详情 : 两数之和 II - 输入有序数组
 * <p>
 * 详细 : https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * @author liangguanglong 2019/6/23
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        int beginIdx = 0, endIdx = numbers.length - 1;
        while (endIdx > beginIdx) {
            int sum = numbers[beginIdx] + numbers[endIdx];
            if (sum == target) break;
            if (sum > target) endIdx --;
            if (sum < target) beginIdx ++ ;
        }
        int[] result = new int[2];
        result[0] = beginIdx + 1;
        result[1] = endIdx + 1;
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> num2Idx = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            num2Idx.put(numbers[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (num2Idx.containsKey(target - numbers[i])) {
                result[0] = i + 1;
                result[1] = num2Idx.get(target - numbers[i]) + 1;
                break;
            }
        }

        return result;
    }
}
