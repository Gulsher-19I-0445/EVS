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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CandidateController implements Initializable {

	@FXML
	ImageView imgView;
	
	@FXML
	Text canName;
	
	@FXML
	Text PName;
	
	
	static Image image;
	public Stage appStage;
	public Scene scene;
	public Parent root;
	eVoteM e1;
	static String party;
	static String name;
	
	
	
	public CandidateController() {
		// TODO Auto-generated constructor stub
	}
	
public void partySelect(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		//id=txt1.getText();
		//System.out.print(id);
	//image = new Image("mobile.jpg");
	//myimg=new ImageView();
		
		eVoteM e1=new eVoteM();
		
		
		//e1.addCnic("Me", "87");
			if(party.equals("PMLN")) {
		
			root=FXMLLoader.load(getClass().getResource("voteCan.fxml"));
			appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			scene=new Scene(root);
			appStage.setScene(scene);
			
			appStage.show();
			
			
			}
			
			else if(party.equals("PTI")) {
				root=FXMLLoader.load(getClass().getResource("pti.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();
				
			}
			
		
	}
	
	public void voteSelect(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		//id=txt1.getText();
		//System.out.print(id);
		eVoteM e1=new eVoteM();

		//party="PTI";
		for(int i=0;i<e1.p_can.size();i++) {
		//e1.addCnic("Me", "87");
			if(party.equals(e1.p_can.get(i).getName())) {
				root=FXMLLoader.load(getClass().getResource("voteSuccess.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();
				
			e1.addvote(e1.p_can.get(i).getName());
			
			}
			
			
		}	
			
		
	}
	
	public void backtoLogin(ActionEvent e) throws IOException {
		root=FXMLLoader.load(getClass().getClassLoader().getResource("voteFx.fxml"));
		appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
		scene=new Scene(root);
		appStage.setScene(scene);
		appStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		imgView.setImage(image);
		//canName=new Text();
		canName.setText(name);
		PName.setText(party);
	}

	

}
