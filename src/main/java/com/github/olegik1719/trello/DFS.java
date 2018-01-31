package com.github.olegik1719.trello;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFS {
    private Map<String, Set<String>> graph;
    private Map<String, Boolean> notUsedDFS;

    public DFS(){
        graph = new HashMap<>();
    }

    public DFS addVertex(String vertex){
        if (graph.get(vertex) == null){
            graph.put(vertex, new HashSet<>());
        }
        return this;
    }

    public DFS addEdge(String begin,String end){
        addVertex(begin);
        addVertex(end);
        graph.get(begin).add(end);
        graph.get(end).add(begin);
        return this;
    }

    public boolean isAccessible(String begin, String end){
        if (graph.get(begin) == null || graph.get(end) == null) return false;
        notUsedDFS = new HashMap<>();
        for (String vertex: graph.keySet()){
            notUsedDFS.put(vertex,true);
        }
        return recoursiveAlgo(begin,end);
    }

    private boolean recoursiveAlgo(String begin, String end){
        notUsedDFS.put(begin,false);
        for (String vertex: graph.get(begin)){
            if(notUsedDFS.get(vertex)){
                if ( begin == end ||recoursiveAlgo(vertex,end))return true;
            }
        }
        return begin.equals(end);
    }
}
