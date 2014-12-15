package com.telizhenko.sort.unstable.quick;

import java.util.*;

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 17:21
 */

/**
 * <b>Quicksort</b>, or <b>partition-exchange sort</b>, is a sorting algorithm developed by Tony Hoare that, on average,
 * makes O(n log n) comparisons to sort n items. In the worst case, it makes O(n2) comparisons, though this behavior is
 * rare. Quicksort is often faster in practice than other O(n log n) algorithms. Additionally, quicksort's sequential
 * and localized memory references work well with a cache. Quicksort is a comparison sort and, in efficient
 * implementations, is not a stable sort. Quicksort can be implemented with an in-place partitioning algorithm, so the
 * entire sort can be done with only O(log n) additional space used by the stack during the recursion.
 * <p/>
 * Class	Sorting algorithm
 * <p/>
 * Worst case performance	O(n2)
 * Best case performance	O(n log n) (simple partition) or O(n) (three-way partition and equal keys)
 * Average case performance	O(n log n)
 * Worst case space complexity	O(n) auxiliary (naive), O(log n) auxiliary (Sedgewick 1978)
 */
public class QuickSort {
    private static final Random RND = new Random();

    public static ArrayList<Integer> quickSort(ArrayList<Integer> numbers) {
        if (numbers.size() <= 1)
            return numbers;
        int pivot = numbers.size() / 2;
        ArrayList<Integer> lesser = new ArrayList<Integer>();
        ArrayList<Integer> greater = new ArrayList<Integer>();
        int sameAsPivot = 0;
        for (int number : numbers) {
            if (number > numbers.get(pivot))
                greater.add(number);
            else if (number < numbers.get(pivot))
                lesser.add(number);
            else
                sameAsPivot++;
        }
        lesser = quickSort(lesser);
        for (int i = 0; i < sameAsPivot; i++)
            lesser.add(numbers.get(pivot));
        greater = quickSort(greater);
        ArrayList<Integer> sorted = new ArrayList<Integer>();
        for (int number : lesser)
            sorted.add(number);
        for (int number : greater)
            sorted.add(number);
        return sorted;
    }

    private static <E> int partition(E[] array, int begin, int end, Comparator<? super E> cmp) {
        int index = begin + RND.nextInt(end - begin + 1);
        E pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (cmp.compare(array[i], pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private static <E> void qSort(E[] array, int begin, int end, Comparator<? super E> cmp) {
        if (end > begin) {
            int index = partition(array, begin, end, cmp);
            qSort(array, begin, index - 1, cmp);
            qSort(array, index + 1, end, cmp);
        }
    }

    public static <E> void quickSort(E[] array, Comparator<? super E> cmp) {
        qSort(array, 0, array.length - 1, cmp);
    }

    private static <E extends Comparable<? super E>> int partition(E[] array, int begin, int end) {
        int index = begin + RND.nextInt(end - begin + 1);
        E pivot = array[index];
        swap(array, index, end);
        for (int i = index = begin; i < end; ++i) {
            if (array[i].compareTo(pivot) <= 0) {
                swap(array, index++, i);
            }
        }
        swap(array, index, end);
        return (index);
    }

    private static <E extends Comparable<? super E>> void qSort(E[] array, int begin, int end) {
        if (end > begin) {
            int index = partition(array, begin, end);
            qSort(array, begin, index - 1);
            qSort(array, index + 1, end);
        }
    }

    public static <E extends Comparable<? super E>> void quickSort(E[] array) {
        qSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<? super E>> List<E> quickSort(List<E> data) {
        List<E> sorted = new ArrayList<E>();
        rQuickSort(data, sorted);
        return sorted;
    }

    public static <E extends Comparable<? super E>> void rQuickSort(List<E> data, List<E> sorted) {
        if (data.size() == 1) {
            sorted.add(data.iterator().next());
            return;
        }

        if (data.size() == 0) {
            return;
        }

        /* choose the pivot randomly */
        int pivot = RND.nextInt(data.size());
        E pivotI = data.get(pivot);
        List<E> fatPivot = new ArrayList<E>();
        List<E> left = new ArrayList<E>();
        List<E> right = new ArrayList<E>();

        /* partition data */
        for (E next : data) {
            int compare = pivotI.compareTo(next);
            if (compare < 0) {
                right.add(next);
            } else if (compare > 0) {
                left.add(next);
            } else {
                fatPivot.add(next);
            }
        }
        rQuickSort(left, sorted);
        sorted.addAll(fatPivot);
        rQuickSort(right, sorted);
    }

    @SuppressWarnings("unchecked")
    private static <E extends Comparable<? super E>> List<E>[] split(List<E> v) {
        List<E>[] results = (List<E>[]) new List[]{new LinkedList<E>(), new LinkedList<E>()};
        Iterator<E> it = v.iterator();
        E pivot = it.next();
        while (it.hasNext()) {
            E x = it.next();
            if (x.compareTo(pivot) < 0) results[0].add(x);
            else results[1].add(x);
        }
        return results;
    }

    public static <E extends Comparable<? super E>> List<E> quicksort(List<E> v) {
        if (v == null || v.size() <= 1) return v;
        final List<E> result = new LinkedList<E>();
        final List<E>[] lists = split(v);
        result.addAll(quicksort(lists[0]));
        result.add(v.get(0));
        result.addAll(quicksort(lists[1]));
        return result;
    }
}
