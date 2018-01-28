package com.github.olegik1719.trello.graph;

import java.util.Collection;

public interface Graph<T> {
    /**
     * Adding Vertices to Graph
     * @param vertex - new vertex for graph
     * @return true if it is added
     *         false if it isn't added
     */
    boolean addVertex(T vertex);

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

    Graph<T> copy(Graph<T> original);
}
