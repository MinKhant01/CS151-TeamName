package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.Optional;

public class ProfileController {

 @FXML
 private ImageView profileImageView;

 @FXML
 private Label usernameLabel;

 public ProfileController() {
     
     // can be used to call to user data
     
 }

 @FXML
 public void changeProfilePicture(ActionEvent event) {
     FileChooser fileChooser = new FileChooser();
     fileChooser.setTitle("Choose Profile Picture");
     fileChooser.getExtensionFilters().add(
             new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
     );

     File selectedFile = fileChooser.showOpenDialog(profileImageView.getScene().getWindow());

     if (selectedFile != null) {
         // Update the profile picture
         Image newImage = new Image(selectedFile.toURI().toString());
         profileImageView.setImage(newImage);

         
         // For now, we'll just display a message
         showAlert("Profile Picture Changed", "Profile picture has been updated.");
     }
 }

 @FXML
 public void editProfile() {
     // Logic for handling the "Edit Profile" button action
     showAlert("Edit Profile", "Edit Profile button clicked");
 }

 @FXML
 public void changePassword() {
     // Logic for handling the "Change Password" button action
     showAlert("Change Password", "Change Password button clicked");
 }

 public void showAlert(String title, String content) {
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle(title);
     alert.setHeaderText(null);
     alert.setContentText(content);
     alert.showAndWait();
 }
}

