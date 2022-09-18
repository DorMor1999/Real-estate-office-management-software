package Model;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



public final class RealEstateOffice implements Serializable , iManagement {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Apartment> allApartments;
	public static Scanner in = new Scanner(System.in);
	public static String fileName = "binaryFile.txt";
	
	public RealEstateOffice() {
		super();
		this.allApartments = new ArrayList<>();
	}
	//13
	public String addApartment(Apartment newApartment) {
		if(this.allApartments.contains(newApartment) == false) {
			this.allApartments.add(newApartment);
			return "\nThe apartment has been successfully added to the list.\n";
		}
		else {
			return "\nThis apartment alredy exist so we dont add her to our list(We have apartment with this addres).\n";
		}
	}
	
	//16
	public String showApartmentsFromOneType(String type) {
		String str = "*List of all apartments from one type:\n";
		int conter = 0;
		for(int i = 0 ; i < allApartments.size() ; i++) {
			if(type.equals(allApartments.get(i).getClass().getSimpleName())) {
				conter++;
				str += "\n" + (conter) + ". " + (allApartments.get(i)).toString() + "\n";
			}
		}
		return str;
	}
	public ArrayList<Apartment> getAllApartments() {
		return allApartments;
	}
	
	//18!!!!!
	public String theMostExpensiveRental(int months) {
		double max = -1;
		String details= "";
		for (Apartment apartment : allApartments) {
			if(apartment.getClass().getSimpleName().equals("ApartmentRegularRent")) {
				if(max < ((ApartmentRegularRent)(apartment)).getPriceForPeriod(months)) {
					max = ((ApartmentRegularRent)(apartment)).getPriceForPeriod(months);
			        details = apartment.getType().toLowerCase() + " in " + apartment.getAddres();
			    }
			}
			else if(apartment.getClass().getSimpleName().equals("ApartmentAirbnbRent")) {
				if(max < ((ApartmentAirbnbRent)(apartment)).getPriceForPeriod(months*30)) {
					max = ((ApartmentAirbnbRent)(apartment)).getPriceForPeriod(months*30);
					details = apartment.getType().toLowerCase() + " in " + apartment.getAddres();
				}	
			}
		}
		if(max != -1)
			return "\nThe most expensive apartment for " + months + " months is " + details + " and the total price is: " + max + " .\n";
		else
			return "\nWe dont have apartments for raent\n";
	}
	
	//find place in arrey list
	public int findIndexOfApartmentByString(String fAddres) {
		for (int i = 0 ; i < allApartments.size() ; i++ ) {
			if(allApartments.get(i).getAddres().equalsIgnoreCase(fAddres))
				return i;
		} 
		return -1;
	}
	
	//add apartment 1. menu
	public String addOneApartment(String addres ,String area ,String numOfRooms,String rate, String price,String time,int type) {
		String str = "";
		int num = -1;
		Apartment newApartment = null;
		String[] strs = {"\nAddress must be at least one character long!\n",
				 "\nThis is not a number!(area input)\n",
		         "\nThis is not a number!(number of rooms input)\n",
		         "\nThis is not a integer!(agent rating input)\n",
		         "\nThis is not a number!(price input)\n",
		         "\nThis is not a integer!(duration time input)\n"};
		try {
			num++;
			if(addres.length() == 0)
				str += strs[0];
			if(type == 1) {
				ApartmentForSale newApartment1 = new ApartmentForSale(addres);
				newApartment = newApartment1;
			}
			else if(type == 2) {
				ApartmentRegularRent newApartment2 = new ApartmentRegularRent(addres);
				newApartment = newApartment2;
			}
			else {
				ApartmentAirbnbRent newApartment3 = new ApartmentAirbnbRent(addres);
				newApartment = newApartment3;
			}
			num++;
			newApartment.setArea(Double.parseDouble(area));
			num++;
			newApartment.setNumOfRooms(Double.parseDouble(numOfRooms));
			num++;
			newApartment.setRating(Integer.parseInt(rate));
			num++;
			if(type == 1) {
				((ApartmentForSale) newApartment).setPrice(Double.parseDouble(price));
			}
			else if(type == 2) {
				((ApartmentRegularRent) newApartment).setPrice(Double.parseDouble(price));
				num++;
				((ApartmentRegularRent) newApartment).setRentTime(Integer.parseInt(time));
			}
			else {
				((ApartmentAirbnbRent) newApartment).setPrice(Double.parseDouble(price));
				num++;
				((ApartmentAirbnbRent) newApartment).setRentTime(Integer.parseInt(time));
			}
		} catch (NumberFormatException e) {
			str += strs[num];
		} catch (IllegalArgumentException e) {
			str += e.getMessage();
		}
		if(str.equals(""))
			return addApartment(newApartment);
		else
			return str;
	}
	
