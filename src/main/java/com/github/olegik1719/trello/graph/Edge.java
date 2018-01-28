package com.github.olegik1719.trello.graph;

public interface Edge<T> {
    T getBegin();
    T getEnd();

    Number getPrice();

    boolean isOriented();
}
