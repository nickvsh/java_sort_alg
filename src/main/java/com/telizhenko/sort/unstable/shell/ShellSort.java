package com.telizhenko.sort.unstable.shell;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 17:53
 */

/**
 * <b>Shellsort</b>, also known as <b>Shell sort</b> or <b>Shell's method</b>, is an in-place comparison sort.
 * It can be seen as either a generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort).
 * The method starts by sorting elements far apart from each other and progressively reducing the gap between them.
 * Starting with far apart elements can move some out-of-place elements into position faster than a simple nearest
 * neighbor exchange. Donald Shell published the first version of this sort in 1959.[2][3] The running time of Shellsort
 * is heavily dependent on the gap sequence it uses. For many practical variants, determining their time complexity
 * remains an open problem.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	        O(n^2)
 * Best case performance	        O(n log n)
 * Average case performance	        depends on gap sequence
 * Worst case space complexity	    Î(n) total, O(1) auxiliary
 */
public class ShellSort {
    /**
     * Shell sort using Shell's (original) gap sequence: n/2, n/4, ..., 1.
     */
    public static <T extends Comparable<? super T>> void shellSort(T[] array) {
        // loop over the gaps
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // do the insertion sort
            for (int i = gap; i < array.length; i++) {
                T val = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap].compareTo(val) > 0; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = val;
            }
        }
    }
}
