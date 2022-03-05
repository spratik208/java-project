package gymManagement;

import java.util.Scanner;

public class MainGymManagement {
	Scanner sc = new Scanner(System.in);
	MainGymManagement() {
		System.out.println("============================================================================================");
		System.out.println("Welcome to the Metro Fitness Gym Management App");
		System.out.println("============================================================================================");
	}
	
	void login() {
		System.out.println("Enter the Admin ID:");
		String ID= sc.nextLine();
		if(ID.equals("Suraj"))
		{
			System.out.println("Enter the Password");
			
			String Pass= sc.nextLine();
			if(Pass.equals("12345"))
			{
				System.out.println();
			 System.out.println("You Have Succesfully Logged in into App");
			 System.out.println();
			}
			else
			{
				System.out.println("You have Entered a Wrong password \nPlease Restart the App");
				System.exit(0);
			}
		}
		else {
			System.out.println("You Have entered Wrong Admin Id\nPlease Restart the App");
			 System.exit(0);
		}
		
	}


	public static void main(String[] args) {
		MainGymManagement MG1 = new MainGymManagement();
		MemberManagement M1 = new MemberManagement();
		MG1.login();
		int choice;
		int Fchoice;
		do {
			Scanner sc = new Scanner(System.in);
			System.out.println("============================================================================================");
			System.out.println("1. Member Management");
			System.out.println("2. Employee Management");
			System.out.println("3. Gym Material and Stock Management");
			System.out.println("0. Exit Gym management App");
			System.out.println("============================================================================================");
			System.out.println("Enter the Choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				System.out.println("Welcome to the Gym Member Management System");
				do {
					System.out.println("=========================================================");
					System.out.println("1. Add Gym Member");
					System.out.println("  --> inside Add member");
					System.out.println("  --> I. Package of member And Payment");
					System.out.println("  --> II. Diet Plan of member Aaccording to weight");
					System.out.println("2. Remove Gym Member");
					System.out.println("3. Print the List of Members with all details in text file");
					System.out.println("  --> inside  Print the List of Members");
					System.out.println("  --> I. Sorting of members");
					System.out.println("  --> II. Writing Data into Text File");
					System.out.println("4. Display List With all the Above details");
					System.out.println("0. Exit from Member Management ");
					System.out.println("=========================================================");

					System.out.println("Enter the Choice For Member Information");

					Fchoice = sc.nextInt();

					switch (Fchoice) {

					case 1: {

						M1.head = new Node();
						char addchoice;
						do {
							System.out.println("Again if you want to add member if yes type y otherwise no");
							addchoice = sc.next().charAt(0);
							if (addchoice == 'N')
								break;
							else
								M1.AddMember();
						} while (addchoice != 'N');
						break;
					}
					case 2 : 
					{
						System.out.println("Enter the Member name to which delete from Linked list");
						String Name = sc.nextLine();
						M1.RemoveMember(Name);
						break;
					}
					
					case 3 :
					{
						M1.memberSorting();
						M1.fileWriter();
						break;
					}
					
					case 5: 
					{
						M1.memberSorting();
						M1.DisplayMember();
						break;
					}

					}
				} while (Fchoice != 0);

			}
			case 2:
			{
				EmployeeManagement e = new EmployeeManagement();
				do {
					System.out.println("\n*********Welcome to the Employee Management System**********\n");
					System.out.println(
							"1). Add Employee to the Gym\n" + "2). Search for Employee\n" + "3). Delete Employee Details\n"
									+ "5). Display all Employees working in this GYM\n" + "6). EXIT\n");
					System.out.println("Enter your choice : ");
					int ch = sc.nextInt();

					switch (ch) {
					case 1: {
						e.addEmployee();
						break;
					}
					case 2: {
						e.SearchEmployee();
						break;
					}

					case 3: {
						e.deleteEmployee();
						break;
					}
					case 4: {
						e.display(EmployeeManagement.al);
					}

					case 6: {
						System.out.println("\nYou have chosen EXIT !! Saving Files and closing the tool.");
						sc.close();
						System.exit(0);
						break;
					}
					default:
						System.out.println("\nEnter a correct choice from the List :");
						break;

					}
				} while (true);

			}
			}
			
		} while (choice != 0);
	}
}
