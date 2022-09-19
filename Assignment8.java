// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class Prints menu and takes a user input and does a series of commands

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Assignment8 {
    public static void main(String[] args) {
        // Menu options
        char inputOpt = ' ';
        String inputLine;
        // Restaurant and Cuisine information
        String restaurantName, cuisineName;
        String review = null, location, signatureDish, priceRange;

        int rating;
        // Output information
        String outFilename, inFilename;
        String outMsg;
        // Restaurant manager
        ReviewManager reviewManager = new ReviewManager();
        try {
            printMenu();
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader stdin = new BufferedReader(isr);

            do {
                System.out.print("\nWhat action would you like to perform?\n");
                inputLine = stdin.readLine().trim();
                if (inputLine.isEmpty()) {
                    continue;
                }
                inputOpt = inputLine.charAt(0);
                inputOpt = Character.toUpperCase(inputOpt);

                switch (inputOpt) {

                    case 'A': // Add a new Restaurant Review
                        System.out.print("Please enter the restaurant information:\n");
                        System.out.print("Enter the restaurant name:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Enter the review:\n");
                        review = stdin.readLine().trim();
                        System.out.print("Enter the price range:\n");
                        priceRange = stdin.readLine().trim();
                        System.out.print("Enter the rating:\n");
                        rating = Integer.parseInt(stdin.readLine().trim());
                        System.out.print("Enter the cuisine name:\n");
                        cuisineName = stdin.readLine().trim();
                        System.out.print("Enter the location:\n");
                        location = stdin.readLine().trim();
                        System.out.print("Enter the signature dish\n");
                        signatureDish = stdin.readLine().trim();
                        if (reviewManager.addReview(restaurantName, rating, review, priceRange, cuisineName, location, signatureDish)) {
                        	System.out.print("Restaurant added\n");
                        } 
                        else {
                        	System.out.print("Restaurant NOT added\n");
                        }
                        break;
                        
                    case 'D': // Search a Restaurant
                        System.out.print("Please enter the restaurant name to search:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the restaurant's location':\n");
                        location = stdin.readLine().trim();
                        int i = reviewManager.restaurantExists(restaurantName, location);
                        if (i != -1) {
                        	System.out.println("Restaurant found. Here's the review:\n" + reviewManager.getRestaurant(i).getReview());
                        }
                        else {
                        	System.out.println("Restaurant not found. Please try again");
                        }
                        break;

                    case 'E': // Search a cuisine
                        System.out.print("Please enter the cuisine name to search:\n");
                        cuisineName = stdin.readLine().trim();
                        ArrayList<Integer> list = reviewManager.cuisineExists(cuisineName); 
                        if (reviewManager.cuisineExists(cuisineName).size() != 0) {
	                        System.out.printf("%s Restaurants matching %s cuisine were found:\n", reviewManager.cuisineExists(cuisineName).size(), cuisineName);
	                        for (int k = 0; k < reviewManager.cuisineExists(cuisineName).size(); k++) {
	                        	System.out.println(reviewManager.getRestaurant(list.get(k)));
	                        }
	             
                        }
                        else {
                        	System.out.printf("Cuisine: %s was NOT found\n", cuisineName);
                        }
                        break;
   
                    case 'L': // List restaurant's reviews
                        if (reviewManager.listReviews().length() != 0) {
                    		System.out.print("\n" + reviewManager.listReviews() + "\n");
                        }
                        else {
                        	System.out.print("No Reviews available");
                        }
                        break;
                       
                    case 'N': //sort by rating
                    	reviewManager.sortByRating();
                    	System.out.println("sorted by rating");
                    	break;
                    	
                    case 'P': //sort by cuisine
                    	reviewManager.sortByCuisine();
                    	System.out.println("sorted by cuisine");
                    	break;
                        
                    case 'Q': // Quit
                        break;

                    case 'R': // Remove a review
                        System.out.print("Please enter the restaurant name of the review to remove:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.print("Please enter the location to remove:\n");
                        location = stdin.readLine().trim();
                        if (reviewManager.removeReview(restaurantName, location)) {
                        	System.out.print(restaurantName + ", " + location + " was removed\n");
                        }
                        else {
                        	System.out.print(restaurantName + ", " + location + " was NOT removed\n");
                        }
                        break;
                        
                    case 'T': // Close reviewList
                        reviewManager.closeReviewManager();
                        System.out.print("Restaurant management system was reset\n");
                        break;

                    case 'U': // Write restaurant names and reviews to a text file
                        System.out.print("Please enter a file name that we will write to:\n");
                        outFilename = stdin.readLine().trim();
                        System.out.print("Please enter the name of the restaurant:\n");
                        restaurantName = stdin.readLine().trim();
                        System.out.println("Please enter a review to save locally:\n");
                        review = stdin.readLine().trim();
                        outMsg = restaurantName + "\n" + review + "\n";
                        //String line = restaurantName + review;
                        //String fileName = "test.txt";
                        FileWriter fw = new FileWriter (outFilename);
                        BufferedWriter bw = new BufferedWriter (fw);
                        PrintWriter outFile = new PrintWriter (bw);
                        
                        
                        outFile.print(outMsg);
                        outFile.println();
                        
                        outFile.close();
                        System.out.println(outFilename + " is written");
                        break;

                    case 'V': // Read strings from a text file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        String line;
                        try
                        {
                           FileReader fr = new FileReader (inFilename);
                           BufferedReader inFile = new BufferedReader (fr);
                         //Scanner inFile = new Scanner(fr); instead of the above
                         // line = inFile.nextLine(); 
                           line = inFile.readLine();
                           System.out.println(inFilename + " was read\n" + "The contents of the file are:");
                           while (line != null)
                           {
                             System.out.println(line);
                             line = inFile.readLine();
                           }
                           inFile.close();
                         }
                        catch (FileNotFoundException exception)
                        {
                           System.out.println (inFilename + " was not found");
                        }
                        catch (IOException exception)
                        {
                           System.out.println("Read string from file error");
                        }
                        break;
 
                    case 'W': // Serialize ReviewManager to a data file
                        System.out.print("Please enter a file name to write:\n");
                        outFilename = stdin.readLine().trim();
                        try {
	                        FileOutputStream fs = new FileOutputStream(outFilename);
	                        ObjectOutputStream os = new ObjectOutputStream(fs);
	                        
	                        os.writeObject(reviewManager);
	                        os.close();
                        }
                        catch (NotSerializableException exception) {
                        	System.out.print("Not serializable exception\n");
                        }
                        catch (IOException exception) {
                        	System.out.print("Data file written exception\n");
                        }
                        break;

                    case 'X': // Deserialize ReviewManager from a data file
                        System.out.print("Please enter a file name which we will read from:\n");
                        inFilename = stdin.readLine().trim();
                        try {
                        	FileInputStream fs = new FileInputStream(inFilename);
                        	ObjectInputStream bs = new ObjectInputStream(fs);
                        	Object output = bs.readObject();
                        	
                        	System.out.print(inFilename + " was read\n");
                        	reviewManager = (ReviewManager) output;
                        	bs.close();
                        }
                        catch (ClassNotFoundException exception){
                        	System.out.print("Class not found exception\n");
                        }
                        catch(NotSerializableException exception) {
                        	System.out.print("Not serializable exception\n");
                        }
                        catch(IOException exception) {
                        	System.out.print("Data file read exception\n");
                        }
                        break;
                        
                    case '?': // Display help
                        printMenu();
                        break;

                    default:
                        System.out.print("Unknown action\n");
                        break;
                }

            } while (inputOpt != 'Q' || inputLine.length() != 1);
        }
        catch (IOException exception) {
            System.out.print("IO Exception\n");
        }
    }

    public static void printMenu() {
        System.out.println("Welcome to Kelp! ");
        System.out.println("Find or post reviews for your favorite (and not so favorite) restaurants.");

        System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd a review\n"
                + "D\t\tSearch for a restaurant\n" + "E\t\tSearch for a cuisine\n"
                + "L\t\tList all reviews\n" + "N\t\tSort by stars\n" + "P\t\tSort by cuisine\n"
                + "Q\t\tQuit\n" + "R\t\tRemove a review\n"
                + "U\t\tAdd personal review to a local file\n" + "V\t\tRetrieve personal review from a local file\n"
                + "W\t\tSave reviews to a file\n"
                + "X\t\tUpload reviews from a file\n"
                + "T\t\t(admin) reset database\n"
                + "?\t\tDisplay Help\n");
    }
}
