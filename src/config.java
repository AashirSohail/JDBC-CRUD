import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class config {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties p = new Properties();
		InputStream in = new FileInputStream(args[0]);
		p.load(in);
		
		p.getProperty("url");
		p.getProperty("username");
		p.getProperty("password");
		
		System.out.println( p.getProperty("url") +" "+ p.getProperty("username") +" "+ p.getProperty("password"));

			
	}
	
}
