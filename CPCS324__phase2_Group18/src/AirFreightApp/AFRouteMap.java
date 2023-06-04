package AirFreightApp;

import GraphFramework.*;
import java.io.File;
import java.io.FileNotFoundException;


/*
 *  @authors Kawka
 */
public class AFRouteMap extends Graph {
 

// Default constructor
 public AFRouteMap() {

    }
 
 //Constructor with specific parameter:       

   public AFRouteMap(int verticesNo, int edgesNo, boolean isDirect) {
        super(verticesNo, edgesNo, isDirect);
    }

   public AFRouteMap(File graphfile) throws FileNotFoundException {

        super(graphfile);
    }

  
 
@Override
    public Vertex createVertex(String label) {
      Vertex ver= new Location(label);//make obj with parametar
       return ver; 
    }

     @Override
    public Edge createEdge(Vertex source, Vertex destination, int weight) {
      Edge edg= new Route(source, destination, weight);//make obj with parametar
         return edg; 
    }
    
    
    public void displayInfo(){
    displayInfo();
    }
}
