package Model;


public abstract class ApartmentForRent extends Apartment {
	
	private int rentTime;
	private double price;

	public ApartmentForRent(String addres, double area, double numOfRooms, int rating, int rentTime, double price, String type) throws IllegalArgumentException {
		super(addres, area, numOfRooms, rating , type);
		setRentTime(rentTime);
		setPrice(price);
	}
	
	public ApartmentForRent(String addres, String type) {
		super(addres, type);
	}

	public int getRentTime() {
		return rentTime;
	}

	public void setRentTime(int rentTime) throws IllegalArgumentException {
		if(rentTime <= 0)
			throw new IllegalArgumentException("The duration of time must be a posetive integer!");
		else
			this.rentTime = rentTime;
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
	//17
	public abstract String priceForPeriodShow();
	
	public double getPriceForPeriod(int time) {
		return price * time;
	}
	
	
	

}