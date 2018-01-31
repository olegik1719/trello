package com.github.olegik1719.trello.graph.hdh;

import com.github.olegik1719.trello.graph.Edge;
import com.github.olegik1719.trello.graph.Graph;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public class Checker {

    public static <T> boolean isUndirected(Graph<T> graph){
        for (Edge<T> edge:new HashSet<>(graph.getEdges())){
            if (edge.isOriented()) return false;
        }
        return true;
    }

    public static <T> boolean isAccessibleInUndirect(Graph<T> graph, T from, T to){
        if (!isUndirected(graph)) throw new IllegalArgumentException ("You must check Undirected graph only!");
        if (!graph.isVertex(from)||!graph.isVertex(to)) return false;

        HashSet<T> fromAccessible = new HashSet<>(graph.getNeighbours(from));
        if (fromAccessible.contains(to)) return true;
        HashSet<T> toAccessible = new HashSet<>(graph.getNeighbours(to));

        HashSet<T> diffFromAccessible = fromAccessible;
        HashSet<T> diffToAccessible = toAccessible;

        while (!
                //if size of Set not changed -- we can't add other neighbors-vertices, exit;
                    (diffFromAccessible.isEmpty()
                        ||diffToAccessible.isEmpty()
                        // if FromSet contains To for N steps, ToSet contains From for same N steps,
                        // because unoriented;
                        || (fromAccessible.contains(to)))
                ) {
            HashSet<T> prevFromAccessible = new HashSet<>(fromAccessible);
            HashSet<T> prevToAccessible = new HashSet<>(toAccessible);
            for (T neighbour: new HashSet<>(diffFromAccessible)){
                fromAccessible.addAll(graph.getNeighbours(neighbour));
            }
            for (T neighbour: new HashSet<>(diffToAccessible)){
                toAccessible.addAll(graph.getNeighbours(neighbour));
            }
            diffFromAccessible = new HashSet<>(fromAccessible);
            diffFromAccessible.removeAll(prevFromAccessible);
            diffToAccessible = new HashSet<>(toAccessible);
            diffToAccessible.removeAll(prevToAccessible);
            // if intersection of fromSet and toSet isn't empty
            if (intersectionNotEmpty(fromAccessible,toAccessible)) return true;
        }
        return fromAccessible.contains(to);
    }

    private static <T> boolean intersectionNotEmpty(Collection<T> a, Collection<T> b){
        Objects.requireNonNull(a);
        Objects.requireNonNull(b);

        if (a.size() >= b.size()) {
            for (T e : b)
                if (a.contains(e)) return true;
        } else {
            for (T e : a)
                if (b.contains(e)) return true;
        }
        return false;

    }

}
