package com.priest.bit;

/**
 * 详情 : 136. 只出现一次的数字
 * <p>
 * 详细 : https://leetcode-cn.com/problems/single-number/
 *
 * @author liangguanglong 2019/7/7
 */
public class SingleNumber {

     public int singleNumber(int[] nums) {
        int result = nums[0];
         for (int i = 1; i < nums.length; i++) {
             result = result ^ nums[i];
         }
         return result;
    }
}
