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
public class Stacked<E> implements StackInt<E>{
    private final int START_CAP = 500;
    
    int size,count,expand;
    
    E[] stackArray;
    //creates constructor with a default cap
    public Stacked(){
        count = 0;
        stackArray = (E[]) new Object[START_CAP];
    }
    //creates a constructor with mutated cap 
    public Stacked(int size){
        this.size = size;
        count = 0;
        expand = 5;
        stackArray = (E[]) new Object[size];
    }
    //checks if stack is empty
    @Override
    public boolean isEmpty(){
        return (count == 0);
    }
    //takes out elements from stack depending if the stack is full or not
    @Override
    public E pop() throws EmptyStackException{
        
        if(!isEmpty()){
            count--;
            E eval = stackArray[count];
            stackArray[count] = null;
            return eval;
        }
        
        else 
            throw new EmptyStackException();
    } 
    //checks if the stack is full       
    @Override
    public boolean isFull(){
        return (count == size);
    
    }
    //checks the first element of the stack
    @Override
    public E top()throws EmptyStackException{
        E c = null;
        if(!isEmpty()){
            c  = stackArray[count-1];
            return c;
        }
        
        else 
            throw new EmptyStackException();
    } 
    //expands the stack is it has reached its limit
    private void expand(){
     
        int newSize = size + expand;
        E[] tempArray = (E[]) new Object[newSize];
        for(int n = 0; n < size; n++){
            tempArray[n] = stackArray[n]; 
        }
        stackArray = tempArray;
        size = newSize;
    }
    //puts elements into the stack
    @Override
    public void push(E z){
        if(isFull()){
            expand();
            System.out.println("Stack expanded by "+ expand+ " cells");
        }
        stackArray[count] = z;
        count++;
    }
}

