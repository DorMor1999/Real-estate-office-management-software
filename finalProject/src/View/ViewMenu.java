package View;

import Controller.Controller;
import javafx.css.converter.PaintConverter;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ViewMenu extends GridPane{
	
	protected Stage primaryStage;
	protected Controller controller;
	
	// create labels
	private Label labelTitle;
	private Label menuTitle;
	private Label fileMsg;
	
	// create buttons
	private Button menu1;
	private Button menu2;
	private Button menu3;
	private Button menu4;
	private Button menu5;
	private Button menu6;
	private Button menu7;
	private Button menu8;
	private Button menu9;
	private Button menu10;
	private Button menu11;
	
	public ViewMenu(Stage primaryStage ,Controller controller) {
		super();
		this.controller = controller;
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Real estate office");
		showMenu();
	}
	
	public void showMenu() {
		String str = controller.readFile();
		
		
		//Title
		this.labelTitle = new Label("Menu");
		add(labelTitle, 0, 0);
		
		//menu label
		this.menuTitle = new Label("Please select an option:");
		add(menuTitle, 0, 1);
		
		//options buttons
		menu1 = new Button("To add an apartment");
		add(menu1, 0, 3);
		this.menu1.setOnAction(e -> { displayMenu1();});
		
		menu2 = new Button("To add an interested client");
		add(menu2, 0, 5);
		this.menu2.setOnAction(e -> { displayMenu2();});
		
		menu3 = new Button("To display all the apartments");
		add(menu3, 0, 7);
		this.menu3.setOnAction(e -> {displayMenu3();});
		
		menu4 = new Button("To display all apartments of certain type");
		add(menu4, 0, 9);
		this.menu4.setOnAction(e -> { displayMenu4();});
		
		menu5 = new Button("Show the full price for a rental period for a particular apartment");
		add(menu5, 0, 11);
		this.menu5.setOnAction(e -> {displayMenu5(); });
		
		menu6 = new Button("Show the most expensive aprtment for rent for a certain period of time(in months)");
		add(menu6, 0, 13);
		this.menu6.setOnAction(e -> { displayMenu6();});
		
		menu7 = new Button("Show all clients of a certain apartment");
		add(menu7, 0, 15);
		this.menu7.setOnAction(e -> {displayMenu7(); });
		
		menu8 = new Button("Show all clients of a certain apartment sorted by name");
		add(menu8, 0, 17);
		this.menu8.setOnAction(e -> {displayMenu8(); });
		
		menu9 = new Button("Create a copy of apartment and display the copy");
		add(menu9, 0, 19);
		this.menu9.setOnAction(e -> { displayMenu9();});
		
		menu10 = new Button("Show all apartments with commissions");
		add(menu10, 0, 21);
		this.menu10.setOnAction(e -> {displayMenu10(); });
		
		menu11 = new Button("To exit and save");
		add(menu11, 0, 23);
		this.menu11.setOnAction(e -> { displayMenu11();});
		
		this.fileMsg = new Label();
		add(fileMsg, 0, 25);
		fileMsg.setText(str);
		
		
		//style		
		setAlignment(Pos.CENTER);
		setHgap(7.5);
		setVgap(7.5);
		labelTitle.setStyle("-fx-font-family: sample; -fx-font-size: 30;");
		menuTitle.setStyle("-fx-font-family: sample; -fx-font-size: 20;");
		fileMsg.setStyle("-fx-font-family: sample; -fx-font-size: 15;");
		menu1.setPrefWidth(470);
		menu2.setPrefWidth(470);
		menu3.setPrefWidth(470);
		menu4.setPrefWidth(470);
		menu5.setPrefWidth(470);
		menu6.setPrefWidth(470);
		menu7.setPrefWidth(470);
		menu8.setPrefWidth(470);
		menu9.setPrefWidth(470);
		menu10.setPrefWidth(470);
		menu11.setPrefWidth(470);
		labelTitle.setTextFill(Color.WHITE);
		menuTitle.setTextFill(Color.WHITE);
		fileMsg.setTextFill(Color.RED);
		this.setStyle("-fx-background-color: #0082e6;");	
	}
	
	//menu 1
	public void displayMenu1() {
		AddApartmentWindow window = new AddApartmentWindow("Add apartment window", "\nEnter apartment details:\n", controller);
		window.display();
	}
	
	//menu 2
	public void displayMenu2() {
		AddClientWindow window = new AddClientWindow("Add client window", "\nEnter the addres of the apartment you want add a client:\n", controller);
		window.display();
	}
	
	//menu 3
	public void displayMenu3() {
		String str = this.controller.showAllApartments();
		ShowWindow window = new ShowWindow("List of all apartments", str);
		window.display();
	}
	
	//menu 4
	public void displayMenu4() {
		ChooseOneTypeOfApartmentWindow window = new ChooseOneTypeOfApartmentWindow("Display one type of apartment", "\nPlease select an option:\n" , controller);
		window.display();
	}
	
	//menu 5
	public void displayMenu5() {
		SearchApartmentWindow window = new SearchApartmentWindow("Apartment price for period time", "\nEnter the addres of the apartment you want to see the price for period time:\n" , controller);
		window.display();
	}
	
	//menu 6
	public void displayMenu6() {
		MostExpensiveApartmentRentWindow window = new MostExpensiveApartmentRentWindow("Most expensive apartment for months window", "\nEnter the number of months you want to check:\n" , controller);
		window.display();
	}
	
	//menu 7
	public void displayMenu7() {
		SearchApartmentWindow window = new SearchApartmentWindow("List of clients of a certain apartment", "\nEnter the addres of the apartment you want to see the inrested clients:\n" , controller);
		window.display();
	}
	
	//menu 8
	public void displayMenu8() {
		SearchApartmentWindow window = new SearchApartmentWindow("List of clients of a certain apartment (sorted by names)", "\nEnter the addres of the apartment you want to see the inrested clients(Sorted by name):\n" , controller);
		window.display();
	}
	
	//menu 9
	public void displayMenu9() {
		SearchApartmentWindow window = new SearchApartmentWindow("Create copy apartment window", "\nEnter the addres of the apartment you want to create copy:\n" , controller);
		window.display();
	}
	
	//menu 10
	public void displayMenu10() {
		String str = this.controller.showCommissions();
		ShowWindow window = new ShowWindow("List of all apartments", str);
		window.display();
	}
	
	//menu 11
	public void displayMenu11() {
		fileMsg.setText(this.controller.saveToBinaryFile());
		this.primaryStage.close();
	};

	

}
