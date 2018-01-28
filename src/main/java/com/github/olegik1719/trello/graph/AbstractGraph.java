package com.github.olegik1719.trello.graph;

import java.util.*;


public abstract class AbstractGraph<T> implements Graph<T> {
    private Map<T, Collection<T>> vertices;
    private Collection<Edge<T>> edges;


    public AbstractGraph(){
        vertices = new HashMap<>();
        edges = new TreeSet<>();
    }

    public AbstractGraph(Graph<T> original){
        vertices = new HashMap<>();
        for(T vertex: original.getVertices()) addVertex(vertex);
        for (Edge<T> edge: original.getEdges()) addEdge(edge);
    }

    @Override
    public boolean addVertex(T vertex) {
        if (!isVertex(vertex)){
            vertices.put(vertex, new HashSet<>());
            return true;
        }
        return false;
    }

    @Override
    public boolean isVertex(T vertex) {
        return vertices.keySet().contains(vertex);
    }

    @Override
    public Collection<T> getVertices() {
        return vertices.keySet();
    }

    @Override
    public Collection<T> getNeighbours(T vertex) {
        return vertices.get(vertex);
    }

    @Override
    public boolean addEdge(Edge<T> edge, boolean force) {
        if (force){
            addVertex(edge.getBegin());
            addVertex(edge.getEnd());
            return edges.add(edge);
        }
        return isVertex(edge.getBegin()) && isVertex(edge.getEnd()) && edges.add(edge);
    }

    @Override
    public Collection<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public boolean isEdge(T begin, T end) {
        return vertices.get(begin).contains(end);
    }

    @Override
    public int getVerticesCount() {
        return vertices.size();
    }

    @Override
    public int getEdgesCount() {
        return edges.size();
    }
}
