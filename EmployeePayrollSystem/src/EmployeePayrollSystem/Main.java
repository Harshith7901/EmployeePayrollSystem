package EmployeePayrollSystem;

import java.util.ArrayList;

abstract class Employee {
	private String name;
	private int id;

	public Employee(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public int getId() {
		return id;
	}

	public abstract double calculateSalary();

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Employee [name=" + name + ", id=" + id + ", salary=" + calculateSalary() + "]";
	}
}

//------------------------FullTimeEmployee---------------------------
class FullTimeEmployee extends Employee {
	private double monthlySalary;

	public FullTimeEmployee(String name, int id, double monthlySalary) {
		super(name, id);
		this.monthlySalary = monthlySalary;
	}

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return monthlySalary;
	}
}

//------------------------PartTimeEmployee---------------------------
class PartTimeEmployee extends Employee {
	private int hoursWorked;
	private double hourlyRate;

	public PartTimeEmployee(String name, int id, int hoursWorked, double hourlyRate) {
		super(name, id);
		this.hoursWorked = hoursWorked;
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculateSalary() {
		// TODO Auto-generated method stub
		return hoursWorked * hourlyRate;
	}
}

//------------------------PayrollSystem---------------------------
class PayrollSystem {
	private ArrayList<Employee> employeeList;

	public PayrollSystem() {
		employeeList = new ArrayList<>();
	}

	public void addEmployee(Employee employee) {
		employeeList.add(employee);
	}

	public void removeEmployee(int id) {
		Employee employeeToRemove = null;
		for (Employee employee : employeeList) {
			if (employee.getId() == id) {
				employeeToRemove = employee;
				break;
			}
		}
		if (employeeToRemove != null) {
			employeeList.remove(employeeToRemove);
		}
	}

	public void displayEmployee() {
		for (Employee employee : employeeList) {
			System.out.println(employee);
		}
	}

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PayrollSystem payrollSystem = new PayrollSystem();
		FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000.0);
		PartTimeEmployee emp2 = new PartTimeEmployee("Alexander", 2, 40, 100);

		payrollSystem.addEmployee(emp1);
		payrollSystem.addEmployee(emp2);
		System.out.println("Intial Employee Details: ");
		payrollSystem.displayEmployee();
		System.out.println("Removing Employee");
		payrollSystem.removeEmployee(2);
		System.out.println("Removing Employee Details: ");
		payrollSystem.displayEmployee();
	}

}