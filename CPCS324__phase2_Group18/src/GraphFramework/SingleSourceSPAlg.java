package GraphFramework;

public class SingleSourceSPAlg {

    // Declare Variables
    Graph graph;
    Vertex source;
    boolean[] visitedVertex;
    int[] distance;
    String[] thePath;

    // ---------------------------------------------------------------------
    
    // Constructor
    public void computeDijkstraAlg(Graph graph, Vertex source) {
        this.graph = graph;
        int srclabel = Integer.parseInt(source.getLabel());

        // Define:
        // distance: least costly distance from parent to verticies.
        // path: frm parent to vertex.
        distance = new int[graph.verticesNo];
        thePath = new String[graph.verticesNo];
        
        for (int i = 0; i < graph.verticesNo; i++) {
            graph.vertices.get(i).setIsVisited(false);// Dijsktra algorithm must first intialize all vertices as NOT visited
            distance[i] = Integer.MAX_VALUE; // And initialize all verticies' distance as INFINITE

        }
        distance[srclabel] = 0;        // However, only distance for parent vertex is 0
        Vertex src = graph.vertices.get(srclabel);
        thePath[srclabel] = src.displayInfo();
   
        for (int i = 0; i < graph.verticesNo - 1; i++) {
            int u = minDistance(distance); // Use method to get minimum distance for any adjacent vertex that has NOT been visited
            graph.vertices.get(u).setIsVisited(true);  // Then change status as VISITED

            for (Edge edge : graph.vertices.get(u).getAdjList()) {// Check adjacent vertices
                edge.setParent(src);
            
                int lab =Integer.parseInt(edge.getDestination().getLabel());

                // Vertex must be NOT visited and is not source
                if (graph.vertices.get(lab).getIsVisited() != true && edge.getWeight() != Integer.MAX_VALUE
                        && edge.getWeight() != 0) {
                    
                    // Find Total cost --------------------------------------------------
                    int totalDistance = distance[u] + edge.getWeight();
                    // Cost is less
                    if (totalDistance < distance[lab]) {
                        // Then take this less costly distance
                        distance[lab] = totalDistance; 

                         if(thePath[u]!=null){ // print format
                            thePath[lab] = thePath[u] + " – " + edge.getDestination().displayInfo();}
                        else
                             thePath[lab] = edge.getParent().displayInfo() + " – " + edge.getDestination().displayInfo();
                    }
                }
            }
        }
        
        // Implement a limit for Dijstra
        if (graph.verticesNo < 1000) {
            printResult(source);
        }
    }
    
    // ---------------------------------------------------------------------
    
    // Methods
    public int minDistance(int[] smallestDistance) {
        int u = 0;
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < graph.verticesNo; i++) {
            // Vertex must be NOT visited and has least cost
            if (graph.vertices.get(i).getIsVisited() != true && smallestDistance[i] < minDistance) {
                // Take least distance
                minDistance = smallestDistance[i];
                u = i; // index
            }
        }
        // Return index
        return u;
    }
    
    // ---------------------------------------------------------------------

    // Print
    public void printResult(Vertex source) {
        System.out.println("\n-----------------------------------------");
        System.out.println("\nThe starting point location is " + (char) (Integer.parseInt(source.getLabel()) + 'A'));
        System.out.println("\nThe routes from location " + (char) (Integer.parseInt(source.getLabel()) + 'A') + " to the rest of the locations are:");

        for (int i = 1; i < graph.verticesNo; i++) {
            // Verticies are not adjacent
            if (distance[i] >= Integer.MIN_VALUE && distance[i] < 0 || distance[i] <= Integer.MAX_VALUE && distance[i] > 59990) {
                System.out.println("\n" + thePath[i] + " route length: no path"); //no path between source and target vertex
            } else {
                System.out.println("\n" + thePath[i] + " route length: " + distance[i]); // print path and weight
            }
        }
    }
}
