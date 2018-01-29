package com.github.olegik1719.trello.graph;

public class DefaultEdge<T> extends AbstractEdge<T> {

    @SuppressWarnings("")
    public DefaultEdge(T begin, T end, boolean oriented) {
        super(begin,end,oriented);
    }

    public DefaultEdge(T begin, T end) {
        this(begin, end, false);
    }

    protected boolean canEqual(Object other) {
        return other instanceof DefaultEdge;
    }
}
