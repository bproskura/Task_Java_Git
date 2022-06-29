package task2;

import java.util.*;

/**
 * Reader is used for read the input data from keyboard.
 */

public class Reader {
    private Scanner scanner = new Scanner(System.in);
    private List<Paths> paths;
    private List<Edge> edges;
    private Map<String, String> runPaths;
    private Graph graph;

    public Map<String, String> getRunPaths() {
        return runPaths;
    }

    public Graph getGraph() {
        return graph;
    }

    public Reader() {

        paths = new ArrayList<>();
        edges = new ArrayList<>();
        runPaths = new LinkedHashMap<>();

        try {
            System.out.println("Enter number of tests not more 10");
            int numberOfTests = scanner.nextInt();
            if (numberOfTests < 10) {
                for (int i = 0; i < numberOfTests; i++) {
                    System.out.println("Enter number of cities not more 10000");
                    int numberOfCities = scanner.nextInt();
                    if (numberOfCities <= 10000) {
                        for (int j = 0; j < numberOfCities; j++) {
                            // read the name of city and the numbers of neighbors of this city
                            System.out.println("Enter city name");
                            String cityName = scanner.next();
                            System.out.println("Enter number of city - neighbors");
                            int numberOfNeighbors = scanner.nextInt();
                            int cityNumber = j + 1;
                            for (int k = 0; k < numberOfNeighbors; k++) {
                                System.out.println("Enter id city");
                                int idCity = scanner.nextInt();
                                System.out.println("Enter cost");
                                int cost = scanner.nextInt();
                                paths.add(new Paths(cityNumber, cityName, idCity, cost));
                            }
                        }
                        createEdge(paths);
                    } else {
                        throw new OverflowException("Exceeding the limit of number of cities");
                    }
                }

                System.out.println("Enter number of paths to find not more 100");
                graph = new Graph(edges);
                String sourceCity;
                String destinationCity;

                int numberOfPaths = scanner.nextInt();
                if (numberOfPaths <= 100) {
                    for (int i = 0; i < numberOfPaths; i++) {
                        System.out.println("Enter source city");
                        sourceCity = scanner.next();
                        System.out.println("Enter destination city");
                        destinationCity = scanner.next();
                        runPaths.put(sourceCity, destinationCity);
                    }
                } else {
                    throw new OverflowException("Exceeding the limit of number of paths");
                }
            } else {
                throw new OverflowException("Exceeding the limit of number of tests");
            }
			
        } catch (NumberFormatException e) {
            System.out.println(e);
        } catch (OverflowException e) {
            throw new RuntimeException(e);
        }

    }


    private void createEdge(List<Paths> paths) {
        for (Paths path : paths) {
            String sourceCity = path.getCity();
            int id = path.getIdNeighbour();
            String destinationCity = null;
            for (Paths auxiliaryPath : paths) {
                if (auxiliaryPath.getIdCity() == id) {
                    destinationCity = auxiliaryPath.getCity();
                }
            }
            edges.add(new Edge(sourceCity, destinationCity, path.getCost()));
        }
    }
}
