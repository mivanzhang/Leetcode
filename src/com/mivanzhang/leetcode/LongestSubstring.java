package com.mivanzhang.leetcode;

import java.util.*;

/**
 * Created by zhangmeng on 17/3/18.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLeng = 0;
        Map<Character, Integer> tempSet = new HashMap();
        char[] charStrings = s.toCharArray();
        for (int index = 0; index < charStrings.length; index++) {
            if (tempSet.get(charStrings[index]) != null) {
                if (tempSet.size() > maxLeng) {
                    maxLeng = tempSet.size();
                }
                index = tempSet.get(charStrings[index]);
                tempSet = new HashMap<>();
            } else {
                tempSet.put(charStrings[index], index);
            }
        }
        return tempSet.size() > maxLeng ? tempSet.size() : maxLeng;
    }

    public int lengthOfLongestSubstring2(String s) {
        int maxLeng = 0;
        Queue<Character> arrayDeque = new ArrayDeque();
        char[] charStrings = s.toCharArray();
        for (int index = 0; index < charStrings.length; index++) {
            if (arrayDeque.contains(charStrings[index])) {
                maxLeng = maxLeng > arrayDeque.size() ? maxLeng : arrayDeque.size();
                while (arrayDeque.contains(charStrings[index])) {
                    arrayDeque.remove();
                }
            }
            arrayDeque.offer(charStrings[index]);
        }
        return arrayDeque.size() > maxLeng ? arrayDeque.size() : maxLeng;
    }

    public int lengthOfLongestSubstring3(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i=0, j=0; i<s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring longestSubstring = new LongestSubstring();
//        System.out.println(longestSubstring.lengthOfLongestSubstring("baiducom"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring2("baiducom"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring2("abcabcbb"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring("bbbbb"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring2("bbbbb"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring("pwpkew"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring2("pwpkew"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring("abadcabcabb"));
//        System.out.println(longestSubstring.lengthOfLongestSubstring2("abadcabcabb"));
        System.out.println(longestSubstring.lengthOfLongestSubstring("dvdf"));
        System.out.println(longestSubstring.lengthOfLongestSubstring2("dvdf"));
        System.out.println(longestSubstring.lengthOfLongestSubstring3("dvdf"));

    }
}
