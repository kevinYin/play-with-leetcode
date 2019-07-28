package com.priest.binarySearch;

/**
 * 详情 : 二分查找
 * <p>
 * 详细 : https://leetcode-cn.com/problems/binary-search/
 *
 * @author liangguanglong 2019/6/22
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length - 1] < target) {
            return -1;
        }
        return getIdx(nums, 0, nums.length - 1, target);
    }

    private int getIdx(int[] nums, int begin, int end, int target) {
        if ((end - begin) == 1) {
            if (nums[begin] == target) {
                return begin;
            }
             if (nums[end] == target) {
                return end;
            }
            return -1;
        }
        int mid = (begin + end) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] > target) {
            return getIdx(nums, begin, mid, target);
        }
        return getIdx(nums, mid, end, target);
    }


 public int search2(int[] nums, int target) {
       int begin = 0, end = nums.length - 1;
       while (begin <= end) {
           int mid = (begin + end) / 2;
           if (nums[mid] == target) {
               return mid;
           }
           if (nums[mid] > target) {
               end = mid - 1;
           } else {
               begin = mid + 1;
           }
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        BinarySearch search = new BinarySearch();
        int search1 = search.search2(arr, 2);
        System.out.println(search1);
    }

}
