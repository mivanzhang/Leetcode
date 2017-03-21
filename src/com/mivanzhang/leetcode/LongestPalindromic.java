package com.mivanzhang.leetcode;

/**
 * Created by zhangmeng on 17/3/20.
 * https://leetcode.com/problems/longest-palindromic-substring/#/description
 */
public class LongestPalindromic {
    public String longestPalindrome(String s) {
//        System.out.print("origin string is " + s);
        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(1);
            }
        }
        String result = "";
        for (int i = 1; i < s.length() - 1; i++) {
            int leftOffset = 0;
            int rightOffset = 0;
            while (true) {
                if (i + rightOffset + 1 < s.length()) {
                    if (s.charAt(i) == s.charAt(i + rightOffset + 1)) {
                        rightOffset++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            while (true) {
                if (i - leftOffset > 0) {
                    if (s.charAt(i) == s.charAt(i - leftOffset - 1)) {
                        leftOffset++;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            while ((i - leftOffset) > 0 && (i + rightOffset + 1) < s.length() && (s.charAt(i - leftOffset - 1) == s.charAt(i + rightOffset + 1))) {
                leftOffset++;
                rightOffset++;
            }
            if (result.length() < (rightOffset + leftOffset + 1)) {
                result = s.substring(i - leftOffset, i + rightOffset + 1);
            }
        }
        return result;
    }

    public String longestPalindrome2(String s, int currentIndex, int leftOffset, int rightOffset) {
//        System.out.print("origin string is " + s);

        return "";
    }

    public static void main(String[] args) {
        LongestPalindromic instance = new LongestPalindromic();
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("a"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("babad"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("cdbcbdec"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("dcedbcfbdecd"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("dcedbcbde"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("dcedbcbdecd"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("abba"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("abccbaabccba"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("bb"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("bbb"));
//        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("bbbb"));
        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("bbbbabbbb"));
        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("bcbbabbbabbb"));
        System.out.println(" Longest Palindromic is " + instance.longestPalindrome("  bbabbbabb"));
    }
}
