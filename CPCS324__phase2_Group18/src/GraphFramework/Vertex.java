package GraphFramework;

import java.util.*;

/*
 *  @authors Kawka
 */
public class Vertex {

    String label;
    Boolean isVisited;
    LinkedList<Edge> adjList;//the Linke dList

    // Default constructor
    public Vertex() {
        adjList = new LinkedList<>();
        isVisited = false;

    }

//Constructor with specific parameter: label      
    public Vertex(String label) {
        this.label = label;
        this.isVisited = false;
        adjList = new LinkedList<>(); //to make linkedlist to evrey vertex 
    }
    
    // ---------------------------------------------------------------------
//-----------------------the get and set
//for label
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

//for isVisited     
    public Boolean getIsVisited() {
        return isVisited;
    }

    public void setIsVisited(Boolean isVisited) {
        this.isVisited = isVisited;
    }

//for adjList
    public List<Edge> getAdjList() {
        return adjList;
    }

    public void setAdjList(LinkedList<Edge> adjList) {
        this.adjList = adjList;
    }

    // ---------------------------------------------------------------------
    
    //cuse in the main we need to print the label
    public String displayInfo() {
        return null;
    }

}
