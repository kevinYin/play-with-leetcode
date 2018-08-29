package com.priest.str;

import java.util.HashMap;

/**
 * 详情 : 同构字符串
 * <p>
 * 详细 : https://leetcode-cn.com/problems/isomorphic-strings/
 *
 * @author liangguanglong 2018/8/28
 */
public class Isomorphic {

    public static boolean isIsomorphic(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();

        HashMap<Character, Character> map = new HashMap<Character, Character>();

        for (int i = 0; i < c1.length; i++) {
            if (map.get(c1[i]) != null) {
                if (map.get(c1[i]) != c2[i]) {
                    return false;
                }
            } else {
                if (map.values().contains(c2[i])) {
                    return false;
                }
                map.put(c1[i], c2[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "ab", t = "aa";

        boolean isomorphic = Isomorphic.isIsomorphic(s, t);
        System.out.println(isomorphic);
    }

}
