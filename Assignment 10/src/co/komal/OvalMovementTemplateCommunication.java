package co.komal;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class OvalMovementTemplateCommunication extends Frame implements Runnable{
	
	public int motion = 1, count = 0;
	public int flag=0;
	int y1 = 400, y2 = 400, y3 = 400;

	Thread red, green, blue;
	public OvalMovementTemplateCommunication() {
		super("Oval Game");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		red = new Thread(this);
		red.setName("red");
		red.start();
		green = new Thread(this);
		green.setName("green");
		green.start();
		blue = new Thread(this);
		blue.setName("blue");
		blue.start();


	}
	ReentrantLock lock=new ReentrantLock();
	Condition condition=lock.newCondition();
	
	public synchronized void reached() {
		flag++;
		System.out.print(flag);
		lock.lock();
		if(flag!=3) {
			//lock.lock();
			try {
				//lock.lock();
				condition.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				lock.unlock();
			}
		
		}
		else {
			condition.signalAll();
			flag=0;
		}
	}
	
	public void run() {
		Thread currentThread = Thread.currentThread();

		//System.out.println(motion);
		if(currentThread.getName().equals("red")) {
			for(;;) {
				if(motion==1) {
					while(y1>=100) {
						y1-=5;
						repaint();
						if(y1==100) {
							motion=0;
							reached();
						}
						try {
							Thread.sleep(100);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
					//System.out.print(motion);
				}
				else {
					while(y1<=400) {
						y1+=5;
						repaint();
						if(y1==400) {
							motion=1;
							reached();
						}
						try {
							Thread.sleep(100);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}

				}
			}
		}
		
		else if(currentThread.getName().equals("green")) {
			for(;;) {
				if(motion==1) {
					while(y2>=100) {
						y2-=5;
						repaint();
						if(y2==100) {
							motion=0;
							reached();
						}
						try {
							Thread.sleep(150);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}

				}
				else {
					while(y2<=400) {
						y2+=5;
						repaint();
						if(y2==400) {
							motion=1;
							reached();
						}
						try {
							Thread.sleep(150);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}
				}
			}
		}
	
		else if(currentThread.getName().equals("blue")) {
			for(;;) {
				if(motion==1) {
					//upward motion
					while(y3>=100) {
						if(y3==400) {
						}
						y3-=5;
						repaint();
						if(y3==100) {
							motion=0;
							reached();
						}
						try {
							Thread.sleep(200);
						}
						catch(Exception e){
							e.printStackTrace();
						}

					}

				}
				else {
					//downward motion motion
					while(y3<=400) {
						if(y3==100) {
						}
						y3+=5;
						repaint();
						if(y3==400) {
							motion=1;
							reached();
						}
						try {
							Thread.sleep(200);
						}
						catch(Exception e){
							e.printStackTrace();
						}
					}

				}
			}
		}



	}




	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(100, y1, 50, 50);
		g.setColor(Color.GREEN);
		g.fillOval(200, y2, 50, 50);
		g.setColor(Color.BLUE);
		g.fillOval(300, y3, 50, 50);
	}

	public static void main(String args[]) {
		Frame om = new OvalMovementTemplateCommunication();
		om.setSize(600, 600);
		om.setBackground(Color.CYAN);
		om.setVisible(true);
	}
}