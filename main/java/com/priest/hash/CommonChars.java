package com.priest.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 详情 : 1002. 查找常用字符

 * <p>
 * 详细 : https://leetcode-cn.com/problems/find-common-characters/
 *
 * @author liangguanglong 2019/6/16
 */
public class CommonChars {

     public List<String> commonChars(String[] A) {

         List<Map<String, Integer>> charNumList = new ArrayList<>();
         for (int i = 1; i < A.length; i++) {
             String s = A[i];
             Map<String, Integer> char2NumMap = new HashMap<>();
             String[] chars = s.split("");
             for (String c : chars) {
                 char2NumMap.merge(c, 1, (a, b) -> a + b);
             }
             charNumList.add(char2NumMap);
         }
         List<String> result = new ArrayList<>();
         String[] chars = A[0].split("");
         for (String c : chars) {
             boolean hasChar = true;
             for (Map<String, Integer> map : charNumList) {
                 if (map.get(c) == null || map.get(c) < 1) {
                     hasChar = false;
                     break;
                 } else {
                     map.put(c, map.get(c) - 1);
                 }
             }
             if (hasChar) {
                 result.add(c);
             }
         }
         return result;
     }

    public static void main(String[] args) {
        String[] A = {"bella","label","roller"};
        CommonChars chars = new CommonChars();
        List<String> strings = chars.commonChars(A);
        System.out.println(strings);
    }
}
