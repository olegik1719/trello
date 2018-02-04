package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public interface Graph<T>{

    Graph<T> addVertex(T vertex);
    Graph<T> addEdge(T begin, T end);

    boolean isVertex(T vertex);
    boolean isEdge(T begin, T end);

    int countVertices();
    int countEdges();

    Collection<T> vertices();

    default Number getWeight(){
        return Double.NaN;
    }

    default  Collection<T> getNeighbours(T vertex){
        Collection<T> result = new HashSet<>(vertices());
        //vertices().forEach(neighbour -> {if (isEdge(vertex,neighbour))result.add(neighbour);});
        result.removeIf(neighbour -> !isEdge(vertex,neighbour));
        return result;
    }
}
