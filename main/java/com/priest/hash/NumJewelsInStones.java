package com.priest.hash;

import java.util.HashMap;

/**
 * 详情 :  宝石与石头
 * <p>
 * 详细 : https://leetcode-cn.com/problems/jewels-and-stones/
 *
 * @author liangguanglong 2019/6/12
 */
public class NumJewelsInStones {

     public int numJewelsInStones(String J, String S) {
         char[] jewels = J.toCharArray();
         char[] stones = S.toCharArray();
         HashMap<Character, Integer> char2NumMap = new HashMap<>();
         for (int i = 0; i < stones.length; i++) {
             Integer numb = char2NumMap.get(stones[i]);
             if (numb == null) {
                 char2NumMap.put(stones[i], 1);
             } else {
                 char2NumMap.put(stones[i], numb + 1);
             }
         }
         int sum = 0;
         for (int i = 0; i < jewels.length; i++) {
             if (char2NumMap.get(jewels[i]) != null) {
                 sum = sum + char2NumMap.get(jewels[i]);
             }
         }
         return sum;
     }
}
