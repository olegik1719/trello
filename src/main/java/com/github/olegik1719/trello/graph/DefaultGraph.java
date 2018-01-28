package com.github.olegik1719.trello.graph;

public class DefaultGraph<T> extends AbstractGraph<T>{

    public DefaultGraph(){
        super();
    }

    public DefaultGraph(Graph<T> original){
        super(original);

    }

    @Override
    public Graph<T> copy(Graph<T> original) {
        return new DefaultGraph(original);
    }
}
