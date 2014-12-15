package com.telizhenko.sort.unstable.cycle;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 12:16
 */

/**
 * Cycle sort is an in-place, unstable sorting algorithm, a comparison sort that is theoretically optimal in terms of
 * the total number of writes to the original array, unlike any other in-place sorting algorithm. It is based on the
 * idea that the permutation to be sorted can be factored into cycles, which can individually be rotated to give a
 * sorted result.
 * Unlike nearly every other sort, items are never written elsewhere in the array simply to push them out of the way of
 * the action. Each value is either written zero times, if it's already in its correct position, or written one time to
 * its correct position. This matches the minimal number of overwrites required for a completed in-place sort.
 * Minimizing the number of writes is useful when making writes to some huge data set is very expensive, such as with
 * EEPROMs like Flash memory where each write reduces the lifespan of the memory.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance	        ?(n2)
 * Best case performance	        ?(n2)
 * Average case performance	        ?(n2)
 * Worst case space complexity	    ?(n) total, ?(1) auxiliary
 */
public class CycleSort {

    public int cycleSort(int[] input) {
        int writes = 0;

        for (int cs = 0, seeker, pos; cs < input.length - 1; cs++) {
            //assume the element at input[cs] is out of place
            seeker = input[cs];
            pos = cs;
            //find the correct position (pos) of seeker
            for (int i = cs + 1; i < input.length; i++) {
                if (input[i] < seeker) {
                    pos++;
                }
            }
            //if seeker is already in correct position, move on
            if (pos == cs) {
                continue;
            }
            //move index pos after duplicates if any
            while (seeker == input[pos]) {
                pos++;
            }
            /**
             * Make a switch: seeker gets index pos, its rightful
             * home; whatever element was at pos is now the seeker
             * in search of a rightful home.
             **/
            seeker = set(input, seeker, pos);
            //track the number of writes
            writes++;

            /**
             * complete the current cycle before moving to the next
             * cycle. At the end of the current cycle, pos will
             * equal cs; which should make sense since a cycle
             * always ends where it began.
             **/
            while (pos != cs) {
                //same as block of code above
                pos = cs;
                for (int i = cs + 1; i < input.length; i++) {
                    if (input[i] < seeker) {
                        pos++;
                    }
                }
                while (seeker == input[pos]) {
                    pos++;
                }
                seeker = set(input, seeker, pos);
                writes++;
            }
        }
        return writes;
    }

    private int set(int[] array, int data, int ndx) {
        try {
            return array[ndx];
        } finally {
            array[ndx] = data;
        }
    }
}
