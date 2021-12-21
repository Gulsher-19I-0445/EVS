package application;
	
import java.io.FileInputStream;
import java.sql.SQLException;

import businessLogic.Candidate;
import businessLogic.eVoteM;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	public eVoteM e;
	public Main() throws ClassNotFoundException, SQLException {
		e=new eVoteM();
		
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			 FXMLLoader loader = new FXMLLoader();
		        // Path to the FXML File
		        String fxmlDocPath = "src\\application\\Registerfx.fxml";
		        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		         
		        // Create the Pane and all Details
		        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
		         
		        // Create the Scene
		        Scene scene = new Scene(root);
		        // Set the Scene to the Stage
		        primaryStage.setScene(scene);
		        // Set the Title to the Stage
		        primaryStage.setTitle("Electronic Voting Machine");
		        // Display the Stage
		        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addVote(Candidate c) throws ClassNotFoundException, SQLException {
		
		c.voteAdd();
		
	}
	
	
	public static void main(String[] args) {
		//Main m1=new Main();
		//m1.e.addParty("PMLN");
		//m1.e.p_can.get(0).addCandidate("h");
		launch(args);
	}
}
