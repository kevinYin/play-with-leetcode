package com.priest.sort;

/**
 * 详情 : 冒泡排序
 * <p>
 * 详细 :
 *  1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
    2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
    3.针对所有的元素重复以上的步骤，除了最后一个。
    4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 *
 * @author liangguanglong 2018/8/13
 */
public class Maopao {
    public int[] solution(int[] arr) {
        if (arr == null ||arr.length == 0) {
            return arr;
        }
        // 9 8 6 7 5
        for (int i = 0; i < arr.length; i++) {
            //每一遍将最大的数放到最后
            int tmp;
            for (int j = 0; j + 1 < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                     tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            //  8 6 7 5 9
            for (int i1 : arr) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }

        return arr;
    }

    public static void main(String[] args) {
        Maopao maopao = new Maopao();
        int[] arr = {9,8,6 ,7, 5};
        maopao.solution(arr);
    }
}
