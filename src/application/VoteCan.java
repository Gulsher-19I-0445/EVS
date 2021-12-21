package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class VoteCan {

	public Stage appStage;
	public Scene scene;
	public Parent root;
	String id;
	@FXML
	public TextField txt1;
	@FXML
	public Button pmln;
	
	public void votePMLN(ActionEvent e) throws IOException {
		
		
		
		root=FXMLLoader.load(getClass().getResource("Vote_party.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();
		
	}

}
