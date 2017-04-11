package com.mivanzhang.leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by zhangmeng on 17/2/12.
 */
public class ThreeSum {
    static ThreeSum threeSum = new ThreeSum();

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            for (int second = first + 1; second < nums.length - 1; second++) {
                for (int third = second + 1; third < nums.length; third++) {
                    if (nums[first] + nums[second] + nums[third] == 0) {
                        List<Integer> triple = new Triplet();
                        triple.add(nums[first]);
                        triple.add(nums[second]);
                        triple.add(nums[third]);
                        if (!result.contains(triple))
                            result.add(triple);
                    }
                }
            }
        }

        return result;

    }


    public List<List<Integer>> threeSum2(int[] nums) {
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(nums[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            for (int second = first + 1; second < nums.length - 1; second++) {
                int third = 0 - nums[first] - nums[second];
                if (null != set.get(third) && (set.get(third) != first && set.get(third) != second)) {
                    List<Integer> triple = new Triplet();
                    triple.add(nums[first]);
                    triple.add(nums[second]);
                    triple.add(third);
                    if (!result.contains(triple))
                        result.add(triple);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            set.put(-nums[i], i);
        }
        for (int first = 0; first < nums.length; first++) {
            for (int second = nums.length - 1; second > first; second--) {
                if (set.containsKey(nums[first] + nums[second]) && (set.get(nums[first] + nums[second]) != first) && set.get(nums[first] + nums[second]) != second) {
                    //this is
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(0 - nums[first] - nums[second]);
                    if (!result.contains(list))
                        result.add(list);
                }
            }
        }
        return result;
    }


    public List<List<Integer>> threeSum4(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int middle = i + 1;
            int j = nums.length - 1;
            while (middle < j) {
                if (nums[i] + nums[j] + nums[middle] == 0) {
                    result.add(Arrays.asList(nums[i], -nums[i] - nums[j], nums[j]));
                    while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    middle++;
                    while (middle < nums.length - 1 && nums[middle] == nums[middle + 1]) {
                        middle++;
                    }
                    while (j > 0 && nums[j] == nums[j - 1]) {
                        j--;
                    }
                } else if (nums[i] + nums[j] + nums[middle] < 0) {
                    middle++;
                } else if (nums[i] + nums[j] + nums[middle] > 0) {
                    j--;
                }
            }

        }
        return result;
    }


    static class Triplet extends ArrayList<Integer> {

        @Override
        public boolean equals(Object o) {
            if ((o instanceof Triplet)) {
                Triplet triplet = (Triplet) o;
                Collections.sort(triplet);
                Collections.sort(this);
                for (int i = 0; i < triplet.size(); i++) {
                    if (!this.get(i).equals(triplet.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public boolean isZero() {
            return (this.size() == 3 && (get(0) + get(1) + get(2) == 0));
        }

        public int sum() {
            int sum = Integer.MIN_VALUE;
            if (size() > 0) {
                sum = 0;
            }
            for (int i = 0; i < this.size(); i++) {
                sum += get(i);
            }
            return sum;
        }
    }


    public List<List<Integer>> threeSum5(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        Arrays.sort(nums);
        int first, second;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                String value = map.get(nums[i] + nums[j]);
                if (value != null) {
                    String array[] = value.split(",");
                    for (int k = 0; k < array.length; k += 2) {
                        first = Integer.valueOf(array[k]);
                        if (nums[first] != nums[i] && nums[first] != nums[j]) {
                            map.put(nums[i] + nums[j], value + "," + i + "," + j);
                        }
                    }
                } else {
                    map.put(nums[i] + nums[j], i + "," + j);
                }

            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                continue;
            }
            if (map.get(-nums[i]) != null) {
                String array[] = map.get(-nums[i]).split(",");
                for (int j = 0; j < array.length; j += 2) {
                    first = Integer.valueOf(array[j]);
                    second = Integer.valueOf(array[j + 1]);
                    if (first != i && second != i) {
                        List<Integer> triple = new Triplet();
                        triple.add(nums[first]);
                        triple.add(nums[i]);
                        triple.add(nums[second]);
                        if (!result.contains(triple))
                            result.add(triple);
                    }
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum6(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            for (int second = first + 1; second < nums.length - 1; second++) {
                for (int third = nums.length - 1; third > second; third--) {
                    if (nums[first] + nums[second] + nums[third] == 0) {
                        result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                        while (second + 1 < third && nums[second] == nums[second + 1]) {
                            second++;
                        }
                        while (third > second && nums[third] == nums[third - 1]) {
                            third--;
                        }
                        while (first + 1 < second && nums[first] == nums[first + 1]) {
                            first++;
                        }
                    }
                }
            }
        }

        return result;

    }

    public List<List<Integer>> threeSum7(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int first = 0; first < nums.length - 2; first++) {
            int second = first + 1;
            int third = nums.length - 1;
            while (second < third) {
                if (nums[first] + nums[second] + nums[third] == 0) {
                    result.add(Arrays.asList(nums[first], nums[second], nums[third]));
                    while (second + 1 < third && nums[second] == nums[second + 1]) {
                        second++;
                    }
                    while (third > second && nums[third] == nums[third - 1]) {
                        third--;
                    }
                    while (first + 1 < second && nums[first] == nums[first + 1]) {
                        first++;
                    }
                } else {

                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
//        int[] nums = {-4, -1, 0, 1, 2, -1};
//        int[] nums = { 2, -1};
//        int[] nums = {-4, -1, -1, 0, 1, 2};
//        System.out.println("{-4,-1, -1,  0, 1, 2}");
        int[] nums = {9, -9, 4, 12, 12, 0, -14, -7, 10, -1, 11, -10, -3, 2, -9, 0, 8, -9, -5, -1, 10, 5, 13, -5, -9, -12, 9, -3, 10, 10, -10, 4, 8, 1, -7, -2, -14, -6, 6, 11, 8, -6, 9, 13, 11, 7, -10, -4, 14, 0, 3, 1, -10, -7, 3, -12, -3, -11, 0, -8, -15, 5, 3, 8, 13, 11, 13, -15, -9, 4, 3, 6, 5, -11, -4, -6, 4, 1, 5, -5, -13, -7, 11, -8, 2, -1, -12, 14, 3, 3, 13, -5, -14, -7, 11, 14, -11, 9, 6, -13, -9, -13, 1, 11, -9, 12, -10, 2, -1, 3, 12, -7, 3, 0, 0, 12, 6, 3, 3, -13, 14, 1, -3};
//        int[] nums = {-1, 3,0, 1, 2, -1, -4,0,6,-3};
//        int[] nums = {0,0,0};
//
//        int[] nums = {-1, 3, 0, 4, 1, 0, 0, 2, -4};
//        int[] nums = {-1, 1, 0};
//        int[] nums = {3, 0, -2, -1, 1, 2};
        System.out.println(threeSum.threeSum(nums));
//        System.out.println(threeSum.threeSum2(nums));
//        System.out.println(threeSum.threeSum3(nums));
        System.out.println(threeSum.threeSum6(nums));

    }
}
