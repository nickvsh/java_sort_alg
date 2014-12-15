package com.telizhenko.sort.stable.insertion;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 15:52
 */

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * Insertion sort is a simple sorting algorithm that builds the final sorted array (or list) one item at a time.
 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort.
 * However, insertion sort provides several advantages:
 * <ul>
 * <li>Simple implementation</li>
 * <li>Efficient for (quite) small data sets</li>
 * <li>Adaptive (i.e., efficient) for data sets that are already substantially sorted: the time complexity is O(n + d), where d is the number of inversions</li>
 * <li>More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as selection sort or bubble sort; the best case (nearly sorted input) is O(n)</li>
 * <li>Stable; i.e., does not change the relative order of elements with equal keys</li>
 * <li>In-place; i.e., only requires a constant amount O(1) of additional memory space</li>
 * <li>Online; i.e., can sort a list as it receives it</li>
 * </ul>
 * <p/>
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	Î(n^2) comparisons, swaps
 * Best case performance	O(n) comparisons, O(1) swaps
 * Average case performance	Î(n^2) comparisons, swaps
 * Worst case space complexity	Î(n) total, O(1) auxiliary
 */
public class InsertionSort {

    public static int[] insertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int copyNumber = numbers[i];
            int j = i;
            while (j > 0 && copyNumber < numbers[j - 1]) {
//                numbers[j] = numbers[j - 1];
                swap(numbers, j, j - 1);
                j--;
            }
            numbers[j] = copyNumber;
        }
        return numbers;
    }
}
