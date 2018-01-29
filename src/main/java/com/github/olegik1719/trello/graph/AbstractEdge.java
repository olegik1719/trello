package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public abstract class AbstractEdge<T> implements Edge<T> {
    private final T begin;
    private final T end;
    private final boolean oriented;
    private final Number price = 1;

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

    @Override
    public Number getPrice(){
        return price;
    }

    @Override
    public String toString(){
        return begin.toString() + (oriented? '-':'<') + "->" + end.toString();
    }
}
