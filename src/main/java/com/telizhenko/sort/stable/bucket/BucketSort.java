package com.telizhenko.sort.stable.bucket;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 15:01
 */

/**
 * <b>Bucket sort</b>, or <b>bin sort</b>, is a sorting algorithm that works by partitioning an array into a number of
 * buckets. Each bucket is then sorted individually, either using a different sorting algorithm, or by recursively
 * applying the bucket sorting algorithm. It is a distribution sort, and is a cousin of radix sort in the most to least
 * significant digit flavour. Bucket sort is a generalization of pigeonhole sort. Bucket sort can be implemented with
 * comparisons and therefore can also be considered a comparison sort algorithm. The computational complexity estimates
 * involve the number of buckets.
 * <p/>
 * Bucket sort works as follows:
 * <p/>
 * 1. Set up an array of initially empty "buckets".
 * 2. Scatter: Go over the original array, putting each object in its bucket.
 * 3. Sort each non-empty bucket.
 * 4. Gather: Visit the buckets in order and put all elements back into the original array.
 * <p/>
 * Class	                        Sorting algorithm
 * Data structure	                Array
 * <p/>
 * Worst case performance	        Î(n2)
 * Average case performance	        O(n+k)
 * Worst case space complexity	    O(nk)
 */
public class BucketSort {
    public static int[] sort(int[] a, int maxVal) {
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int anA : a) {
            bucket[anA]++;
        }

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }
        return a;
    }
}
