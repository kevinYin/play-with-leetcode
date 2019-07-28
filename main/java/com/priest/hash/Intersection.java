package com.priest.hash;

import java.util.*;

/**
 * 详情 : 349. 两个数组的交集
 * <p>
 * 详细 : https://leetcode-cn.com/problems/intersection-of-two-arrays/
 *
 * @author liangguanglong 2019/6/16
 */
public class Intersection {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Integer num : set1) {
            if (set2.contains(num)) {
                list.add(num);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        List<Integer> numsList1 = new ArrayList<>();
        List<Integer> numsList2 = new ArrayList<>();
        for (int i : nums1) {
           numsList1.add(i);
        }
        for (int i : nums2) {
          numsList2.add(i);
        }
        Collections.sort(numsList1);
        Collections.sort(numsList2);

        List<Integer> list = new ArrayList<>();
        int head1, head2;
        for (int i = 0, j = 0; i < numsList1.size() && j < numsList2.size(); ) {
            head1 = numsList1.get(i);
            head2 = numsList2.get(j);
            if (list.size() > 0 && list.get(list.size() -1 ) == head1) {
                i ++ ;
                continue;
            }
            if (list.size() > 0 && list.get(list.size() -1 ) == head2) {
                j ++ ;
                continue;
            }
            if (head1 == head2) {
                list.add(head1);
                i++;
                j++;
            } else if (head1 > head2) {
                j ++;
            } else {
                i ++;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Intersection intersection = new Intersection();
        int[] result = intersection.intersection2(nums1, nums2);
        System.out.println(result);
    }
}
