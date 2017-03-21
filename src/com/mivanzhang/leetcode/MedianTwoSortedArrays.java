package com.mivanzhang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangmeng on 17/3/18.
 */
public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] firstArray = new int[nums1.length + 1];
        int[] secondArray = new int[nums2.length + 1];
//        firstArray[0] = Integer.MIN_VALUE;
        firstArray[nums1.length] = Integer.MAX_VALUE;
//        secondArray[0] = Integer.MIN_VALUE;
        secondArray[nums2.length] = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            firstArray[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            secondArray[i] = nums2[i];
        }
        System.out.println("origin nums1:");
        print(nums1);
        System.out.println("modified nums1:");
        print(firstArray);

        System.out.println("origin nums2:");
        print(nums2);
        System.out.println("modified nums2:");
        print(secondArray);

        double result = 0.0;
        boolean isOdd = (firstArray.length + secondArray.length) % 2 == 0;
        int middleSize = (firstArray.length + secondArray.length) / 2 - 1;
        boolean addFirst = true;
        for (int i = 0, j = 0; i + j < (middleSize + 1); ) {
            if (!isOdd && (i + j == middleSize)) {
                if (addFirst) {
                    result = Math.min(firstArray[i], secondArray[j]);
                } else {
                    result = Math.min(secondArray[j], firstArray[i]);
                }
                break;
            }
            if (isOdd && (i + j + 1 == middleSize)) {
                //偶数的
//                result = ((double) (nums1[i] + nums2[j])) / 2;
                if (addFirst) {
                    result = ((double) (secondArray[j] + Math.min(firstArray[i], secondArray[j + 1]))) / 2;
                } else {
                    result = ((double) (firstArray[i] + Math.min(secondArray[j], firstArray[1 + 1]))) / 2;
                }
                break;
            }
            if (firstArray[i] < secondArray[j]) {
                i++;
                addFirst = true;
            } else {
                j++;
                addFirst = false;
            }
        }
        return result;
    }

    public double findMedianSortedArrays2(int[] firstArray, int[] secondArray) {
        System.out.println("origin nums1:");
        print(firstArray);

        System.out.println("origin nums2:");
        print(secondArray);
        int megeredArray[] = new int[firstArray.length + secondArray.length];
        double result = 0.0;
        boolean isOdd = (firstArray.length + secondArray.length) % 2 == 0;
        int middleSize = (firstArray.length + secondArray.length) / 2;
        boolean addFirst = true;
        for (int i = 0, j = 0; i + j < (middleSize + 1); ) {
            if (!isOdd && (i + j + 1 == middleSize)) {
                if (addFirst) {
                    result = Math.min(firstArray[i], secondArray[j]);
                } else {
                    result = Math.min(secondArray[j], firstArray[i]);
                }
                break;
            }
            if (isOdd && (i + j + 1 == middleSize)) {
                //偶数的
//                result = ((double) (nums1[i] + nums2[j])) / 2;
                if (addFirst) {
                    result = ((double) (secondArray[j] + Math.min(firstArray[i], secondArray[j + 1]))) / 2;
                } else {
                    result = ((double) (firstArray[i] + Math.min(secondArray[j], firstArray[1 + 1]))) / 2;
                }
                break;
            }
            if (firstArray[i] < secondArray[j]) {
                if (i < firstArray.length - 1) {
                    megeredArray[i + j] = firstArray[i];
                    i++;
                    addFirst = true;
                } else {
                    megeredArray[i + j] = secondArray[j];
                    j++;
                    addFirst = false;
                }
            } else {

                if (j < secondArray.length - 1) {
                    megeredArray[i + j] = secondArray[j];
                    j++;
                    addFirst = false;
                } else {
                    megeredArray[i + j] = firstArray[i];
                    i++;
                    addFirst = true;
                }
            }
            print(megeredArray);
        }
        return result;
    }

    // best
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int[] firstArray = new int[nums1.length + 1];
        int[] secondArray = new int[nums2.length + 1];
        firstArray[nums1.length] = Integer.MAX_VALUE;
        secondArray[nums2.length] = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            firstArray[i] = nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            secondArray[i] = nums2[i];
        }
//        System.out.println("origin nums1:");
//        print(firstArray);
//
//        System.out.println("origin nums2:");
//        print(secondArray);
        int megeredArray[] = new int[firstArray.length + secondArray.length];

        int megeredCount = 0;
        for (int first = 0, second = 0; first < firstArray.length && second < secondArray.length; ) {
            if (firstArray[first] < secondArray[second]) {
                megeredArray[megeredCount] = firstArray[first];
                first++;
            } else {
                megeredArray[megeredCount] = secondArray[second];
                second++;
            }
            megeredCount++;
        }
//        print(megeredArray);
        double result;
        if (megeredArray.length % 2 == 0) {
            result = ((double) (megeredArray[megeredArray.length / 2 - 2] + megeredArray[megeredArray.length / 2 - 1])) / 2;
        } else {
            result = ((double) megeredArray[megeredArray.length / 2 - 1]);
        }
        return result;
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays instance = new MedianTwoSortedArrays();
//        int[] nums1 = {1, 3, 5, 7, 9};
//        int[] nums2 = {2, 4, 6, 8, 10};
//        System.out.println(instance.findMedianSortedArrays(nums1, nums2));
//
//        int[] nums3 = {1, 3};//1 2 3 7
//        int[] nums4 = {2};
//        System.out.println(instance.findMedianSortedArrays(nums3, nums4));
//        int[] nums5 = {1, 3, 9};//1 2 3 7 9
//        System.out.println(instance.findMedianSortedArrays(nums5, nums4));


//        int[] nums7 = {5, 6, 7};
//        int[] nums6 = {1, 3};
//        int[] nums6 = {2, 4, 7};
//        int[] nums7 = {1, 5};
//        int[] nums6 = {1};//1 2 3 7
//        int[] nums7 = {2};
//        int[] nums6 = {1, 3, 5, 7, 9};
//        int[] nums7 = {2, 4, 6, 8, 10};
        int[] nums6 = {1, 35};
        int[] nums7 = {3, 26};
        System.out.println("result : " + instance.findMedianSortedArrays3(nums6, nums7));
    }

    public static void print(int[] args) {
        for (int i : args) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }
}
