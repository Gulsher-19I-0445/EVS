package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import businessLogic.eVoteM;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class voteController implements Initializable {
	
	public Stage appStage;
	public Scene scene;
	public Parent root;
	
	@FXML
	private ListView<String>myList;
	
	@FXML
	private Label myLabel;
	
	eVoteM e1;
	String party;
	
	
	public voteController() {
		// TODO Auto-generated constructor stub
	}
	//String[]f= {"hello","world"};
	
	
	
	
	//eVoteM e1=new eVoteM();
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(myList!=null) {
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
			myList.getItems().add(e1.p_can.get(i).getName());
			
		}
		
		myList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				// TODO Auto-generated method stub
				party=myList.getSelectionModel().getSelectedItem();
				CandidateController.party=party;
				myLabel.setText(party);
			}
		
		});
		
		}
		//myList.getItems().addAll(f);
		
		
		
	}
	
	public void partySelect(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		//id=txt1.getText();
		//System.out.print(id);
		
		eVoteM e1=new eVoteM();
		//e1.addCnic("Me", "87");
		for(int i=0;i<e1.p_can.size();i++) {	
			if(party.equals(e1.p_can.get(i).getName())) {
				//new Image("k.jpg");
				if(getClass().getResource(e1.p_can.get(i).getP_can().url)!=null){
				CandidateController.image=new Image(getClass().getResource(e1.p_can.get(i).getP_can().url).toExternalForm());
				}
				CandidateController.name=e1.p_can.get(i).getP_can().getName();
				//CandidateController.canName=new Text();
				//CandidateController.canName.setText(party);
				root=FXMLLoader.load(getClass().getResource("voteCan.fxml"));
				appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
				scene=new Scene(root);
				appStage.setScene(scene);
				appStage.show();
			
			}
			
		}
		
	}
	
/*public void voteSelect(ActionEvent e) throws IOException, ClassNotFoundException, SQLException {
		
		//id=txt1.getText();
		//System.out.print(id);
		
		eVoteM e2=new eVoteM();
		//eVoteM e1=new eVoteM();
		for(int i=0;i<e1.p_can.size();i++) {
		//e1.addCnic("Me", "87");
			if(party.equals(e2.p_can.get(i).getName())) {
			//root=FXMLLoader.load(getClass().getResource("voteCan.fxml"));
			//appStage=(Stage)((Node)e.getSource()).getScene().getWindow();
			//scene=new Scene(root);
			//appStage.setScene(scene);
			//appStage.show();
			e2.addvote(e2.p_can.get(i).getName());
			
			}
			
			
		}
			
		
	}*/
	
	
	
	
	
	

}
