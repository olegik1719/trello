package com.github.olegik1719.trello.graph;

public abstract class AbstractEdge<T> implements Edge<T> {
    final T begin;
    final T end;

    public AbstractEdge(T begin, T end){
        this.begin = begin;
        this.end = end;
    }

    @Override
    public T getBegin() {
        return begin;
    }

    @Override
    public T getEnd() {
        return end;
    }

}
