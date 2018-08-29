package com.priest.str;

/**
 * 详情 : https://leetcode-cn.com/problems/valid-palindrome-ii/description/
 * <p>
 * 详细 : 验证回文字符串 Ⅱ
 *
 * @author liangguanglong 2018/8/29
 */
public class ValidPalindrome {

    public static boolean validPalindrome(String s) {
        // 2边开始遍历，遇到不同的，想办法确认是删左边还是右边
        char[] array = s.toCharArray();
        boolean hasRemove = false;
        for (int i = 0, j = array.length - 1; i <= j; i++, j--) {
            if (array[i] != array[j]) {
                if (hasRemove) {
                    return false;
                } else {
                    // 比较左边的前一位是否跟右边的相等，相等，则左边向前移一位
                    if (array[i + 1] == array[j] || array[i] == array[j - 1]) {
                        // 可能左边跟右边都可能
                        boolean leftIsOK = false;
                        if (array[i + 1] == array[j]) {
                            leftIsOK = true;
                            for (int k = i + 1, p = j; k <= p; k++, p--) {
                                if (array[k] != array[p]) {
                                    leftIsOK = false;
                                    break;
                                }
                            }
                        }
                        if (leftIsOK) {
                            return true;
                        }
                        boolean rightIdOK = false;
                        if (array[i] == array[j - 1]) {
                            j = j - 1;
                            rightIdOK = true;
                            if (j == (i + 1)) {
                                rightIdOK = array[i] == array[j];
                            } else {
                                for (; i <= j; i++, j--) {
                                    if (array[i] != array[j]) {
                                        rightIdOK = false;
                                        break;
                                    }
                                }
                            }
                        }
                        return leftIsOK || rightIdOK;
                    } else {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String a = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        boolean palindrome = ValidPalindrome.validPalindrome(a);
        System.out.println(palindrome);
    }
}
