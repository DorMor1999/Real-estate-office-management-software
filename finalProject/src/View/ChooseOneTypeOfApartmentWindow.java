package View;

import Controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChooseOneTypeOfApartmentWindow extends NewWindow {

	protected Controller controller;
	private Label msg = new Label();
	
	public ChooseOneTypeOfApartmentWindow(String windowTitle, String windowText , Controller controller) {
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
		ToggleGroup types = new ToggleGroup();
		RadioButton sale = new RadioButton("Apartment for sale");
		RadioButton regularRent = new RadioButton("Apartment for regular rent");
		RadioButton airbnbRent = new RadioButton("Apartment for airbnb rent");
		sale.setToggleGroup(types);
		regularRent.setToggleGroup(types);
		airbnbRent.setToggleGroup(types);
		Button backToMenu = new Button("Beck to menu");
		VBox box = new VBox(10);
		box.getChildren().addAll(text,sale,regularRent,airbnbRent,backToMenu,msg);
		//radio buttons actions
		sale.setOnAction(e -> { msg.setText(controller.displayApartmentFromOneType(1)); });
		regularRent.setOnAction(e -> { msg.setText(controller.displayApartmentFromOneType(2)); });
		airbnbRent.setOnAction(e -> { msg.setText(controller.displayApartmentFromOneType(3)); });
		
		backToMenu.setOnAction(e -> { window.close(); });
		text.setStyle("-fx-font-family: sample; -fx-font-size: 30;");
		box.setPadding(new Insets(10));
		backToMenu.setPrefWidth(100);
		pane.setContent(box);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
		
	}

}
