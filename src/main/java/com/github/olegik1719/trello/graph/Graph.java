package com.github.olegik1719.trello.graph;

import java.util.List;

public interface Graph<T> {
    /**
     * Adding Verticle to Graph
     * @param verticle
     * @return true if it is added
     *         false if it isn't added
     */
    boolean add(T verticle);
    boolean addEdge(T begin, T end);
    boolean isEdge(T begin, T end);
    List<T> getVericles();
    int getVerticlesCount();
    int getEdgesCount();
}
