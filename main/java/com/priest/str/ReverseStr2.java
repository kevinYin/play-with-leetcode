package com.priest.str;

/**
 * 详情 : 反转字符串 II
 * <p>
 * 详细 : https://leetcode-cn.com/problems/reverse-string-ii/description/
 *
 * @author liangguanglong 2018/8/30
 */
public class ReverseStr2 {

    public static String reverseStr(String s, int k) {
        char[] c1 = s.toCharArray();
        if (s.length() < k) {
            revert(c1, 0, c1.length - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c1.length; i++) {
                sb.append(c1[i]);
            }
            return sb.toString();
        }
        if (s.length() >= k && s.length() < 2 * k) {
            revert(c1, 0, k - 1);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < c1.length; i++) {
                sb.append(c1[i]);
            }
            return sb.toString();
        }

        for (int i = 0; i < c1.length / (2 * k); i++) {
            int begin = i * 2 * k,
                    end = begin + k - 1;

            revert(c1, begin, end);
        }

        int left = c1.length % (2 * k);
        if (left > 0) {
            int begin = c1.length / (2 * k) * 2 * k;
            int end = c1.length - 1;
            if (left < k) {
                revert(c1, begin, end);
            } else if (left >= k && left < (2 * k)) {
                end = begin + k - 1;
                revert(c1, begin, end);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c1.length; i++) {
            sb.append(c1[i]);
        }
        return sb.toString();
    }

    private static void revert(char[] c1, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char tmp = c1[begin];
            c1[begin] = c1[end];
            c1[end] = tmp;
        }
    }

    public static void main(String[] args) {
        String a = "krmyfshbspcgtesxnnljhfursyissjnsocgdhgfxubewllxzqhpasguvlrxtkgatzfybprfmmfithphckksnvjkcvnsqgsgosfxc";
        String reverseStr = ReverseStr2.reverseStr(a, 20);
        System.out.println(reverseStr);
    }
}
