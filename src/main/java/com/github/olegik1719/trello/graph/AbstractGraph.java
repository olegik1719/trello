package com.github.olegik1719.trello.graph;

import java.util.*;


public abstract class AbstractGraph<T> implements Graph<T> {
    private Map<T, Map<T,Collection<Edge<T>>>> vertices;
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
            vertices.put(vertex, new HashMap<>());
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
        return vertices.get(vertex).keySet();
    }

    @Override
    public boolean addEdge(Edge<T> edge, boolean force) {
        T begin = edge.getBegin();
        T end = edge.getEnd();
        if (force) {
            addVertex(begin);
            addVertex(end);
        }
        if(isVertex(begin)&&isVertex(end)){
            Set<T> beginNeighbours = vertices.get(begin).keySet();
            if (!beginNeighbours.contains(end)){
                vertices.get(begin).put(end,new HashSet<>());
            }
            vertices.get(begin).get(end).add(edge);
            if(!edge.isOriented()){
                Set<T> endNeighbours = vertices.get(end).keySet();
                if (!beginNeighbours.contains(begin)){
                    vertices.get(end).put(begin,new HashSet<>());
                }
                vertices.get(end).get(begin).add(edge);
            }
            return edges.add(edge);
        }
        return false;
    }

    @Override
    public Collection<Edge<T>> getEdges() {
        return edges;
    }

    @Override
    public boolean isEdge(T begin, T end) {
        return vertices.get(begin).keySet().contains(end) && (vertices.get(begin).get(end).size() > 0);
    }

    @Override
    public int getVerticesCount() {
        return vertices.size();
    }

    @Override
    public int getEdgesCount() {
        return edges.size();
    }

    @Override
    public String toString(){
        return String.format("Vertices:%n%s: %s%nEdges:%n%s: %s%n",vertices.size(), getVertices(),edges.size(),getEdges());
    }

    @Override
    public boolean removeEdge(Edge<T> edge) {
        T begin = edge.getBegin();
        T end = edge.getEnd();
        boolean result = vertices.get(begin).get(end).remove(edge);
        if (edge.isOriented()){
            result &= vertices.get(end).get(begin).remove(edge);
        }
        return result;
    }

    @Override
    public boolean removeEdge(T begin, T end) {
        return removeEdge(begin,end, false);
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean removeEdge(T begin, T end, boolean removeAll) {
        Edge<T>[] edgesBeginEnd = (Edge<T>[]) vertices.get(begin).get(end).toArray();
        boolean result = removeEdge(edgesBeginEnd[0]);

        if (removeAll){
            for (int i = 1; i < edgesBeginEnd.length; i++) {
                result &= removeEdge(edgesBeginEnd[i]);
            }
        }
        return result;
    }
}
