package com.telizhenko.sort.stable.tree;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 16:52
 */

/**
 * A tree sort is a sort algorithm that builds a binary search tree from the keys to be sorted, and then traverses the
 * tree (in-order) so that the keys come out in sorted order. Its typical use is sorting elements adaptively: after
 * each insertion, the set of elements seen so far is available in sorted order.
 * <p/>
 * Adding one item to a binary search tree is on average an O(log n) process (in big O notation), so adding n items is
 * an O(n log n) process, making tree sort a so-called 'fast sort'. But adding an item to an unbalanced binary tree
 * needs O(n) time in the worst-case, when the tree resembles a linked list (degenerate tree), causing a worst case of
 * O(n^2) for this sorting algorithm. This worst case occurs when the algorithm operates on an already sorted set, or
 * one that is nearly sorted. Expected O(log n) time can however be achieved in this case by shuffling the array.
 * The worst-case behaviour can be improved upon by using a self-balancing binary search tree. Using such a tree,
 * the algorithm has an O(n log n) worst-case performance, thus being degree-optimal for a comparison sort. When using
 * a splay tree as the binary search tree, the resulting algorithm (called splaysort) has the additional property that
 * it is an adaptive sort, meaning that its running time is faster than O(n log n) for inputs that are nearly sorted.
 * <p/>
 * Class	Sorting algorithm
 * Data structure	Array
 * <p/>
 * Worst case performance O(n?) (unbalanced), O(n log n) (balanced)
 * Best case performance O(n) (unbalanced), O(n log n) (balanced)
 * Average case performance	O(n log n)
 * Worst case space complexity	?(n)
 */
public class Tree {
    public Tree left;            // левое и правое поддеревья и ключ
    public Tree right;
    public int key;

    public Tree(int k) {        // конструктор с инициализацией ключа
        key = k;
    }

    /*  insert (добавление нового поддерева (ключа))
        сравнить ключ добавляемого поддерева (К) с ключом корневого узла (X).
        Если K>=X, рекурсивно добавить новое дерево в правое поддерево.
        Если K<X, рекурсивно добавить новое дерево в левое поддерево.
        Если поддерева нет, то вставить на это место новое дерево
    */
    public void insert(Tree aTree) {
        if (aTree.key < key)
            if (left != null) left.insert(aTree);
            else left = aTree;
        else if (right != null) right.insert(aTree);
        else right = aTree;
    }

    /*  traverse (обход)
        Рекурсивно обойти левое поддерево.
        Применить функцию f (печать) к корневому узлу.
        Рекурсивно обойти правое поддерево.
    */
    public void traverse(TreeVisitor visitor) {
        if (left != null)
            left.traverse(visitor);

        visitor.visit(this);

        if (right != null)
            right.traverse(visitor);
    }
}
