package com.mivanzhang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmeng on 17/3/29.
 * https://leetcode.com/problems/palindrome-number/#/description
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        System.out.print(" input x is " + x + "  ");
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        list.add(x % 10);
        while ((x = x / 10) != 0) {
            list.add(x % 10);
        }
        for (int first = 0, second = list.size() - 1; first <= second; first++, second--) {
            if (list.get(first) != list.get(second)) {
                return false;
            }
        }
        return true;

    }

    public boolean isPalindrome2(int x) {
        System.out.print(" input x is " + x + "  ");
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = temp % 10;
        while ((temp = temp / 10) != 0) {
            result = result * 10 + temp % 10;
        }
        return x == result;

    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
//        System.out.println(palindromeNumber.isPalindrome(-1));
//        System.out.println(palindromeNumber.isPalindrome(123));
//        System.out.println(palindromeNumber.isPalindrome(12321));
        System.out.println(palindromeNumber.isPalindrome2(-1));
        System.out.println(palindromeNumber.isPalindrome2(123));
        System.out.println(palindromeNumber.isPalindrome2(12321));
        System.out.println(palindromeNumber.isPalindrome2(Integer.MAX_VALUE));
        System.out.println(palindromeNumber.isPalindrome2(Integer.MIN_VALUE));
        System.out.println(palindromeNumber.isPalindrome2(0));
        System.out.println(palindromeNumber.isPalindrome2(100));
        System.out.println(palindromeNumber.isPalindrome2(1001));
        System.out.println(palindromeNumber.isPalindrome2(1123456789));
//        System.out.println(palindromeNumber.isPalindrome2(9876543211));
    }
    //best chocie 利用了对称的性质,多思考呀
    public boolean isPalindrome3(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }
}
