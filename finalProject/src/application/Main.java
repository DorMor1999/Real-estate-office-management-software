package application;
	

import Controller.Controller;
import Model.RealEstateOffice;
import View.ViewMenu;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			RealEstateOffice firm = new RealEstateOffice();
			Controller controller = new Controller(firm);
			ViewMenu view = new ViewMenu(primaryStage,controller);
			Scene scene = new Scene(view,600,600);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
