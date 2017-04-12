package com.mivanzhang.leetcode.second;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmeng on 17/4/11.
 */
public class LetterCombinationsPhoneNumber {
    String lettersArray[] = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
//        System.out.print("  input digits is " + digits);
        List<String> result = new ArrayList<>();
        if (null == digits || digits.isEmpty()) {
            return result;
        }
        for (char c : digits.toCharArray()) {
            if (c < '2' || c > '9') {
                return result;
            }
            String letter = lettersArray[c - '2'];
            result=mix(result, letter);
        }
        return result;
    }

    public List<String>  mix(List<String> result, String letter) {

        if (result.size() == 0) {
            for (char le : letter.toCharArray()) {
                result.add(String.valueOf(le));
            }
            return result;
        }

        List<String> newResult=new ArrayList<>();
        for (char le : letter.toCharArray()) {
            for (int index = 0; index < result.size(); index++) {
                newResult.add(result.get(index) + le);
            }
        }
        return newResult;
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber letterCombinationsPhoneNumber = new LetterCombinationsPhoneNumber();
//        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("1"));
//        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("12"));
//        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations(""));
//        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("123asd"));
//        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("123asd"));
        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("9"));
        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("23"));
        System.out.println("  result is " + letterCombinationsPhoneNumber.letterCombinations("9231"));
    }


}
