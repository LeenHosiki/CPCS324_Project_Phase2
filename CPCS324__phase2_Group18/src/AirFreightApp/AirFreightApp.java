package AirFreightApp;

import GraphFramework.ShortestPathAlgorithm;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 *  @authors Kawka  
 */

/* 
Group 18

Kawther Kamal 
Leen Hosiki 
Layan othman Algarni 
Arwa Alamoudi 

4 JUNE 2023
 */

public class AirFreightApp {

    public static void main(String[] args) throws FileNotFoundException {
         Scanner input = new Scanner(System.in);
        boolean isDigraph = false;
         int verticesNo = 0; // number of vertices
        int edgesNo = 0; // number of edges

    // Print welcome messgae
        System.out.println("    ------------- Welcome to Compute the Shortest Path Algorithm-------------");
        System.out.println("----------------------------- Dijkstra  Algorithm  -----------------------------");
        
        System.out.println("Please choose");
        System.out.println("1- Rread Graph From File"); // Requirement 1
        System.out.println("2- Make random Graph"); // Requirement 2
        System.out.println(); // format

        // Take choice input from user
        System.out.print("Enter your choice: ");
        int choice = input.nextInt(); // user choice
        System.out.println(); // format

        // Make sure input is valid
        while (choice != 1 && choice != 2) {
            System.out.println("Your choice is incorrect!");
            System.out.print("Try again: ");
            choice = input.nextInt();
        }

 // ------------------------ Read Graph From File 
      if (choice == 1) {
            System.out.println("-----------------------------------"); // Format
            System.out.println("Your choice is .. Read Graph From File  ");
            File FileOfgraph = new File("CPCS324.txt");
            AFRouteMap map = new AFRouteMap(); // Create An Object of AFRouteMap 
            map.readGraphFromFile(FileOfgraph); // Access readGraphFromFile Method in Graph Class

            ShortestPathAlgorithm dijkstra = new ShortestPathAlgorithm(map);

        } // End of Requirement 1

 // --------------------- RMake Graph (randomly)
      if (choice == 2) {
            System.out.println("-----------------------------------");
            System.out.println("You choice is .. Make Graph (randomly)");
            System.out.println();
            
            isDigraph = true;//in our

            System.out.println("Choice one of the cases to Compear");
            System.out.println("note: n is number of vertices | m is number of edges");
            System.out.println("1-  n=2,000 - m=10,000");
            System.out.println("2-  n=3,000 - m=15,000");
            System.out.println("3-  n=4,000 - m=25,000");
            System.out.println("4-  n=5,000 - m=15,000");
            System.out.println("5-  n=6,000 - m=25,000");
 
            System.out.print("Enter your choice : ");//take the choice frome the user
            int Choice_Case = input.nextInt();// user choice
            while (Choice_Case < 1 || Choice_Case > 5) {
                System.out.println("Your choice is incorrect !!!! ");
                System.out.print("Try again : ");
                Choice_Case = input.nextInt();
                System.out.println(); //New line
            }

            switch (Choice_Case) {
                case 1: {
                    verticesNo = 2000;
                    edgesNo = 10000;
                    break;
                }
                case 2: {
                    verticesNo = 3000;
                    edgesNo = 15000;
                    break;
                }
                case 3: {
                    verticesNo = 4000;
                    edgesNo = 25000;
                    break;
                }
                case 4: {
                    verticesNo = 5000;
                    edgesNo = 15000;
                    break;
                }
                case 5: {
                    verticesNo = 6000;
                    edgesNo = 25000;
                    break;
                }
                
            }

            
            AFRouteMap map = new AFRouteMap(verticesNo, edgesNo, isDigraph); // Create An Object of AFRouteMap
            long startTime = System.currentTimeMillis(); // Store start time
            ShortestPathAlgorithm dijkstra = new ShortestPathAlgorithm(map); // Create ShortestPathAlgorithm object to use Dijkstra algorithm
            long finishTime = System.currentTimeMillis();// Store finish time
             long TotalTime=(finishTime - startTime);
            System.out.println("Run time for Dijkstra algorithm " + TotalTime+ " ms ");
          System.out.println();
        } 
     } 
} 
