// Assignment: Assignment8
// Name: Jonathan Cranmer
// StudentID: 1221599600
// Lecture: Navabi 1:30-2:45 T/Th
// Description: This class creates a sort method that is used to organize arraylist based on a comparator

import java.util.ArrayList;
import java.util.Comparator;

public class Sorts {
	//Bubble Sort
	public static void sort(ArrayList<Restaurant> restaurant, Comparator<Restaurant> xComparator) {
        int n = restaurant.size();
        for (int i = 0; i < n - 1; i++) {
        	for (int j = i+1; j < n; j++) {
                if (xComparator.compare(restaurant.get(i), restaurant.get(j)) > 0) {
                    Restaurant temp = restaurant.get(i);
                    restaurant.set(i, restaurant.get(j));
                    restaurant.set(j ,temp);
                }
            }
        }
    }
}
