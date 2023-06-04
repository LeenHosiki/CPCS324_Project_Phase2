package AirFreightApp;

import GraphFramework.Vertex;

/*
 *  @authors Kawka
 */
public class Location extends Vertex {

    String city;
        // Default constructor
public Location() {
         
    }

//Constructor with specific parameter: label     
    public Location(String label) {
        super(label);
        city = label;
    }

    // Methods
    @Override
    public void setLabel(String label) {
        super.setLabel(label);
    }

    @Override
        public String displayInfo() {
           char ci=  (char)(Integer.parseInt(super.getLabel())+'A');
            String print="loc."+ci +": city " + city;
                return print;

    }

}
 