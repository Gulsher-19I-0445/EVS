package businessLogic;

public class Voters {
	String name;
	String CNIC;
	int status;
	
	public Voters(String n,String cnic) {
		name=n;
		this.CNIC=cnic;
		status=0;
	}
	
	public Voters(String n,String cnic,int s) {
		name=n;
		this.CNIC=cnic;
		status=s;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
