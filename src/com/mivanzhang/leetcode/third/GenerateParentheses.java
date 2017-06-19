package com.mivanzhang.leetcode.third;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangmeng on 2017/6/18.
 *
 * 这个问题体现出来了递归的两次优点,递归的问题就是把问题拆解为一个一个独立的小问题,利用子问题 的结果拼接出大问题的答案
 *
 * 但是对于子问题的结果的获取,下面的算法这是与众不同的,不是利用函数的返回值,而是把计算结果作为一个参数,更多是体现利用递归的遍历的特点
 *
 * 和一个集合的最大子集合问题有类似的地方,但是也有不同,最大子集合的问题充分利用子问题的返回值,思维上也可以很容易的理解和接受,
 *
 * 而这个问题就不显得那么明显,拆分为子问题的时候,显得大问题和子问题之间的关系不够强烈,这个算法充分利用了递归的遍历性
 *
 */
public class GenerateParentheses {
    /**
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
//        List<String> resultString = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            StringBuilder string=new StringBuilder();
//            string.append("{");
//        }
        List<String> resultString = new ArrayList<>();
        caculate(resultString, "", 0, n);
        return resultString;

    }

    private void caculate(List<String> resultList, String resultItem, int leftMiniRight, int unmatched) {
        if (unmatched == 0) {
            if (leftMiniRight == 0) {
                resultList.add(resultItem);
                return;
            }
        }
        if (leftMiniRight < unmatched) {
            caculate(resultList, resultItem+"(", leftMiniRight + 1, unmatched);
        }
        if (leftMiniRight > 0) {
            caculate(resultList, resultItem + ")", leftMiniRight - 1, unmatched - 1);
        }

    }

    private List<String> caculate(int leftMiniRight, int unmatched) {
        List<String> resultString = new ArrayList<>();
        if (leftMiniRight == 0) {
            if (unmatched == 0) {
                return resultString;
            }
        }
        resultString.addAll(addLeft(leftMiniRight, unmatched));
        resultString.addAll(addRight(leftMiniRight, unmatched));
        return resultString;

    }

    private List<String> addLeft(int leftMiniRight, int unmatched) {
        List<String> resultString = new ArrayList<>();
        if (leftMiniRight < unmatched) {
            for (String string : caculate(leftMiniRight + 1, unmatched)) {
                resultString.add("(" + string);
            }
        }
        return resultString;
    }

    private List<String> addRight(int leftMiniRight, int unmatched) {
        List<String> resultString = new ArrayList<>();
        //addleft
        if (leftMiniRight > 0) {
            for (String string : caculate(leftMiniRight - 1, unmatched - 1)) {
                resultString.add(string + ")");
            }
        }
        return resultString;
    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println("input n=0 " + generateParentheses.generateParenthesis(0));
        System.out.println("input n=1 " + generateParentheses.generateParenthesis(1));
        System.out.println("input n=2 " + generateParentheses.generateParenthesis(2));
        System.out.println("input n=3 " + generateParentheses.generateParenthesis(3));
        System.out.println("input n=4 " + generateParentheses.generateParenthesis(4));
    }
}
