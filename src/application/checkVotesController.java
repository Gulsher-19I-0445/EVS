package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import businessLogic.eVoteM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class checkVotesController implements Initializable {

	public Stage appStage;
	public Scene scene;
	public Parent root;
	
	@FXML
	private ListView<String>myPList;
	@FXML
	private ListView<String>myVoteList;
	eVoteM e1;
	
	public checkVotesController() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.print("helllo");
		try {
			e1=new eVoteM();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<e1.p_can.size();i++) {
			System.out.println(e1.p_can.get(i).getName());
			myPList.getItems().add(e1.p_can.get(i).getName());
			System.out.print("helllo");
		}
		
		for(int i=0;i<e1.p_can.size();i++) {
			System.out.println(e1.p_can.get(i).getName());
			myVoteList.getItems().add(String.valueOf(e1.p_can.get(i).getP_can().getVote()));
			
		}


		
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

}
