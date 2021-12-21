package application;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

//import javax.swing.Action;

import businessLogic.eVoteM;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;

public class RegisterPartyController {
	@FXML
	TextField pname;
	
	@FXML
	TextField cname;
	@FXML
	Button reg;
	public Stage appStage;
	public Scene scene;
	public Parent root;
	String myurl;
	public RegisterPartyController() {
		// TODO Auto-generated constructor stub
	}
	
	public void addpic(ActionEvent e) {
	
		FileChooser fc=new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Image files","*.png","*.jpg"));
		File f=fc.showOpenDialog(null);
		if(f!=null) {
			System.out.println("Path is:"+ f.getAbsolutePath());
			myurl=f.getName();
			reg.setDisable(false);
		}
		
		
	}
	
	public void create(ActionEvent e) throws ClassNotFoundException, SQLException, IOException {
		
		eVoteM e1=new eVoteM();
		System.out.println("xd");
		e1.addParty(pname.getText());
		for(int i=0;i<e1.p_can.size();i++) {
			if(e1.p_can.get(i).getName().equals(pname.getText())) {
				e1.p_can.get(i).addCandidate(cname.getText(),myurl);
			}
		}
		
		root=FXMLLoader.load(getClass().getResource("reg_success.fxml"));
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
	
	
	

}
