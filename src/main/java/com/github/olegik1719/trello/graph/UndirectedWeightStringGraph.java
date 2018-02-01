package com.github.olegik1719.trello.graph;

import java.util.*;


public class UndirectedWeightStringGraph {
    private Map<String, Map<String,Collection<Number>>> graph;
    private final static int DEFAULT_PRICE = 1;

    public UndirectedWeightStringGraph(){
        graph = new HashMap<>();
    }

    public UndirectedWeightStringGraph addVertex(String vertex){
        graph.computeIfAbsent(vertex, k -> new HashMap<>());
        return this;
    }

    public UndirectedWeightStringGraph addEdge(String begin, String end, Number price){
        addVertex(begin);
        addVertex(end);
        graph.computeIfAbsent(begin,k->new HashMap<>())
                .computeIfAbsent(end,k->new HashSet<>()).add(price);
        graph.computeIfAbsent(end,k->new HashMap<>())
                .computeIfAbsent(begin,k->new HashSet<>()).add(price);
        return this;
    }

    /**
     * Add edges(DEFAULT_PRICE) to graph in batch mode: from vertex to all neighbours
     * @param vertex -- main vertex-target
     * @param neighbours -- list of vertex's neighbors
     * @return this graph
     */
    public UndirectedWeightStringGraph addNeighbours(String vertex, String... neighbours){
        Arrays.asList(neighbours)
                .forEach(integer -> addEdge(vertex,integer, DEFAULT_PRICE));
        return this;
    }

    public boolean isAccessible(String begin, String end){
        return isAccessible(begin,end,false);
    }

    public boolean isAccessible(String begin, String end,boolean recursive){
        if (graph.get(begin) == null || graph.get(end) == null) return false;
        if (begin.equals(end)) return true;
        Map<String,Boolean> notUsedDFS = new HashMap<>();
        graph.keySet().forEach(s -> notUsedDFS.put(s,true));
        return recursive?
                recursiveDFS(begin,end,notUsedDFS)
                : loopDFS(begin,end,notUsedDFS);
    }

    private boolean recursiveDFS(String begin, String end, Map<String,Boolean> notUsed){
        notUsed.put(begin,false);
        for (String vertex: graph.get(begin).keySet())
            if(notUsed.get(vertex))
                if ( begin.equals(end) || recursiveDFS(vertex,end, notUsed))
                    return true;
        return begin.equals(end);
    }

    private boolean loopDFS(String begin, String end, Map<String,Boolean> notUsed){
        Stack<String> forCheck = new Stack<>();
        String current = begin;
        forCheck.push(current);
        while (!(forCheck.empty())){
            current = forCheck.pop();
            if (current.equals(end)) return true;
            if (notUsed.put(current, false))
                graph.get(current).keySet().forEach(s -> {if(notUsed.get(s))forCheck.push(s);});
        }
        return current.equals(end);
    }
}
