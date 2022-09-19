// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class is a series of methods that use the ReviewManager. These Methods are used in the Assignment8 Class

import java.io.Serializable;
import java.util.ArrayList;

public class ReviewManager implements Serializable {
    // Declaring reviewList and serializing ReviewManager
    private static final long serialVersionUID = 205L;
    ArrayList<Restaurant> reviewList;

    // ReviewManager Constructor
     public ReviewManager() {
        reviewList = new ArrayList<>();
    }

    // Checks if Restaurant exists and returns index
    public int restaurantExists(String name, String location) {
    	for (int i = 0; i < reviewList.size(); i++) {
	    	if (reviewList.get(i).getRestaurantName().compareTo(name) == 0 && reviewList.get(i).getLocation().compareTo(location) == 0) {
	    		return i;
	    	}
    	}
    	return -1;
    }
     
    //Checks if cuisineExist and returns how many exist
    public ArrayList<Integer> cuisineExists(String cuisine) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	for (int i = 0; i < reviewList.size(); i++) {
	    	if (cuisine.compareTo(reviewList.get(i).getCuisine().getName()) == 0) 
	    		list.add(i);
	    	}
    	return list;
    	}
    
    //Restaurant getter
    public Restaurant getRestaurant(int poo) {
    	return reviewList.get(poo);
    }
 
    //adds a Review and if the review already exists returns a false boolean value
    public boolean addReview(String restaurantName, int stars, String review, String priceRange, String cuisineName, String location, String signatureDish) {
        if (restaurantExists(restaurantName, location) == -1) {
            int price = priceRange.length();
            Cuisine newCuisine = new Cuisine(signatureDish, cuisineName);
            Restaurant newRestaurant = new Restaurant(restaurantName, stars, review, price, location, newCuisine);
            reviewList.add(newRestaurant);
            return true;
        }
        return false;
    }
    
    //Remove Review if it is exist
    public boolean removeReview(String name, String location) {
    	boolean exist = false;
    	if (restaurantExists(name, location) != -1) {
    		reviewList.remove(restaurantExists(name, location));
    		exist = true;
    	}
    	return exist;
    }
    
    //Sorts by Rating
    public void sortByRating() {
    	ReviewRatingComparator comparator = new ReviewRatingComparator();
    	Sorts.sort(reviewList, comparator);
    }
    
    //Sorts by Cuisine
    public void sortByCuisine() {
    	ReviewCuisineComparator comparator = new ReviewCuisineComparator();
    	Sorts.sort(reviewList, comparator);
    }
    
    //Returns Review Arraylist
    public String listReviews() {
    	String list = "";
    	
    	for (int i = 0; i < reviewList.size(); i++) {
    		list += reviewList.get(i).toString(); 
    	}
    	
    	return list;
    }
    
    //Clears ReviewManager
    public void closeReviewManager() {
    	reviewList.clear();
    }
}
