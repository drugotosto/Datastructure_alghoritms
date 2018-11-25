package com.ferrero.dataStructures.stack;

public interface CustomStack<X> {
    public void push(X newitem);
    public X pop();
    public boolean contains(X item);
    public X access(X item);
    public int size();
}
