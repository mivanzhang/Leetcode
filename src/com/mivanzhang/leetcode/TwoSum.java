
package com.mivanzhang.leetcode;
import java.util.Arrays;

/**
 * Created by zhangmeng on 17/2/12.
 * pass
 */
public class TwoSum {
    private static TwoSum instance = new TwoSum();

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums.length < 1) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {9,11, 15,0, 7, 2};
//        int[] nums = { 8, 9,1, 2, 3, 5, 15};
//        int[] nums = {1};
//        int[] nums = {3,2,4};
//        int[] nums = {1,3, 5,8, 10, 15};
//        int target = 6;
//        int target = 11;
        int target = 9;
        int[] indeice = instance.twoSum(nums, target);
        if (indeice == null) {
            return;
        }
        System.out.print("[");
        for (int i = 0; i < indeice.length; i++) {
            System.out.print(indeice[i]);
            if (i != indeice.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }
}
