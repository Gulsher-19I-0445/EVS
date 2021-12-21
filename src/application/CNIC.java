package application;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CNIC extends Application {

	public CNIC() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(Stage arg0) throws Exception {
		
		try {
			 FXMLLoader loader = new FXMLLoader();
		        // Path to the FXML File
		        String fxmlDocPath = "C:\\Users\\gulsh\\eclipse-workspace\\Voting\\src\\voteFx.fxml";
		        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		         
		        // Create the Pane and all Details
		        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
		         
		        // Create the Scene
		        Scene scene = new Scene(root);
		        // Set the Scene to the Stage
		        arg0.setScene(scene);
		        // Set the Title to the Stage
		        arg0.setTitle("A SceneBuilder Example");
		        // Display the Stage
		        arg0.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);

	}

}
