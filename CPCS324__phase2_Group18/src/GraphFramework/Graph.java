package GraphFramework;

import java.io.*;
import java.util.*;

/*
 *  @authors Kawka
 */
public abstract class Graph {

    public int verticesNo; //number of vertices
    public int edgeNo;//number of edge
    boolean isDigraph = false;// dose the graph dierected or not
    ArrayList<Vertex> vertices = new ArrayList<>();//array list for vertices

// Default constructor
    public Graph() {
    }

    public Graph(int verticesNo, int edgeNo) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        // makeGraph(verticesNo,edgeNo);
    }

    //Constructor with specific parameter: graphFile to read the file
    public Graph(File graphFile) throws FileNotFoundException {
        readGraphFromFile(graphFile);
    }

//Constructor with specific parameter:verticesNo,edgeNo,  
    public Graph(int verticesNo, int edgeNo, boolean isDigraph) {
        this.verticesNo = verticesNo;
        this.edgeNo = edgeNo;
        this.isDigraph = isDigraph;
        makeGraph(verticesNo, edgeNo);
    }
    
    
        /**
     * Adds a new edge to the graph between the two specified vertices with the
     * given weight. If either vertex is not already in the graph, it is added.
     * Returns the newly created edge.
     */
    public Edge addEdge(Vertex srcVertex, Vertex destVertex, int weight) {
        boolean FoundSource = false;
        boolean FoundDestination = false;

        for (int i = 0; i < vertices.size(); i++) { //go thro all vertices
            if (vertices.get(i).getLabel().equals(srcVertex.getLabel())) { //if source found in vertices
                srcVertex = vertices.get(i);
                FoundSource = true;
            } //assign v with source
            else if (vertices.get(i).getLabel().equals(destVertex.getLabel())) { //if u found in vertices
                destVertex = vertices.get(i);
                FoundDestination = true;

            }
        } 

         if (!FoundSource) {
            vertices.add(srcVertex);
        }
         if (!FoundDestination) {
            vertices.add(destVertex);
        }

       

        Vertex sour = vertices.get(Integer.parseInt(srcVertex.getLabel()));
        Vertex des = vertices.get(Integer.parseInt(destVertex.getLabel()));
        int w = weight; //create new edge object between v and u 
        Edge makeEdge = createEdge(sour, des, w);
        sour.getAdjList().add(makeEdge);
        if (!isDigraph) {
            makeEdge = createEdge(des, sour, w);
            vertices.get(vertices.indexOf(destVertex)).getAdjList().add(makeEdge); //add this edge to the adjacency list of the v vertex
 this.edgeNo= this.edgeNo+2;
        }else if(isDigraph)
            this.edgeNo= this.edgeNo+1;

        return makeEdge;
    }
    
    

    public void makeGraph(int verticesNo, int edgeNo) {
        //for loop with size of verticesNo to store every Vertex in the arry list 
        for (int i = 0; i < verticesNo; i++) {
            vertices.add(createVertex(i + ""));
        }
        //for loop with size of verticesNo-1 (becuse tha last 2 vertex connect together in one edge) to conect the every vertices using addEdge
        for (int i = 0; i < verticesNo - 1; i++) {
            int weightRandom = (int) (1 + Math.random() * 40);
            Vertex source = vertices.get(i);
            Vertex des = vertices.get(i + 1);
            addEdge(source, des, weightRandom);

            // the last two Vertex
            if (i == verticesNo - 2) {
                Vertex lastsource = vertices.get(verticesNo - 1);
                Vertex lastdes = vertices.get(0);
                addEdge(lastsource, lastdes, weightRandom);
            }

        }

        int remainingEdge = edgeNo - (verticesNo);
        //for loop to the remaining Edge
        for (int i = 0; i < remainingEdge; i++) {
            //random numbers for the source and destination
            int source = (int) (Math.random() * verticesNo);
            int destination = (int) (Math.random() * verticesNo);

            if (isDigraph && isConnected(destination, source)) { // cuse iteration should not be counted, decrease i               
                continue;
            }

            // need to make sure to avoid having an adjacent vertex that already exists OR  self-edges   
            if (isConnected(source, destination) || destination == source) {
                continue;
            }

            int weightRandom = (int) (1 + Math.random() * 40); //initiate the weight value randomly
            //if soure and target don't have an edge and they are not equal, create new edge
            addEdge(vertices.get(source), vertices.get(destination), weightRandom);

        }
    }

    // method to check if the edge already exists to avoid 
    public boolean isConnected(int source, int destination) {
        for (int i = 0; i < vertices.get(source).getAdjList().size(); i++) {//for all edges of source vertex
            if ((vertices.get(source).getAdjList().get(i).getDestination().getLabel().equals(vertices.get(destination).getLabel()))) {
                // becuse they duplicate return true 
                return true;
            }
        }
        //if there is no edge with this source and detination return false not duplicate
        return false;
    }

    public void readGraphFromFile(File fileName) throws FileNotFoundException {
        Scanner input = new Scanner(fileName); //  Scanner  
        String name_Type_graph = input.nextLine(); // rade the first line that has (digraph 0 OR digraph 1)

        if (name_Type_graph.equalsIgnoreCase("digraph 0")) {
            isDigraph = false; //so it is undirected 
            edgeNo = edgeNo * 2;//iff undirected graph ... cuse it has 2 direction
        } else if (name_Type_graph.equalsIgnoreCase("digraph 1")) {
            isDigraph = true; //so it is directed 
        }

        verticesNo = input.nextInt(); // number of vertice and we inatioat it in the fist of this class      
        edgeNo = input.nextInt();  // number of edge and we inatioat it in the fist of this class

        // raed the vertices and the edge                
        while (input.hasNext()) {
            // int randomId_foLable=(int)(input.next().charAt(0)) -65 ;
            String source = (int) (input.next().charAt(0)) - 65 + ""; //read source label  //65 is A in char 
            String destination = (int) (input.next().charAt(0)) - 65 + ""; // read destination label  
            int w = input.nextInt();//read the weight (cost) of edge between source and destination          
            //create Vertex for source destination to send it to addEdge
            Vertex v = createVertex(source);
            Vertex u = createVertex(destination);
            addEdge(v, u, w); //add edge between source and target vertex with specific weight 

        }
    }

    // Abstract method to create object of Vertex with parametar lable
    public abstract Vertex createVertex(String lable);

    // Abstract method to create object of Edge with parametar v,u,w
    public abstract Edge createEdge(Vertex v, Vertex u, int w);


}
 