package com.github.olegik1719.trello.graph;

import java.util.*;

/**
 * Undirected, Unweight graph
 */

public abstract class AbstractSimpleGraph<T> extends AbstractGraph<T>{

    private Map<T,Collection<T>> vertices;
    private Collection<Edge<T>> edges;

    public AbstractSimpleGraph(Graph<T> original){
        this();
        for (Edge<T> edge: original.getEdges()){
            addEdge(edge, true);
        }
        addVertices(original.getVertices());
    }

    public AbstractSimpleGraph() {
        vertices = new HashMap<>();
        edges = new HashSet<>();
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
        }
        return vertices.keySet().contains(begin)&& vertices.keySet().contains(end)
                && vertices.get(begin).add(end) && vertices.get(end).add(begin)
                && edges.add(new DefaultEdge<>(begin,end));
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

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean removeEdge(Edge<T> edge) {
        T begin = edge.getBegin();
        T end = edge.getEnd();
        vertices.get(begin).remove(end);
        vertices.get(end).remove(begin);
        return edges.remove(edge);
    }

    @Override
    public boolean removeEdge(T begin, T end) {
        if (isEdge(begin,end)){
            vertices.get(begin).remove(end);
            vertices.get(end).remove(begin);
            for(Edge<T> edge: edges)
                if((edge.getBegin() == begin)&&(edge.getEnd()==end))
                    return edges.remove(edge);
        }
        return false;
    }

    @Override
    public boolean removeEdge(T begin, T end, boolean removeAll) {
        return removeEdge(begin, end);
    }

    @Override
    public boolean removeVertex(T vertex, boolean force) {
        if (force){
            for(T neighbour: vertices.get(vertex)){
                removeEdge(vertex,neighbour);
            }
        }else{
            if(!vertices.get(vertex).isEmpty())
                return false;
        }
        vertices.remove(vertex);
        return true;
    }

    @Override
    public boolean addVertices(T[] vertices) {
        return addVertices(Arrays.asList(vertices));
    }

    @Override
    public boolean addVertices(Collection<T> vertices) {
        boolean result = true;
        for (T vertex:vertices)
            result &= addVertex(vertex);
        return result;
    }

    @Override
    public boolean addEdge(Edge<T> edge) {
        return addEdge(edge,false);
    }

    @Override
    public boolean removeVertex(T vertex) {
        return removeVertex(vertex,false);
    }

    @Override
    public boolean removeAllVertex(Collection<T> vertices) {
        boolean result = true;
        for (T vertex:vertices)
            result &= removeVertex(vertex);
        return result;
    }
}
