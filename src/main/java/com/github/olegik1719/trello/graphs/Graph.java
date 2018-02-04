package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashSet;

public interface Graph<T>{

    Graph<T> addVertex(T vertex);
    Graph<T> addEdge(T begin, T end);
    Collection<T> vertices();


    default Graph<T> addNeighbours(T vertex, T...neighbours){
        for (T neighbour:neighbours){
            addEdge(vertex,neighbour);
        }
        return this;
    }

    default boolean isVertex(T vertex){
        return vertices().contains(vertex);
    }

    boolean isEdge(T begin, T end);

    default int countVertices(){
        return vertices().size();
    }

    default int countEdges(){
        int sum = 0;
        for (T vertex:vertices()){
            sum += getNeighbours(vertex).size();
        }
        return sum / 2;
    }

    default  Collection<T> getNeighbours(T vertex){
        Collection<T> result = new HashSet<>(vertices());
        //vertices().forEach(neighbour -> {if (isEdge(vertex,neighbour))result.add(neighbour);});
        result.removeIf(neighbour -> !isEdge(vertex,neighbour));
        return result;
    }
}
