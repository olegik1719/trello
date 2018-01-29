package com.github.olegik1719.trello.graph;

public class DefaultEdge<T> extends AbstractEdge<T> {

    public DefaultEdge(T begin, T end, boolean oriented, Number price){
        super(begin,end,oriented, price);
    }

    public DefaultEdge(T begin, T end, Number price){
        super(begin,end,price);
    }

    public DefaultEdge(T begin, T end, boolean oriented) {
        super(begin,end,oriented);
    }

    public DefaultEdge(T begin, T end) {
        super(begin, end);
    }

    protected boolean canEqual(Object other) {
        return other instanceof DefaultEdge;
    }
}
