package com.mivanzhang.leetcode;

/**
 * Created by zhangmeng on 17/3/20.
 */
public class ReverseInteger {
    public int reverse2(int x) {
        long result = 0;
        while (x / 10 != 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }
        result = result * 10 + x % 10;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            result = 0;
        }
        return (int) result;
    }

    public int reverse(int x) {
        int result = 0;
        while (x  != 0) {
            result = result * 10 + x % 10;
            if (result % 10 != x % 10)
                return 0;
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        System.out.println("  reverse result is " + reverseInteger.reverse(123445));
        System.out.println("  reverse result is " + reverseInteger.reverse(865431210));
        System.out.println("  reverse result is " + reverseInteger.reverse(1131456789));
        System.out.println("  reverse result is " + reverseInteger.reverse(128606719));
        System.out.println("  reverse result is " + reverseInteger.reverse(1286606719));
        System.out.println("  reverse result is " + reverseInteger.reverse(1));
        System.out.println("  reverse result is " + reverseInteger.reverse(22));
        System.out.println("  reverse result is " + reverseInteger.reverse(-2147483648));
        System.out.println("  reverse result is " + reverseInteger.reverse(Integer.MAX_VALUE));
    }
}
