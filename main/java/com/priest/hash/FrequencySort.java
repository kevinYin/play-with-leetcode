package com.priest.hash;

import java.util.*;

/**
 * 详情 : 451. 根据字符出现频率排序
 * <p>
 * 详细 : https://leetcode-cn.com/problems/sort-characters-by-frequency/
 *
 * @author liangguanglong 2019/6/16
 */
public class FrequencySort {

    public String frequencySort(String s) {
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> char2NumbMap = new HashMap<>();
        for (char c : arr) {
            if (char2NumbMap.get(c) == null) {
                char2NumbMap.put(c, 1);
            } else {
                char2NumbMap.put(c, char2NumbMap.get(c) + 1);
            }
        }
        HashMap<Integer, List<Character>> numb2CharMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : char2NumbMap.entrySet()) {
            if (numb2CharMap.get(entry.getValue()) == null) {
                List<Character> list = new ArrayList<>();
                list.add(entry.getKey());
                numb2CharMap.put(entry.getValue(), list);
            } else {
                numb2CharMap.get(entry.getValue()).add(entry.getKey());
            }
        }
        List<Integer> numbs = new ArrayList<>(numb2CharMap.keySet());
        Collections.sort(numbs);
        Collections.reverse(numbs);
        StringBuilder result = new StringBuilder();
        for (Integer numb : numbs) {
            List<Character> characters = numb2CharMap.get(numb);
            for (Character c : characters) {
                for (int i = 0; i < numb; i++) {
                    result.append(c);
                }
            }
        }
        return result.toString();
    }
}
