package com.priest.array;

/**
 * 详情 : 删除排序数组中的重复项
 * <p>
 * 详细 : https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * @author liangguanglong 2018/6/24
 */
public class RemoveDuplicates {

    /**
     * 从最后开始遍历
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        /**
         * 0,0,1,1,1,2,3,3,4,4
         *
         * 0,0,1,1,1,2,3,4,0
         *
         * 0,0,1,2,3,4,0,0,0
         *
         * 0,1,2,3,4,0,0,0,0
         */
        for (int i = nums.length-1 ; i > 0; i++) {
            int mv = 0;
            if (nums[i] ==nums[i-1]) {

            }
        }
        return 0;
    }
}
