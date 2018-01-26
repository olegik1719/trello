package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

import java.util.*;

public class DefaultGraph implements Graph<Integer> {

    private HashSet<Integer> vertices;
    private HashSet<Edge<Integer>> edges;
    private HashMap<Integer,Collection<Integer>> neighbors;

    public DefaultGraph(){
        vertices = new HashSet<>();
        edges = new HashSet<>();
        neighbors = new HashMap<>();
    }

    public DefaultGraph(Graph<Integer> other){
        this();
        vertices.addAll(other.getVertices());
        for (Edge<Integer> edge: other.getEdges()){
            addEdge(edge);
        }
    }

    public DefaultGraph copy(Graph<Integer> original){
        return new DefaultGraph(original);
    }

    @EqualsAndHashCode
    private class DefaultEdge implements Edge<Integer>{

        private final Integer begin;
        private final Integer end;

        private DefaultEdge(Integer first, Integer second){
            if (first.compareTo(second)>=0){
                begin = second;
                end = first;
            }else {
                begin = first;
                end = second;
            }
        }

        @Override
        public Integer[] getVertices() {
            return new Integer[]{begin,end};
        }
    }

    @Override
    public boolean add(Integer verticle) {
        if (vertices.add(verticle) ){
            neighbors.put(verticle,new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(Integer begin,Integer end) {
        if (vertices.contains(begin) && vertices.contains(end)){
            neighbors.get(begin).add(end);
            neighbors.get(end).add(begin);
            return edges.add(new DefaultEdge(begin, end));
        }
        return false;
    }

    @Override
    public boolean addEdge(Edge<Integer> edge) {
        Integer[] points = edge.getVertices();
        if (points.length > 2) throw new RuntimeException();
        return addEdge(points[0],points[1]);
    }

    @Override
    public boolean isEdge(Integer begin, Integer end) {
        //create new Edge and look it in edges.
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
    public Collection<Integer> getNeighbours(Integer vertex) {
        return neighbors.get(vertex);
    }

    @Override
    public Collection<Edge<Integer>> getEdges() {
        return new ArrayList<>(edges);
    }

    @Override
    public Collection<Integer> getVertices() {
        return new ArrayList<>(vertices);
    }
}
