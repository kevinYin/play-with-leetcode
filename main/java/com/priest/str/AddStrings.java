package com.priest.str;

/**
 * 详情 :
 * <p>
 * 详细 :
 *
 * @author liangguanglong 2018/8/19
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {
       // 给最短的前面补充0
       if (num1.length() > num2.length()) {
           int lenth = num1.length() - num2.length();
           for (int i = 0; i < lenth; i++) {
                num2 = "0" + num2;
            }
        } else {
           int length = num2.length() - num1.length();
            for (int i = 0; i < length; i++) {
                num1 = "0" + num1;
            }
        }
        // 从最后的开始进行 相加
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        int addOne = 0;
        for (int i = c2.length - 1; i >= 0; i--) {
            int result = c1[i] + c2[i] - 48 * 2 + addOne;
            if (result >= 10) {
                c1[i] = (char) ((result - 10) + 48);
                addOne = 1;
            } else {
                c1[i] = (char)(result + 48);
                addOne = 0;
            }
        }
        // 从开始进行输出
        StringBuffer a = new StringBuffer();
        if (addOne == 1) {
            a.append("1");
        }
        for (int i = 0; i < c1.length; i++) {
           a.append(c1[i]);
        }
        return  a.toString();
    }


    public static void main(String[] args) {
        String result = AddStrings.addStrings("74", "48213");
        System.out.println(result);
    }
}
