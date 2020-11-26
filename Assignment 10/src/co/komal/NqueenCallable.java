package co.komal;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Task implements Callable<List<String>> {
	int a=0;
	String s;
	static int i = 1;
	List<String> list = new ArrayList<>();
	public Task(int a) {
		this.a = a;
	}
    @Override
    public List<String> call() throws Exception {
    	int a2 = 0, b2 = 1, c2 = 2, d2 = 3, e2 = 4, f2 = 5, g2 = 6, h2 = 7;
    	for(int b=0; b<=7; b++) {
			for(int c=0; c<=7; c++) {
				for(int d=0; d<=7; d++) {
					for(int e=0; e<=7; e++) {
						for(int f=0; f<=7; f++) {
							for(int g=0; g<=7; g++) {
								for(int h=0; h<=7; h++) {

									if(NqueenCallable.isSafePosition(a, b, a2, b2) && NqueenCallable.isSafePosition(a, c, a2, c2) && NqueenCallable.isSafePosition(a, d, a2, d2) && NqueenCallable.isSafePosition(a, e, a2, e2) && NqueenCallable.isSafePosition(a, f, a2, f2) && NqueenCallable.isSafePosition(a, g, a2, g2) && NqueenCallable.isSafePosition(a, h, a2, h2)
										&& NqueenCallable.isSafePosition(b, c, b2, c2) && NqueenCallable.isSafePosition(b, d, b2, d2) && NqueenCallable.isSafePosition(b, e, b2, e2) && NqueenCallable.isSafePosition(b, f, b2, f2) && NqueenCallable.isSafePosition(b, g, b2, g2) && NqueenCallable.isSafePosition(b, h, b2, h2)
											&& NqueenCallable.isSafePosition(c, d, c2, d2) && NqueenCallable.isSafePosition(c, e, c2, e2) && NqueenCallable.isSafePosition(c, f, c2, f2) && NqueenCallable.isSafePosition(c, g, c2, g2) && NqueenCallable.isSafePosition(c, h, c2, h2)
												&& NqueenCallable.isSafePosition(d, e, d2, e2) && NqueenCallable.isSafePosition(d, f, d2, f2) && NqueenCallable.isSafePosition(d, g, d2, g2) && NqueenCallable.isSafePosition(d, h, d2, h2)
													&& NqueenCallable.isSafePosition(e, f, e2, f2) && NqueenCallable.isSafePosition(e, g, e2, g2) && NqueenCallable.isSafePosition(e, h, e2, h2) 
														&& NqueenCallable.isSafePosition(f, g, f2, g2) && NqueenCallable.isSafePosition(f, h, f2, h2)
															&& NqueenCallable.isSafePosition(g, h, g2, h2)) {
											
										s = ("Position " + i + ") " + a + " - " + b + " - " + c + " - " + d + " - " + e + " - " + f + " - " + g + " - " + h);
										list.add(s);
										i++;
									}
								}
							}
						}
					}
				}
			}
		}
    	return list;
    }
}
 
public class NqueenCallable {

	public static boolean isSafePosition(int y1, int y2, int x1, int x2) {
		if(y1 != y2 && x1 != x2) {
			double slope = ((y2 - y1)*1.0) / (x2 - x1);
			if (slope != 1.0 && slope != -1.0) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Future<List<String>> future = null;
		List<String> list = new ArrayList<>();
		long startTime = System.currentTimeMillis();
		ExecutorService executorService = Executors.newFixedThreadPool(8);
		for(int a = 0; a < 8; a++) {
		 future = executorService.submit(new Task(a));
		 list.addAll(future.get());
		}
		for(String s : list) {
			System.out.println(s);
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken: " + (endTime - startTime) + " milisec");
	}

}

