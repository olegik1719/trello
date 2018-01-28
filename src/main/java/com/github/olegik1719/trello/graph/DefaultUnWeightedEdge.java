package com.github.olegik1719.trello.graph;

public class DefaultUnWeightedEdge extends AbstractEdge<Integer> {

    public DefaultUnWeightedEdge(Integer begin, Integer end){
        super(begin, end);
    }

    @Override
    public Edge<Integer> getOpposite() {
        return new DefaultUnWeightedEdge(end, begin);
    }
}
