package co.komal;

import co.komal.entity.Stack;

public class StackTest {
	 public static void main(String[] args) {
		    Stack stack = new Stack(5);

		    stack.push(45);
		    stack.push(23);
		    stack.push(3);

		    stack.pop();
		    stack.push(89);
		    stack.push(23);
		    stack.pop();
		    stack.push(100);
		    System.out.println("\nAfter popping out");
		    stack.printStack();

		  }
}
