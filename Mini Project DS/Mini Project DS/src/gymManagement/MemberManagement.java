package gymManagement;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Node {
	Node next;
	String Name;
	long mobileNo;
	String Address;
	String Package;
	int Attendance;
	String dietPlan;
	MemberManagement M1 = new MemberManagement();

	Node() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the Member");
		Name = sc.nextLine();

		try {
			System.out.println("Enter the Mobile Number");
			mobileNo = sc.nextLong();
		} catch (Exception e) {
			System.out.println("You have entered a Wrong Number");
			return;
		}
		sc.nextLine();
		System.out.println("Ënter the Address of Member");
		Address = sc.nextLine();

		Package = M1.PackageOfGymForMember();
		dietPlan= M1.DietPlanForMember();
	}

	public String toString() {
		System.out.println("=========================================================");
		return "" + " Name of the Member is :" + Name + "\n" + " Mobile Number of the Member is :" + mobileNo + "\n"
				+ " Address of Member is " + Address + "\n"+Package
				+"\n"+dietPlan+ "\n=========================================================\n";
	}
}

	

public class MemberManagement {

	Node head;
	Scanner sc = new Scanner(System.in);

	int countEle() {
		Node temp = head;
		int count = 0;

		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}

	void AddMember() {
		Node new_node = new Node();

		if (head == null) {
			head = new_node;
		} else {
			Node n = head;
			while (n.next != null) {
				// System.out.println(n.data);
				n = n.next;
			}
			n.next = new_node;
		}
	}

	void RemoveMember(String Name) {

		// Store head node
		Node temp = head, prev = null;

		// If head node itself holds the key to be deleted
		if (temp != null && temp.Name.equals(Name)) {
			head = temp.next; // Changed head
			return;
		}

		// Search for the key to be deleted, keep track of
		// the previous node as we need to change temp.next
		while (temp != null && !temp.Name.equals(Name)) {
			prev = temp;
			temp = temp.next;
		}

		// If key was not present in linked list
		if (temp == null)
			return;

		// Unlink the node from linked list
		prev.next = temp.next;
	}

	void DisplayMember() {
		System.out.println("Gym Member List is as Follows");
		Node n = head;
		while (n != null) {
			System.out.println(n);
			n = n.next;
		}
	}

	void AttendanceOFMember() {
		Node n = head;
		int count = countEle();

	}

	String PackageOfGymForMember() {
		int choice;

		do {
			System.out.println(" Packages for Gym membership ");
			System.out.println("1. Monthly Plan");
			System.out.println("2. Quaterly Plan");
			System.out.println("3. Half yearly Plan");
			System.out.println("4. Yearly Plan");
			System.out.println("0. Exit");
			choice = sc.nextInt();
			switch (choice) {
			case 1: {
				return "You have Enrolled for Monthly plan" + "\n Your payment of RS 1000 is successfully Done";

			}
			case 2: {
				return "You have Enrolled for Quaterly plan" + "\n Your payment of RS 2500 is successfully Done";

			}
			case 3: {
				return "You have Enrolled for Half yearly plan" + "\n Your payment of RS 4500 is successfully Done";
			}
			case 4: {
				return "You have Enrolled for Yearly plan" + "\n Your payment of RS 8000 is successfully Done";
			}
			default:
				return "You have entered a Wrong Option";
			}
		} while (choice != 0);

	}

	String DietPlanForMember() {
		int choice;
			System.out.println("Enter the Weight for the Diet Plan");
			choice = sc.nextInt();
		if(choice >=40 && choice<=60) {
				return " breakfast:2 cup of milk, 2 slices of bread with peanut butter and a handful of mixed nuts.\n"
						+ "lunch: 250 grams of chicken breast, a portion of salad, 1 bowl of dal, 1 bowl of curd and lots of vegetables.\n"
						+ "My dinner: 250 grams of boiled chicken, a portion of beans and protein shake.\n";

			}
		else if(choice >=60 && choice<=80) {
				return "Breakfast: 3-4 almonds, upma/poha and one glass of milk without sugar\n"
						+ "Lunch: 1 chapatis with boiled dal, one bowl of vegetable salad.\n"
						+ "Dinner: 250 grams of boiled chiken / Boiled dal with one chapati, paneer or tofu and green salad \n";

			}
		else if(choice >=80 && choice<=95) {
				return "Breakfast: No parathas, only one chapatti (no ghee) and a single egg omelette.\n "
						+ "Lunch: two pieces of vada or half a plate of Chow Mein (four small pieces of chicken).\n "
						+ "Sugar-free tea in the evenings with dry grams.\n"
						+ "Dinner: one cup of rice, dal and lots of vegetables.\n "
						+ "On Sundays, I eat a piece of either fish or chicken.\n";
			}
		else if(choice >=95 && choice <150){
				return "Breakfast: Prefer to have poha or upma in breakfast with 4 boiled egg whites andcup of green tea in between breakfast and lunch.\n"
						+ "My lunch: Two chapatis, a portion of sabzi and salad.\n"
						+ "My snacks: Dry fruits (almonds, walnuts and cashews) and a glass of fruit juice.\n"
						+ "My dinner: Grilled paneer or roasted chicken or 1 chapatti with sabzi.\n";
			}
		else {
			return "You have either a child or above 150 weight ";
		}

	}

	void fileWriter() {

		Node n = head;
		try {
			FileWriter fWriter = new FileWriter("F:\\CDAC Main Course\\Module 3\\Gym Management\\demo.txt");
			while (n != null) {

				fWriter.write(n.toString());

				n = n.next;
			}
			fWriter.close();
		} catch (IOException e) {
			System.out.print(e.getMessage());
		}
		System.out.println("File is created successfully with the content.");
		
		DisplayMember();
	}
	
	
	 void memberSorting()
	 {
	       Node current = head, index = null;
	       
	        String temp;
	 
	        if (head == null) {
	            return;
	        }
	        else {
	            while (current != null) {
	                // Node index will point to node next to
	                // current
	                index = current.next;
	 
	                while (index != null) {
	                    // If current node's data is greater
	                    // than index's node data, swap the data
	                    // between them
	                    if (current.Name.compareTo(index.Name)>1) {
	                        temp = current.Name;
	                        current.Name = index.Name;
	                        index.Name = temp;
	                    }
	 
	                    index = index.next;
	                }
	                current = current.next;
	            }
	        }
	    }
	 }