	// add client to apartment 2. menu
	public String addClientToApartment(String addres,String fullName ,String phoneNumber) {
		String str = "";
		int indexOfApartment = findIndexOfApartmentByString(addres);
		if(indexOfApartment != -1) {
			if(fullName.length() == 0)
				str += "\nFull name must be at least one character long!\n";
			if(phoneNumber.length() == 0)
				str += "\nPhone number must be at least one character long!\n";
			if(fullName.length() > 0 && phoneNumber.length() > 0)
				str = getAllApartments().get(indexOfApartment).addClient(new Client(fullName, phoneNumber));
			return str;
		}
		else {
			return "\nERROR! We don't have this apartment\n";
		}
	}
	
	//15     show all apartments 3. menu
	public String showAllApartments() {
		String str = "*List of all apartments:\n";
		for(int i = 0 ; i < allApartments.size() ; i++) {
			str += "\n" + (i+1) + ". " +  (allApartments.get(i)).toString() + "\n";
		}
		return str;
	}
	
	//show apartment from 1 type 4. menu
	public String displayApartmentFromOneType(int choose) {
		String str = "";
		switch (choose) {
		case 1:
			str = showApartmentsFromOneType("ApartmentForSale");
			break;
		case 2:
			str = showApartmentsFromOneType("ApartmentRegularRent");
			break;
		case 3:
			str = showApartmentsFromOneType("ApartmentAirbnbRent");
			break;
		}
		return str;
	}
	
	//show price for particular apartment for period time 5. menu
	public String showPriceForPeriodTimeParticularApartment(String addres) {
		int indexOfApartment = findIndexOfApartmentByString(addres);
		if(indexOfApartment != -1 && getAllApartments().get(indexOfApartment) instanceof ApartmentForRent) {
			return ((ApartmentForRent)getAllApartments().get(indexOfApartment)).priceForPeriodShow();
		}
		else {
			return "\nERROR! We don't have this apartment for rent\n";
		}
	}
	
	//show the most expensive menu 6
	public String showMostExpensiveMenue(String time) {
		int months = -1;
		try {
			months = Integer.parseInt(time);
			if (months < 1)
				throw new IllegalArgumentException("\nNumber of months must be a positive integer!\n");
		} catch (NumberFormatException e) {
			return "\nThis is not a integer!\n";
		} catch (IllegalArgumentException e) {
			return e.getMessage();
		}
		
		return theMostExpensiveRental(months);
	}
	
	//show all clients for certain apartment 7. menu
	public String showAllClientsParticularApartment(String addres) {
		int indexOfApartment = findIndexOfApartmentByString(addres);
		if(indexOfApartment != -1) {
			return getAllApartments().get(indexOfApartment).viewAllClients();
		}
		else {
			return "\nERROR! We don't have this apartment\n";
		}
	}
	
	//show all clients for certain apartment sort by names 8. menu
	public String showAllClientsParticularApartmentSortedByName(String addres) {
		int indexOfApartment = findIndexOfApartmentByString(addres);
		if(indexOfApartment != -1) {
			return getAllApartments().get(indexOfApartment).viewAllClientsSorted();
		}
		else {
			return "\nERROR! We don't have this apartment\n";
		}
	}
	
	//create a copy of apartment and display the copy menu 9
	public String createCopy(String addres) {
		int indexOfApartment = findIndexOfApartmentByString(addres);
		if(indexOfApartment != -1) {
			try {
				Apartment theCopy = getAllApartments().get(indexOfApartment).clone();
				return "\nCopy apartment details:\n" + theCopy + "\n";
				
			} catch (CloneNotSupportedException e) {
				return e.getMessage();
			}
		}
		else {
			return "\nERROR! We don't have this apartment\n";
		}
		
	}
	
	//10. menu     24
	public String showCommissions() {
		String str = "list of all apartments(display commissions to apartments with commissions):\n";
		int j = 0;
		for(int i = 0 ; i < allApartments.size() ; i++ ) {
			if(allApartments.get(i) instanceof iCommission) {
				str += (i+1-j) + ". " + allApartments.get(i).getType();
				str += "\nAddres: " + allApartments.get(i).getAddres();
				str += "\nId: " + allApartments.get(i).getId();
				str += "\nCommission: ";
				str += ((iCommission) allApartments.get(i)).getCommission() + "\n\n";
			}
			else
				j++;
		}
		return str;
	}
	
