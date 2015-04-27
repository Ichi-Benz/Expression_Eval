/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package w2014c2080asg1_100854239;

import java.util.EmptyStackException;
/**
 *
 * @author Stan
 */
public interface StackInt<E> {
    boolean isEmpty();
    boolean isFull();
    E top()throws EmptyStackException;
    E pop() throws EmptyStackException;
    void push(E e);
}
