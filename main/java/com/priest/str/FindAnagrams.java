package com.priest.str;

import java.util.*;

/**
 * 详情 : 找到字符串中所有字母异位词
 * <p>
 * 详细 : https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/description/
 *
 * @author liangguanglong 2018/9/2
 */
public class FindAnagrams {

    public   List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return Collections.emptyList();
        }

        List<Integer> indexes = new ArrayList<Integer>();
        char[] c1 = p.toCharArray();
        HashMap<Character, Integer> char2CountMap = buildChar2CountMap(c1, 0, c1.length);
        char[] c2 = s.toCharArray();
        HashMap<Character, Integer> tmpChar2CountMap = buildChar2CountMap(c2, 0,  c1.length);

        for (int i = 0; i <= c2.length - c1.length; i++) {
            if (checkMatch(char2CountMap, tmpChar2CountMap)) {
                indexes.add(i);
            }
           tmpChar2CountMap.put(c2[i], tmpChar2CountMap.get(c2[i]) - 1);
            if((i + c1.length) >= c2.length) {
                break;
            }
            if (tmpChar2CountMap.get(c2[i + c1.length]) == null) {
                tmpChar2CountMap.put(c2[i + c1.length], 1);
            } else {
                tmpChar2CountMap.put(c2[i + c1.length], tmpChar2CountMap.get(c2[i + c1.length]) + 1);
            }
        }
        return indexes;
    }

    private  boolean checkMatch(HashMap<Character, Integer> char2CountMap, HashMap<Character, Integer> tmpCahr2CountMap) {
        boolean match = true;
        for (Map.Entry<Character, Integer> entry : char2CountMap.entrySet()) {
            if (tmpCahr2CountMap.get(entry.getKey()) == null) {
                match = false;
            } else if (!tmpCahr2CountMap.get(entry.getKey()).equals(entry.getValue())){
                 match = false;
            }
        }
        return match;
    }

    private HashMap<Character, Integer> buildChar2CountMap(char[] c1, int begin , int end) {
        HashMap<Character, Integer> char2CountMap = new HashMap<Character, Integer>();
        for (int i = begin; i < end; i++) {
            if (char2CountMap.get(c1[i]) == null) {
                char2CountMap.put(c1[i], 1);
            } else {
                 char2CountMap.put(c1[i], char2CountMap.get(c1[i]) + 1);
            }
        }
        return char2CountMap;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        String a = "cbaebabacd", b = "abc";
        List<Integer> anagrams = findAnagrams.findAnagrams(a, b);
        for (Integer anagram : anagrams) {
            System.out.print(anagram + ",");
        }
    }
}
