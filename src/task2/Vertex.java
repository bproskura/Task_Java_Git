package task2;

import java.util.HashMap;
import java.util.Map;

/**
 * One vertex of the graph, complete with mappings to neighbouring vertices
 */
public class Vertex implements Comparable<Vertex> {
    public final String name;
    public int maxCost = 200001;
    public Vertex previous = null;
    public final Map<Vertex, Integer> neighbours = new HashMap<>();

    public Vertex(String name) {
        this.name = name;
    }

    public void printCost() {
        if (!(this == this.previous)) {
            System.out.printf(this.maxCost + "\n");
        }
    }

    public int compareTo(Vertex other) {
        return Integer.compare(maxCost, other.maxCost);
    }
}
