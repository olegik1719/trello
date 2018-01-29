package com.github.olegik1719.trello.graph;

import java.util.*;


public abstract class AbstractGraph<T> implements Graph<T> {
    private Map<T, Collection<T>> vertices;
    private Collection<Edge<T>> edges;


    public AbstractGraph(){
        vertices = new HashMap<>();
        edges = new HashSet<>();
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
        T begin = edge.getBegin();
        T end = edge.getEnd();
        if (force){
            addVertex(begin);
            addVertex(end);
            vertices.get(begin).add(end);
            if(!edge.isOriented()) vertices.get(end).add(begin);
            return edges.add(edge);
        }else{
            if(isVertex(edge.getBegin())&&isVertex(edge.getEnd())){
                vertices.get(begin).add(end);
                if(!edge.isOriented()) vertices.get(end).add(begin);
                return edges.add(edge);
            }
        }
        return false;
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
