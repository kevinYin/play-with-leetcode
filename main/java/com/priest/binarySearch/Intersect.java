package com.priest.binarySearch;

import java.util.*;

/**
 * 详情 : 350. 两个数组的交集 II
 * <p>
 * 详细 : https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 *
 * @author liangguanglong 2019/7/6
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> num2CountMap1 = convert2Map(nums1);
        HashMap<Integer, Integer> num2CountMap2 = convert2Map(nums2);

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : num2CountMap1.entrySet()) {
            if (num2CountMap2.containsKey(entry.getKey())) {
                Integer count = entry.getValue() > num2CountMap2.get(entry.getKey()) ? num2CountMap2.get(entry.getKey()) : entry.getValue();
                for (int i = 0; i < count; i++) {
                    result.add(entry.getKey());
                }
            }
        }
        int[] nums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }

    private HashMap<Integer, Integer> convert2Map(int[] nums) {
        HashMap<Integer, Integer> num2CountMap2 = new HashMap<>();
        for (int num : nums) {
            if (num2CountMap2.get(num) == null) {
                num2CountMap2.put(num, 1);
            } else {
                num2CountMap2.put(num, 1 + num2CountMap2.get(num));
            }
        }
        return num2CountMap2;
    }

    // 先排序，后用2个指针 遍历2个数组
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int firstIdx = 0;
        int secondIdx = 0;
        ArrayList<Integer> result = new ArrayList<>();
        while (firstIdx < nums1.length && secondIdx < nums2.length) {
            if (nums1[firstIdx] == nums2[secondIdx]) {
                result.add(nums1[firstIdx]);
                firstIdx ++;
                secondIdx ++;
            } else if (nums1[firstIdx] > nums2[secondIdx]) {
                 secondIdx ++;
            } else {
                 firstIdx ++;
            }
        }
         int[] nums = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            nums[i] = result.get(i);
        }
        return nums;
    }
}
