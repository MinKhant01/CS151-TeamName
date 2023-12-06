module FX {
	requires javafx.controls;
	requires java.sql;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.media;
	
	opens application to javafx.graphics, javafx.fxml;
}
