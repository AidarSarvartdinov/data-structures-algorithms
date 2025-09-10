package com.aidar.algs.BinarySearch;

public class BinarySearcher {
    private BinarySearcher() {
    }

    /**
     * Searches for target within an array of distinct integers nums,
     * sorted in ascending order. If it exists, then returns its index,
     * otherwise, returns -1
     */
    public static int searchInSorted(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int index = (l + r) / 2;
            if (nums[index] == target) {
                return index;
            }
            if (nums[index] < target) {
                l = index + 1;
            } else {
                r = index - 1;
            }
        }
        return -1;
    }
}
