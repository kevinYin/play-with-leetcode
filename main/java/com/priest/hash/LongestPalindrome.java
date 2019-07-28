package com.priest.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 详情 : 409. 最长回文串
 * <p>
 * 详细 : https://leetcode-cn.com/problems/longest-palindrome/
 *
 * @author liangguanglong 2019/6/16
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        int result = 0;
        int hasOdd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                result = result + entry.getValue();
            } else {
               result = result + entry.getValue() - 1;
                if (hasOdd == 0) {
                    hasOdd = 1;
                }
            }
        }

        return result + hasOdd;
    }
}
