package co.komal;

public class Queue {
	 int SIZE = 5;
	  int items[] = new int[SIZE];
	  int front, rear;

	  Queue() {
	    front = -1;
	    rear = -1;
	  }


	  // insert elements to the queue
	  void enQueue(int element) {
	    if (front == 0 && rear == SIZE - 1) {
	      System.out.println("Queue is full");
	    }
	    else {
	      if (front == -1) {
	        front = 0;
	      }
	      rear++;	      
	      items[rear] = element;
	      System.out.println("Insert " + element);
	    }
	  }

	  // delete element from the queue
	  int deQueue() {
	    int element;
	    if (front == -1) {
	      System.out.println("Queue is empty");
	      return (-1);
	    }
	    else {
	      element = items[front];
	      if (front >= rear) {
	        front = -1;
	        rear = -1;
	      }
	      else {
	        front++;
	      }
	      System.out.println( element + " Deleted");
	      return (element);
	    }
	  }

	  // display element of the queue
	  void display() {
	    int i;
	    if (front == -1) {
	      System.out.println("Empty Queue");
	    }
	    else {
	      System.out.println("\nFront index-> " + front);

	      // display element of the queue
	      System.out.println("Items -> ");
	      for (i = front; i <= rear; i++)
	        System.out.print(items[i] + "  ");

	      // display the rear of the queue
	      System.out.println("\nRear index-> " + rear);
	    }
	  }

	  public static void main(String[] args) {
	    Queue q = new Queue();
	    q.deQueue();
	    // insert elements to the queue
	    for(int i = 1; i < 6; i ++) {
	      q.enQueue(i);
	    }
	    q.enQueue(6);
	    q.display();
	    q.deQueue();
	    q.display();

	  }
}
