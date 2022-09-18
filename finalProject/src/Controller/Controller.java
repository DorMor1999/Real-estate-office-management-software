package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import Model.RealEstateOffice;

public class Controller {
	
	private RealEstateOffice firm;

	public Controller(RealEstateOffice firm) {
		super();
		this.firm = firm;
	}

	public RealEstateOffice getRealEstateOffice() {
		return firm;
	}
	
	//menu1
	public String addOneApartment(String addres ,String area ,String numOfRooms,String rate, String price,String time,int type) {
		return firm.addOneApartment(addres, area, numOfRooms, rate, price, time, type);
	};
	
	//menu2
	public String addClientToApartment(String addres,String fullName ,String phoneNumber) {
		return firm.addClientToApartment(addres,fullName ,phoneNumber);
	};
	
	//menu3
	public String showAllApartments() {
		return firm.showAllApartments();
	};
	
	//menu4
	public String displayApartmentFromOneType(int choose) {
		return firm.displayApartmentFromOneType(choose);
	};
	
	
	//menu5
	public String showPriceForPeriodTimeParticularApartment(String addres) {
		return firm.showPriceForPeriodTimeParticularApartment(addres);
	}
	
	//menu6
	public String showMostExpensiveMenue(String time) {
		return firm.showMostExpensiveMenue(time);
	};
	
	//menu7
	public String showAllClientsParticularApartment(String addres) {
		return firm.showAllClientsParticularApartment(addres);
	}
	
	//menu8
	public String showAllClientsParticularApartmentSortedByName(String addres) {
		return firm.showAllClientsParticularApartmentSortedByName(addres);
	};
	
	//menu9
	public String createCopy(String addres) {
		return firm.createCopy(addres);
	};
	
	//menu10
	public String showCommissions() {
		return firm.showCommissions();
	}
	
	//menu11
	public String saveToBinaryFile() {
		try {
			this.firm.saveToFile();
			return"";
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	//read file
	public String readFile() {
		try {
			this.firm = firm.readFile();
			return "";
		} catch (FileNotFoundException e1) {
			this.firm.createObjects();
			return e1.getMessage();
		} catch (ClassNotFoundException e1) {  
			this.firm.createObjects();
			return e1.getMessage();
		} catch (IOException e1) { 
			this.firm.createObjects();
			return e1.getMessage();
		}
	}
	

}
