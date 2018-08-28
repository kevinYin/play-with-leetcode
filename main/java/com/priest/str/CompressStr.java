package com.priest.str;

/**
 * 详情 :
 * <p>  "a","a","b","b","b",c","c","c"
 *      a 2 b 3 c 3
 * 详细 :
 *
 * @author liangguanglong 2018/8/20
 */
public class CompressStr {

    public static int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }

        StringBuilder finalAnswer = new StringBuilder();
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] != chars[i + 1]) {
                if (count == 1) {
                    finalAnswer.append(chars[i]);
                    if ((i + 1) == (chars.length - 1)) {
                        finalAnswer.append(chars[i + 1]);
                        break;
                    }
                    continue;
                } else {
                    finalAnswer.append(chars[i]);
                    finalAnswer.append(count);
                    count = 1;
                    if ((i + 1) == (chars.length - 1)) {
                        finalAnswer.append(chars[i + 1]);
                        break;
                    }
                }
            } else {
                ++count;
                if ((i + 1) == (chars.length - 1)) {
                    finalAnswer.append(chars[i]);
                    finalAnswer.append(count);
                }
            }
        }
        char[] charArray = finalAnswer.toString().toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            chars[i] = charArray[i];
        }
        return charArray.length;
    }

    public static void main(String[] args) {
        String str = "aaaaab";
        char[] chars = str.toCharArray();
        int i = CompressStr.compress(chars);
        System.out.println(i);
        for (int k = 0; k < i; k++) {
            System.out.println(chars[k]);
        }
    }
}
