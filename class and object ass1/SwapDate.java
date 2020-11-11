package co.komal.entity;

public class SwapDate {
	private int day;
	private int month;
	private int year;
	//default constructor
	public SwapDate() {
		
	}
	//parameterized constructor
	public SwapDate(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return String.format("%s / %s /%s", day, month, year);
	}
	
	public static void swap(SwapDate d1,SwapDate d2) {
		SwapDate temp=d1;
		d1=d2;
		d2=temp;
		System.out.println("d1= "+d1 +" &   d2= "+d2);
	}
}
