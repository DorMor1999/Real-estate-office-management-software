package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MostExpensiveApartmentRentWindow extends NewWindow {

	protected Controller controller;
	private Label msg = new Label();
	
	public MostExpensiveApartmentRentWindow(String windowTitle, String windowText,Controller controller) {
		super(windowTitle, windowText);
		this.controller = controller;
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
		TextField time = new TextField();
		Button submit = new Button("Submit");
		Button backToMenu = new Button("Beck to menu");
		VBox box = new VBox(10);
		box.getChildren().addAll(text,time,submit,backToMenu,msg);
		
		submit.setOnAction(e -> { 
			msg.setText(controller.showMostExpensiveMenue(time.getText()));
			if(msg.getText().equals("\nThis is not a integer!\n") || msg.getText().equals("\nNumber of months must be a positive integer!\n"))
				msg.setStyle("-fx-text-fill: red;");
			else
				msg.setStyle("-fx-text-fill: green;");
		});
		
		
		backToMenu.setOnAction(e -> { window.close(); });
		text.setStyle("-fx-font-family: sample; -fx-font-size: 15;");
		submit.setPrefWidth(100);
		box.setPadding(new Insets(10));
		backToMenu.setPrefWidth(100);
		pane.setContent(box);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
