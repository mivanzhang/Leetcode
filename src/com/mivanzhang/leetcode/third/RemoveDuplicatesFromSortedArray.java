package com.mivanzhang.leetcode.third;

import com.mivanzhang.leetcode.utils.ArrayUtils;

/**
 * Created by zhangmeng on 2017/10/15.
 * <p>
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 *
 * 两个指针一个负责找出连续重复的数,一个负责记录新的数组
 *
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
//        System.out.println("input is ");
//        ArrayUtils.printArray(nums);
        if (nums == null) {
            return 0;
        }
        if (nums.length < 2) {
            return nums.length;
        }
        int newIndex = 0;
        for (int index = 1; index < nums.length + 1; index++) {
            //不能过早的结束,最后一个也要参与
            if (index < nums.length && nums[index] == nums[index - 1]) {
                continue;
            }
            nums[newIndex] = nums[index - 1];
            newIndex++;

        }
//        System.out.println("after input is ");
//        ArrayUtils.printArray(nums);

        return newIndex;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();
        int num[] = {1, 2, 3, 4, 4, 5, 5};
        System.out.println("result is " + removeDuplicatesFromSortedArray.removeDuplicates(num));
        System.out.println("");
        System.out.println("");
//
        int num2[] = {1, 1, 1, 5, 5, 5, 8};
        System.out.println("result is " + removeDuplicatesFromSortedArray.removeDuplicates(num2));
        System.out.println("");
        System.out.println("");
//
        int num3[] = {1, 1, 1};
        System.out.println("result is " + removeDuplicatesFromSortedArray.removeDuplicates(num3));
        System.out.println("");
        System.out.println("");
//
        int num4[] = {1};
        System.out.println("result is " + removeDuplicatesFromSortedArray.removeDuplicates(num4));
        System.out.println("");
        System.out.println("");

        int num5[] = {};
        System.out.println("result is " + removeDuplicatesFromSortedArray.removeDuplicates(num5));
    }

}
