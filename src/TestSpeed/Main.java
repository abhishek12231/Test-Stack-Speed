package TestSpeed;

//question -
//Test a stack's speed (with millions of operations) as to which is faster: an array based stack or a linked list based stack.

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) { // main method
		// TODO Auto-generated method stub
		final int finalNum = 1000000; // final number it doesn't change
		int increment = 5000; // increment
		
		long totalTime = arrayStack(finalNum, increment); // sending the values to run
		System.out.println("Total time for array stack: " + totalTime + " ms"); // now printing it for the array
		
		long totalTimeLL = LLStack(finalNum, increment);
		System.out.println("Total time for LL stack: " + totalTimeLL + " ms");// now printing it for the LL

	}
	public static long arrayStack(int finalNum, int increment) {
		ArrayDeque<Integer> arrStack = new ArrayDeque<>(); // // created an array stack using ArrayDeque 
		//Deque is like first in and first out.
		long startTimer; // all the are variable needed to perform this operation
		long endTimer;
		long totalTimer = 0;
		//so this for loop increment 5000 every time to get the accurate time
		for(int operations = increment; operations <= finalNum; operations += increment) { // start at 5000 and its less tah 1 million and increment by 5K
		
		startTimer = System.currentTimeMillis(); // start timer here 
		
		for(int i = 0; i< operations; i++) { // performing add operations
			arrStack.add(i);
		}
		for(int i = 0; i< operations; i++) { //performing remove operations
			arrStack.remove(i);
		}
		
		endTimer = System.currentTimeMillis(); // end timer here
		long iterationTime = endTimer - startTimer;
        //System.out.println("Operations: " + operations + ", Time: " + (endTime - startTime) + " ms");
        totalTimer += iterationTime; // this update everytime the loop runs to give the accurate time
		}
		return totalTimer; // returning total timer value should be in ms
	}
	
	public static long LLStack(int finalNum , int increment) {
		LinkedList<Integer> LLStack = new LinkedList<>();  // created a linked stack using LinkedList of integers
		long startTime, endTime; // variable to measure time
		long totalTime = 0;
		//looping through the target operations with 5000 increment
		for(int operations=increment; operations <= finalNum; operations += increment) {
			startTime = System.currentTimeMillis(); //recording the start time
		
		for(int i = 0; i< operations; i++) { // performing push operations
			LLStack.push(i);
		}
		for(int i = 0; i< operations; i++) { // performing pop operations
			LLStack.pop();
				
		}
		endTime = System.currentTimeMillis(); // so here i am recoring the end time
		//long iterationTime = endTime - startTime;
		totalTime += endTime - startTime;  // this  the total time taken for this iteration
		}
		return totalTime; // now return the value
		// The Array stack is faster on my mac.
		// its probably because of its contiguous memory allocation. 
		// elements are stored in adjacent memory locations allowing for better cache locality and reducing the number of cache misses.  
	}
	

}
