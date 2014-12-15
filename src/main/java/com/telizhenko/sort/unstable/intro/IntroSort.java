package com.telizhenko.sort.unstable.intro;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 13:27
 */

/**
 * Introsort or introspective sort is a hybrid sorting algorithm that provides both fast average performance and
 * (asymptotically) optimal worst-case performance. It begins with quicksort and switches to heapsort when the recursion
 * depth exceeds a level based on (the logarithm of) the number of elements being sorted. This combines the good parts
 * of both algorithms, with practical performance comparable to quicksort on typical data sets and worst-case O(n log n)
 * runtime due to the heap sort. Since both algorithms it uses are comparison sorts, it too is a comparison sort.
 * <p/>
 * Introsort was invented by David Musser in Musser (1997), in which he also introduced introselect, a hybrid selection
 * algorithm based on quickselect (a variant of quicksort), which falls back to median of medians and thus provides
 * worst-case linear complexity, which is optimal. Both algorithms were introduced with the purpose of providing generic
 * algorithms for the C++ Standard Library which had both fast average performance and optimal worst-case performance,
 * thus allowing the performance requirements to be tightened.
 * <p/>
 * Class	                    Sorting algorithm
 * Data structure	            Array
 * <p/>
 * Worst case performance	    O(n log n)
 * Average case performance	    O(n log n)
 */
// original Copyright Ralph Unden,
// http://ralphunden.net/content/tutorials/a-guide-to-introsort/?q=a-guide-to-introsort
// Modifications: Bernhard Pfahringer
//  changes include: local insertion sort, no global array
public class IntroSort {
    private static int size_threshold = 16;

    public static void sort(int[] a) {
        introsort_loop(a, 0, a.length, 2 * floor_lg(a.length));
    }

    public static void sort(int[] a, int begin, int end) {
        if (begin < end) {
            introsort_loop(a, begin, end, 2 * floor_lg(end - begin));
        }
    }

    /*
     * Quicksort algorithm modified for Introsort
     */
    private static void introsort_loop(int[] a, int lo, int hi, int depth_limit) {
        while (hi - lo > size_threshold) {
            if (depth_limit == 0) {
                heapsort(a, lo, hi);
                return;
            }
            depth_limit = depth_limit - 1;
            int p = partition(a, lo, hi, medianof3(a, lo, lo + ((hi - lo) / 2) + 1, hi - 1));
            introsort_loop(a, p, hi, depth_limit);
            hi = p;
        }
        insertionsort(a, lo, hi);
    }

    private static int partition(int[] a, int lo, int hi, int x) {
        int i = lo, j = hi;
        while (true) {
            while (a[i] < x) i++;
            j = j - 1;
            while (x < a[j]) j = j - 1;
            if (!(i < j))
                return i;
            exchange(a, i, j);
            i++;
        }
    }

    private static int medianof3(int[] a, int lo, int mid, int hi) {
        if (a[mid] < a[lo]) {
            if (a[hi] < a[mid])
                return a[mid];
            else {
                if (a[hi] < a[lo])
                    return a[hi];
                else
                    return a[lo];
            }
        } else {
            if (a[hi] < a[mid]) {
                if (a[hi] < a[lo])
                    return a[lo];
                else
                    return a[hi];
            } else
                return a[mid];
        }
    }

    /*
     * Heapsort algorithm
     */
    private static void heapsort(int[] a, int lo, int hi) {
        int n = hi - lo;
        for (int i = n / 2; i >= 1; i = i - 1) {
            downheap(a, i, n, lo);
        }
        for (int i = n; i > 1; i = i - 1) {
            exchange(a, lo, lo + i - 1);
            downheap(a, 1, i - 1, lo);
        }
    }

    private static void downheap(int[] a, int i, int n, int lo) {
        int d = a[lo + i - 1];
        int child;
        while (i <= n / 2) {
            child = 2 * i;
            if (child < n && a[lo + child - 1] < a[lo + child]) {
                child++;
            }
            if (d >= a[lo + child - 1]) break;
            a[lo + i - 1] = a[lo + child - 1];
            i = child;
        }
        a[lo + i - 1] = d;
    }

    /*
     * Insertion sort algorithm
     */
    private static void insertionsort(int[] a, int lo, int hi) {
        int i, j;
        int t;
        for (i = lo; i < hi; i++) {
            j = i;
            t = a[i];
            while (j != lo && t < a[j - 1]) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = t;
        }
    }

    /*
     * Common methods for all algorithms
     */
    private static void exchange(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static int floor_lg(int a) {
        return (int) (Math.floor(Math.log(a) / Math.log(2)));
    }
}