	//save to binary file
	public  void saveToFile() throws FileNotFoundException, IOException {
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(fileName));
		o.writeObject(this);
		if(allApartments.size() > 0)
			o.writeInt(this.getAllApartments().get(0).getIdGenerator());
		o.close();
	}
	
	//read to binary file
	public RealEstateOffice readFile() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream i = new ObjectInputStream(new FileInputStream(fileName));
		RealEstateOffice a = (RealEstateOffice) i.readObject();
		if(a.allApartments.size() > 0)
			a.getAllApartments().get(0).setIdGenerator(i.readInt());
		i.close();
		return a;
	}
	
	public void createObjects() {
		//Clients
		Client c1 = new Client("Dan Mor", "052000001");
		Client c2 = new Client("Tal Mor", "052000002");
		Client c3 = new Client("Igal Mor", "052000003");
		Client c4 = new Client("Gal Mor", "052000004");
		Client c5 = new Client("Ron Mor", "052000005");
		Client c6 = new Client("Roy Mor", "052000006");
		Client c7 = new Client("Angel Mor", "052000007");
		Client c8 = new Client("Lital Mor", "052000008");
		Client c9 = new Client("Dan Cohen", "052000009");
		Client c10 = new Client("Igal Cohen", "052000010");
		Client c11 = new Client("Tal Cohen", "0520000011");
		Client c12 = new Client("Gal Cohen", "052000012");
		Client c13 = new Client("Ron Cohen", "052000013");
		Client c14 = new Client("Roy Cohen", "052000014");
		Client c15 = new Client("Angel Cohen", "052000015");
		Client c16 = new Client("Lital Cohen", "052000016");
		
		//sell
		ApartmentForSale s1 = new ApartmentForSale("Sumsum 10", 120, 6, 10, 2000000);
		ApartmentForSale s2 = new ApartmentForSale("Sumsum 11", 110, 5.5, 9, 1900000);
		ApartmentForSale s3 = new ApartmentForSale("Sumsum 12", 100, 5, 9, 1800000);
		ApartmentForSale s4 = new ApartmentForSale("Sumsum 13", 90, 4, 8, 1700000);
		this.addApartment(s1);
		this.addApartment(s2);
		this.addApartment(s3);
		this.addApartment(s4);
		s1.addClient(c1);
		s1.addClient(c2);
		s1.addClient(c3);
		s1.addClient(c4);
		s2.addClient(c5);
		s2.addClient(c6);
		s2.addClient(c7);
		s2.addClient(c8);
		s3.addClient(c9);
		s3.addClient(c10);
		s3.addClient(c11);
		s3.addClient(c12);
		s4.addClient(c13);
		s4.addClient(c14);
		s4.addClient(c15);
		s4.addClient(c16);
		//regular rent
		ApartmentRegularRent r1 = new ApartmentRegularRent("Sumsum 1", 100, 5, 8, 12, 4000);
		ApartmentRegularRent r2 = new ApartmentRegularRent("Sumsum 2", 110, 6, 10, 6, 6000);
		ApartmentRegularRent r3 = new ApartmentRegularRent("Sumsum 3", 105, 5.5, 9, 8, 4500);
		ApartmentRegularRent r4 = new ApartmentRegularRent("Sumsum 4", 100, 5, 8, 18, 4000);
		this.addApartment(r1);
		this.addApartment(r2);
		this.addApartment(r3);
		this.addApartment(r4);
		r1.addClient(c1);
		r1.addClient(c2);
		r1.addClient(c3);
		r1.addClient(c4);
		r2.addClient(c5);
		r2.addClient(c6);
		r2.addClient(c7);
		r2.addClient(c8);
		r3.addClient(c9);
		r3.addClient(c10);
		r3.addClient(c11);
		r3.addClient(c12);
		r4.addClient(c13);
		r4.addClient(c14);
		r4.addClient(c15);
		r4.addClient(c16);
		//Airbnb
		ApartmentAirbnbRent a1 = new ApartmentAirbnbRent("Sumsum 20", 50, 2, 7, 7, 150);
		ApartmentAirbnbRent	a2 = new ApartmentAirbnbRent("Sumsum 21", 40, 1, 5, 2, 125);
		ApartmentAirbnbRent a3 = new ApartmentAirbnbRent("Sumsum 22", 45, 1.5, 4, 1, 100);
		ApartmentAirbnbRent a4 = new ApartmentAirbnbRent("Sumsum 23", 50, 2, 8, 9, 175);
		this.addApartment(a1);
		this.addApartment(a2);
		this.addApartment(a3);
		this.addApartment(a4);
		a1.addClient(c1);
		a1.addClient(c2);
		a1.addClient(c3);
		a1.addClient(c4);
		a2.addClient(c5);
		a2.addClient(c6);
		a2.addClient(c7);
		a2.addClient(c8);
		a3.addClient(c9);
		a3.addClient(c10);
		a3.addClient(c11);
		a3.addClient(c12);
		a4.addClient(c13);
		a4.addClient(c14);
		a4.addClient(c15);
		a4.addClient(c16);
		
	}
	
	
}
