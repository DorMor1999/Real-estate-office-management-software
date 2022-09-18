package Model;



public interface iManagement {
	
	//add apartment 1. menu sell and rent
	public String addOneApartment(String addres ,String area ,String numOfRooms,String rate, String price,String time,int type);
	
	// add client to apartment 2. menu
	public String addClientToApartment(String addres,String fullName ,String phoneNumber);
	
	//show all apartments 3. menu
	public String showAllApartments();
		
	//show apartment from 1 type 4. menu
	public String displayApartmentFromOneType(int choose);
	
	//show price for particular apartment for period time 5. menu
	public String showPriceForPeriodTimeParticularApartment(String addres);
	
	//show the most expensive menu 6
	public String showMostExpensiveMenue(String time);
	
	//show all clients for certain apartment 7. menu
	public String showAllClientsParticularApartment(String addres);
	
	//show all clients for certain apartment sort by names 8. menu
	public String showAllClientsParticularApartmentSortedByName(String addres);
	
	//create a copy of apartment menu 9
	public String createCopy(String addres);
	
	//show all apartments with commissions menu 10
	public String showCommissions();

}
