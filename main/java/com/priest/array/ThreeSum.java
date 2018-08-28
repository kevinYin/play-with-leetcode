package com.priest.array;

import java.util.*;

/**
 * 详情 : 给定一个包含 n 个整数的数组 S，
 * 是否存在属于 S 的三个元素 a，b，c 使得 a + b + c = 0 ？
 * 找出所有不重复的三个元素组合使三个数的和为零
 * <p>
 * <link>https://leetcode-cn.com/problems/3sum/description/
 *
 * @author liangguanglong 2018/4/8
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> numb2CountMap = new HashMap<Integer, Integer>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (numb2CountMap.get(nums[i]) != null) {
                numb2CountMap.put(nums[i], numb2CountMap.get(nums[i]) + 1);
            } else {
                numb2CountMap.put(nums[i], 1);
            }
        }

        Set<Integer> keySet = numb2CountMap.keySet();
        List<Integer> keys = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!keySet.contains(nums[i])) {
                keys.add(nums[i]);
            }
        }

        for (int i = 0; i < keys.size(); i++) {
            int num = keys.get(i);
            List<Integer> tmp = null;
            // 看总数，重复的数量
            Integer count = numb2CountMap.get(num);
            if (count >= 3) {
                if (num == 0) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(0);
                    tmp.add(0);
                    tmp.add(0);
                }
            } else if (count == 2) {
                int keyNum = 0 - num - num;
                if (numb2CountMap.get(keyNum) != null && keyNum > num) {
                    tmp = new ArrayList<Integer>();
                    tmp.add(num);
                    tmp.add(num);
                    tmp.add(keyNum);
                }
            } else {
                for (int j = i + 1; j < keys.size(); j++) {
                    int keyNum = 0 - num - nums[j];
                    if (numb2CountMap.get(keyNum) != null && keyNum > num && keyNum >= nums[j]) {
                        if (keyNum == nums[j]) {
                            if (numb2CountMap.get(keyNum) > 1) {
                                tmp = new ArrayList<Integer>();
                                tmp.add(num);
                                tmp.add(nums[j]);
                                tmp.add(keyNum);
                            }
                        } else {
                            tmp = new ArrayList<Integer>();
                            tmp.add(num);
                            tmp.add(nums[j]);
                            tmp.add(keyNum);
                        }
                    }
                }
            }

            if (tmp != null) {
                result.add(tmp);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] arr = {1,2,-2,-1};
        List<List<Integer>> lists = threeSum.threeSum(arr);

        for (List<Integer> list : lists) {
            System.out.print(list.get(0) + ",");
            System.out.print(list.get(1) + ",");
            System.out.print(list.get(2));
            System.out.println();
        }
    }
}

