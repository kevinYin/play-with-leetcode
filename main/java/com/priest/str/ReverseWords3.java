package com.priest.str;

/**
 * 详情 : 反转字符串中的单词 III
 * <p>
 * 详细 : https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/description/
 *
 * @author liangguanglong 2018/9/2
 */
public class ReverseWords3 {

    public static String reverseWords(String s) {

        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            char[] c1 = split[i].toCharArray();
            for (int j = 0, p = c1.length - 1; j < p; j++, p--) {
                char tmp = c1[j];
                c1[j] = c1[p];
                c1[p] = tmp;
            }
            for (int i1 = 0; i1 < c1.length; i1++) {
                sb.append(c1[i1]);
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String reverseWords = ReverseWords3.reverseWords("Let's take LeetCode contest");
        System.out.println(reverseWords);

        String a = ", , , ,        a, eaefa";
        String[] split = a.split(" ");
        System.out.println(split.length);
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i].length());
        }
    }
}
