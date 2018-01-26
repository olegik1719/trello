package com.github.olegik1719.trello.graph;

import java.util.Collection;

public class DefaultGraph implements Graph<Integer> {

    @Override
    public boolean add(Integer verticle) {
        return false;
    }

    @Override
    public boolean addEdge(Edge<Integer> edge) {
        return false;
    }

    @Override
    public boolean isEdge(Integer begin, Integer end) {
        return false;
    }

    @Override
    public Collection<Integer> getVericles() {
        return null;
    }

    @Override
    public int getVerticlesCount() {
        return 0;
    }

    @Override
    public int getEdgesCount() {
        return 0;
    }

    @Override
    public Collection<Integer> neighbors(Integer verticle) {
        return null;
    }

    @Override
    public Collection<Edge<Integer>> edges() {
        return null;
    }

    @Override
    public Collection<Integer> verticles() {
        return null;
    }
}
