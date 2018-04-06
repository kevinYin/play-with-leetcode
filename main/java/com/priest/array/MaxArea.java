package com.priest.array;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/4/2
 */
public class MaxArea {

    public int maxArea(int[] height) {

        int groups = height.length / 1000 + 1;
        int maxWeight = 0;
        for (int i = 0; i < groups; i++) {
            int begin = i;
            int end = (i + 1) * 1000 > height.length ? height.length : (i + 1) * 1000;
            maxWeight = getMaxWeight(height, maxWeight, begin, end);
        }

        return maxWeight;
    }

    private int getMaxWeight(int[] height, int maxWeight, int begin, int end) {
        for (int i = begin; i < end + 1; i++) {
            for (int j = i + 1; j < end + 1; j++) {
                int width = j - i;
                int heightValue = height[i] > height[j] ? height[j] : height[i];
                int result = (width * heightValue);
                if (maxWeight < result ) {
                    maxWeight = result;
                }
            }
        }
        return maxWeight;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        MaxArea maxArea = new MaxArea();
        int result = maxArea.maxArea(arr);
        System.out.println(result);
    }
}
