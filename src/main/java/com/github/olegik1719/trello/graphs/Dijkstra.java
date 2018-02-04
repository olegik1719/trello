package com.github.olegik1719.trello.graphs;

public interface Dijkstra<T> extends Graph<T> {
    default Number getDijkstra(T begin, T end){
        return Double.NaN;
    }
}
