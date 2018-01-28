package com.github.olegik1719.trello.graph;

public class DefaultGraph extends AbstractGraph<Integer>{

    public DefaultGraph(){
        super();
    }

    public DefaultGraph(Graph<Integer> original){
        super(original);

    }

    @Override
    public Graph copy(Graph original) {
        return new DefaultGraph(original);
    }
}
