package com.ferrero.dataStructures.queue;


import lombok.extern.java.Log;
/**
 * Created by Maurizio on 25/11/2018.
 */
@Log
public class BasicQueue<X> implements CustomQueue<X>{

    // Array circolare che contiene i generici dati di tipo "X" della queue
    private X[] data;
    // Puntatore alla testa della queue da dove si prelevano gli elementi (punta al primo posto che contiene un valore all'interno dell'array "data")
    private int tail;
    // Puntatore alla coda della queue da dove si inseriscono gli elementi (punta all'ultimo posto che contiene un valore all'interno dell'array "data")
    private int head;

    public BasicQueue() {
        this(1000);
    }

    public BasicQueue(int size){
        this.data=(X[]) new Object[size];
        head = tail = -1;
    }

    // O(1) Function
    public int size(){
        if (head==-1 && tail==-1) {
            return 0;
        }
        // sarebbe come (tail-head)+1
        else return tail-head+1;
    }

    // O(1) Function
    public void enQueue(X item){
        // Controllo che ci sia ancora spazio all'interno dell'array
        if ((tail>=size()) && (tail+1) % data.length >= head) {
            log.warning("ATTENZIONE: Non c'è più spazio nella queue!");
            throw new IllegalStateException("Non c'è più spazio all'interno della queue!");
        }
        else if(this.size()>0) {
            tail++;
            data[tail]=item;
        }
        else {
            tail++;
            head++;
            data[tail]=item;
        }
    }

    // O(1) Function
    public X deQueue(){
        X returnValue;
        if (this.size()>1){
            returnValue=data[head];
            data[head]=null;
            head++;
        }
        else if(this.size()==1) {
            returnValue=data[head];
            data[head]=null;
            head=tail=-1;
            log.warning("ATTENZIONE: Ho prelevato l'ultimo elemento della queue!");
        }
        else{
            log.warning("ATTENZIONE: Non ci sono più elementi nella queue!");
            throw new IllegalStateException("Non ci sono items all'interno dello stack!");
        }
        return returnValue;
    }

    // O(n) Function
    public boolean contains(X item) {
        if (size()>0) {
            for (int i = head; i <= tail; i++) {
                if (data[i].equals(item)) return true;
            }
            return false;
        }
        log.warning("ATTENZIONE: La queue è vuota!");
        throw new IllegalStateException("La Queue è vuota");
    }

    // O(n) Function
    public X access(int position) {
        if (size()==0 || position>size()) {
            log.warning("ATTENZIONE: Non ci sono elementi validi per la data posizione all'interno della queue!");
            throw new IllegalStateException("La Queue è vuota");
        }

        // Ciclo all'interno della queue tenendo conto di dover gestire un array circolare
        int trueIndex=0;
        for (int i = head; i < tail; i++) {
            if (position==trueIndex) return data[position];
            trueIndex++;
        }

        throw new IllegalStateException(String.format("Non è possibile recuperare l'elemento alla posizione %d",position ));
    }

}
