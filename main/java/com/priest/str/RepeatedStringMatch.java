package com.priest.str;

/**
 * 详情 : 重复叠加字符串匹配
 * <p>
 * 详细 : https://leetcode-cn.com/problems/repeated-string-match/description/
 *
 * @author liangguanglong 2018/8/29
 */
public class RepeatedStringMatch {

    public static int repeatedStringMatch(String A, String B) {
        if (A.length() >= B.length()) {
            if (!A.contains(B)) {
                A = A + A;
                if (A.contains(B)) {
                    return 2;
                }
                return -1;
            } else {
                return 1;
            }
        }
        // 最少次数是
        int minNum = B.length() / A.length();
        if (A.length() * minNum < B.length()) {
            minNum += 1;
        }
        // 最大的次数
        int maxNum = minNum + 1;
        String newStr = A;
        for (int i = 1; i < maxNum; i++) {
            newStr = newStr + A;
            if (newStr.contains(B)) {
                 return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String A = "abc",B = "cabcabca";
        int match = RepeatedStringMatch.repeatedStringMatch(A, B);
        System.out.println(match);
    }

}
