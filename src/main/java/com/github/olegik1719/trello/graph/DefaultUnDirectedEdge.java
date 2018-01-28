package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DefaultUnDirectedEdge<T> extends AbstractEdge<T> {
    final boolean oriented;

    public DefaultUnDirectedEdge(T begin, T end, boolean oriented) {
        super(begin, end);
        this.oriented = oriented;
    }

    public DefaultUnDirectedEdge(T begin, T end) {
        this(begin, end, false);
    }

    @Override
    public boolean isOriented() {
        return oriented;
    }
}
