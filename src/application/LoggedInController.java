package application;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class LoggedInController {
	private Stage stage;
	private Scene scene;
	private Parent parent;
	
	 @FXML
     private MediaView mediaView1;

    @FXML
     private MediaView mediaView2;
	    
	public void switchToLogin(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void switchToPost(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Content.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
	public void toProfile(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
	/**
	 * Method for gifs
	 * 
	 * --Deprecated--
	 */
//	private void initialize() {
//        // Load media files (images or gifs) for the posts
//        File mediaFile1 = new File("path/to/post1/media.gif");
//        File mediaFile2 = new File("path/to/post2/media.jpg");
//
//        // Create Media objects
//        Media media1 = new Media(mediaFile1.toURI().toString());
//        Media media2 = new Media(mediaFile2.toURI().toString());
//
//        // Set Media objects to MediaViews
//        mediaView1.setMediaPlayer(new javafx.scene.media.MediaPlayer(media1));
//        mediaView2.setMediaPlayer(new javafx.scene.media.MediaPlayer(media2));
//    }
	
}
