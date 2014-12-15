package com.telizhenko.sort.stable.gnome;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 15:32
 */

/**
 * Gnome sort (Stupid sort), originally proposed by Dr. Hamid Sarbazi-Azad (Professor of Computer Engineering at Sharif
 * University of Technology) in 2000 and called Stupid sort (not to be confused with Bogosort), and then later on
 * described by Dick Grune and named "Gnome sort",[1] is a sorting algorithm which is similar to insertion sort,
 * except that moving an element to its proper place is accomplished by a series of swaps, as in bubble sort. It is
 * conceptually simple, requiring no nested loops. The running time is O(n^2), but tends towards O(n) if the list is
 * initially almost sorted.[2] In practice the algorithm can run as fast as Insertion sort.[citation needed] The average
 * runtime is O(n^2).
 * The algorithm always finds the first place where two adjacent elements are in the wrong order, and swaps them.
 * It takes advantage of the fact that performing a swap can introduce a new out-of-order adjacent pair only right
 * before or after the two swapped elements. It does not assume that elements forward of the current position are sorted,
 * so it only needs to check the position directly before the swapped elements.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	O(n^2)
 * Best case performance	O(n)
 * Average case performance	O(n^2)
 * Worst case space complexity	O(1) auxiliary
 */
public class GnomeSort {

    public static int[] gnomeSort(int[] theArray) {
        for (int index = 1; index < theArray.length; ) {
            if (theArray[index - 1] <= theArray[index]) {
                ++index;
            } else {
                int tempVal = theArray[index];
                theArray[index] = theArray[index - 1];
                theArray[index - 1] = tempVal;
                --index;
                if (index == 0) {
                    index = 1;
                }
            }
        }
        return theArray;
    }
}
