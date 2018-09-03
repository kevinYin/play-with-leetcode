package com.priest.str;

/**
 * 详情 : 最长公共前缀
 * <p>
 * 详细 : https://leetcode-cn.com/problems/longest-common-prefix/description/
 *
 * @author liangguanglong 2018/9/2
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String minStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (minStr.length() > strs[i].length()) {
                minStr = strs[i];
            }
        }

        String longest = "";
        for (int i = 0; i < minStr.length(); i++) {
            longest = minStr.substring(0, minStr.length() - i);

            boolean isLongest = false;
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(longest)) {
                    break;
                }
                if (j == strs.length - 1) {
                    isLongest = true;
                    break;
                }
            }
            if (isLongest) {
                break;
            }
            longest = "";
        }

        return longest;
    }

    public static void main(String[] args) {
        String[] arr = {"flower","flow","flight"};
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String commonPrefix = prefix.longestCommonPrefix(arr);
        System.out.println(commonPrefix);
    }
}
