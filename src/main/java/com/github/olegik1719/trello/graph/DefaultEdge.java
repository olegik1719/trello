package com.github.olegik1719.trello.graph;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DefaultEdge implements Edge<Integer>{
    private final Vertex<Integer> begin;
    private final Vertex<Integer> end;

    protected DefaultEdge(Vertex<Integer> first, Vertex<Integer> second){
        if (first.getValue().compareTo(second.getValue())>=0){
            begin = second;
            end = first;
        }else {
            begin = first;
            end = second;
        }
    }

    @Override
    public Vertex<Integer> getBegin() {
        return begin;
    }

    @Override
    public Vertex<Integer> getEnd(){
        return end;
    }
}

    