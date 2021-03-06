package com.github.olegik1719.trello.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class UndirectedUnweightedGraph implements Graph<Integer>{
    private HashMap<Integer, HashSet<Integer>> vertices;
    public UndirectedUnweightedGraph(){
        vertices = new HashMap<>();
    }

    @Override
    public UndirectedUnweightedGraph addVertex(Integer vertex){
        vertices.computeIfAbsent(vertex,k -> new HashSet<>());
        return this;
    }

    public UndirectedUnweightedGraph addEdge(Integer begin, Integer end){
        vertices.computeIfAbsent(begin, k->new HashSet<>()).add(end);
        vertices.computeIfAbsent(end, k->new HashSet<>()).add(begin);
        return this;
    }

    public boolean containsVertex(Integer vertex){
        return vertices.containsKey(vertex);
    }

    public boolean containsEdge(Integer begin, Integer end){
        return containsVertex(begin) && containsVertex(end) && vertices.get(begin).contains(end);
    }

    public int countVertices(){
        return vertices.size();
    }

    public int countEdges(){
        //return vertices.keySet().stream().mapToInt(integer -> vertices.get(integer).size()).sum() / 2;
        int sum = 0;
        for(Integer vertex: vertices.keySet()){
            sum+=vertices.get(vertex).size();
        }
        return  sum / 2;
    }

    public List<Integer> vertices(){
        return new ArrayList<>(vertices.keySet());
    }
}
