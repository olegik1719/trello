package com.github.olegik1719.trello.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
    private Map<String, Map<String,Set<Number>>> graph;
    private Map<String, Boolean> notUsedDFS;

    public DFS(){
        graph = new HashMap<>();
    }

    public DFS addVertex(String vertex){
        graph.computeIfAbsent(vertex, k -> new HashMap<>());
        return this;
    }

    public DFS addEdge(String begin,String end,Number price){
        addVertex(begin);
        addVertex(end);
        graph.get(begin).computeIfAbsent(end,k->new HashSet<>()).add(price);
        graph.get(end).computeIfAbsent(begin, k->new HashSet<>()).add(price);
        return this;
    }

    public boolean isAccessible(String begin, String end){
        if (graph.get(begin) == null || graph.get(end) == null) return false;
        notUsedDFS = new HashMap<>();
        for (String vertex: graph.keySet())
            notUsedDFS.put(vertex,true);
        return recoursiveAlgo(begin,end);
    }

    private boolean recoursiveAlgo(String begin, String end){
        notUsedDFS.put(begin,false);
        for (String vertex: graph.get(begin).keySet())
            if(notUsedDFS.get(vertex))
                if ( begin == end || recoursiveAlgo(vertex,end))
                    return true;
        return begin.equals(end);
    }
}
