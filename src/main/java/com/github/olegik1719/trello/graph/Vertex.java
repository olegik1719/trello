package com.github.olegik1719.trello.graph;

import java.util.Collection;

public interface Vertex<T> {
    boolean isNeighbour(Vertex<T> vertex);
    Collection<Vertex<T>> getNeighbours();
    T getValue();
    boolean addNeighbour(Vertex<T> vertex);
}
