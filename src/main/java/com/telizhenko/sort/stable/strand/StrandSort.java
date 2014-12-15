package com.telizhenko.sort.stable.strand;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 14:01
 */

/**
 * <b>Strand</b> sort is a sorting algorithm. It works by repeatedly pulling sorted sublists out of the list to be
 * sorted and merging them with a result array. Each iteration through the unsorted list pulls out a series of elements
 * which were already sorted, and merges those series together.
 * <p/>
 * The name of the algorithm comes from the "strands" of sorted data within the unsorted list which are removed one at
 * a time. It is a comparison sort due to its use of comparisons when removing strands and when merging them into the
 * sorted array.
 * <p/>
 * The strand sort algorithm is O(n2) in the average case. In the best case (a list which is already sorted) the
 * algorithm is linear, or O(n). In the worst case (a list which is sorted in reverse order) the algorithm is O(n^2).
 * <p/>
 * Strand sort is most useful for data which is stored in a linked list, due to the frequent insertions and removals of
 * data. Using another data structure, such as an array, would greatly increase the running time and complexity of the
 * algorithm due to lengthy insertions and deletions. Strand sort is also useful for data which already has large
 * amounts of sorted data, because such data can be removed in a single strand.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Linked list
 * <p/>
 * Worst case performance	        O(n^2)
 * Best case performance	        O(n)
 * Average case performance	        O(n^2)
 * Worst case space complexity	    O(1) auxiliary
 */
public class StrandSort {

    // note: the input list is destroyed
    public static <E extends Comparable<? super E>>
    LinkedList<E> strandSort(LinkedList<E> list) {
        if (list.size() <= 1) return list;

        LinkedList<E> result = new LinkedList<E>();
        while (list.size() > 0) {
            LinkedList<E> sorted = new LinkedList<E>();
            sorted.add(list.removeFirst()); //same as remove() or remove(0)
            for (Iterator<E> it = list.iterator(); it.hasNext(); ) {
                E elem = it.next();
                if (sorted.peekLast().compareTo(elem) <= 0) {
                    sorted.addLast(elem); //same as add(elem) or add(0, elem)
                    it.remove();
                }
            }
            result = merge(sorted, result);
        }
        return result;
    }

    private static <E extends Comparable<? super E>>
    LinkedList<E> merge(LinkedList<E> left, LinkedList<E> right) {
        LinkedList<E> result = new LinkedList<E>();
        while (!left.isEmpty() && !right.isEmpty()) {
            //change the direction of this comparison to change the direction of the sort
            if (left.peek().compareTo(right.peek()) <= 0)
                result.add(left.remove());
            else
                result.add(right.remove());
        }
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
