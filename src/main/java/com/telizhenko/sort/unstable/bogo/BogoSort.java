package com.telizhenko.sort.unstable.bogo;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 14:46
 */

import java.util.Collections;
import java.util.List;

/**
 * In computer science, <b>bogosort</b> (also <b>stupid sort</b>, <b>slowsort</b>, <b>random sort</b>, <b>shotgun sort</b>
 * or <b>monkey sort</b>) is a particularly ineffective sorting algorithm based on the generate and test paradigm.
 * It is not useful for sorting, but may be used for educational purposes, to contrast it with other more realistic
 * algorithms; it has also been used as an example in logic programming.[2][4][5] If bogosort were used to sort a deck
 * of cards, it would consist of checking if the deck were in order, and if it were not, throwing the deck into the air,
 * picking the cards up at random, and repeating the process until the deck is sorted. Its name comes from the word bogus.
 * <p/>
 * Class	                            Sorting algorithm
 * Data structure	                    Array
 * <p/>
 * Worst case performance	            Unbounded
 * Best case performance	            ?(n)[1]
 * Average case performance	            O(n * n!)
 * Worst case space complexity	        O(n)
 */
public class BogoSort {

    public void bogoSort(List<Integer> deck) {
        while (!isInOrder(deck)) {
            Collections.shuffle(deck);
        }
    }

    private boolean isInOrder(List<Integer> deck) {
        for (int i = 0; i < deck.size() - 1; i++) {
            if (deck.get(i) > deck.get(i + 1)) return false;
        }
        return true;
    }
}
