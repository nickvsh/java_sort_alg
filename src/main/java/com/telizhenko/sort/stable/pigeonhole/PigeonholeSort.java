package com.telizhenko.sort.stable.pigeonhole;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 14:56
 */

/**
 * Pigeonhole sorting, also known as count sort (not to be confused with counting sort), is a sorting algorithm that is
 * suitable for sorting lists of elements where the number of elements (n) and the number of possible key values (N)
 * are approximately the same. It requires O(n + N) time.
 * <p/>
 * The pigeonhole algorithm works as follows:
 * <p/>
 * 1. Given an array of values to be sorted, set up an auxiliary array of initially empty "pigeonholes," one pigeonhole
 * for each key through the range of the original array.
 * 2. Going over the original array, put each value into the pigeonhole corresponding to its key, such that each
 * pigeonhole eventually contains a list of all values with that key.
 * 3. Iterate over the pigeonhole array in order, and put elements from non-empty pigeonholes back into the original array.
 * <p/>
 * Class	                        Sorting algorithm
 * Data structure	                Array
 * <p/>
 * Worst case performance	        O(N+n), where N is the range of key values and n is the input size
 * Worst case space complexity      O(N+n)
 */
public class PigeonholeSort {
    public static int[] pigeonhole_sort(int[] a) {
        // size of range of values in the list (ie, number of pigeonholes we need)
        int min = a[0], max = a[0];
        for (int x : a) {
            min = Math.min(x, min);
            max = Math.max(x, max);
        }
        final int size = max - min + 1;

        // our array of pigeonholes
        int[] holes = new int[size];

        // Populate the pigeonholes.
        for (int x : a)
            holes[x - min]++;

        // Put the elements back into the array in order.
        int i = 0;
        for (int count = 0; count < size; count++)
            while (holes[count]-- > 0)
                a[i++] = count + min;

        return a;
    }
}
