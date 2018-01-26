package com.github.olegik1719.trello.graph;

import java.util.*;

public class DefaultGraph implements Graph<Integer> {

    private HashSet<Vertex<Integer>> vertices;
    private HashSet<Edge<Integer>> edges;

    public DefaultGraph(){
        vertices = new HashSet<>();
        edges = new HashSet<>();
    }

    public DefaultGraph(Graph<Integer> other){
        this();
        vertices.addAll(other.getVertices());
        for (Edge<Integer> edge: other.getEdges()){
            addEdge(edge);
        }
    }

    @Override
    public DefaultGraph copy(Graph<Integer> original){
        return new DefaultGraph(original);
    }

    public boolean addVertex(Integer value){
        return addVertex(new DefaultVertex(value));
    }

    @Override
    public boolean addVertex(Vertex<Integer> vertex) {
        return  vertices.add(vertex);
    }

    public boolean addEdge(Integer begin, Integer end){
        return addEdge(new DefaultVertex(begin),new DefaultVertex(end));
    }

    public boolean addEdge(Vertex<Integer> begin,Vertex<Integer> end) {
        return vertices.contains(begin) && vertices.contains(end)&& edges.add(new DefaultEdge(begin, end));
    }

    @Override
    public boolean addEdge(Edge<Integer> edge) {
        return addEdge(edge.getBegin(),edge.getEnd());
    }

    public boolean isEdge(Integer begin, Integer end) {
        Edge<Integer> edge = new DefaultEdge(new DefaultVertex(begin), new DefaultVertex(end));
        return edges.contains(edge);
    }

    @Override
    public boolean isEdge(Vertex<Integer> begin, Vertex<Integer> end) {
        Edge<Integer> edge = new DefaultEdge(begin, end);
        return edges.contains(edge);
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
    public Collection<Vertex<Integer>> getNeighbours(Vertex<Integer> vertex) {
        return vertex.getNeighbours();
    }

    @Override
    public Collection<Edge<Integer>> getEdges() {
        return new ArrayList<>(edges);
    }

    @Override
    public Collection<Vertex<Integer>> getVertices() {
        return new ArrayList<>(vertices);
    }
}
