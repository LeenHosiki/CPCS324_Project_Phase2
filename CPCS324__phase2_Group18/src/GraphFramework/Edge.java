package GraphFramework;


/*
 *  @authors Kawka
 */
public class Edge implements Comparable<Edge> {
//parametars
    private Vertex source;
    private Vertex destination;//destination
    private Vertex parent;
    private int weight;

  
        // Default constructor
    public Edge() {

    }

//Constructor with specific parameter: source, destination, weight, parent

    public Edge(Vertex source, Vertex destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    
    
//-----------------------the get and set

//for source    
    public Vertex getSource() {
        return source;
    }

    public void setSource(Vertex source) {
        this.source = source;
    }
    
//for des
    
    public Vertex getDestination() {
        return destination;
    }

    public void setDestination(Vertex destination) {
        this.destination = destination;
    }

  
//for Weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
//for parent
    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    
    
 // the compare btween the weights  
    @Override
    public int compareTo(Edge edgeObj) {
        if (this.weight == edgeObj.weight) {
            return 0;
        } else if (this.weight > edgeObj.weight) {
            return 1;
        } else {
            return -1;
        }
    }

//for the output 
    public void displayInfo() {
    }

}
