package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class UndirectedUnweightGraph<T> implements Graph<T> {

    private HashMap<T, HashSet<T>> vertices;

    public UndirectedUnweightGraph(){
        vertices = new HashMap<>();
    }

    public UndirectedUnweightGraph(Graph<T> otherGraph){
        this();
        otherGraph.vertices().forEach(vertex -> vertices.put(vertex,new HashSet<>(otherGraph.getNeighbours(vertex))));
    }

    @Override
    public UndirectedUnweightGraph<T> addVertex(T vertex) {
        vertices.computeIfAbsent(vertex,k -> new HashSet<>());
        return this;
    }

    @Override
    public UndirectedUnweightGraph<T> addEdge(T begin, T end) {
        vertices.computeIfAbsent(begin, k->new HashSet<>()).add(end);
        vertices.computeIfAbsent(end, k->new HashSet<>()).add(begin);
        return this;
    }

    @Override
    public Collection<T> vertices() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public boolean containsVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(T begin, T end) {
        return containsVertex(begin) && containsVertex(end) && vertices.get(begin).contains(end);
    }

    @Override
    public int countVertices() {
        return vertices.size();
    }

    @Override
    public Collection<T> getNeighbours(T vertex) {
        return new HashSet<>(vertices.get(vertex));
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(T vertex:vertices.keySet()){
            result.append(vertex.toString() + ": ");
            for (T neighbour:vertices.get(vertex)){
                result.append(neighbour.toString() + ", ");
            }
            result.append('\n');
        }
        return result.toString();
    }

}
