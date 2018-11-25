package com.ferrero.dataStructures.stack;

import java.util.ArrayList;

public class ArrayListStack<X> implements CustomStack<X> {

    // Array che contiene i generici dati di tipo "X" dello stack
    private ArrayList<X> data;

    public ArrayListStack() {
        this.data = new ArrayList<X>();
    }

    // Inserisce il nuovo elemento al fondo dell'ArrayList
    public void push(X newitem) {
        data.add(newitem);
    }

    public X pop() {
        return (data.size()>0) ? data.remove(data.size()-1) : null;
    }

    public boolean contains(X item) {
        return data.contains(item);
    }

    public X access(X item) {
        X retriveItem;
        while (data.size()>0){
            // Sfrutta il metodo pop()
            retriveItem = pop();
           if (retriveItem.equals(item)) return retriveItem;
        }
        throw  new IllegalStateException("L'elemento cercato non è presente!");
    }

    public int size() {
        return data.size();
    }
}
