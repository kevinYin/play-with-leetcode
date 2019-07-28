package com.priest.binarySearch;

/**
 * 详情 : 35. 搜索插入位置
 * <p>
 * 详细 : https://leetcode-cn.com/problems/search-insert-position/
 *
 * @author liangguanglong 2019/6/24
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) return 0;
        if (target > nums[nums.length - 1]) return nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
            if (target < nums[i]) return i;
        }
        return 0;
    }

    public int searchInsert2(int[] nums, int target) {
       int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) {
                return mid;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6};
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert2(arr, 4));
    }
}
