package com.github.olegik1719.trello.graph;

import java.util.Collection;

public interface Graph<T> {
    /**
     * Adding Verticle to Graph
     * @param vertex
     * @return true if it is added
     *         false if it isn't added
     */
    boolean add(T vertex);

    /**
     * Adding Edge
     * @param edge
     * @return false is this edge was in graph yet
     */
    boolean addEdge(Edge<T> edge);
    boolean isEdge(T begin, T end);
    int getVerticesCount();
    int getEdgesCount();
    Collection<T> getNeighbours(T verticle);
    Collection<Edge<T>> getEdges();
    Collection<T> getVertices();
}
