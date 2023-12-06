package application;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class PostController {
	private Stage stage;
	private Scene scene;
	private Parent parent;
	
	@FXML
	private TextArea commentArea;
	
	@FXML
	private TextArea postArea;
	
	@FXML
    private VBox imageContainer; 
	
	@FXML
	private VBox postContainer;
	
	public void goBack(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	/**
	 * Method for uploading gifs/photos to both post and comments to comments
	 * 
	 * @param event
	 */
	@FXML
    public void uploadImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image or GIF");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            // Display the selected image/GIF in the comment area
            Image newImage = new Image(selectedFile.toURI().toString());
            commentArea.insertText(commentArea.getCaretPosition(), "![Image](file:" + selectedFile.getAbsolutePath() + ")\n");

            // Dynamically allocate an ImageView and add it to the VBox
            ImageView imageView = new ImageView(newImage);
            imageView.setFitHeight(200);
            imageView.setFitWidth(400);
            imageContainer.getChildren().add(imageView);
        }
    }
	
	/**
	 * Method for uploading gifs/photos to both post and comments to post
	 * 
	 * @param event
	 */
	
	public void uploadGifImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Image or GIF");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(((Node) event.getSource()).getScene().getWindow());

        if (selectedFile != null) {
            // Display the selected image/GIF in the comment area
            Image newImage = new Image(selectedFile.toURI().toString());
            postArea.insertText(postArea.getCaretPosition(), "![Image](file:" + selectedFile.getAbsolutePath() + ")\n");

            // Dynamically allocate an ImageView and add it to the VBox
            ImageView imageView = new ImageView(newImage);
            imageView.setFitHeight(200);
            imageView.setFitWidth(400);
            postContainer.getChildren().add(imageView);
        }
    }
	

	
}
