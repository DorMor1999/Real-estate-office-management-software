package View;

import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AddApartmentWindow extends NewWindow {

	protected Controller controller;
	private Label msg = new Label();
	private int kind = -1;
	
	public AddApartmentWindow(String windowTitle, String windowText, Controller controller) {
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
		
		Label text2 = new Label("\nEnter apartment addres:\n");
		TextField addres = new TextField();
		
		Label text3 = new Label("\nEnter the apartment area:\n");
		TextField area = new TextField();
		
		Label text4 = new Label("\nHow many rooms are there in the apartment:\n");
		TextField numOfRooms = new TextField();
		
		Label text5 = new Label("\nWhat is the agent rating for this apartment:\n");
		TextField rate = new TextField();
		
		Label text6 = new Label("\nPlease select an option:\n");
		ToggleGroup types = new ToggleGroup();
		RadioButton sale = new RadioButton("Apartment for sale");
		RadioButton regularRent = new RadioButton("Apartment for regular rent");
		RadioButton airbnbRent = new RadioButton("Apartment for airbnb rent");
		sale.setToggleGroup(types);
		regularRent.setToggleGroup(types);
		airbnbRent.setToggleGroup(types);
		
		Button submit = new Button("Submit");
		Button backToMenu = new Button("Beck to menu");
		
		VBox box = new VBox(10);
		box.getChildren().addAll(text1 , text2 ,addres,text3,area,text4,numOfRooms, text5, rate, text6,sale,regularRent,airbnbRent,submit ,backToMenu, msg);
		
		Label text7= new Label();
		TextField price = new TextField();
		Label text8 = new Label();
		TextField time = new TextField();
		
		sale.setOnAction(new EventHandler(){
			@Override
			public void handle(Event arg0) {
				
				kind = 1;
				text7.setText("\nEnter the buying price for this apartment:\n");
				if(box.getChildren().contains(text7) == false && box.getChildren().contains(price) == false) {
					box.getChildren().add(13, text7);
					box.getChildren().add(14, price);
				}
				if(box.getChildren().contains(text8) == true && box.getChildren().contains(time) == true) {
					box.getChildren().remove(text8);
					box.getChildren().remove(time);
				}
			}
		});
		
		regularRent.setOnAction(new EventHandler(){
			@Override
			public void handle(Event arg0) {
				kind = 2;
				text7.setText("\nEnter a monthly rental price:\n");
				text8.setText("\nEnter the number of months you want to rent the apartment:\n");
				if(box.getChildren().contains(text7) == false && box.getChildren().contains(price) == false) {
					box.getChildren().add(13, text7);
					box.getChildren().add(14, price);
				}
				if(box.getChildren().contains(text8) == false && box.getChildren().contains(time) == false) {
					box.getChildren().add(15, text8);
					box.getChildren().add(16, time);
				}
			}
		});
		
		airbnbRent.setOnAction(new EventHandler(){
			@Override
			public void handle(Event arg0) {
				kind = 3;
				text7.setText("\nEnter a daily rental price:\n");
				text8.setText("\nEnter the number of days you want to rent the apartment:\n");
				if(box.getChildren().contains(text7) == false && box.getChildren().contains(price) == false) {
					box.getChildren().add(13, text7);
					box.getChildren().add(14, price);
				}
				if(box.getChildren().contains(text8) == false && box.getChildren().contains(time) == false) {
					box.getChildren().add(15, text8);
					box.getChildren().add(16, time);
				}
			}
		});
		
		submit.setOnAction(new EventHandler(){
			@Override
			public void handle(Event arg0) {
				if(kind > 0 && kind < 4) {
					if(kind == 1)
						msg.setText(controller.addOneApartment(addres.getText(), area.getText(), numOfRooms.getText(), rate.getText(), price.getText(), "", kind));
					else
						msg.setText(controller.addOneApartment(addres.getText(), area.getText(), numOfRooms.getText(), rate.getText(), price.getText(), time.getText(), kind));				
				}	
				else {
					msg.setText("Please fill in all the details!");
				}
				
				if(msg.getText().equals("\nThe apartment has been successfully added to the list.\n") )
					msg.setStyle("-fx-text-fill: green;");
				else
					msg.setStyle("-fx-text-fill: red;");
			}
		});
		text1.setStyle("-fx-font-family: sample; -fx-font-size: 30;");
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
