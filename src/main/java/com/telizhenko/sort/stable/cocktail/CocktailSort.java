package com.telizhenko.sort.stable.cocktail;

import static com.telizhenko.sort.utils.SwapUtil.swap;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 14:52
 */

/**
 * Cocktail sort, also known as bidirectional bubble sort, cocktail shaker sort, shaker sort (which can also refer to a
 * variant of selection sort), ripple sort, shuffle sort,[1] or shuttle sort, is a variation of bubble sort that is both
 * a stable sorting algorithm and a comparison sort. The algorithm differs from a bubble sort in that it sorts in both
 * directions on each pass through the list. This sorting algorithm is only marginally more difficult to implement than
 * a bubble sort, and solves the problem of turtles in bubble sorts. It provides only marginal performance improvements,
 * and does not improve asymptotic performance; like the bubble sort, it is not of practical interest (insertion sort is
 * preferred for simple sorts), though it finds some use in education.
 * <p/>
 * Data structure	Array
 * Worst case performance	O(n^2)
 * Best case performance	O(n)
 * Average case performance	O(n^2)
 * Worst case space complexity	O(1)
 */
public class CocktailSort {

    public static int[] cocktailSort(int[] numbers) {
        boolean swapped = true;
        int i = 0;
        int j = numbers.length - 1;
        while (i < j && swapped) {
            swapped = false;
            for (int k = i; k < j; k++) {
                if (numbers[k] > numbers[k + 1]) {
//                    int temp = numbers[k];
//                    numbers[k] = numbers[k + 1];
//                    numbers[k + 1] = temp;
                    swap(numbers, k, k + 1);
                    swapped = true;
                }
            }
            j--;
            if (swapped) {
                swapped = false;
                for (int k = j; k > i; k--) {
                    if (numbers[k] < numbers[k - 1]) {
//                        int temp = numbers[k];
//                        numbers[k] = numbers[k - 1];
//                        numbers[k - 1] = temp;
                        swap(numbers, k, k - 1);
                        swapped = true;
                    }
                }
            }
            i++;
        }
        return numbers;
    }
}
