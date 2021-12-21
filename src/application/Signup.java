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

public class Signup {
	
	@FXML
	TextField name;
	
	@FXML
	TextField cnic;
	public Stage appStage;
	public Scene scene;
	public Parent root;
	
	
	public Signup() {
		// TODO Auto-generated constructor stub
	}
	
	public void sign(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		
		eVoteM e1=new eVoteM();
		boolean x=e1.search(cnic.getText());
		
		if(x) {
			
			root=FXMLLoader.load(getClass().getResource("alreadyReg.fxml"));
			appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			appStage.setScene(scene);
			appStage.show();
			
		}
		else if(!x) {
			
			e1.addCnic(name.getText(), cnic.getText());
			
			root=FXMLLoader.load(getClass().getResource("regcomp.fxml"));
			appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			appStage.setScene(scene);
			appStage.show();
			
			
		}
		
		
	}
	
	

}
