package com.ferrero.dataStructures.stack;

import com.ferrero.dataStructures.queue.BasicQueue;

public class BasicStack<X> implements CustomStack<X> {

    // Tale array che rappresenta lo stack che contiene i generici dati di tipo "X"
    private X[] data;
    // Rappresenta il puntatore alla cima dello stack rappresentato dall'array "data" (punta al primo posto vuoto disponibile)
    private int stackPointer;

    public BasicStack() {
        this(100);
    }

    public BasicStack(int size) {
        this.data = (X[]) new Object[size];
        stackPointer = 0;
    }
    // O(1) Function
    public void push(X newitem) {
        data[stackPointer++] = newitem;
    }

    // O(1) Function
    public X pop() {
        if (stackPointer == 0) {
                throw new IllegalStateException("Non ci sono items all'interno dello stack!");
        }
        return data[--stackPointer];
    }

    // O(n) Function
    public boolean contains(X item) {
        for (int i = 0; i < stackPointer; i++) {
            if (data[i].equals(item)) return true;
        }
        return false;
    }

    /*
        O(n) Function
        Sfrutta il metodo pop()
    */
    public X access(X item) {
        X returnValue=null;
        while (stackPointer>0){
            returnValue=pop();
            if(returnValue.equals(item)) return returnValue;
        }
        throw  new IllegalStateException("L'elemento cercato non è presente!");
    }

    // O(1) Function
    public int size(){
        return stackPointer;
    }
}
