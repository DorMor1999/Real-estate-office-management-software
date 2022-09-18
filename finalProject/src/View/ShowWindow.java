package View;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowWindow extends NewWindow {

	public ShowWindow(String windowTitle, String windowText) {
		super(windowTitle, windowText);
	}
	
	@Override
	public void display() {
		
		
		ScrollPane pane = new ScrollPane();
		Stage window = new Stage();
		window.setWidth(600);
		window.setHeight(500);
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(windowTitle);
		Label text = new Label(windowText);
		Button backToMenu = new Button("Beck to menu");
		VBox box = new VBox(10);
		box.getChildren().addAll(text,backToMenu);
		backToMenu.setOnAction(e -> { window.close(); });
		pane.setContent(box);
		text.setStyle("-fx-font-family: sample; -fx-font-size: 15;");
		box.setPadding(new Insets(10));
		backToMenu.setPrefWidth(100);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
	}

}
