package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DefaultEdge<T> extends AbstractEdge<T> {
    final boolean oriented = false;

    public DefaultEdge(T begin, T end, boolean oriented){
        super(begin,end,oriented);
    }

    public DefaultEdge(T begin, T end) {
        super(begin, end, false);
    }

}
