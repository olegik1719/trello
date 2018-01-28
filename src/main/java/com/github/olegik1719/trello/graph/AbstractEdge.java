package com.github.olegik1719.trello.graph;

public abstract class AbstractEdge<T> implements Edge<T> {
    private final T begin;
    private final T end;
    private final boolean oriented;

    public AbstractEdge(T begin, T end, boolean oriented) {
        this.begin = begin;
        this.end = end;
        this.oriented = oriented;
    }

    public AbstractEdge(T begin, T end){
        this(begin, end, false);
    }

    @Override
    public T getBegin() {
        return begin;
    }

    @Override
    public T getEnd() {
        return end;
    }

    @Override
    public boolean isOriented() {
        return oriented;
    }
}
