package GraphFramework;

/*
 *  @authors Kawka
 */
public class DBAIISourceSPAlg {

            // Declare variables
    SingleSourceSPAlg SPAlgObj;
        Graph graphObj;


       // Constructor
 public DBAIISourceSPAlg(Graph graphobj) {
                graphObj = graphobj;
                computeDijkstraBasedSPAlg();        // Call method


    }
    // Method

    public void computeDijkstraBasedSPAlg() {

        for (int i = 0; i < graphObj.verticesNo; i++) { 
            SPAlgObj = new SingleSourceSPAlg();
            SPAlgObj.computeDijkstraAlg(graphObj, graphObj.vertices.get(i)); // Apply Dijkstra algorithm

        }
    }

}

 