package com.nissan.app;

/*
 * b. Create an array having 10 elements. Try to print the element in the 11th position. 
 * Catch the appropriate exception.
 */

public class Question2 {

	public static void main(String[] args) {
		
		//declaring and initializing an integer array
		int[] demoElements = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		try {
			System.out.println("Array elements are: ");
			
			//printing all elements in the array
			for(int demoElement : demoElements)
				System.out.println(demoElements[demoElement]);
			
			//printing the 11th element
			System.out.println(demoElements[11]);
			
		}catch (IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}

}
