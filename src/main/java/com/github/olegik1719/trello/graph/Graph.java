package com.github.olegik1719.trello.graph;

import java.util.Collection;

public interface Graph<T> {
    /**
     * Adding Vertices to Graph
     * @param vertex - new vertex for graph
     * @return true on success, false otherwise
     */
    boolean addVertex(T vertex);

    default boolean addVertices(T[] vertices){
        boolean result = true;
        for (T vertex: vertices) result &= addVertex(vertex);
        return result;
    }

    default boolean addVertices(Collection<T> vertices){
        return addVertices((T[])vertices.toArray());
    }

    /**
     * Check is this Vertex in Graph
     * @param vertex -- vertex for check
     * @return true if Graph include this vertex
     */
    boolean isVertex(T vertex);

    Collection<T> getVertices();
    Collection<T> getNeighbours(T vertex);

    /**
     * Adding Edge
     * @param edge -- new Edge for graph
     * @return false is this edge was in graph yet, or one of vertices doesn't exist
     */
    default boolean addEdge(Edge<T> edge){
        return addEdge(edge, false);
    }

    /**
     * Adding Edge
     * @param edge -- new Edge for graph
     * @param force -- add Vertices of edge to Graph
     * @return false if this edge exists in graph.
     */
    boolean addEdge(Edge<T> edge, boolean force);

    Collection<Edge<T>> getEdges();


    boolean isEdge(T begin, T end);
    int getVerticesCount();
    int getEdgesCount();

    /**
     * Remove edge from graph.
     * @param edge -- What we want remove
     * @return true on success, false otherwise
     */
    boolean removeEdge(Edge<T> edge);

    /**
     * Remove random edge from begin to end
     * @param begin -- from where
     * @param end -- to where
     * @return true on success, false otherwise
     */
    default boolean removeEdge(T begin, T end){
        return removeEdge(begin,end, false);
    }

    /**
     * Remove random edge from begin to end
     * @param begin -- from where
     * @param end -- to where
     * @param removeAll -- true if you want remove all
     * @return true on success, false otherwise
     */

    boolean removeEdge(T begin, T end, boolean removeAll);

    default boolean removeVertex(T vertex){
        return removeVertex(vertex, false);
    }
    boolean removeVertex(T vertex, boolean force);

    default boolean removeAllVertex(Collection<T> vertices){
        boolean result = true;
        for (T vertex: vertices) {
            result &= removeVertex(vertex);
        }
        return result;
    }

    default boolean contains(T vertex){
        return isVertex(vertex);
    }

    default boolean contains(Edge<T> edge){
        return isEdge(edge.getBegin(),edge.getEnd());
    }

    Graph<T> copy(Graph<T> original);
}
