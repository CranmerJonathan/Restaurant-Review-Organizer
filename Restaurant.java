// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class is the blueprint for the restaurant Object

import java.io.Serializable;


public class Restaurant implements Serializable {
	//Declaring Variables
	private static final long serialVersionUID = 205L; 
	private String restaurantName;
	private int stars;
	private String review;
	private int priceRange;
	private String location;
	private Cuisine cuisine;
	private String starsString = "";
	private String priceString = "";
	
	//Restaurant Constructor
	public Restaurant (String restaurantName, int stars, String review, int priceRange, String location, Cuisine cuisine) {
		this.restaurantName = restaurantName;
		this.stars = stars;
		this.review = review;
		this.priceRange = priceRange;
		this.location = location;
		this.cuisine = cuisine;
		for (int i=0; i < this.stars; i++) {
			starsString += "*";
		}
		
		for (int j=0; j < this.priceRange; j++) {
			priceString += "$";
		}
	}
	
	//Restaurant Name Getter
	public String getRestaurantName() {
		return restaurantName;
	}
	
	//Stars Getter
	public int getStars() {
		return stars;
	}
	
	//Price Range Getter
	public int getPriceRange() {
		return priceRange;
	}
	
	//Location Getter
	public String getLocation() {
		return location;
	}
	
	//Review Getter
	public String getReview() {
		return review;
	}
	
	//Cuisine Getter
	public Cuisine getCuisine() {
		return cuisine;
	}
	
	//StarsString Getter
	public String getStarsString() {
		return starsString;
	}
	
	//Price String Getter
	public String getPriceString() {
		return priceString;
	}
	
	//To String method
	public String toString() {
		return restaurantName + " restaurant\n" + starsString + "\t\t" + priceString + "\n" +  cuisine.toString() + "Location: " + location + "\n" + "Review:\t" + review + "\n\n";
	}
}
