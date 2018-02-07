package com.github.olegik1719.trello.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface Dijkstra<T> extends Graph<T> {

    default Map<T, Integer> getDistanceMap(T begin){
        Map<T, Integer> distances = new HashMap<>();
        vertices().forEach(vertex -> distances.computeIfAbsent(vertex,s -> Integer.MAX_VALUE));
        if (!containsVertex(begin)) {
            return distances;
        }
        distances.put(begin, 0);
        Map<T, Boolean> notUsed = new HashMap<>();
        vertices().forEach(vertex -> notUsed.computeIfAbsent(vertex,s -> true));
        List<T> inWork = new LinkedList<>();
        inWork.add(begin);
        while (!inWork.isEmpty()){
            T current = inWork.remove(0);
            Integer currentDist = distances.get(current);
            if (notUsed.get(current)) {
                getNeighbours(current).forEach(neighbour -> {
                    if (notUsed.get(neighbour)) {
                         if (currentDist + 1 <distances.get(neighbour))
                             distances.put(neighbour, currentDist + 1);
                        inWork.add(neighbour);
                    }
                });
            }
            notUsed.put(current, false);
        }
        return distances;
    }

    default Integer getDistance(T begin, T end){
        if (!containsVertex(begin)&&!containsVertex(end)) {
            return Integer.MAX_VALUE;
        }
        Map<T, Integer> distances = new HashMap<>();
        vertices().forEach(vertex -> distances.computeIfAbsent(vertex,s -> Integer.MAX_VALUE));

        distances.put(begin, 0);
        Map<T, Boolean> notUsed = new HashMap<>();
        vertices().forEach(vertex -> notUsed.computeIfAbsent(vertex,s -> true));
        List<T> inWork = new LinkedList<>();
        inWork.add(begin);
        while (!inWork.isEmpty()){
            T current = inWork.remove(0);
            Integer currentDist = distances.get(current);
            if (current.equals(end)) return distances.get(end);
            if (notUsed.get(current)) {
                getNeighbours(current).forEach(neighbour -> {
                    if (notUsed.get(neighbour)) {
                        if (currentDist + 1 <distances.get(neighbour))
                            distances.put(neighbour, currentDist + 1);
                        inWork.add(neighbour);
                    }
                });
            }
            notUsed.put(current, false);
        }
        return Integer.MAX_VALUE;
    }
}
