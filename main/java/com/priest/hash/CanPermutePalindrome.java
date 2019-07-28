package com.priest.hash;

import java.util.HashMap;

/**
 * 详情 : 回文排列
 * <p>
 * 详细 : https://leetcode.com/problems/palindrome-permutation/
 *
 * @author liangguanglong 2019/6/13
 */
public class CanPermutePalindrome {

    public boolean canPermutePalindrome(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> char2NumbMap = new HashMap<>();
        for (char c : chars) {
            if (char2NumbMap.containsKey(c)) {
                char2NumbMap.put(c, char2NumbMap.get(c) + 1);
            } else {
                char2NumbMap.put(c, 1);
            }
        }
        int oddChar = 0;
        for (Integer value : char2NumbMap.values()) {
            if (value % 2 > 0) {
                oddChar ++;
                if (oddChar > 1) return false;
            }
        }
        return true;
    }
}
