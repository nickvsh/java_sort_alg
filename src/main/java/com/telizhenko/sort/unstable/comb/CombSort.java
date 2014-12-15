package com.telizhenko.sort.unstable.comb;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 14:37
 */

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * Comb sort is a relatively simple sorting algorithm originally designed by W?odzimierz Dobosiewicz in 1980.
 * Later it was rediscovered by Stephen Lacey and Richard Box in 1991. Comb sort improves on bubble sort.
 * <p/>
 * Class	                        Sorting algorithm
 * Data structure	                Array
 * <p/>
 * Worst case performance	        O(n^2)[1]
 * Best case performance	        O(n)
 * Average case performance	        \Omega(n^2/2^p), where p is the number of increments[1]
 * Worst case space complexity	    O(1)
 */
public class CombSort {

    public static <E extends Comparable<? super E>> E[] sort(E[] input) {
        int gap = input.length;
        boolean swapped = true;
        while (gap > 1 || swapped) {
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < input.length; i++) {
                if (input[i].compareTo(input[i + gap]) > 0) {
//                    E t = input[i];
//                    input[i] = input[i + gap];
//                    input[i + gap] = t;
                    swap(input, i, i + gap);
                    swapped = true;
                }
            }
        }
        return input;
    }
}
