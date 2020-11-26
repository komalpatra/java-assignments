package co.komal;

//class Thread implements Runnable implicitly
public class PingPongISaRelation extends Thread{
	public PingPongISaRelation(String threadName) {
		this.setName(threadName);
		this.start();
	}
	
	@Override
	public void run() {
		Thread currentThread=Thread.currentThread();
		if(currentThread.getName().equals("PING")) {
			for(int i=0;i<10;i++) {
				System.out.println("PING");
				try {
					Thread.sleep(200);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		if(currentThread.getName().equals("PONG")) {
			for(int i=0;i<10;i++) {
				System.out.println("\t PONG");
				try {
					Thread.sleep(250);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
		public static void main(String[] args) {
			new PingPongISaRelation ("PING");
			new PingPongISaRelation("PONG");
		}
}
