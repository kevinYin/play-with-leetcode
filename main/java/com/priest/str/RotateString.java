package com.priest.str;

/**
    https://leetcode-cn.com/problems/rotate-string/description/
    旋转字符串
 *
 * @author liangguanglong 2018/8/19
 */
public class RotateString {

    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return true;
        }

        char[] c1 = A.toCharArray();
        StringBuilder sb;
        for (int k = 0; k < c1.length; k++) {
            char first = c1[0];
            for (int i = 0; i < c1.length - 1; i++) {
                c1[i] = c1[i + 1];
            }
            c1[c1.length - 1] = first;

            sb = new StringBuilder();
            for (int i = 0; i < c1.length; i++) {
                sb.append(c1[i]);
            }
            if (sb.toString().equals(B)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        String A = "", B = "";

        boolean result = RotateString.rotateString(A, B);
        System.out.println(result);
    }
}
