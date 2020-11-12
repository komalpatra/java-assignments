package co.komal;

import co.komal.entity.Stack;

public class StackTest {
	public static void main(String[] args) {
	    Stack stack = new Stack(5);

	    stack.push(1);
	    stack.push(2);
	    stack.push(3);

	    stack.pop();

	    stack.push(46);
	    stack.push(2);
	    stack.pop();
	    System.out.println("\nAfter popping out");
	    stack.printStack();

	  }
}
