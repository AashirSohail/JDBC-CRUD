import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class handler {    
	
	String username;
	String url;
	String password;
	Connection connection;
	PreparedStatement stmt ;
	ResultSet rs ;
	
	public handler() throws SQLException {
		 
		connection = connect.returnConnection();
		//stmt = connect.returnStatement();
		boolean p = connection.isValid(100);
		System.out.println("Connection Established: "+ p);
	}
	 
	
	public void store(person p) throws SQLException
	{
		
		System.out.println("Added ID: "+p.id + " Name: " +p.name+" Fname: "+p.fname+" Org: "+p.org+" Mob: "+p.mob);

		
		stmt = connection.prepareStatement("INSERT INTO orgDB(id, name, fname, org, mob) VALUES (?, ?, ?, ?, ?)");
		
		stmt.setInt(1, p.id);
		stmt.setString(2, p.name);
		stmt.setString(3, p.fname);
		stmt.setString(4, p.org);
		stmt.setString(5, p.mob);

		if(stmt.executeUpdate() == 0) {
			System.out.println("Couldn't Add to database.");
		} 
		
	}
	//
	public void update( person p) throws SQLException {
		
		
		String query = "update orgDB set name = ?, fname = ?, org = ?, mob = ? where id = ?";
		stmt = connection.prepareStatement(query);
		
			
			stmt.setString(1, p.name);
			stmt.setString(2, p.fname);
			stmt.setString(3, p.org);
			stmt.setString(4, p.mob);
			stmt.setInt(5, p.id);
			stmt.executeUpdate(); 
			
			if(stmt.executeUpdate() == 0) {
	        	
	        	System.out.println("Invalid ID can't delete.");
	        	
	        }
			else
				System.out.println("Updated ID: "+p.id + " Name: " +p.name+" Fname: "+p.fname+" Org: "+p.org+" Mob: "+p.mob);

		
	}
	//
	public void delete(int id) throws SQLException {
		
		stmt = connection.prepareStatement("delete from orgDB where id = ?");
        stmt.setInt(1, id);
        if(stmt.executeUpdate() == 0) {
        	
        	System.out.println("Invalid ID can't delete.");
        	
        }
        else
			System.out.println("DeletedID: "+id);

		
	}
	
	public void getInfo(int id) throws SQLException {
		
		stmt = connection.prepareStatement("SELECT * FROM orgDB WHERE id = ?");
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

		if(rs.next()) {
			System.out.println("Info: ID: "+rs.getInt("id")+" Name: "+rs.getString("name")+" Father's Name: "+rs.getString("fname")+" Organization: "+rs.getString("org")+" Mobile: "+rs.getInt("mob")+"");	
		}
		else {
			System.out.println("Invalid ID.");
		}
		
	}
	
	
}
