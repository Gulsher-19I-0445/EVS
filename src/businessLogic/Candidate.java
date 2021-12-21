package businessLogic;

import java.sql.SQLException;

public class Candidate {
	private int ID;
	private int privateID;
	private String Name;
	private int vote;
	public String url;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getVote() {
		return vote;
	}

	public void setVote(int vote) {
		this.vote = vote;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getPrivateID() {
		return privateID;
	}

	public void setPrivateID(int privateID) {
		this.privateID = privateID;
	}

	public Candidate(String name,int id) {
		//DBhandler h1=new DBhandler();
		Name=name;
		privateID=id;
		vote=0;
		//h1.canDatabase(this);
		
		// TODO Auto-generated constructor stub
	}
	
	public Candidate(String name,int myid,int id,int v) {
		DBhandler h1=new DBhandler();
		Name=name;
		ID=myid;
		privateID=id;
		vote=v;
		//h1.canDatabase(this);
		
		// TODO Auto-generated constructor stub
	}
	
	
	public Candidate(String name,int myid,int id,int v, String u) {
		DBhandler h1=new DBhandler();
		Name=name;
		ID=myid;
		privateID=id;
		vote=v;
		url=u;
		//h1.canDatabase(this);
		
		// TODO Auto-generated constructor stub
	}
	
	public Candidate() {
			
		// TODO Auto-generated constructor stub
	}
	
	public void voteAdd() throws ClassNotFoundException, SQLException {
		DBhandler h1=new DBhandler();
		vote++;
		h1.UpdateVote(vote, ID);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
