package com.priest.str;

/**
    https://leetcode-cn.com/problems/rotate-string/description/
    旋转字符串
 *
 * @author liangguanglong 2018/8/19
 */
public class RotateString2 {

    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return true;
        }

        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        // 找到第一个数在B中的索引，每找到一个，就根据索引比较对应位置的值是否相等
        // 不相等则跳出继续
        char key = c1[0];
        for (int offset = 0; offset < c2.length; offset++) {
            if (c2[offset] == key) {
                // 根据偏移量 比较对应的位置
                for (int k = 0; k < c1.length; k++) {
                    int c2Index = k + offset;
                    if (c2Index >= c1.length) {
                        c2Index = c2Index - c1.length;
                    }
                    if (c1[k] != c2[c2Index]) {
                        break;
                    }
                    if (k == (c1.length - 1)) {
                        return true;
                    }
                }
            }
        }

        return  false;
    }



    public static void main(String[] args) {
        String A = "abcde", B = "cdaeb";

        boolean result = RotateString2.rotateString(A, B);
        System.out.println(result);
    }
}
