package com.github.olegik1719.trello.graphs;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

public class DirectedUnweightedGraph<T> implements Graph<T> {
    private HashMap<T, HashSet<T>> vertices;

    public DirectedUnweightedGraph(){
        vertices = new HashMap<>();
    }

    public DirectedUnweightedGraph(Graph<T> otherGraph){
        this();
        otherGraph.vertices().forEach(vertex -> vertices.put(vertex,new HashSet<>(otherGraph.getNeighbours(vertex))));
    }

    @Override
    public DirectedUnweightedGraph<T> addVertex(T vertex) {
        vertices.computeIfAbsent(vertex,k -> new HashSet<>());
        return this;
    }

    @Override
    public DirectedUnweightedGraph<T> addEdge(T begin, T end) {
        vertices.computeIfAbsent(begin, k->new HashSet<>()).add(end);
        return this;
    }

    @Override
    public Collection<T> vertices() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public boolean isVertex(T vertex) {
        return vertices.containsKey(vertex);
    }

    @Override
    public boolean isEdge(T begin, T end) {
        return isVertex(begin) && isVertex(end) && vertices.get(begin).contains(end);
    }

    @Override
    public int countVertices() {
        return vertices.size();
    }

    @Override
    public Collection<T> getNeighbours(T vertex) {
        return new HashSet<>(vertices.get(vertex));
    }


}
