package com.telizhenko.sort.unstable.patience;

/**
 * @author Artem.Telizhenko
 *         Date: 12.09.2014
 *         Time: 13:11
 */

import java.util.*;

/**
 * Patience sorting is a sorting algorithm, based on a solitaire card game, that has the property of being able to
 * efficiently compute the length of a longest increasing subsequence in a given array.
 * <p/>
 * Algorithm for sorting
 * Given an n-element array with an ordering relation as an input for the sorting, consider it as a collection of cards,
 * with the (unknown in the beginning) statistical ordering of each element serving as its index. Note that the game
 * never uses the actual value of the card, except for comparison between two cards, and the relative ordering of any
 * two array elements is known.
 * Now simulate the patience sorting game, played with the greedy strategy, i.e., placing each new card on the leftmost
 * pile that is legally possible to use. At each stage of the game, under this strategy, the labels on the top cards of
 * the piles are increasing from left to right. To recover the sorted sequence, repeatedly remove the minimum visible card.
 * Complexity
 * If values of cards are in the range 1, ..., n, there is an efficient implementation with O(n * log * log n)
 * worst-case running time for putting the cards into piles, relying on a van Emde Boas tree. A description is given in
 * the work by S. Bespamyatnikh and M. Segal.
 * When no assumption is made about values, the greedy strategy can be implemented in O(n * log n) comparisons in worst
 * case. In fact, one can implement it with an array of stacks ordered by values of top cards and, for inserting a new
 * card, use a binary search, which is O(\log p) comparisons in worst case, where p is the number of piles. To complete
 * the sorting in an efficient way (aka O(n \log n) worst case), each step will retrieve the card with the least value
 * from the top of leftmost pile, and then some work has to be done. Finding the next card by searching it among all
 * tops of piles, as in the wikibooks implementation suggested below, gives a O(n \sqrt n) worst case. However, we can
 * use an efficient priority queue (for example, a binary heap) to maintain the piles so that we can extract the maximum
 * data in O(log n) time.
 * <p/>
 * Class	                Sorting algorithm
 * Data structure	        Array
 * <p/>
 * Worst case performance	O(n * log n)
 */
public class PatienceSort {
    public static <E extends Comparable<? super E>> void sort(E[] n) {
        List<Pile<E>> piles = new ArrayList<Pile<E>>();
        // sort into piles
        for (E x : n) {
            Pile<E> newPile = new Pile<E>();
            newPile.push(x);
            int i = Collections.binarySearch(piles, newPile);
            if (i < 0) i = ~i;
            if (i != piles.size())
                piles.get(i).push(x);
            else
                piles.add(newPile);
        }
        System.out.println("longest increasing subsequence has length = " + piles.size());

        // priority queue allows us to retrieve least pile efficiently
        PriorityQueue<Pile<E>> heap = new PriorityQueue<Pile<E>>(piles);
        for (int c = 0; c < n.length; c++) {
            Pile<E> smallPile = heap.poll();
            n[c] = smallPile.pop();
            if (!smallPile.isEmpty())
                heap.offer(smallPile);
        }
        assert (heap.isEmpty());
    }

    private static class Pile<E extends Comparable<? super E>> extends Stack<E> implements Comparable<Pile<E>> {
        public int compareTo(Pile<E> y) {
            return peek().compareTo(y.peek());
        }
    }
}
