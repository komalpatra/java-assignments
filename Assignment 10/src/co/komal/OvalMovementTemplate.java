package co.komal;

import java.awt.*;
import java.awt.event.*;

public class OvalMovementTemplate extends Frame implements Runnable {
	int y1 = 400, y2 = 400, y3 = 400;
	Thread y1_red,y2_green,y3_blue;
	public OvalMovementTemplate() {
		super("Oval Game");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		y1_red=new Thread(this);
		y1_red.setName("RED");
		y1_red.start();
		
		y2_green=new Thread(this);
		y2_green.setName("GREEN");
		y2_green.start();
		
		y3_blue=new Thread(this);
		y3_blue.setName("BLUE");
		y3_blue.start();
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
		Frame om = new OvalMovementTemplate();
		om.setSize(600, 600);
		om.setBackground(Color.CYAN);
		om.setVisible(true);
	}



	@Override
	public void run() {
		Thread currentThread=Thread.currentThread();
		if(currentThread.getName().equals("RED")) {
			for( ; ; ) {
				while(y1>50) {
					y1=y1-5;
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
				while(y1<400) {
					y1=y1+5;
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		}
			
		
		if(currentThread.getName().equals("GREEN")) {
			for( ; ; ) {
				while(y2>50) {
					y2=y2-5;
					repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
				while(y2<400) {
					y2=y2+5;
					repaint();
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		}
		
		
		if(currentThread.getName().equals("BLUE")) {
			for( ; ; ) {
				while(y3>50) {
					y3=y3-5;
					repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
				while(y3<400) {
					y3=y3+5;
					repaint();
					try {
						Thread.sleep(200);
					} catch (InterruptedException e) {
							e.printStackTrace();
					}
				}
			}
		}
					
		
  }
}



