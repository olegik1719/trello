package com.github.olegik1719.trello.graph;

import java.util.*;

public class DefaultGraph implements Graph<Integer> {

    private HashSet<Integer> verticles;
    private HashSet<Edge<Integer>> edges;
    private HashMap<Integer,List<Integer>> neighbors;

    public DefaultGraph(){
        verticles = new HashSet<>();
        edges = new HashSet<>();
        neighbors = new HashMap<>();
    }

    @Override
    public boolean add(Integer verticle) {
        return verticles.add(verticle);
    }



    @Override
    public boolean addEdge(Edge<Integer> edge) {
        return edges.add(edge);
    }

    @Override
    public boolean isEdge(Integer begin, Integer end) {
        //create new Edge and look it in edges.
        return false;
    }

    @Override
    public Collection<Integer> getVericles() {
        return (Collection<Integer>) verticles.clone();
    }

    @Override
    public int getVerticlesCount() {
        return verticles.size();
    }

    @Override
    public int getEdgesCount() {
        return edges.size();
    }

    @Override
    public Collection<Integer> getNeighbours(Integer verticle) {
        return neighbors.get(verticle);
    }

    @Override
    public Collection<Edge<Integer>> getEdges() {
        return (Collection<Edge<Integer>>) edges.clone();
    }

    @Override
    public Collection<Integer> getVerticles() {
        return (Collection<Integer>)verticles.clone();
    }
}
