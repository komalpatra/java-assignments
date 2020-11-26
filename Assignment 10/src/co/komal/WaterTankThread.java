package co.komal;

package co.komal;

public class WaterTankThread implements Runnable{
	private int water=0;
	Thread inlet,outlet,controller;
	
	public WaterTankThread () {
		inlet=new Thread(this);
		inlet.setName("WATER_IN");
		inlet.start();
		
		outlet=new Thread(this);
		outlet.setName("WATER_OUT");
		outlet.start();
		
		controller=new Thread(this);
		controller.setName("CONTROLLER");
		controller.setDaemon(true);
		controller.start();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread currentThread=Thread.currentThread();
		if(currentThread.getName().equals("WATER_IN")) {
			for( ; ; ) {
				if(water<80) {
					water+=6;
					System.out.println("current water level: "+water+"%");
					System.out.println("inlet opened");
					try {
						Thread.sleep(20);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
		 }		
		}
	}
		else if(currentThread.getName().equals("WATER_OUT")) {
			for( ; ; ) {
			//while(water>80 && water<70) {
					water-=3;
					System.out.println("current water level: "+water+"%");
					try {
						Thread.sleep(40);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
			//}
		}
	}
		else if(currentThread.getName().equals("CONTROLLER")) {
			for( ; ; ) {
				if(water<=80) {
					outlet.suspend();
					inlet.resume();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else {
					inlet.suspend();
					outlet.resume();
					try {
						Thread.sleep(60);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		}
	}				
}
	
	public static void main(String[] args) {
		new WaterTankThread();
		
	}
}
