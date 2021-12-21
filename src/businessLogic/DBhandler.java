package businessLogic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBhandler {

	public DBhandler() {
		// TODO Auto-generated constructor stub
	}
	
	public void partyDB(Party p) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO party(id,name) VALUES (?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,p.getID());
			//statement.setInt(1,p.getPrivateID());
			statement.setString(2,p.getName());
			
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}

	public void canDatabase(Candidate c) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO candidate(id,party_id,name,votes,url) VALUES (?,?,?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setInt(1,c.getID());
			statement.setInt(2,c.getPrivateID());
			statement.setString(3,c.getName());
			statement.setInt(4, c.getVote());
			statement.setString(5, c.url);
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	}
	
	public void UpdateVote(int vote,int MyID) throws SQLException, ClassNotFoundException {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		String sql="UPDATE candidate SET votes =? WHERE id=?";
		PreparedStatement statement= con.prepareStatement(sql);
		statement.setInt(2, MyID);
		statement.setInt(1, vote);
		statement.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}
	
	public void AddVoter(String n,String c,int stat) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver successfully loaded");
			
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
			System.out.println("Connection Established");
			
			String sql="INSERT INTO voters(name,CNIC,status) VALUES (?,?,?)";
			PreparedStatement statement=con.prepareStatement(sql);
			statement.setString(1,n);
			//statement.setInt(1,p.getPrivateID());
			statement.setString(2,c);
			statement.setInt(3,stat);
			
			statement.executeUpdate();
			//int i=statement.executeUpdate();
			//con.commit();
			con.close();
			
			
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
		
	}
	
	public ArrayList<Voters> checkVoter() throws ClassNotFoundException, SQLException {
		
		ArrayList<Voters>temp=new ArrayList<Voters>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver successfully loaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("Connection Established");
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from voters");
		
		while(rs.next()) {
			String name=rs.getString("name");
			String cnic=rs.getString("CNIC");
			//System.out.println(cnic);
			int s=rs.getInt("status");
			temp.add(new Voters(name,cnic,s));
		}
		return temp;
		
	}
	
	public ArrayList<Party> checkParty() throws ClassNotFoundException, SQLException {
		
		ArrayList<Party>temp=new ArrayList<Party>();
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver successfully loaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("Connection Established");
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from party");
		
		while(rs.next()) {
			
			int id=rs.getInt("id");
			String name=rs.getString("name");
			System.out.println(name);
			//int s=rs.getInt("status");
			temp.add(new Party(name,id));
		}
		return temp;
		
	}
	
public ArrayList<Candidate> checkCan() throws ClassNotFoundException, SQLException {
		
		ArrayList<Candidate>temp=new ArrayList<Candidate>();
		//Candidate temp=null;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("Driver successfully loaded");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		System.out.println("Connection Established");
		
		Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("select * from candidate");
		
		while(rs.next()) {
			
			int id=rs.getInt("id");
			int P_ID=rs.getInt("PARTY_ID");
			String Name=rs.getString("Name");
			int votes=rs.getInt("votes");
			String myUrl=rs.getString("url");
			System.out.println(myUrl);
			//int s=rs.getInt("status");
			temp.add(new Candidate(Name,id,P_ID,votes,myUrl));
		}
		return temp;
		
	}

public void UpdateStatus(String id) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","1234");
		String sql="UPDATE voters SET status =? WHERE CNIC=?";
		PreparedStatement statement= con.prepareStatement(sql);
		statement.setInt(1, 1);
		statement.setString(2, id);
		statement.executeUpdate();
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver not loaded");
		}
		
		catch(SQLException e) {
			System.out.println("Connection Failed");
		}
	
	
}
	
	
	

}
