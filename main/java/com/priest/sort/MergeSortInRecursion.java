package com.priest.sort;

/**
 * 详情 : 归并排序  （递归写法）
 * <p>
 * 详细 :
 * 1.把 n 个记录看成 n 个长度为 l 的有序子表
 * 2.进行两两归并使记录关键字有序，得到 n/2 个长度为 2 的有序子表
 * 3.重复第 2 步直到所有记录归并成一个长度为 n 的有序表为止。
 *
 * @author liangguanglong 2018/8/13
 */
public class MergeSortInRecursion {

    // 6, 5, 3, 1, 8, 7, 2, 4
    // 递归
    public void solutionWithRecursion(int[] arr) {
        // 1.新建一个数组存最终的结果，在计算的中间，每次做完一轮的排序就将结果存放新数组，同时同步到原数组
        int[] tmp = new int[arr.length];
        // 2.排序，拆分 sort + merge 2部
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private void mergeSort(int[] arr, int[] tmp, int begin, int end) {
        if (begin >= end) {
            return;
        }
        // 中间位置
        int mid = (end - begin) / 2 + begin;
        int leftBegin = begin, leftEnd = mid,
                rightBegin = mid + 1, rightEnd = end;
        // 1. 左边的进行sort
        mergeSort(arr, tmp, leftBegin, leftEnd); // 5 6
        // 2. 右边的进行sort
        mergeSort(arr, tmp, rightBegin, rightEnd);  // 1 3
        // 3. 左右进行merge
        int k = begin;
        // 逐个比较，可能是左边先排好，右边的还有一部分没写入tmp，或者相反
        while (leftBegin <= leftEnd && rightBegin <= rightEnd) {
            if (arr[leftBegin] < arr[rightBegin]) {
                tmp[k] = arr[leftBegin];
                k++;
                leftBegin++;
            } else {
                tmp[k] = arr[rightBegin];
                k++;
                rightBegin++;
            }
        }
        // 检测左边
        while (leftBegin <= leftEnd) {
            tmp[k] = arr[leftBegin];
            leftBegin++;
            k++;
        }
        // 检测右边
        while (rightBegin <= rightEnd) {
            tmp[k] = arr[rightBegin];
            rightBegin++;
            k++;
        }

        // 将tmp的结果写到 arr去
        for (k = begin; k <= end; k++) {
            arr[k] = tmp[k];
            System.out.print(arr[k] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        MergeSortInRecursion mergeSort = new MergeSortInRecursion();
        mergeSort.solutionWithRecursion(arr);

        System.out.println("结果是：");
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
