import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class m {
	
	static int id, mob;
	static String name,fname,org;
	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) throws IOException, SQLException{
		
		Properties p = new Properties();
		InputStream in = new FileInputStream(args[0]);
		p.load(in); 
		
		p.getProperty("url");
		p.getProperty("username");
		p.getProperty("password");
		
		System.out.println( p.getProperty("url") +" "+ p.getProperty("username") +" "+ p.getProperty("password"));
		
		new connect(p);
		
		getChoice();

	}
	public static void getChoice() throws SQLException {
		
		handler query = new handler();
		int choice= 0;
		
		while(true) {
		
		System.out.print("\n[1] Add [2] Update [3] Delete\n[4] Get Info [5] Exit Program\nYour Choice:");
		choice = in.nextInt();
		
		switch(choice) {
		
		case 1:	query.store(person.getPerson()); continue;
		
		case 2: query.update(person.updatePerson()); continue;
	
		case 3: System.out.print("Enter ID to Delete: ");
				id = in.nextInt();
				query.delete(id); continue;
			
		case 4: System.out.print("Enter ID for Info: ");
				id = in.nextInt();
				query.getInfo(id); continue;
		
		case 5: break;
				
		default: System.out.println("Enter a valid choice.\n"); continue;
		}
		
		}
		
	} 

}
