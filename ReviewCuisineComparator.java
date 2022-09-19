// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This Class is the Review Cuisine Comparator Object

import java.util.Comparator;

public class ReviewCuisineComparator implements Comparator <Restaurant>{
	//Comparator Constructor
	public int compare(Restaurant first, Restaurant second) {
		//Initiating the difference variable used to get the difference between price ranges
		int difference = first.getPriceRange() - second.getPriceRange();
		//Comparing the Cuisine Strings
		if (first.getCuisine().getName().compareTo(second.getCuisine().getName()) == 0) {
			//Comparing the difference between price ranges
			if (difference == 0) {
				//Comparing restaurants name
				if (first.getRestaurantName().compareTo(second.getRestaurantName()) == 0) {
					//Comparing Location Strings
					if (first.getLocation().compareTo(second.getLocation()) == 0) {
						//Comparing the Review Strings
						if (first.getReview().compareTo(second.getReview()) == 0) {
							return 0;
						}
	
						else {
							return first.getReview().compareTo(second.getReview());
						}
					}
					
					else {
						return first.getLocation().compareTo(second.getLocation());
					}
				}
				
				else {
					return first.getRestaurantName().compareTo(second.getRestaurantName());
				}
			}
			
			else {
				return difference;
			}
		} 
		else {
			return first.getCuisine().toString().compareTo(second.getCuisine().toString());
		}
	}
}
