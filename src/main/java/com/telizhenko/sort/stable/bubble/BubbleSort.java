package com.telizhenko.sort.stable.bubble;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 13:04
 */

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * Bubble sort, sometimes referred to as sinking sort, is a simple sorting algorithm that works by repeatedly stepping
 * through the list to be sorted, comparing each pair of adjacent items and swapping them if they are in the wrong
 * order. The pass through the list is repeated until no swaps are needed, which indicates that the list is sorted.
 * The algorithm gets its name from the way smaller elements "bubble" to the top of the list. Because it only uses
 * comparisons to operate on elements, it is a comparison sort. Although the algorithm is simple, most of the other
 * sorting algorithms are more efficient for large lists.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	O(n^2)
 * Best case performance	O(n)
 * Average case performance	O(n^2)
 * Worst case space complexity	O(1) auxiliary
 */
public class BubbleSort {

    private static int[] bubbleSort(int[] array) {
        int a = array.length;
        int temp;
        for (int i = 0; i < a - 1; i++) {
            for (int j = 1; j < a - i; j++) {
                if (array[j - 1] > array[j]) {
//                    temp = array[j - 1];
//                    array[j - 1] = array[j];
//                    array[j] = temp;
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }
}
