package com.github.olegik1719.trello.graph;

public interface Edge<T> {
    Vertex<T> getBegin();
    Vertex<T> getEnd();
}
