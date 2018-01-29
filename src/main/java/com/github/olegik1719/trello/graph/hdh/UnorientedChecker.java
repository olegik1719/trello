package com.github.olegik1719.trello.graph.hdh;

import com.github.olegik1719.trello.graph.DefaultEdge;
import com.github.olegik1719.trello.graph.DefaultGraph;
import com.github.olegik1719.trello.graph.Edge;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UnorientedChecker extends DefaultGraph<String> {
    private Map<String,Collection<String>> vertices;
    private Collection<Edge<String>> edges;

    private class StringUnorientedWeightEdge extends DefaultEdge<String>{
        StringUnorientedWeightEdge(String begin, String end, Number price) {
            super(begin, end, false, price);
        }

        StringUnorientedWeightEdge(String begin, String end) {
            super(begin, end,false);
        }
    }

    UnorientedChecker(String[][] table){
        vertices = new HashMap<>();
        edges = new HashSet<>();
        for (String[] aTable : table) {
            addEdges(aTable);
        }
    }

    @Override
    public boolean addVertex(String vertex) {
        return (!isVertex(vertex)&&vertices.put(vertex,new HashSet<>()) == null);
    }

    @Override
    public boolean addEdge(Edge<String> edge, boolean force) {
        return addEdge(edge.getBegin(),edge.getEnd(),edge.getPrice(), force);
    }

    private boolean addEdge(String begin, String end, Number price, boolean force){
        StringUnorientedWeightEdge edge = new StringUnorientedWeightEdge(begin,end,price);
        if (force){
            addVertex(begin);
            addVertex(end);
        } else if(!(isVertex(begin)&&isVertex(end))) return false;
            vertices.get(begin).add(end);
            vertices.get(end).add(begin);
        return edges.add(edge);
    }

    private void addEdges(String[] table){
        if (table.length < 1) throw new RuntimeException();
        else addVertex(table[0]);
        for (int i = 1; i < table.length; i++) {
            addEdge(new StringUnorientedWeightEdge(table[0],table[i]),true);
        }
        //return this;
    }

    @Override
    public boolean isVertex(String vertex) {
        return vertices.keySet().contains(vertex);
    }

    public boolean isAccessible(String from, String to){
        if (!isVertex(from)||!isVertex(to)) return false;
        if (vertices.get(from).contains(to)) return true;
        HashSet<String> fromAccessible = new HashSet<>(vertices.get(from));
        HashSet<String> toAccessible = new HashSet<>(vertices.get(to));
        int prevFromAccessible = 0;
        int prevToAccessible = 0;
        int currentFromAccessible = fromAccessible.size();
        int currentToAccessible = toAccessible.size();
        System.out.printf("FromSet:%n%s%nToSet:%n%s%n",fromAccessible,toAccessible);
        while (!
                //if size of Set not changed -- we can't add other neighbors-vertices, exit;
                ((prevFromAccessible == currentFromAccessible)
                ||(prevToAccessible == currentToAccessible)
                // if FromSet contains To for N steps, ToSet contains From for same N steps,
                // because unoriented;
                || (fromAccessible.contains(to)))
                ) {

            for (String neighbour: new HashSet<>(fromAccessible)){
                fromAccessible.addAll(vertices.get(neighbour));
            }
            for (String neighbour: new HashSet<>(toAccessible)){
                toAccessible.addAll(vertices.get(neighbour));
            }
            prevFromAccessible = currentFromAccessible;
            prevToAccessible = currentToAccessible;
            currentFromAccessible = fromAccessible.size();
            currentToAccessible = toAccessible.size();
            // if intersection of fromSet and toSet isn't empty
            if (fromAccessible.removeAll(toAccessible)) return true;
        }
        return fromAccessible.contains(to);
    }

    @Override
    public int getVerticesCount() {
        return vertices.size();
    }

    @Override
    public Collection<String> getVertices() {
        return new HashSet<>(vertices.keySet());
    }

    @Override
    public Collection<Edge<String>> getEdges() {
        return new HashSet<>(edges);
    }

    @Override
    public boolean isEdge(String begin, String end) {
        return vertices.get(begin).contains(end);
    }

    @Override
    public int getEdgesCount() {
        return edges.size();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(String vertex: vertices.keySet()){
            stringBuilder.append(String.format("%s: %s%n",vertex,vertices.get(vertex)));
        }
        return stringBuilder.toString();
        //String.format("Vertices:%n%s: %s%nEdges:%n%s: %s%n",vertices.size(), getVertices(),edges.size(),getEdges());
    }
}
