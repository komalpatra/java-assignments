package co.komal;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailTest implements Runnable{
	Thread add,iterator;
	ArrayList<Integer> list = new ArrayList<Integer>();
	
	public FailTest() {
		// TODO Auto-generated constructor stub
		add=new Thread(this);
		add.setName("add");
		add.start();
		iterator=new Thread(this);
		iterator.setName("iterator");
		iterator.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread cuThread=Thread.currentThread();
		if (cuThread.getName().equals("add")) {
			int i=0;
			for(;;) {
				list.add(i++);
				System.out.println("Added "+i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		if (cuThread.getName().equals("iterator")) {
			for (;;) {
				for (Integer integer : list) {
					System.out.println(integer);
				}
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FailTest();
	}


}