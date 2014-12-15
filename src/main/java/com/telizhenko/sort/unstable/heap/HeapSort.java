package com.telizhenko.sort.unstable.heap;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 17:41
 */

import java.util.Collections;
import java.util.PriorityQueue;

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * <b>Heapsort</b> is a comparison-based sorting algorithm. Heapsort is part of the selection sort family; it improves
 * on the basic selection sort by using a logarithmic-time priority queue rather than a linear-time search. Although
 * somewhat slower in practice on most machines than a well-implemented quicksort, it has the advantage of a more
 * favorable worst-case O(n log n) runtime. Heapsort is an in-place algorithm, but it is not a stable sort.
 * It was invented by J. W. J. Williams in 1964.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	O(n\log n)
 * Best case performance	Omega(n), O(n\log n)
 * Average case performance	    O(n\log n)
 * Worst case space complexity	O(1) auxiliary
 */
public class HeapSort {

    /*Basic heapsort*/
    public static <E extends Comparable<? super E>> void heapSort(E[] array) {

        // Java's PriorityQueue class functions as a min heap
        PriorityQueue<E> heap = new PriorityQueue<E>(array.length);

        // Add each array element to the heap
        Collections.addAll(heap, array);

        // Elements come off the heap in ascending order
        for (int i = 0; i < array.length; i++)
            array[i] = heap.remove();

    }

    /*In-place heapsort*/
    public static void heapSort(int[] array) {
    /* This method performs an in-place heapsort. Starting
     * from the beginning of the array, the array is swapped
     * into a binary max heap.  Then elements are removed
     * from the heap, and added to the front of the sorted
     * section of the array. */

    /* Insertion onto heap */
        for (int heapsize = 0; heapsize < array.length; heapsize++) {
        /* Step one in adding an element to the heap in the
         * place that element at the end of the heap array-
         * in this case, the element is already there. */
            int n = heapsize; // the index of the inserted int
            while (n > 0) { // until we reach the root of the heap
                int p = (n - 1) / 2; // the index of the parent of n
                if (array[n] > array[p]) { // child is larger than parent
                    swap(array, n, p); // swap child with parent
                    n = p; // check parent
                } else // parent is larger than child
                    break; // all is good in the heap
            }
        }

    /* Removal from heap */
        for (int heapsize = array.length; heapsize > 0; ) {
            swap(array, 0, --heapsize); // swap root with the last heap element
            int n = 0; // index of the element being moved down the tree
            while (true) {
                int left = (n * 2) + 1;
                if (left >= heapsize) // node has no left child
                    break; // reached the bottom; heap is heapified
                int right = left + 1;
                if (right >= heapsize) { // node has a left child, but no right child
                    if (array[left] > array[n]) // if left child is greater than node
                        swap(array, left, n); // swap left child with node
                    break; // heap is heapified
                }
                if (array[left] > array[n]) { // (left > n)
                    if (array[left] > array[right]) { // (left > right) & (left > n)
                        swap(array, left, n);
                        n = left;
                        continue; // continue recursion on left child
                    } else { // (right > left > n)
                        swap(array, right, n);
                        n = right;
                        continue; // continue recursion on right child
                    }
                } else { // (n > left)
                    if (array[right] > array[n]) { // (right > n > left)
                        swap(array, right, n);
                        n = right;
                        continue; // continue recursion on right child
                    } else { // (n > left) & (n > right)
                        break; // node is greater than both children, so it's heapified
                    }
                }
            }
        }
    }
}
