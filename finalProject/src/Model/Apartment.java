package Model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Apartment implements Cloneable , Serializable {
	
	private static final long serialVersionUID = 1L;
	private static int idGenerator = 1000;
	private int id;
	private String addres;
	private double area;
	private double numOfRooms;
	private int rating;
	private ArrayList<Client> allInterestedClients;
	private String type;
	
	public Apartment(String addres, double area, double numOfRooms, int rating, String type) throws IllegalArgumentException {
		super();
		this.id = ++idGenerator;
		this.addres = addres;
		setArea(area);
		setNumOfRooms(numOfRooms);
        setRating(rating);
		this.allInterestedClients = new ArrayList<>();
		this.type =type;
	}
	
	public Apartment(String addres , String type) {
		super();
		this.id = ++idGenerator;
		this.addres = addres;
		this.allInterestedClients = new ArrayList<>();
		this.type =type;
	}
	
	
	
	protected static int getIdGenerator() {
		return idGenerator;
	}

	protected static void setIdGenerator(int idGenerator) {
		Apartment.idGenerator = idGenerator;
	}

	public void setArea(double area) throws IllegalArgumentException {
		if (area <= 0)
			throw new IllegalArgumentException("Area must be a posetive number!");
		else
			this.area = area;
	}

	public void setNumOfRooms(double numOfRooms) throws IllegalArgumentException {
		if(numOfRooms <= 0)
			throw new IllegalArgumentException("The number of rooms must be a posetive number!");
		else
			this.numOfRooms = numOfRooms;
	}

	public int getRating() {
		return rating;
	}

	public String getType() {
		return type;
	}

	public void setRating(int rating) throws IllegalArgumentException {
		if(rating < 0 || rating > 10 )
			throw new IllegalArgumentException("The rating must be a posetive integer betwwen 0-10 inclusive!");
		else
			this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public String getAddres() {
		return addres;
	}

	public double getArea() {
		return area;
	}

	public double getNumOfRooms() {
		return numOfRooms;
	}

	public ArrayList<Client> getAllInrestedClients() {
		return allInterestedClients;
	}
	//13
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Apartment) {
			if((((Apartment) obj).addres).equalsIgnoreCase(this.addres)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
	//14
	public String addClient(Client newClient) {
		if(this.allInterestedClients.contains(newClient) ==  false) {
			this.allInterestedClients.add(newClient);
			return "\nClient successfully added\n";
		}
		else {
			return "\nThis client alredy in our intrested clients list for this apartment so we dont add him to the list(We have client with this phone number).\n";
		}
	}
	//19
	public String viewAllClients() {
		String str = "All interested clients for this aprtment:\n" + this.getListOfAllClients(allInterestedClients);
		return str;
	}
	
	public String getListOfAllClients(ArrayList<Client> list) {
		String strClients = "";
		for(int i = 0 ; i < list.size() ; i++) {
			strClients += (list.get(i)).toString() + "\n" ;
		}
		return strClients;
	}

	@Override
	public String toString() {
		return "Id: " + id + " .\nAddres: " + addres + " .\nArea: " + area + " .\nNum of rooms: " + numOfRooms
				+ " .\nRating: " + rating + " .\nAll interested clients:\n" + this.getListOfAllClients(allInterestedClients) ;
	}
	
	//20
	public String viewAllClientsSorted(){
		String str = "All interested clients for this aprtment(Sorted by name):\n" + this.getListOfAllClients(SortClients());
		return str;
	}
	
	//20
	public ArrayList<Client> SortClients(){
		Client[] allSorted = allInterestedClients.toArray(new Client[allInterestedClients.size()]);
		
		for(int i = allSorted.length-1 ; i > 0 ; i--) {
			for(int j = 0 ; j < i ;j++) {
				if( allSorted[j].getFullName().compareToIgnoreCase(allSorted[j+1].getFullName()) > 0  ) {
					Client temp = allSorted[j];
					allSorted[j] = allSorted[j+1];
					allSorted[j+1] = temp;
				}
			}
		}
		ArrayList<Client> allSortedList = new ArrayList<>();
		for(int i = 0 ; i < allSorted.length ; i++)
			allSortedList.add(allSorted[i]);
		return allSortedList;
	}

	@Override
	protected Apartment clone() throws CloneNotSupportedException {
		Apartment temp = (Apartment)super.clone();
		temp.addres = addres + "";
		temp.type = type + "";
		temp.allInterestedClients = (ArrayList<Client>) allInterestedClients.clone();
		for(int i = 0 ; i < temp.allInterestedClients.size() ; i++) {
			temp.allInterestedClients.set(i, allInterestedClients.get(i).clone());
		}
		return temp;
	}

	
	
}

