package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class ExampleDijkstraImplementation implements Dijkstra<String> {

    private HashMap<String, HashSet<String>> vertices;

    public ExampleDijkstraImplementation(){
        vertices = new HashMap<>();
    }

    @Override
    public Graph<String> addVertex(String vertex) {
        vertices.computeIfAbsent(vertex,s->new HashSet<>());
        return this;
    }

    @Override
    public Graph<String> addEdge(String begin, String end) {
        vertices.computeIfAbsent(begin,s->new HashSet<>()).add(end);
        vertices.computeIfAbsent(end, s-> new HashSet<>()).add(begin);
        return this;
    }

    @Override
    public Collection<String> vertices() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public Collection<String> getNeighbours(String vertex){
        return new HashSet<>(vertices.get(vertex));
    }

    @Override
    public boolean isEdge(String begin, String end) {
        return vertices.containsKey(begin)
                && vertices.containsKey(end)
                && vertices.get(begin).contains(end);
    }
}
