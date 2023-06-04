 
package GraphFramework;

/*
 *  @authors Kawka
 */
//suber
public class ShortestPathAlgorithm {
       // Declare data variables
 Graph graphObj;
    DBAIISourceSPAlg source;
    
       // Constructor
 public ShortestPathAlgorithm(Graph graphobj){
        
     graphObj=graphobj;
    
    source=new DBAIISourceSPAlg(graphobj);
    }
}
 