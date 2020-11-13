package co.komal;

class Employee{
	private int id;
	private String name;
	private double salary;
	
	public Employee(int id, String name, double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}	
}

class Manager extends Employee{
	private double incentive;
	public Manager(int id, String name, double salary,double incentive) {
		super(id, name, salary);
		this.incentive=incentive;
	}
	public double getIncentive() {
		return incentive;
	}
	public void setIncentive(double incentive) {
		this.incentive = incentive;
	}
	public double getSalary() {
		return super.getSalary() + this.incentive;
	}
}

class Labour extends Employee{
	private double overTime;
	public Labour(int id, String name, double salary,double overTime) {
		super(id, name, salary);
		this.overTime=overTime;
	}
	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}
	public double getSalary() {
		return super.getSalary() + this.overTime;
	}
}
public class EmployeeTest {
	public static double getTotalSal(Employee e[]) {
		double totalSal = 0.0;
		for(int i = 0; i < e.length; i++) {
			totalSal += e[i].getSalary();
		}
		return totalSal;
	}

	public static void main(String[] args) {
		
		Employee e[] = new Employee[2];
		e[0] = new Manager(1, "Ram", 10000, 100);
		e[1] = new Labour(2, "Shyam", 1000, 100);
		System.out.println("Total Salary of all the employees: " + getTotalSal(e));
	}
}
