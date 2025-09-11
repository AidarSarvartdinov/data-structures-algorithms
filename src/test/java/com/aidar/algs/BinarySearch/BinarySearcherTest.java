package com.aidar.algs.BinarySearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearcherTest {

    @Test
    public void binarySearch() {
        int[] arr = {1, 4, 5, 7, 8, 9};

        assertEquals(BinarySearcher.searchInSorted(arr, 4), 1);
        assertEquals(BinarySearcher.searchInSorted(arr, 10), -1);
        assertEquals(BinarySearcher.searchInSorted(arr, 1), 0);
        assertEquals(BinarySearcher.searchInSorted(arr, 9), 5);
    }

    @Test
    public void searchInArrWithOneElem() {
        int[] arr = {1};
        assertEquals(BinarySearcher.searchInSorted(arr, 10), -1);
        assertEquals(BinarySearcher.searchInSorted(arr, 1), 0);

    }

    @Test
    public void findMinInTheRotatedSortedTest() {
        int[] arr = {5, 6, 1, 2, 3, 4};
        assertEquals(BinarySearcher.findMinInRotatedSorted(arr), 1);

        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        assertEquals(BinarySearcher.findMinInRotatedSorted(arr2), 1);

        int[] arr3 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1};
        assertEquals(BinarySearcher.findMinInRotatedSorted(arr3), 1);

        int[] arr4 = {1};
        assertEquals(BinarySearcher.findMinInRotatedSorted(arr4), 1);
    }

}
