package com.telizhenko.sort.stable.tree;

/**
 * @author Artem.Telizhenko
 *         Date: 11.09.2014
 *         Time: 16:53
 */
public class KeyPrinter implements TreeVisitor {
    @Override
    public void visit(Tree node) {
        System.out.println(" " + node.key);
    }
}
