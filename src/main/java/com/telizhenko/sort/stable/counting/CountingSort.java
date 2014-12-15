package com.telizhenko.sort.stable.counting;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 17:12
 */

import java.util.Arrays;

/**
 * In computer science, <b>counting sort</b> is an algorithm for sorting a collection of objects according to keys that are
 * small integers; that is, it is an integer sorting algorithm. It operates by counting the number of objects that have
 * each distinct key value, and using arithmetic on those counts to determine the positions of each key value in the
 * output sequence. Its running time is linear in the number of items and the difference between the maximum and minimum
 * key values, so it is only suitable for direct use in situations where the variation in keys is not significantly
 * greater than the number of items. However, it is often used as a subroutine in another sorting algorithm, radix sort,
 * that can handle larger keys more efficiently.
 * Because counting sort uses key values as indexes into an array, it is not a comparison sort, and the ?(n log n)
 * lower bound for comparison sorting does not apply to it.[1] Bucket sort may be used for many of the same tasks as
 * counting sort, with a similar time analysis; however, compared to counting sort, bucket sort requires linked lists,
 * dynamic arrays or a large amount of preallocated memory to hold the sets of items within each bucket, whereas
 * counting sort instead stores a single number (the count of items) per bucket.
 * <p/>
 * # variables:
 * #    input -- the array of items to be sorted; key(x) returns the key for item x
 * #    n -- the length of the input
 * #    k -- a number such that all keys are in the range 0..k-1
 * #    count -- an array of numbers, with indexes 0..k-1, initially all zero
 * #    output -- an array of items, with indexes 0..n-1
 * #    x -- an individual input item, used within the algorithm
 * #    total, oldCount, i -- numbers used within the algorithm
 * <p/>
 * # calculate the histogram of key frequencies:
 * for x in input:
 * count[key(x)] += 1
 * <p/>
 * # calculate the starting index for each key:
 * total = 0
 * for i in range(k):   # i = 0, 1, ... k-1
 * oldCount = count[i]
 * count[i] = total
 * total += oldCount
 * <p/>
 * # copy to output array, preserving order of inputs with equal keys:
 * for x in input:
 * output[count[key(x)]] = x
 * count[key(x)] += 1
 * <p/>
 * return output
 */
public class CountingSort {
    public static void countingSort(int[] a, int low, int high) {
        int[] counts = new int[high - low + 1]; // this will hold all possible values, from low to high
        for (int x : a)
            counts[x - low]++; // - low so the lowest possible value is always 0

        int current = 0;
        for (int i = 0; i < counts.length; i++) {
            Arrays.fill(a, current, current + counts[i], i + low); // fills counts[i] elements of value i + low in current
            current += counts[i]; // leap forward by counts[i] steps
        }
    }
}
