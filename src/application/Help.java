package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Help{
	
	public Stage appStage;
	public Scene scene;
	public Parent root;
	
	public Stage appStage1;
	public Scene scene1;
	public Parent root1;
	
	@FXML
	public Button btn;
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
		
		//appStage=(Stage)btn.getScene().getWindow();
       /*Stage primaryStage=new Stage();
		
		FXMLLoader loader = new FXMLLoader();
        // Path to the FXML File
        String fxmlDocPath = "C:\\Users\\gulsh\\eclipse-workspace\\Voting\\src\\application\\voteFx.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
         
        // Create the Pane and all Details
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
         
        // Create the Scene
        Scene scene = new Scene(root);
        // Set the Scene to the Stage
        primaryStage.setScene(scene);
        // Set the Title to the Stage
        primaryStage.setTitle("A SceneBuilder Example");
        // Display the Stage
        primaryStage.show();	*/
		
		 
		
	}
	
	@FXML
	public void go_to_preg(ActionEvent e) throws IOException {
		//System.out.print("h");
		//CNIC.main(null);
		//btn.setDisable(true);
		//btn=new Button("btn");
		
		root=FXMLLoader.load(getClass().getClassLoader().getResource("registerParty.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();
		
		
		 
		
	}
	
	
	
	
	

}
