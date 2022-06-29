package task2;
/**
 * Here is the launch of the program
 */

public class Main {

    public static void main(String[] args) {

        Reader reader = new Reader();

        for (String key : reader.getRunPaths().keySet()) {
            reader.getGraph().shortestPath(key);
            reader.getGraph().printCost(reader.getRunPaths().get(key));
        }
    }
}
