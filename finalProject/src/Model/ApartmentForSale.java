package Model;

public class ApartmentForSale extends Apartment implements iCommission{
	
	private double price;

	public ApartmentForSale(String addres, double area, double numOfRooms, int rating, double price) throws IllegalArgumentException {
		super(addres, area, numOfRooms, rating, "Apartment for sale");
		setPrice(price);
	}
	
	public ApartmentForSale(String addres) {
		super(addres ,"Apartment for sale");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) throws IllegalArgumentException {
		if (price <= 0)
			throw new IllegalArgumentException("The price must be a posetive number!");
		else
			this.price = price;
	}

	@Override
	public String toString() {
		return getType() + ":\n" + super.toString() + "Price: " + price + " .\nCommission: " + getCommission() + " .";
	}
    //24
	@Override
	public double getCommission() {
		return price * 0.05;
	}
	
	
	
	
	

}
