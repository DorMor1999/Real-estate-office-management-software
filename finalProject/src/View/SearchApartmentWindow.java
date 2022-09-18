package View;



import Controller.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SearchApartmentWindow extends NewWindow {
	
	protected Controller controller;
	private Label msg = new Label();
	private String[] options = new String[4];

	public SearchApartmentWindow(String windowTitle, String windowText , Controller controller ) {
		super(windowTitle, windowText);
		this.controller = controller;
		this.options[0] = "\nEnter the addres of the apartment you want to see the price for period time:\n";
		this.options[1] = "\nEnter the addres of the apartment you want to see the inrested clients:\n";
		this.options[2] = "\nEnter the addres of the apartment you want to see the inrested clients(Sorted by name):\n";
		this.options[3] = "\nEnter the addres of the apartment you want to create copy:\n";
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
		TextField addres = new TextField();
		Button submit = new Button("Submit");
		Button backToMenu = new Button("Beck to menu");
		VBox box = new VBox(10);
		box.getChildren().addAll(text,addres,submit,backToMenu,msg);
		//submit click
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if(text.getText() == options[0])
					msg.setText(controller.showPriceForPeriodTimeParticularApartment(addres.getText()));
				else if (text.getText() == options[1])
					msg.setText(controller.showAllClientsParticularApartment(addres.getText()));
				else if (text.getText() == options[2])
					msg.setText(controller.showAllClientsParticularApartmentSortedByName(addres.getText()));
				else if (text.getText() == options[3])
					msg.setText(controller.createCopy(addres.getText()));
				
				if(msg.getText().equals("\nERROR! We don't have this apartment\n") || msg.getText().equals("\nERROR! We don't have this apartment for rent\n"))
					msg.setStyle("-fx-text-fill: red;");
				else
					msg.setStyle("-fx-text-fill: green;");
			}
		});
		backToMenu.setOnAction(e -> { window.close(); });
		text.setStyle("-fx-font-family: sample; -fx-font-size: 13;");
		submit.setPrefWidth(100);
		box.setPadding(new Insets(10));
		backToMenu.setPrefWidth(100);
		pane.setContent(box);
		Scene scene = new Scene(pane);
		window.setScene(scene);
		window.showAndWait();
	}
	
	
	
	

}
