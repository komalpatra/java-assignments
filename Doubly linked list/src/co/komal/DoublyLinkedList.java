package co.komal;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
	
	private ListNode head;
	private ListNode tail;
	private int length;  //calculate length of nodes
	
	
	private class ListNode{
		private int data;
		private ListNode next;
		private ListNode previous;
		
		public ListNode(int data) {
			this.data=data;
		}
	}


	public DoublyLinkedList(ListNode head, ListNode tail, int length) {
		super();
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public DoublyLinkedList() {
		
	}

	public boolean isEmpty() {
		return length==0;		
	}
	
	public int length() {
		return length;		
	}
	
	//inserting
	//inserting at first
	public void insertFirst(int value) {
		ListNode newNode=new ListNode(value);
		if(isEmpty()) {
			tail=newNode;
		}
		else {
			head.previous=newNode;
		}
		newNode.next=head;
		head=newNode;
		length++;
	}
	//inserting at last
	public void lastInsert(int value) {
		ListNode newNode=new ListNode(value);
		if(isEmpty()) {
			head=newNode;
		}
		else {
			tail.next=newNode;
			newNode.previous=tail;
			}
			tail=newNode;
			length++;
		}
	
	
	//deleting
	//deleting at first
	public ListNode deleteFirst() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		ListNode temp=head;
		if(head==null) {
			tail=null;
		}else {
			head.next.previous=null;
		}
		head=head.next;
		temp.next=null;
		return temp;
	}
	//delete at last
		public ListNode deleteLast() {
			if(isEmpty()) {
				throw new NoSuchElementException();
			}
			ListNode temp=tail;
			if(head==tail) {
				head=null;
			}else {
				tail.previous.next=null;
			}
			tail=tail.previous;
			temp.previous=null;
			return temp;
		}
	
	
	//displaying linked list
	public void displayForward() {
		if(head==null) {
			return;
		}
		ListNode temp=head;
		while(temp!=null) {
			System.out.print(temp.data + "-->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	
	
	public static void main(String[] args) {
		
		DoublyLinkedList dll=new DoublyLinkedList();
		dll.insertFirst(23);
		dll.insertFirst(3);
		dll.lastInsert(34);
		dll.displayForward();
		dll.deleteFirst();
		dll.insertFirst(83);
		dll.displayForward();
		dll.deleteLast();
		dll.displayForward();
	}
}
