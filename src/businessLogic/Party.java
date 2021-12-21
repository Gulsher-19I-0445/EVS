package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

public class Party {
	private int ID;
	private String Name;
	private Candidate p_can;
	//ArrayList<Candidate> p_can = new ArrayList<Candidate>();
	public Party(String name,int id) throws ClassNotFoundException, SQLException {
		DBhandler h1=new DBhandler();
		
		Name=name;
		ID=id;
		//Candidate temp=h1.checkCan();
		//if(temp.getPrivateID()==this.ID) {
			//p_can=temp;
		//}
		//h1.partyDB(this);
		// TODO Auto-generated constructor stub
	}
	
	public void popCan(int id) throws ClassNotFoundException, SQLException {
		DBhandler h1=new DBhandler();
		
		//Name=name;
		//ID=id;
		ArrayList<Candidate> temp=h1.checkCan();
		for(int i=0;i<temp.size();i++) {
			if(temp.get(i).getPrivateID()==this.ID) {
				p_can=temp.get(i);
				System.out.println("Can is"+p_can.getPrivateID()+"This");
			}
		}
	}
	
	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	/*public ArrayList<Candidate> getP_can() {
		return p_can;
	}


	public void setP_can(ArrayList<Candidate> p_can) {
		this.p_can = p_can;
	}*/


	public int getID() {
		return ID;
	}


	public Candidate getP_can() {
		return p_can;
	}


	public void setP_can(Candidate p_can) {
		this.p_can = p_can;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public void addCandidate(String name,String url) {
		DBhandler h1=new DBhandler();
		//p_can.add(new Candidate(name));
		p_can=new Candidate(name,this.ID,this.ID,0,url);
		h1.canDatabase(p_can);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
