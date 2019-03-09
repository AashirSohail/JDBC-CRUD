import java.util.Scanner;

public class person {
	
	int id;
	String name,fname,org,mob;
	static Scanner in = new Scanner(System.in);
	
	person(int id, String name, String fname, String org, String mob){
		this.id = id;
		this.name = name;
		this.fname = fname;
		this.org = org;
		this.mob = mob;
	}
	
	static person getPerson() {
		
		System.out.print("\nEnter ID: ");
		int id = in.nextInt();
		System.out.print("Enter Name: ");
		String name = in.next();
		System.out.print("Enter Father's Name: ");
		String fname = in.next();
		System.out.print("Enter Organization: ");
		String org = in.next();
		System.out.print("Enter Mobile No: ");
		String mob = in.next();
		
		return new person(id,name,fname,org,mob);
	}
	
	static person updatePerson() {
		
		System.out.print("\nEnter ID to Update: ");
		int id = in.nextInt();
		System.out.print("Enter Name: ");
		String name = in.next();
		System.out.print("Enter Father's Name: ");
		String fname = in.next();
		System.out.print("Enter Organization: ");
		String org = in.next();
		System.out.print("Enter Mobile No: ");
		String mob = in.next();
		
		return new person(id,name,fname,org,mob);

	}
	
}
