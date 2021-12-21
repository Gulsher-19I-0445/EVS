package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class NotRegController {

	public NotRegController() {
		// TODO Auto-generated constructor stub
	}
	public Stage appStage;
	public Scene scene;
	public Parent root;
	
	//@FXML
	//public Button btn;
	@FXML
	public void go_to_vote(ActionEvent e) throws IOException {
		//System.out.print("h");
		//CNIC.main(null);
		//btn.setDisable(true);
		//btn=new Button("btn");
		
		root=FXMLLoader.load(getClass().getClassLoader().getResource("voteFx.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();

	}
	
	public void go_to_help(ActionEvent e) throws IOException {
		//System.out.print("h");
		//CNIC.main(null);
		//btn.setDisable(true);
		//btn=new Button("btn");
		
		root=FXMLLoader.load(getClass().getClassLoader().getResource("Registerfx.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();

	}
	
	/*public void go_to_reg(ActionEvent e) throws IOException {
		//System.out.print("h");
		//CNIC.main(null);
		//btn.setDisable(true);
		//btn=new Button("btn");
		
		root=FXMLLoader.load(getClass().getClassLoader().getResource("signup.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();

	}*/
	
	
}