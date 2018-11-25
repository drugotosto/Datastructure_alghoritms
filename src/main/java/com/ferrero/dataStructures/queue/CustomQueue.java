package com.ferrero.dataStructures.queue;

public interface CustomQueue<X> {
    public int size();
    public void enQueue(X item);
    public X deQueue();
    public boolean contains(X item);
    public X access(int position);
}
