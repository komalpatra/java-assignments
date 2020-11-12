package co.komal.entity;

public class Stack {
	// store elements of stack
	  private int arr[];
	  // represent top of stack
	  private int top;
	  // total capacity of the stack
	  private int capacity;

	  // Creating a stack
	  public Stack(int size) {
	    // initialize the array
	    // initialize the stack variables
	    arr = new int[size];
	    capacity = size;
	    top = -1;
	  }

	  // push elements to the top of stack
	  public void push(int x) {
	    if (top==capacity-1) {
	      System.out.println("Stack OverFlow");
	      System.exit(1);
	    }
	    System.out.println("Inserting " + x);
	    arr[++top] = x;
	  }

	  // pop elements from top of stack
	  public int pop() {
	    if (top==-1) {
	      System.out.println("STACK EMPTY");
	      System.exit(1);
	    }
	    System.out.println("popping item is:"+arr[top]);
	    return arr[top--];
	  }
	  
	// display elements of stack
	  public void printStack() {
	    for (int i = 0; i <= top; i++) {
	      System.out.print(arr[i] + ", ");
	    }
	  }
}
