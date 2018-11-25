package com.ferrero.dataStructures.queue;

import java.util.ArrayList;

public class ArrayListQueue<X> implements CustomQueue<X> {

    // Array che contiene i generici dati di tipo "X" della queue
    private ArrayList<X> data = new ArrayList<>();

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void enQueue(X item) {
        data.add(item);
    }

    @Override
    public X deQueue() {
        if (data.size()>0) return data.remove(0);
        else throw new IllegalStateException("Non ci sono più elementi nella queue!");
    }

    @Override
    public boolean contains(X item) {
        return data.contains(item);
    }

    @Override
    public X access(int position) {
        return data.get(position);
    }
}
