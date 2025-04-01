package main.resources.control.manager.clientControl.registerClient;

public class ManagerSpecialCasesData extends ControlSpecialCases {
	
	/**
	 * @author Ethan T. Anwar
	 */
	
	@SuppressWarnings("unused")
	private String mainPhoneNumber;
	
	@SuppressWarnings("unused")
	private String secondPhoneNumber;
	
	@SuppressWarnings("unused")
	private String curp;
	
	@SuppressWarnings("unused")
	private int day, year;
	
	@SuppressWarnings("unused")
	private String month;
	
	@SuppressWarnings("unused")
	private String residenceState;
	
	/*Attribute for the control of the client's state Mexico residence*/
	private final String MexicoStates[] = {
			"Aguascalientes",
			"Baja California",
			"Baja California Norte",
			"Baja California Sur",
			"Campeche",
			"Coahuila",
			"Colima",
			"Chiapas",
			"Chihuahua",
			"Distrito Federal",
			"Durango",
			"Guanajuato",
			"Guerrero",
			"Hidalgo",
			"Jalisco",
			"México",
			"Michoacán",
			"Morelos",
			"Nayarit",
			"Nuevo León",
			"Oaxaca",
			"Puebla",
			"Querétaro",
			"Quintana Roo",
			"San Luis Potosí",
			"Sinaloa",
			"Sonora",
			"Tabasco",
			"Tamaulipas",
			"Tlaxcala",
			"Veracruz",
			"Yucatán",
			"Zacatecas"
	};
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/*
	 * @see Class constructor
	 * @atributes Set default values 
	 * */
	public ManagerSpecialCasesData() {
		this.curp = null;
		this.residenceState = null;
		this.day = 0;
		this.month = null;
		this.year = 0;
		this.mainPhoneNumber = null;
		this.secondPhoneNumber = null;
	}

	/*
	 * @see Class constructor
	 * @attributes Set with the parameters values
	 * @params All attributes 
	 * */
	public ManagerSpecialCasesData(String curp, String residenceState, int day, 
			                      String month, int year, String mainPhoneNumber, String secondPhoneNumber) {
		this.curp = curp;
		this.residenceState = residenceState;
		this.day = day;
		this.month = month;
		this.year = year;
		this.mainPhoneNumber = mainPhoneNumber;
		this.secondPhoneNumber = secondPhoneNumber;
	}
	
	/**
	 * @params Type a integer String, the phone number proportioned for the user
	 * @return false if the character of number is less to 10 digits
	 * @return true if the character of number is equal to 10 digits
	 */
	public boolean isPhoneNumberDigitsCorrect(String mainPhoneNumber) {
		return super.isPhoneNumberDigitsCorrect(this.mainPhoneNumber = mainPhoneNumber);
	}
	
	/**
	 * @deprecated
	 * @params Type a integer String, the phones numbers proportioned for the user
	 * @return false if the character of both numbers is less to 10 digits
	 * @return true if the character of both numbers is equal to 10 digits
	 */
	public boolean ArePhonesNumbersDigitsCorrects(String mainPhoneNumber, String secondPhoneNumber) {
		return super.isPhoneNumberDigitsCorrect(this.mainPhoneNumber = mainPhoneNumber,
				                          this.secondPhoneNumber = secondPhoneNumber);
	}
	
	/**
	 * @param user's phone number
	 * @return true if the phone number is empty
	 * @return false if the phone number is not empty
	 */
	public boolean isPhoneNumberEmpty(String mainPhoneNumber) {
		if ((mainPhoneNumber.length() == 0) 
				|| (mainPhoneNumber.equals(PLACEHOLDER))) return true;
		
		return false;
	}	
	
	/**
	 * @params The client's: day/month/year -> dd/mm/yyyy format 
	 * @return true if the client is 18 years old
	 * @return false if the client isn't 18 years old
	 */
	public boolean isAgeClientAuthorized(int day, String month, int year) {
		return super.isAgeClientAuthorized(this.day = day,
				                           this.month = month,
				                           this.year = year);
	}
	
	/**
	 * @param Name of the residence state 
	 * @return true is the state name proportioned for the user exist
	 * @return false is the state name proportioned for the don't exist
	 */
	public boolean isStateResidenceExist(String residenceState) {
		return super.isStateResidenceExist(MexicoStates,
				                           this.residenceState = residenceState);
	}
		
	/**
	 * @param The alphanumeric code (CURP)
	 * @return true If the CURP'S characters is equal to 18 digits
	 * @return false If the CURP'S characters is less than 18 digits
	 */
	public boolean isCurpValidate(String curp) {
		return super.isCurpValidate(this.curp = curp);
	}	
	
	/**
	 * @return MINIMUM_BORN_YEAR, an integer type 
	 */
	public int getMinimumBornYear() {
		return super.MINIMUM_BORN_YEAR;
	}
	
	/**
	 * @return LIMIT_YEAR_AUTHORIZED, an integer type
	 */
	public int getLimitYearAuthorized() {
		return super.LIMIT_YEAR_AUTHORIZED;
	}
}
