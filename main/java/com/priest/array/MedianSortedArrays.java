package com.priest.array;

/**
 * 有两个大小为 m 和 n 的排序数组 nums1 和 nums2 。
 * 请找出两个排序数组的中位数并且总的运行时间复杂度为 O(log (m+n))
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 中位数是 (2 + 3)/2 = 2.5
 *
 * @author liangguanglong 2018/4/1
 * @link https://leetcode-cn.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianSortedArrays {

    /**
     * 思路：用归并排序的方式处理
     *       先合并2个数组，然后取中间数
     *       合并过程：先创建一个大数组，然后将逐步合入，最后完成合并
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // 1.初始化一个大数组存放最终的结果
        int[] arr = new int[A.length + B.length];
        // 2.初始化2个数组的起始位置
        int i = 0, j = 0;
        // 3.比较2个起始位置的大小，小的写入新的数组，并且将起始位置移到下一个位置
        for (int index = 0; index < arr.length; index++) {
            // A已经全部写入 arr了
            if (i == A.length) {
                for (; j < B.length; j++) {
                    arr[index] = B[j];
                    index ++;
                }
                break;
            } else if (j == B.length) {
                // B已经全部写入 arr了
                for (; i < A.length; i++) {
                    arr[index] = A[i];
                    index ++;
                }
                break;
            }

            if (A[i] <= B[j]) {
                arr[index] = A[i];
                i++;
            } else {
                arr[index] = B[j];
                j++;
            }
        }

        if (arr.length % 2 == 1) {
            return (double) arr[arr.length/2];
        }
        return ((double) arr[arr.length/2 - 1 ] + (double) arr[arr.length/2])/2;
    }

    public static void main(String[] args) {
        MedianSortedArrays sortedArrays = new MedianSortedArrays();
       int[] nums1 = {1, 2},nums2 = {3};
        double result = sortedArrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
}
