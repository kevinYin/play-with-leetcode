package com.priest.str;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/9/2
 */
public class CountSegments {
    public static int countSegments(String s) {
        int num = 0;
        String[] split = s.split(" ");
        for (int i = 0; i < split.length; i++) {
            if (split[i].length() > 0) {
                num ++;
            }
        }
        return num;
    }

    public static void main(String[] args) {
         String a = ", , , ,        a, eaefa";
        int segments = CountSegments.countSegments(a);
        System.out.println(segments);
    }
}
