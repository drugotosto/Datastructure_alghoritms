package com.ferrero.dataStructures.queue;

/**
 * Created by Maurizio on 25/11/2018.
 */
public class BasicQueue<X> {

    // Tale array che rappresenta lo stack che contiene i generici dati di tipo "X"
    private X[] data;
    private int head;
    private int tail;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size){
        this.data=(X[]) new Object[size];
        head = tail = -1;
    }

    public int size(){
        if (head!=0 && tail!=0) {
            return 0;
        }
        else return -1;
     }
}
