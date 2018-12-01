package com.ferrero.dataStructures.list;

import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class BasicLinkedList<X> {
    private Node fist;
    private Node last;
    private int nodeCount;

    public BasicLinkedList() {
        fist=null;
        last=null;
        nodeCount=0;
    }

    public int size(){
        return nodeCount;
    }

    public void add(X item){
        Node newNode = new Node(item);
        if (size()>0) {
            last.setNextNode(newNode);
            last=newNode;
        }
        else {
            last=fist=newNode;
        }
        nodeCount++;
    }

    public X remove(){

    }

    @Data
    private class Node {
        private Node nextNode;
        private X nodeItem;

        public Node(X nodeItem) {
            this.nextNode = null;
            this.nodeItem = nodeItem;
        }

    }
}
