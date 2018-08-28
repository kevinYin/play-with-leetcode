package com.priest.sort;

/**
 * 详情 : 快速排序
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/4/5
 */
public class QuickSort {

    /**
     * 快排的思想：从第一位数，视为基准数（类似基准数,可以随便选一个位置的数作为基准数），然后从左边和右边开始遍历
     * 如果左边的数大于基准数，右边的数小于基准数，这个时候，就将2者进行互换，
     * 到最后如果左边的index == 右边的index，则，将基准数与这个数进行互换，
     * 最终的效果就是左边的数都是小于基准数，右边的数都是大于基准数的
     * 然后递归处理左边的数组和右边的
     */
    public void quickSort(int[] arr, int start, int end) {
        int realStart = start + 1;
        int realEnd = end;
        if (realEnd < realStart) {
            return;
        }
        // 第一个数作为基准数
        int midNum = arr[start];
        while (realStart <= realEnd) {
            while(midNum < arr[realEnd]) {
                realEnd -- ;
            }
            while(realStart <= realEnd && midNum > arr[realStart]) {
                realStart ++ ;
            }

            if(realStart < realEnd) {
                // 如果还没碰到一起就互换，否则，
                int tmp = arr[realEnd];
                arr[realEnd] = arr[realStart];
                arr[realStart] = tmp;
            } else {
                // 碰到最后一个数 基准数跟最后一个数进行互换，完成本次基准数的位置存放
                int tmp = arr[realEnd];
                arr[realEnd] = midNum;
                arr[start] = tmp;
                System.out.println("基准数是：" + midNum + "获取到的位置是：" + realEnd);
            }
        }
        print(arr);
        quickSort(arr, start, realEnd);
        quickSort(arr, realStart, end);
    }

    private void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort.quickSort(arr, 0, arr.length - 1);
    }
}
