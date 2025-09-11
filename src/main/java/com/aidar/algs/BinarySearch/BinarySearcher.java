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

    /**
     * Searches for the smallest element in the array that was sorted in
     * ascending order and rotated between 1 and n times. n is the number
     * of elements in the array. Rotating the array k times moves the last
     * k elements to the beginning. Rotating 4 times: [1, 2, 3, 4, 5, 6] ->
     * [3, 4, 5, 6, 1, 2].
     * @param arr - rotated array
     * @return the smallest element in the array
     */
    public static int findMinInRotatedSorted(int[] arr) {
        int l = 0;
        int r = arr.length - 1;
        int min = arr[0];

        while (l <= r) {
            if (arr[l] <= arr[r]) {
                min = Math.min(arr[l], min);
                break;
            }

            int mid = (r + l) / 2;
            min = Math.min(min, arr[mid]);

            if (arr[l] <= arr[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return min;
    }
}
