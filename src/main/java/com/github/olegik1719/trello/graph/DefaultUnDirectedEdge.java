package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DefaultUnDirectedEdge<T> extends AbstractEdge<T> {
    final boolean oriented = false;

    public DefaultUnDirectedEdge(T begin, T end) {
        super(begin, end, false);
    }
}
