package com.telizhenko.sort.unstable.selection;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 12:45
 */

/**
 * In computer science, selection sort is a sorting algorithm, specifically an in-place comparison sort. It has O(n^2)
 * time complexity, making it inefficient on large lists, and generally performs worse than the similar insertion sort.
 * Selection sort is noted for its simplicity, and it has performance advantages over more complicated algorithms in
 * certain situations, particularly where auxiliary memory is limited.
 * The algorithm divides the input list into two parts: the sublist of items already sorted, which is built up from left
 * to right at the front (left) of the list, and the sublist of items remaining to be sorted that occupy the rest of the
 * list. Initially, the sorted sublist is empty and the unsorted sublist is the entire input list. The algorithm proceeds
 * by finding the smallest (or largest, depending on sorting order) element in the unsorted sublist, exchanging it with
 * the leftmost unsorted element (putting it in sorted order), and moving the sublist boundaries one element to the right.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Data structure	Array
 * Worst case performance	Î(n2)
 * Best case performance	Î(n2)
 * Average case performance	Î(n2)
 * Worst case space complexity	Î(n) total, O(1) auxiliary
 */
public class SelectionSort {

    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++)
                if (array[j] < array[index])
                    index = j;

            int smallerNumber = array[index];
            array[index] = array[i];
            array[i] = smallerNumber;
        }
        return array;
    }
}
