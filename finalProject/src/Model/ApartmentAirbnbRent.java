package Model;


public class ApartmentAirbnbRent extends ApartmentForRent {

	public ApartmentAirbnbRent(String addres, double area, double numOfRooms, int rating, int rentTime,
			double price) throws IllegalArgumentException {
		super(addres, area, numOfRooms, rating, rentTime, price , "Apartment airbnb rent");
	}
	
	public ApartmentAirbnbRent(String addres) {
		super(addres, "Apartment airbnb rent");
	}
	
	//17
	@Override
	public String priceForPeriodShow() {
		return "The price for " + getRentTime() + " days of rent is: " + (getPriceForPeriod(getRentTime())) +" .\n";
	}
	@Override
	public String toString() {
		return getType() + ":\n" + super.toString() + "Rent time: " + getRentTime() + " .\nPrice per day: " + getPrice() + " .\nPrice per rent time: " + getPriceForPeriod(getRentTime()) + " .";
	}
	
	
	

}

