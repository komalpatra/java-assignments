package co.komal;
import java.util.*;
public class Ass8q2 {
	public static void printList(List<? extends Number> list) {
		for (Number number : list) {
			System.out.println(number);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		List<Integer> l1=new ArrayList<>();
		List<Double> l2=new ArrayList<>();
		
		l1.add(1);
		l1.add(2);
		
		l2.add(2.3);
		l2.add(3.6);
		
		
		Ass8q2.printList(l1);
		Ass8q2.printList(l2);
	}
}
