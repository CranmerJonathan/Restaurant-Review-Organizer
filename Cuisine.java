// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: The Cuisine class is the blueprint for a Constructor Object.

import java.io.Serializable;

public class Cuisine implements Serializable {
    // The serialVersionUID is used to verify compatibility of senders and
    // receivers. See the document for more details:
    // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/io/Serializable.html
    private static final long serialVersionUID = 205L; 
    private String signatureDish;
    private String name;
    
    //Cuisine Constructor
    public Cuisine(String signatureDish, String name) {
        this.name = name;
        this.signatureDish = signatureDish;
    }

    //Name Getter
    public String getName() {
        return name;
    }

    //Overriding toString method
    public String toString() {
        return name + " Cuisine\n" +
                "Signature Dish:\t" + signatureDish + '\n';
    }
}
