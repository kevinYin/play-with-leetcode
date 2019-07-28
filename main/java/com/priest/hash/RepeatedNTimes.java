package com.priest.hash;

import java.util.HashSet;

/**
 * 详情 : 重复 N 次的元素
 * <p>
 * 详细 : https://leetcode-cn.com/problems/n-repeated-element-in-size-2n-array/
 *
 * @author liangguanglong 2019/6/12
 */
public class RepeatedNTimes {

    public int repeatedNTimes(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            if (set.contains(i)) {
                return i;
            }
            set.add(i);
        }
        return 0;
    }
}
