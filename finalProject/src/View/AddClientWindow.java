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

public class AddClientWindow extends NewWindow {

	protected Controller controller;
	private Label msg = new Label();
	
	public AddClientWindow(String windowTitle, String windowText, Controller controller) {
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
		Label text1 = new Label(windowText);
		TextField addres = new TextField();
		Label text2 = new Label("\nEnter the client full name:\n");
		TextField fullName = new TextField();
		Label text3 = new Label("\nEnter the client phone number:\n");
		TextField phoneNumber = new TextField();
		Button submit = new Button("Submit");
		Button backToMenu = new Button("Beck to menu");
		VBox box = new VBox(10);
		box.getChildren().addAll(text1,addres,text2,fullName,text3,phoneNumber,submit,backToMenu,msg);
		submit.setOnAction(e -> {
			msg.setText(controller.addClientToApartment(addres.getText(), fullName.getText(), phoneNumber.getText()));
			if(msg.getText().equals("\nClient successfully added\n") )
				msg.setStyle("-fx-text-fill: green;");
			else
				msg.setStyle("-fx-text-fill: red;");
		});
		text1.setStyle("-fx-font-family: sample; -fx-font-size: 20;");
		submit.setPrefWidth(100);
		box.setPadding(new Insets(10));
		backToMenu.setPrefWidth(100);
		backToMenu.setOnAction(e -> { window.close(); });
		pane.setContent(box);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		
		
	}

}
