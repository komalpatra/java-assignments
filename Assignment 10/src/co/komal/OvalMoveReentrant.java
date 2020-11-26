package co.komal;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;;

public class OvalMoveReentrant extends Frame implements Runnable{

	int y1 = 400, y2 = 400, y3 = 400;
	Thread Ball_1,Ball_2,Ball_3;
	boolean flag =false;
	public OvalMoveReentrant() {
		super("Oval Game");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		Ball_1 = new Thread(this);
		Ball_1.setName("Ball_1");
		Ball_1.start();
		
		Ball_2 = new Thread(this);
		Ball_2.setName("Ball_2");
		Ball_2.start();
		
		Ball_3 = new Thread(this);
		Ball_3.setName("Ball_3");
		Ball_3.start();
	}
	ReentrantLock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	
	public void ballOne() {
		lock.lock();
		if(flag==true) {
			try {
				 condition.await();
			}
			catch(Exception e) {}
		}
		try {
			condition.signalAll();
		}
		finally {
			lock.unlock();
		}
		
	}
	public void ballTwo() {
		lock.lock();
		if(flag==true) {
			try {
				condition.await();
			}
			catch(Exception e) {}
		}
		try {
			condition.signalAll();
		}
		finally {
			lock.unlock();
		}
		//else {}
		
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		if (currentThread.getName().equals("Ball_1")) {
			for (;;) {
				System.out.println("Ball_1");
				while(y1>100) {
						y1=y1-10;
						repaint();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				flag = true;
				ballOne();
				while(y1<400) {
					y1=y1+10;					
					repaint();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				flag=true;
				ballOne();

			}
		}
		if (currentThread.getName().equals("Ball_2")) {
			for (;;) {
				System.out.println("Ball_2");
				while(y2>100) {
						y2=y2-8;						
						repaint();
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
				}
				flag=true;
				ballTwo();
				while(y2<400) {
						y2=y2+8;
						repaint();
					try {
						Thread.sleep(100);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				flag=true;
				ballTwo();

			}
}
			
		if (currentThread.getName().equals("Ball_3")) {
			for (;;) {
				System.out.println("Ball_3");
					while(y3>100) {
						y3=y3-6;
						repaint();
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
				}
					
					flag=false;
					ballOne();
					ballTwo();
					while(y3<400) {
						y3=y3+6;
						repaint();
						try {
							Thread.sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
							e.printStackTrace();
						}
					}
					flag=false;
					ballOne();
					ballTwo();
			}
		}
	}
	
	public static void main(String args[]) {
		Frame om = new OvalMoveReentrant();
		om.setSize(600, 600);
		om.setBackground(Color.CYAN);
		om.setVisible(true);
	}
}