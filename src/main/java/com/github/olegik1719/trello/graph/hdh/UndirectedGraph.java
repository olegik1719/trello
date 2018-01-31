package com.github.olegik1719.trello.graph.hdh;

import com.github.olegik1719.trello.graph.Edge;
import com.github.olegik1719.trello.graph.Graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UndirectedGraph implements Graph<String> {
    private Map<String,Collection<String>> vertices;
    private Collection<Edge<String>> edges;



    private class StringUndirectedWeightEdge implements Edge<String> {
        private static final int DEFAULT_PRICE = 1;
        private final String begin;
        private final String end;
        private final Number price;

        @Override
        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            result = result * PRIME + begin.hashCode() + end.hashCode();
            final Object $price = this.getPrice();
            result = result * PRIME + (price == null ? 43 : price.hashCode());
            return result;
        }

        public  boolean isEquals(Object object) {
            if (object == this) return true;
            if (!(object instanceof StringUndirectedWeightEdge)) return false;
            final StringUndirectedWeightEdge other = (StringUndirectedWeightEdge) object;
            boolean result = ((this.begin.equals(other.begin)) && (this.end.equals(other.end)))
                    || ((this.begin.equals(other.end)) && (this.end.equals(other.begin)));

            return result && (this.price == null ? other.price == null : this.price.equals(other.price));
        }


        StringUndirectedWeightEdge(String begin, String end, Number price) {
            this.begin = begin;
            this.end = end;
            this.price = price;
        }

        StringUndirectedWeightEdge(String begin, String end) {
            this (begin, end,DEFAULT_PRICE);
        }

        @Override
        public String getBegin() {
            return begin;
        }

        @Override
        public String getEnd() {
            return end;
        }

        @Override
        public Number getPrice() {
            return price;
        }

        @Override
        public boolean isOriented() {
            return false;
        }
    }
    private UndirectedGraph(){
        vertices = new HashMap<>();
        edges = new HashSet<>();
    }
    UndirectedGraph(String[][] table){
        this();
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
        StringUndirectedWeightEdge edge = new StringUndirectedWeightEdge(begin,end,price);
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
            addEdge(new StringUndirectedWeightEdge(table[0],table[i]),true);
        }
        //return this;
    }

    @Override
    public boolean isVertex(String vertex) {
        return vertices.keySet().contains(vertex);
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
    public boolean removeEdge(Edge<String> edge) {
        String begin = edge.getBegin();
        String end = edge.getEnd();
        if (!isVertex(begin)||!isVertex(end)||!isEdge(begin,end)) return false;
        vertices.get(begin).remove(end);
        vertices.get(end).remove(begin);
        edges.remove(edge);
        return true;
    }


    @Override
    public boolean removeEdge(String begin, String end, boolean removeAll) {
        return removeEdge(new StringUndirectedWeightEdge(begin,end));
    }

    @Override
    public boolean removeVertex(String vertex, boolean force) {
        if (isVertex(vertex)){
            if (force){
                for (Edge edge:edges)
                    if (edge.getBegin() == vertex|| edge.getEnd() == vertex)
                        removeEdge(edge);
            }else {
                for (Edge edge:edges)
                    if (edge.getBegin() == vertex|| edge.getEnd() == vertex)
                        return false;
            }
            vertices.remove(vertex);
            return true;
        }
        return false;
    }

    @Override
    public Graph<String> copy() {
        UndirectedGraph duplicate = new UndirectedGraph();
        for (String vertex: vertices.keySet()){
            duplicate.addVertex(vertex);
        }
        for (Edge edge: edges){
            duplicate.addEdge(edge);
        }
        return duplicate;
    }

    @Override
    public Collection<String> getNeighbours(String vertex) {
        return new HashSet<>(vertices.get(vertex));
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
