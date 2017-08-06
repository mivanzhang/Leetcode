package com.mivanzhang.leetcode.second;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangmeng on 2017/8/6.
 * <p>
 * https://leetcode.com/problems/container-with-most-water/description/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int current = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            current = (right - left) * Math.min(height[left], height[right]);
            if (height[right] > height[left]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(current, maxArea);
        }
        return maxArea;
    }

    private int calculateArea2(int[] height, int left, int right) {
        int area = (right - left) * Math.min(height[left], height[right]);
        return area;
    }

    //time Exceeded
    public int maxArea2(int[] height) {
        hashMap = new HashMap();
        return mostArea(height, 0, height.length - 1);
    }

    private int mostArea(int[] height, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int area = calculateArea(height, left, right);
        int leftArea = mostArea(height, left + 1, right);
        int rightArea = mostArea(height, left, right - 1);
        return Math.max(Math.max(area, leftArea), rightArea);
    }

    HashMap<String, Integer> hashMap = new HashMap();

    private int calculateArea(int[] height, int left, int right) {
        String key = left + "," + right;
        if (hashMap.containsKey(key)) {
            return hashMap.get(key);
        }
        int area = (right - left) * Math.min(height[left], height[right]);
        hashMap.put(key, area);
        return area;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        System.out.println(containerWithMostWater.maxArea(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 1}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 2, 2}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1}));

        System.out.println(containerWithMostWater.maxArea(new int[]{93, 45, 97, 9, 23}));
        System.out.println(containerWithMostWater.maxArea(new int[]{93, 1, 3, 198, 45, 97, 9, 23}));
        System.out.println(containerWithMostWater.maxArea(new int[]{93, 97, 9, 23,}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1, 23, 76, 34}));
    }
}
