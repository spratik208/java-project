package gymManagement;
import java.util.ArrayList;
import java.util.Scanner;

class Employee  {

	int id;
	String name;
	float salary;
	long contact_no;
	String employeeRole;

	public Employee(int id, String name, float salary, long contact_no, String employeeRole) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.contact_no = contact_no;
		this.employeeRole = employeeRole;
	}

	public String toString() {
		return "\nEmployee Details :" + "\nID: " + this.id + "\nName: " + this.name + "\nSalary: " + this.salary
				+ "\nContact No: " + this.contact_no + "\nEmail-id: " + this.employeeRole;
	}

}

public class EmployeeManagement {
	int id;
	String name;
	float salary;
	long contact_no;
	String employeeRole;
	static ArrayList<Employee> al = new ArrayList<Employee>();

	 void display(ArrayList<Employee> al) {
		System.out.println("\n--------------Employee List---------------\n");
		System.out.println(al);
	}

	 void addEmployee() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter the following details to ADD list:\n");
		System.out.println("Enter ID :");
		id = sc.nextInt();
		System.out.println("Enter Name :");
		name = sc.next();
		System.out.println("Enter Salary :");
		salary = sc.nextFloat();
		System.out.println("Enter Contact No :");
		contact_no = sc.nextLong();
		System.out.println("Enter Employee Role :");
		employeeRole = sc.next();
		al.add(new Employee(id, name, salary, contact_no, employeeRole));
		display(al);

	}

	 void SearchEmployee() {
		System.out.println("Enter the Employee ID to search :");
		Scanner sc = new Scanner(System.in);
		id = sc.nextInt();
		int i = 0;
		for (Employee e : al) {
			if (id == e.id) {
				System.out.println(e + "\n");
				i++;
			}
		}
		if (i == 0) {
			System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
		}
	}

	 void deleteEmployee() {
		System.out.println("\nEnter Employee ID to DELETE from the Databse :");
		Scanner sc = new Scanner(System.in);
		id = sc.nextInt();
		int k = 0;
		try {
			for (Employee e : al) {
				if (id == e.id) {
					al.remove(e);
					display(al);
					k++;
				}
			}
			if (k == 0) {
				System.out.println("\nEmployee Details are not available, Please enter a valid ID!!");
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
