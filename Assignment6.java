// Allen Bao
// CS 211
// Instructor: Craig Niiyama
// 2/9/2022
// Code for Assignment 6 in CS 211 Class at Bellevue College

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment6 {
	
	public static void main(String[] args) {
		testSeeingThreeMethod();
		testTwoStacksAreEqualMethod();
		testIsMirrored();
	
	}
	
	public static void seeingThree(Stack<Integer> s) {

		Queue<Integer> q = new LinkedList<>();

		// first, we take all the items in a stack and put them in the queue in reverse order
		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		// we take all the items from the queue at the first position and put them into the stack
		// this leaves us with the original stack, but backwards.
		while (!q.isEmpty()) {
			s.add(q.remove());
		}

		// we repeat the same process as the first loop, putting all the stack items in the queue backwards
		// since the stacked items were already backwards, adding backwards makes the order now forward.
		while (!s.isEmpty()) {
			q.add(s.pop());
		}

		// we finally go through the queue and add each integer 3 times.
		while (!q.isEmpty()) {
			Integer i = q.remove();
			s.add(i);
			s.add(i);
			s.add(i);
		}
	}
	    
	
	
	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {

		// if both s1 and s2 have items left
		while (!s1.isEmpty() && !s2.isEmpty()) {
			// if the any item in s1 and s2 aren't equal then they aren't equal
			if (!s1.pop().equals(s2.pop())) {
				return false;
			}
		}
		// they are equal if they have the same amount of items in them
		return (s1.isEmpty() && s2.isEmpty());

	}

	public static boolean isMirrored(Queue<Integer> q) {
		
		// A palindrome is when a collection of items are the same in reverse order.
		Stack<Integer> s = new Stack<>();

		int qSize = q.size();

		for (int j = 0; j < qSize / 2; ++j){
			Integer i = q.remove();
			s.add(i);
			q.add(i);
		}

		if (qSize % 2 == 1) {
			q.add(q.remove());
		}

		boolean result = true;
		while (!s.isEmpty()) {
			Integer i = q.remove();
			q.add(i);

			if (!s.pop().equals(i)) {
				result = false;
			}
		}

		return result;
	}


	private static void testIsMirrored() {

		Queue<Integer> myQueueP  = new LinkedList<Integer>();;
	
		for (int i = 0; i < 5; i++) {
		
			System.out.print(i);
			myQueueP.add(i);
			
		}
		for (int i = 3; i >= 0 ; i--) {
			
			System.out.print(i);
			myQueueP.add(i);
				
		}

		System.out.println();
		
		System.out.println(isMirrored(myQueueP) + " isMirrord");
		
	}


	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1  = new Stack<Integer>();	
		Stack<Integer> myStack2  = new Stack<Integer>();
		Stack<Integer> myStack3  = new Stack<Integer>();
		Stack<Integer> myStack4  = new Stack<Integer>();
	
		for (int i = 0; i < 5; i++) {
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		
		}
		for (int i = 0; i < 6; i++) {
			myStack3.push(i);
		
		}
	
		System.out.println(twoStacksAreEqual(myStack1,myStack2) + " Same Stack ");
		
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
		
	}


	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		
		for (int i = 0; i < 5; i++) {
			myStack.push(i);

		}
		
		System.out.println();
		print(myStack);
		
		seeingThree(myStack);
	
		print(myStack);
		
	}

	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();

		 while ( e.hasMoreElements() )
			 System.out.print( e.nextElement() + " " );
		 System.out.println();
	
	}

} //end of Assignment6 
