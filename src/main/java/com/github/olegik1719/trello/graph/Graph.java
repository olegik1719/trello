package com.github.olegik1719.trello.graph;

import com.sun.tools.internal.xjc.model.CElementPropertyInfo;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface Graph<T> {
    /**
     * Adding Verticle to Graph
     * @param verticle
     * @return true if it is added
     *         false if it isn't added
     */
    boolean add(T verticle);

    /**
     * Adding Edge
     * @param edge
     * @return false is this edge was in graph yet
     */
    boolean addEdge(Edge<T> edge);
    boolean isEdge(T begin, T end);
    Collection<T> getVericles();
    int getVerticlesCount();
    int getEdgesCount();
    Collection<T> getNeighbours(T verticle);
    Collection<Edge<T>> getEdges();
    Collection<T> getVerticles();
}
