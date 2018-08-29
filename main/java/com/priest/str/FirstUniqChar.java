package com.priest.str;

import java.util.HashMap;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/8/29
 */
public class FirstUniqChar {

    public static int firstUniqChar(String s) {

        char[] c1 = s.toCharArray();
        HashMap<Character, Integer> key2NumMap = new HashMap<Character, Integer>();
        for (int i = 0; i < c1.length; i++) {
            if (key2NumMap.get(c1[i]) == null) {
                key2NumMap.put(c1[i], 1);
            } else {
                key2NumMap.put(c1[i], key2NumMap.get(c1[i]) + 1);
            }
        }
        for (int i = 0; i < c1.length; i++) {
            if (key2NumMap.get(c1[i]) == 1) {
                return i;
            }
        }
        return  -1;
    }

    public static void main(String[] args) {
        int leetcode = FirstUniqChar.firstUniqChar("aadadaad");
        System.out.println(leetcode);
    }
}
