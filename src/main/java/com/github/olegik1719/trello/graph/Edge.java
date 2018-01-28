package com.github.olegik1719.trello.graph;

public interface Edge<T> {
    T getBegin();
    T getEnd();
    default Number getPrice(){
        return 1;
    }
    Edge<T> getOpposite();
}
