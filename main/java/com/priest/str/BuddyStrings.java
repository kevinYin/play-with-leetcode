package com.priest.str;

import java.util.HashSet;

/**
 * 详情 : https://leetcode-cn.com/problems/buddy-strings/description/
 * <p>
 * 详细 : 亲密字符串
 *
 * @author liangguanglong 2018/8/28
 */
public class BuddyStrings {

    public static boolean buddyStrings(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.length() == 0) {
            return false;
        }

        char[] c1 = A.toCharArray();
        char[] c2 = B.toCharArray();
        // 相同的2个字符串，判断是否存在同一个字符
        HashSet<Character> set = new HashSet<Character>();
        if (A.equals(B)) {
            for (int i = 0; i < c1.length; i++) {
                set.add(c1[i]);
            }
            if (set.size() != c1.length) {
                return true;
            }
            return false;
        }


        Integer begin = null, end = null;
        for (int i = 0; i < c1.length; i++) {
            if (begin == null) {
                if (c1[i] != c2[i]) {
                    begin = i;
                }
            }
            if (end == null) {
                if (c1[c1.length - 1 - i] != c2[c1.length - 1 - i]) {
                    end = c1.length - 1 - i;
                }
            }

            if (begin != null && end !=null) {
                break;
            }
        }
        if (begin == null && end != null) {
            return false;
        }
        if (begin != null && end == null) {
            return false;
        }

        if (begin == null && end == null) {
            begin = 0;
            end = c2.length - 1;
        }
        char tmp = c1[begin];
        c1[begin] = c1[end];
        c1[end] = tmp;

        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String A = "qq", B = "qq";
        boolean result = BuddyStrings.buddyStrings(A, B);
        System.out.println(result);
    }
}
