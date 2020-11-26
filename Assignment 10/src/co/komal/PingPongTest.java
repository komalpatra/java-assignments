package co.komal;

public class PingPongTest implements Runnable{

	Thread tPing,tPong,tTong;
	public PingPongTest() {
		tPing=new Thread(this);
		tPing.setName("PING");
		tPing.start();
		
		tPong=new Thread(this);
		tPong.setName("PONG");
		tPong.start();
		
		tTong=new Thread(this);
		tTong.setName("TONG");
		tTong.setDaemon(true);//it only executes till other hread executes
		tTong.start();
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
	else if(currentThread.getName().equals("PONG")) {
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
	
	else if(currentThread.getName().equals("TONG")) {
		for(; ;) {
			System.out.println("\t\t TONG");
			try {
				Thread.sleep(100);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
	public static void main(String[] args) {
		new PingPongTest();
	}

}
