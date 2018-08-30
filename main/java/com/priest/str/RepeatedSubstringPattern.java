package com.priest.str;

/**
 * 详情 : 重复的子字符串
 * <p>
 * 详细 : https://leetcode-cn.com/problems/repeated-substring-pattern/description/
 *
 * @author liangguanglong 2018/8/30
 */
public class RepeatedSubstringPattern {

    public static boolean repeatedSubstringPattern(String s) {
        String subStr = null;
        for (int i = s.length() / 2; i > 0 ; i--) {
            if (s.length() % i > 0) {
                continue;
            } else {
               subStr = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < s.length() / i; j++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abab";
        boolean pattern = RepeatedSubstringPattern.repeatedSubstringPattern(s);
        System.out.println(pattern);
    }
}
