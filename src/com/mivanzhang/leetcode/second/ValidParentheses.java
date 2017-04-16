package com.mivanzhang.leetcode.second;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Created by zhangmeng on 17/4/16.
 */
public class ValidParentheses {
    static HashMap<Character, Character> mapping = new HashMap<>();

    {
        mapping.put('}', '{');
        mapping.put(']', '[');
        mapping.put(')', '(');
    }

    public boolean isValid2(String s) {

        System.out.print("input string is " + s + "  ");
        Stack<Character> stack = new Stack();
        for (char c : s.toCharArray()) {
            if (!stack.empty() && mapping.get(c) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public boolean isValid3(String s) {
        System.out.print("input string is " + s + "  ");
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() &&mapping.get(s.charAt(i)) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{}"));
        System.out.println(validParentheses.isValid("{"));
        System.out.println(validParentheses.isValid("[]"));
        System.out.println(validParentheses.isValid("()(([]))"));
        System.out.println(validParentheses.isValid("{[]"));
        System.out.println(validParentheses.isValid("{[(])}"));
        System.out.println(validParentheses.isValid("{[()]()}"));
        System.out.println(validParentheses.isValid("()[]{}"));
        System.out.println(validParentheses.isValid("([)]"));
    }
}
