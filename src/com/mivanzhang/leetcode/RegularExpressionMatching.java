package com.mivanzhang.leetcode;

/**
 * Created by zhangmeng on 17/3/30.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        System.out.print("   input string is " + s + "  pattern is " + p + "  ");
        if (s == null || p == null || p.isEmpty() || p.charAt(0) == '*') {
            return false;
        }
        if (!p.contains("*") && !p.contains(".")) {
            return s.equals(p);
        }
        //出去多余的*
        StringBuilder temp = new StringBuilder();
        temp.append(p.charAt(0));
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == '*' && p.charAt(i) == p.charAt(i - 1)) {

            } else {
                temp.append(p.charAt(i));
            }
        }
        p = temp.toString();

        int originStringIndex = 0, patternIndex = 0;
        for (; originStringIndex < s.length() && patternIndex < p.length(); ) {
            if ((s.charAt(originStringIndex) == p.charAt(patternIndex))) {
                originStringIndex++;
                patternIndex++;
            } else if ('.' == p.charAt(patternIndex)) {
                if (patternIndex + 1 < p.length() && '*' == p.charAt(patternIndex + 1)) {
                    int pRemainLength = p.length() - patternIndex - 2;
                    if(pRemainLength>0&&s.length() - pRemainLength>originStringIndex) {
                        return isMatch(s.substring(s.length() - pRemainLength, s.length()), (p.substring(patternIndex + 2)));
                    }else {
                        return true;
                    }
                } else {
                    patternIndex++;
                    originStringIndex++;
                }

            } else if ((patternIndex + 1) < p.length() && '*' == p.charAt(patternIndex + 1)) {
                patternIndex += 2;
            } else if ('*' == p.charAt(patternIndex)) {
                while (originStringIndex < s.length() && (s.charAt(originStringIndex) == s.charAt(originStringIndex - 1))) {
                    originStringIndex++;
                }
                while ((patternIndex + 1 < p.length()) && (s.charAt(originStringIndex - 1) == p.charAt(patternIndex + 1))) {
                    patternIndex++;
                }
                patternIndex++;
            } else {
                return false;
            }
            while (originStringIndex == s.length() && patternIndex < p.length() && '*' == p.charAt(patternIndex)) {
                patternIndex++;
            }
        }
        if (originStringIndex != s.length() || patternIndex != p.length()) {
            return false;
        }
        return true;

    }

//    public boolean isMatch2(String s, String p) {
//        System.out.print("input string is " + s + "  pattern is " + p + "  ");
//        if (s == null || p == null || p.isEmpty() || p.charAt(0) == '*') {
//            return false;
//        }
//        if (!p.contains("*") && !p.contains(".")) {
//            return s.equals(p);
//        }
//        //出去多余的*
//        StringBuilder temp = new StringBuilder();
//        temp.append(p.charAt(0));
//        for (int i = 1; i < p.length(); i++) {
//            if (p.charAt(i) == '*' && p.charAt(i) == p.charAt(i - 1)) {
//
//            } else {
//                temp.append(p.charAt(i));
//            }
//        }
//        p=temp.toString();
//
//        int originStringIndex = 0, patternIndex = 0;
//        for (; originStringIndex < s.length() && patternIndex < p.length(); ) {
//            if ((s.charAt(originStringIndex) == p.charAt(patternIndex)) || ('.' == p.charAt(patternIndex))) {
//                originStringIndex++;
//                patternIndex++;
//            } else if ((patternIndex + 1) < p.length() && '*' == p.charAt(patternIndex + 1)) {
//                patternIndex += 2;
//            } else if ('*' == p.charAt(patternIndex)) {
//                while (originStringIndex < s.length() && (s.charAt(originStringIndex) == s.charAt(originStringIndex - 1))) {
//                    originStringIndex++;
//                }
//                if ((patternIndex + 1 < p.length()) && (s.charAt(originStringIndex - 1) == p.charAt(patternIndex + 1))) {
//                    patternIndex++;
//                }
//                patternIndex++;
//            } else {
//                return false;
//            }
//            if (originStringIndex == s.length() && patternIndex < p.length() && '*' == p.charAt(patternIndex)) {
//                patternIndex++;
//            }
//        }
//        if (originStringIndex != s.length() || patternIndex != p.length()) {
//            return false;
//        }
//        return true;
//
//    }

    public boolean isCharMatch(char s, char p) {
        return s == p || p == '.';
    }

    public static void main(String[] args) {
        RegularExpressionMatching regularExpressionMatching = new RegularExpressionMatching();
//        System.out.println(regularExpressionMatching.isMatch("aa", "a"));
//        System.out.println(regularExpressionMatching.isMatch("aa", "a*"));
//        System.out.println(regularExpressionMatching.isMatch("aaa", "aa"));
//        System.out.println(regularExpressionMatching.isMatch("aa", "aa"));
//        System.out.println(regularExpressionMatching.isMatch("aa", ".*"));
//        System.out.println(regularExpressionMatching.isMatch("ab", ".**b"));
//        System.out.println(regularExpressionMatching.isMatch("ab", ".*"));

//        System.out.println(regularExpressionMatching.isMatch("aaabc", ".*a"));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", ".*b"));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", "c*a*b"));
//
//        //all true
//        System.out.println(regularExpressionMatching.isMatch("aab", "c*a**b"));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", "c*a*b*c"));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", "c*a*b."));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", "c*a*bc"));
//        System.out.println(regularExpressionMatching.isMatch("aaabc", ".*c"));


        //all true
//        System.out.println(regularExpressionMatching.isMatch("aaabc", ".*bc"));
//        System.out.println(regularExpressionMatching.isMatch("aaab", ".*b"));
//        System.out.println(regularExpressionMatching.isMatch("aaacb", ".*b"));
//        System.out.println(regularExpressionMatching.isMatch("aaabbbbbb", ".*.*b"));
//        System.out.println(regularExpressionMatching.isMatch("aaabbbbbcb", ".*.*b"));
//        System.out.println(regularExpressionMatching.isMatch("a", ".*"));
//        System.out.println(regularExpressionMatching.isMatch("aaab", ".*"));
//        System.out.println(regularExpressionMatching.isMatch("a", "a"));

        System.out.println(regularExpressionMatching.isMatch("a", ".*..a*"));
    }
}
