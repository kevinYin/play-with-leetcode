package com.priest.bit;

/**
 * 详情 : 461. 汉明距离
 * <p>
 * 详细 : https://leetcode-cn.com/problems/hamming-distance/
 *
 * @author liangguanglong 2019/7/7
 */
public class HammingDistance {

     public int hammingDistance(int x, int y) {
         int resultNum = x ^ y;
         int result = 0;

         // 从最右边的1开始，每一次操作都使n的最右的一个1变成了0，
         // 即使是符号位也会进行操作。
         while (resultNum != 0) {
             result ++ ;
             resultNum = (resultNum - 1) & resultNum;
         }
         return result;
     }
}
