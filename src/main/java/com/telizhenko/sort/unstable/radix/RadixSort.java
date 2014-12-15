package com.telizhenko.sort.unstable.radix;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 15:14
 */

/**
 * In computer science, radix sort is a non-comparative integer sorting algorithm that sorts data with integer keys by
 * grouping keys by the individual digits which share the same significant position and value. A positional notation is
 * required, but because integers can represent strings of characters (e.g., names or dates) and specially formatted
 * floating point numbers, radix sort is not limited to integers. Radix sort dates back as far as 1887 to the work of
 * Herman Hollerith on tabulating machines.
 * <p/>
 * Most digital computers internally represent all of their data as electronic representations of binary numbers, so
 * processing the digits of integer representations by groups of binary digit representations is most convenient. Two
 * classifications of radix sorts are least significant digit (LSD) radix sorts and most significant digit (MSD) radix
 * sorts. LSD radix sorts process the integer representations starting from the least digit and move towards the most
 * significant digit. MSD radix sorts work the other way around.
 * <p/>
 * The integer representations that are processed by sorting algorithms are often called "keys", which can exist all by
 * themselves or be associated with other data.
 * <p/>
 * LSD radix sorts typically use the following sorting order: short keys come before longer keys, and keys of the same
 * length are sorted lexicographically. This coincides with the normal order of integer representations, such as the
 * sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10.
 * <p/>
 * MSD radix sorts use lexicographic order, which is suitable for sorting strings, such as words, or fixed-length integer
 * representations. A sequence such as "b, c, d, e, f, g, h, i, j, ba" would be lexicographically sorted as
 * "b, ba, c, d, e, f, g, h, i, j". If lexicographic ordering is used to sort variable-length integer representations,
 * then the representations of the numbers from 1 to 10 would be output as 1, 10, 2, 3, 4, 5, 6, 7, 8, 9, as if the
 * shorter keys were left-justified and padded on the right with blank characters to make the shorter keys as long as
 * the longest key for the purpose of determining sorted order.
 */
public class RadixSort {

    public static int[] sort(int[] old) {
        for (int shift = Integer.SIZE - 1; shift > -1; shift--) { //Loop for every bit in the integers
            int[] tmp = new int[old.length]; //the array to put the partially sorted array into
            int j = 0;  //The number of 0s

            for (int i = 0; i < old.length; i++) {  //Move the 0s to the new array, and the 1s to the old one
                boolean move = old[i] << shift >= 0;  //If there is a 1 in the bit we are testing, the number will be negative
                if (shift == 0 ? !move : move) {  //If this is the last bit, negative numbers are actually lower
                    tmp[j] = old[i];
                    j++;
                } else {  //It's a 1, so stick it in the old array for now
                    old[i - j] = old[i];
                }

            }
            System.arraycopy(old, 0, tmp, j, tmp.length - j);
            old = tmp;  //And now the tmp array gets switched for another round of sorting
        }

        return old;

    }
}
