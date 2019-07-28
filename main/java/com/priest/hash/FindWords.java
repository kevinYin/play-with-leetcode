package com.priest.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 详情 : 500. 键盘行
 * <p>
 * 详细 : https://leetcode-cn.com/problems/keyboard-row/
 *
 * @author liangguanglong 2019/6/16
 */
public class FindWords {

    public String[] findWords(String[] words) {

        ArrayList<String> list = new ArrayList<>();

        List<String> firstList = Arrays.asList("qwertyuiop".split(""));
        HashSet<String> first = new HashSet<>(firstList);

        List<String> secondList = Arrays.asList("asdfghjkl".split(""));
        HashSet<String> second = new HashSet<>(secondList);

        List<String> thirdList = Arrays.asList("zxcvbnm".split(""));
        HashSet<String> third = new HashSet<>(thirdList);

        for (String word : words) {
            String[] split = word.toLowerCase().split("");
            HashSet<String> set = getMatchSet(first, second, third, split[0]);
            for (int i = 0; i < split.length; i++) {
                if (!set.contains(split[i])) {
                    break;
                }
                if (i == (split.length - 1)) {
                    list.add(word);
                }
            }
        }

        return list.toArray(new String[list.size()]);
    }

    private HashSet<String> getMatchSet(HashSet<String> first, HashSet<String> second,HashSet<String> third,String firstStr ) {
        if (first.contains(firstStr)) {
            return first;
        }
        if (second.contains(firstStr)) {
            return second;
        }
        return third;
    }
}
