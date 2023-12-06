package application;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
	private Stage stage;
	private Scene scene;
	private Parent parent;
	
	public void switchTofeed(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToRegister(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	

	
}
