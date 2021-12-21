package businessLogic;

import java.sql.SQLException;
import java.util.ArrayList;

public class eVoteM {
	public ArrayList<Party> p_can = new ArrayList<Party>();
	public ArrayList<Voters> v;
	int party_id;
	public eVoteM() throws ClassNotFoundException, SQLException {
		v = new ArrayList<Voters>();
		party_id=0;
		DBhandler db1=new DBhandler();
		v=db1.checkVoter();
		p_can=db1.checkParty();
		
		for(int i=0;i<p_can.size();i++) {
			party_id++;
			p_can.get(i).popCan(p_can.get(i).getID());
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public void addParty(String n) throws ClassNotFoundException, SQLException {
		DBhandler h1=new DBhandler();
		party_id++;
		Party p1=new Party(n,party_id);
		p_can.add(p1);
		h1.partyDB(p1);
	}
	
	
	public void addCnic(String n,String cnic) {
		
		v.add(new Voters(n,cnic));
		DBhandler db1=new DBhandler();
		db1.AddVoter(n,cnic,0);
	}
	
	public boolean search(String CNIC) {
		
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i).CNIC);
			if((CNIC).equals(v.get(i).CNIC)) {
				return true;
			}
			
		}
		return false;
		
	}
	
	
public boolean searchStat(String CNIC) {
		DBhandler h1=new DBhandler();
		for(int i=0;i<v.size();i++) {
			System.out.println(v.get(i).CNIC);
			if((CNIC).equals(v.get(i).CNIC)) {
				if(v.get(i).status==0) {
					v.get(i).status=1;
					h1.UpdateStatus(v.get(i).CNIC);
					
					return true;
				}
				else {
					return false;
				}
				
			}
			
		}
		return false;
		
	}
	
	
public boolean addvote(String p) throws ClassNotFoundException, SQLException {
		
		for(int i=0;i<p_can.size();i++) {
			//System.out.println(v.get(i).CNIC);
			if((p).equals(p_can.get(i).getName())) {
				p_can.get(i).getP_can().voteAdd();
				return true;
			}
			
		}
		return false;
		
	}
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		eVoteM e1=new eVoteM();
		//e1.addParty("PMLN");
		//e1.addCnic("gulsh", "166");
		 
		for(int i=0;i<e1.p_can.size();i++) {
			
			System.out.print(e1.p_can.get(i).getName());
			
		}
		
	}

}
