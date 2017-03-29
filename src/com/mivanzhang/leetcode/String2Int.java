package com.mivanzhang.leetcode;

/**
 * Created by zhangmeng on 17/3/27.
 */
public class String2Int {
    public int myAtoi2(String str) {
        if (str == null || str.isEmpty() || (str.contains("+") && str.contains("-"))) {
            return 0;
        }
        str = str.trim();
        int result = 0;
        boolean signal = true;
        for (char c : str.toCharArray()) {
            if (signal && c == '-') {
                signal = false;
            }
            if ('0' <= c && c <= '9') {
                result = result * 10 + c - '0';
                if (result % 10 != (c - '0')) {
                    if (!signal) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                    return result;
                }
            }
        }

        if (!signal) {
            result = -result;
        }
        return result;
    }

    public int myAtoi(String str) {
        System.out.print("input origin str is " + str + "   ");
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        if (str.length() < 1) {
            return 0;
        }
        int result = 0;
        boolean signal = (str.charAt(0) != '-');
        for (int i = 0; i < str.length(); i++) {
            if ('0' <= str.charAt(i) && str.charAt(i) <= '9') {
                result = result * 10 + str.charAt(i) - '0';
                if (result % 10 != (str.charAt(i) - '0')) {
                    if (!signal) {
                        result = Integer.MIN_VALUE;
                    } else {
                        result = Integer.MAX_VALUE;
                    }
                    return result;
                }
            } else if (i != 0) {
                break;
            } else if (str.charAt(i) != '-' && str.charAt(i) != '+') {
                break;
            }
        }

        if (!signal) {
            result = -result;
        }
        return result;
    }

    public static void main(String[] args) {
        String2Int string2Int = new String2Int();
//        System.out.println("result is " + string2Int.myAtoi(" 113"));
//        System.out.println("result is " + string2Int.myAtoi(" -12124"));
        System.out.println("result is " + string2Int.myAtoi(" +1243"));
//        System.out.println("result is " + string2Int.myAtoi(" +123ab43"));
//        System.out.println("result is " + string2Int.myAtoi(" -12!c43"));
//        System.out.println("result is " + string2Int.myAtoi(""));
//        System.out.println("result is " + string2Int.myAtoi(" "));
//        System.out.println("result is " + string2Int.myAtoi(" 1112=+asd13"));
//        System.out.println("result is " + string2Int.myAtoi(" -asd1"));
//        System.out.println("result is " + string2Int.myAtoi(" -+2134"));
//        System.out.println("result is " + string2Int.myAtoi(" -2134+1241"));
//        System.out.println("result is " + string2Int.myAtoi(" +2134+1241"));
//        System.out.println("result is " + string2Int.myAtoi(" +aasd1"));
//        System.out.println("result is " + string2Int.myAtoi(" +1-1aasd1"));
//        System.out.println("result is " + string2Int.myAtoi(" -11-1aasd1"));
//        System.out.println("result is " + string2Int.myAtoi(" b11228552307"));


    }

}
