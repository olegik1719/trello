package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class ExampleDijkstraImplementation<T> implements Dijkstra<T> {

    private HashMap<T, HashSet<T>> vertices;

    public ExampleDijkstraImplementation(){
        vertices = new HashMap<>();
    }

    @Override
    public Graph<T> addVertex(T vertex) {
        vertices.computeIfAbsent(vertex,s->new HashSet<>());
        return this;
    }

    @Override
    public Graph<T> addEdge(T begin, T end) {
        vertices.computeIfAbsent(begin,s->new HashSet<>()).add(end);
        vertices.computeIfAbsent(end, s-> new HashSet<>()).add(begin);
        return this;
    }

    @Override
    public Collection<T> vertices() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public Collection<T> getNeighbours(T vertex){
        return new HashSet<>(vertices.get(vertex));
    }

    @Override
    public boolean containsEdge(T begin, T end) {
        return vertices.containsKey(begin)
                && vertices.containsKey(end)
                && vertices.get(begin).contains(end);
    }
}
