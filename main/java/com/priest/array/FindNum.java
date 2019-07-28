package com.priest.array;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2019/3/2
 */
public class FindNum {

    public  static boolean find(int target, int[][] array) {
        // 1.先找出横向和纵向的范围
        if (array[0][0] > target || array[array.length - 1][array[0].length - 1] < target) {
            return false;
        }
        int xBegin = 0, xEnd = 0, yBegin = 0, yEnd = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i][0] == target) {
                return true;
            }
            if (target > array[i][0]) {
                yBegin = i;
               // yEnd = i;
            } else {
                yBegin = yEnd;
                yEnd = i;
            }
        }

         for (int i = 0; i < array[0].length - 1; i++) {
            if (array[i][0] == target) {
                return true;
            }
            if (target > array[i][0]) {
                xBegin = i;
               // yEnd = i;
            } else {
                xBegin = xEnd;
                xEnd = i;
            }
        }

        System.out.println(xBegin + " " + xEnd + " " + yBegin + " " + yEnd);
        return array[yBegin][xBegin] == target || array[yBegin][yBegin] == target
        || array[yEnd][xBegin] == target || array[yEnd][yBegin] == target;

    }

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        System.out.println(find(7, arr));
    }
}