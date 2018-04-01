package com.priest.array;

/**
 * 详情 :
 * <p>给定一个整数数列，找出其中和为特定值的那两个数。
    你可以假设每个输入都只会有一种答案，同样的元素不能被重用。

    示例:
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]

 * @link https://leetcode-cn.com/problems/two-sum/description/
 * @author liangguanglong 2018/4/1
 */
public class ArrayTwoSum {

    public int[] twoSum(int[] nums, int target) {
        int[] result = null;

        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j == i) {
                    continue;
                }
                if (other == nums[j]) {
                    result = new int[2];
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
            if (result != null) {
                return result;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayTwoSum sum = new ArrayTwoSum();
        int[] arr = {2, 7, 11, 15};
        int[] twoSum = sum.twoSum(arr, 9);
        System.out.println("结果是：" + twoSum[0] + " " + twoSum[1]);
    }
}
