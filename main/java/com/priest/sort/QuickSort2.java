package com.priest.sort;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/8/18
 */
public class QuickSort2 {

    /**
     * 1.随便定一个中位数，找到中位数在数组的位置
     * 2.遍历交换，达到中位数右边都是比中位数大的，左边都是比中位数小的
     * 3.递归处理
     */
    public static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        //1.确定中位数
        int pivot = arr[(begin + end)/2];
        //2.找到中位数的位置
        int i = begin, j= end;
        while (i<j) {
            // 右边移动
            while (arr[j] > pivot)  --j;
            // 左边移动
            while (arr[i] < pivot) {
                ++i;
            }
            // 遇到有左边和右边  有不符合 左小右大的规则的元素，交换
            if(i < j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i ++;
                j --;
            } else {
                // 相等的话需要 向前移位
                ++ i;
            }
            for (int i1 = 0; i1 < arr.length; i1++) {
                System.out.print(arr[i1]);
            }
            System.out.println();
        }
        //3.对左边的进行递归处理
        quickSort(arr, begin, j);
        //4.对右边的进行递归处理
        quickSort(arr, i, end);
    }

    public static void main(String[] args) {
        int[] arr = {6,3,7,4,9,1,5};
        QuickSort2.quickSort(arr, 0, arr.length - 1);
    }
}
