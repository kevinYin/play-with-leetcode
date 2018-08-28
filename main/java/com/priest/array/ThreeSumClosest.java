package com.priest.array;

/**
 * 详情 : https://leetcode-cn.com/problems/3sum-closest/description/
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/4/27
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {

        Integer result = null;
        Integer cha = null;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    for (int k = 0; k < nums.length; k++) {
                        if (j != k && k != i) {
                            int sum = nums[i] + nums[j] + nums[k];
                            int tmp = target - sum;
                            if (result == null) {
                                result = sum;
                                cha = tmp;
                            } else if (Math.abs(tmp) < Math.abs(cha)) {
                                cha = tmp;
                                result = sum;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest = new ThreeSumClosest();
        int sumClosest = threeSumClosest.threeSumClosest(new int[]{1, 1, 1, 0}, -100);
        System.out.println(sumClosest);
    }
}
