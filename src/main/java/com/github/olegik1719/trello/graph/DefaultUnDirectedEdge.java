package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DefaultUnDirectedEdge<T> extends AbstractEdge<T> {

    public DefaultUnDirectedEdge(T begin, T end) {
        super(begin, end);
    }

    @Override
    public Edge<T> getOpposite() {
        return new DefaultUnDirectedEdge(getEnd(),getBegin());
    }
}
