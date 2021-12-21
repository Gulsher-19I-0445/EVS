package application;

import java.io.IOException;
import java.sql.SQLException;

import businessLogic.eVoteM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogIn {

	public Stage appStage;
	public Scene scene;
	public Parent root;
	String id;
	@FXML
	public TextField txt1;
	
	@FXML
	public void LoggedIn(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
			id=txt1.getText();
			System.out.print(id);
			
			eVoteM e1=new eVoteM();
			//e1.addCnic("Me", "87");
			boolean x=e1.search(id);
			boolean y=false;
			if(x==true) {
			y=e1.searchStat(id);
			}
			if(x==true&&y==true) {
				root=FXMLLoader.load(getClass().getResource("Vote_party.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();
			}
			else if(x==true&&y==false) {
				root=FXMLLoader.load(getClass().getResource("casted.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();
			}
			
			else {
				root=FXMLLoader.load(getClass().getResource("Notreg.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();	
			}
			
			
		
		
		
		
	}
	public void checkV(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
			
			root=FXMLLoader.load(getClass().getResource("checkvotes.fxml"));
			appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			appStage.setScene(scene);
			appStage.show();
			//System.out.print("helllo");
		
		
	
	
	
	
}
	public void regV(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		
		root=FXMLLoader.load(getClass().getResource("signup.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();
		//System.out.print("helllo");
	
	




	}
	
	public void back(ActionEvent e) throws IOException {
		
		root=FXMLLoader.load(getClass().getResource("Registerfx.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();
		
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
