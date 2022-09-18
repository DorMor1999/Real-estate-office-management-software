package Model;


public class ApartmentRegularRent extends ApartmentForRent implements iCommission{

	public ApartmentRegularRent(String addres, double area, double numOfRooms, int rating, int rentTime,
			double price) throws IllegalArgumentException {
		super(addres, area, numOfRooms, rating, rentTime, price, "Apartment regular rent");
	}
	
	public ApartmentRegularRent(String addres) {
		super(addres, "Apartment regular rent");
	}
    //17
	@Override
	public String priceForPeriodShow() {
		return "The price for " + getRentTime() + " months of rent is: " + (getPriceForPeriod(getRentTime())) +" .\n";
	}
	@Override
	public String toString() {
		return getType() + ":\n" + super.toString() + "Rent time: " + getRentTime() + " .\nPrice per month: " + getPrice() + " .\nPrice per rent time: " + getPriceForPeriod(getRentTime()) + " .\nCommission: " + getCommission() + " .";
	}
	//24
	@Override
	public double getCommission() {
		return 4000;
	}
	
	

	
	
	

}
