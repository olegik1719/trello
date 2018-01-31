package com.github.olegik1719.trello.graph.hdh;

import com.github.olegik1719.trello.graph.Edge;
import com.github.olegik1719.trello.graph.Graph;

import java.util.HashSet;

public class Checker {

    public static <T> boolean isUndirected(Graph<T> graph){
        for (Edge<T> edge:new HashSet<>(graph.getEdges())){
            if (edge.isOriented()) return false;
        }
        return true;
    }

    public static <T> boolean isAccessibleInUndirect(Graph<T> graph, T from, T to){
        if (!isUndirected(graph)) throw new IllegalArgumentException ("You must check Undirected graph!");

        if (!graph.isVertex(from)||!graph.isVertex(to)) return false;
        HashSet<T> fromAccessible = new HashSet<>(graph.getNeighbours(from));
        if (fromAccessible.contains(to)) return true;
        HashSet<T> toAccessible = new HashSet<>(graph.getNeighbours(to));
        int prevFromAccessible = 0;
        int prevToAccessible = 0;
        int currentFromAccessible = fromAccessible.size();
        int currentToAccessible = toAccessible.size();
        //System.out.printf("FromSet:%n%s%nToSet:%n%s%n",fromAccessible,toAccessible);
        while (!
                //if size of Set not changed -- we can't add other neighbors-vertices, exit;
                ((prevFromAccessible == currentFromAccessible)
                        ||(prevToAccessible == currentToAccessible)
                        // if FromSet contains To for N steps, ToSet contains From for same N steps,
                        // because unoriented;
                        || (fromAccessible.contains(to)))
                ) {

            for (T neighbour: new HashSet<>(fromAccessible)){
                fromAccessible.addAll(graph.getNeighbours(neighbour));
            }
            for (T neighbour: new HashSet<>(toAccessible)){
                toAccessible.addAll(graph.getNeighbours(neighbour));
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
}
