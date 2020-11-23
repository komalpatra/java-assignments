package co.komal;

import java.util.*;

public class Ass8q3 {
	public static void printMapKeyValues(HashMap<? extends Number, ?> hm) {
		
		hm.entrySet().forEach(entry ->{
			System.out.println(entry.getKey()+"  "+entry.getValue());
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> h1=new HashMap<>();
		HashMap<Double, String> h2=new HashMap<>();
		//HashMap<String, String> h3=new HashMap<>();
		HashMap<Integer, Integer> h4=new HashMap<>();
		
		h1.put(1, "kaveri");
		h1.put(2, "anu");
		
		h2.put(2.0, "K");
		h2.put(3.2, "anu");
		
		//h3.put("kk", "value");
		//h3.put("k2", "value");
		
		h4.put(1, 1);
		h4.put(2, 3);
		
		Ass8q3.printMapKeyValues(h1);
		Ass8q3.printMapKeyValues(h2);
		Ass8q3.printMapKeyValues(h4);

		
	}	
	
}
