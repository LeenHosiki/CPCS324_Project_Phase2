package AirFreightApp;

import GraphFramework.*;

/*
 *  @authors Kawka
 */
public class Route extends Edge {

    int theRoute;
    
    public Route(Vertex source, Vertex target, int weight) {
        super(source, target, weight);
        theRoute = weight;
    }

    // Methods
    @Override
    public void displayInfo() {
        System.out.println("--- route length: " + theRoute);
    } 

} 
