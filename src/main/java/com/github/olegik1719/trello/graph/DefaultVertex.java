package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

@EqualsAndHashCode
public class DefaultVertex implements Vertex<Integer> {

    private final Integer vertex;
    private final HashSet<Vertex<Integer>> neighbours;

    public DefaultVertex(int value){
        vertex = value;
        neighbours = new HashSet<>();
    }

    @Override
    public boolean isNeighbour(Vertex<Integer> vertex) {
        return neighbours.contains(vertex);
    }

    @Override
    public Collection<Vertex<Integer>> getNeighbours() {
        return new ArrayList<>(neighbours);
    }

    @Override
    public Integer getValue() {
        return vertex;
    }

    @Override
    public boolean addNeighbour(Vertex<Integer> vertex) {
        return false;
    }
}
