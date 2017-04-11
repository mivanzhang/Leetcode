package com.mivanzhang.leetcode;

/**
 * Created by zhangmeng on 17/4/8.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder longestPrefix = new StringBuilder();
        if (strs.length < 1) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            longestPrefix.append(strs[0].charAt(i));
            for (int index = 1; index < strs.length; index++) {
                if (i < strs[index].length() && strs[index].charAt(i) == strs[0].charAt(i)) {

                } else {
                    longestPrefix.deleteCharAt(i);
                    return longestPrefix.toString();
                }
            }
        }
        return longestPrefix.toString();
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(" result is " + longestCommonPrefix.longestCommonPrefix(new String[]{}));
        System.out.println(" result is " + longestCommonPrefix.longestCommonPrefix(new String[]{"a", "ab", "abc"}));
        System.out.println(" result is " + longestCommonPrefix.longestCommonPrefix(new String[]{"abd", "ab", "abc"}));
        System.out.println(" result is " + longestCommonPrefix.longestCommonPrefix(new String[]{"abc", "abc", "abc"}));
        System.out.println(" result is " + longestCommonPrefix.longestCommonPrefix(new String[]{"bca", "abc", "abc"}));
    }
}
