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

}
