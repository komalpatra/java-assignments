package co.komal;

import co.komal.entity.SwapDate;

public class Source {
	public static void main(String[] args) {
		
		SwapDate d1=new SwapDate(12,4,2020);
		SwapDate d2=new SwapDate(12,2,2020);
		
		System.out.println("date1= "+ d1);
		System.out.println("date2= "+ d2);
		System.out.println("after swapping");
		SwapDate.swap(d1, d2);
	}
}
