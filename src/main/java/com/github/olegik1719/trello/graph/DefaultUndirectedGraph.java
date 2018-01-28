package com.github.olegik1719.trello.graph;

public class DefaultUndirectedGraph extends AbstractGraph<Integer>{

    public DefaultUndirectedGraph(){
        super();
    }

    @Override
    public boolean addEdge(Edge<Integer> edge, boolean force) {
        boolean result = super.addEdge(edge,force);
        super.addEdge(edge.getOpposite());
        return result;
    }

    public DefaultUndirectedGraph(Graph<Integer> original){
        super(original);

    }

    @Override
    public Graph copy(Graph original) {
        return new DefaultUndirectedGraph(original);
    }
}
