// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This Class is the Review Rating Comparator Object

import java.util.Comparator;

public class ReviewRatingComparator implements Comparator <Restaurant> {
	
	//Comparator Constuctor
	public int compare(Restaurant first, Restaurant second) {
		//Compares Stars
		if (first.getStarsString().compareTo(second.getStarsString()) == 0) {
			//Compares Restaurant Name
			if (first.getRestaurantName().compareTo(second.getRestaurantName()) == 0) {
				//Compares Locations
				if (first.getLocation().compareTo(second.getLocation()) == 0) {
					//Compares Location
					if (first.getLocation().compareTo(second.getLocation()) == 0) {
						return 0;
					}
					else {
						return first.getLocation().compareTo(second.getLocation());
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
			return first.getStarsString().compareTo(second.getStarsString());
		}
	}
}
