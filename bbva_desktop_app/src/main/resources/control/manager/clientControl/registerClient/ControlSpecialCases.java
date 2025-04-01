package main.resources.control.manager.clientControl.registerClient;

import java.util.Calendar;
import javax.swing.JOptionPane;

public abstract class ControlSpecialCases {
	
	/**@author Ethan T. Anwar Pagourtzis*/

	protected static final String PLACEHOLDER = "Número teléfonico";
	/**
	 * @see attributes for control y the date
	 * @see Attributes for the date control
	 */
	protected final int MINIMUM_BORN_YEAR = 1940;
	protected final int LIMIT_YEAR_AUTHORIZED = Calendar.getInstance().get(Calendar.YEAR) - 18;
	/**
	 * 
	 */
	private static final int LEGAL_AGE = 18;
	private static final int ACTUAL_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	private static final int ACTUAL_DAY = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
	/**
	 * 
	 */
	private static String ACTUAL_MONTH = null;
	/**
	 * 
	 */
	private static final int[] POSITION_OF_ACTUAL_MONTH = {0,0};
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/**
	 * <p>@see months of the year, categorized in number of days
	 * seven months of the calendar they're have 31th days</p>
	 */
	private final Object MONTHS_OF_THE_YEAR_CATEGORY1[] = {
			"Enero", "Marzo",  "Mayo", 
			"Julio", "Agosto", "Octubre", 
			"Diciembre"
	};
	/*4 months of the calendar they're have 30th days*/
	private final Object MONTHS_OF_THE_YEAR_CATEGORY2[] = {
			"Abril","Junio",
			"Septiembre","Noviembre"
	};
	/*Only one month of the calendar they're have 28th days*/
	private final Object MONTHS_OF_THE_YEAR_CATEGORY3 = "Febrero";
	
	private final String[][] MONTHS_BIDIMENSIONAL_FORMAT = {
			{"Enero",   "Febrero",   "Marzo"},
			{"Abril",   "Mayo",      "Junio"},
			{"Julio",   "Agosto",    "Septiembre"},
			{"Octubre", "Noviembre", "Diciembre"},
	};
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public ControlSpecialCases() {
		setActualMonth();
		initializedMonthsOfYearArray();
	}
	
	private void initializedMonthsOfYearArray() {
		for (int i = 0; i < 4; i++) 
		{
			for (int j = 0; j < 3; j++) 
			{
				if (ACTUAL_MONTH.equals(MONTHS_BIDIMENSIONAL_FORMAT[i][j])) 
				{
					POSITION_OF_ACTUAL_MONTH[0] = i;
					POSITION_OF_ACTUAL_MONTH[1] = j;
					i = 4; j = 3;// Forced to break loop
				}
			}
		}
	}
	
	/**
	 * <p>The method <strong>{@link #updateMonthsArray()}</strong> take the
	 * actual month from the computer system and puts in {@link #ACTUAL_MONTH}
	 * <p>
	 */
	private void setActualMonth() {
		switch (Calendar.getInstance().get(Calendar.MONTH)) 
		{
    		case 0: ACTUAL_MONTH = "Enero";      break;
    		case 1: ACTUAL_MONTH = "Febrero";    break;
    		case 2: ACTUAL_MONTH = "Marzo";      break;
    		case 3: ACTUAL_MONTH = "Abril";      break;
    		case 4: ACTUAL_MONTH = "Mayo";       break;
    		case 5: ACTUAL_MONTH = "Junio";      break;
    		case 6: ACTUAL_MONTH = "Julio";      break;
    		case 7: ACTUAL_MONTH = "Agosto";     break;
    		case 8: ACTUAL_MONTH = "Septiembre"; break;
    		case 9: ACTUAL_MONTH = "Octubre";    break;
    		case 10: ACTUAL_MONTH = "Noviembre"; break;
    		case 11: ACTUAL_MONTH = "Diciembre"; break;
    		default: System.out.print("system error");
		}
	}
	
	/**
	 * @see {@link #setActualMonth()}
	 * @return actual month in String type
	 */
	private String getActualMonth() {
		return ACTUAL_MONTH;
	}
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/**
	 * <p>
	 * @param phone number of the user
	 * @return True if the <strong>phoneNumber characters</strong> length is equal 10
	 * @return False if the <strong>phoneNumber characters</strong> length is less than 10
	 * </p>
	 */
	protected boolean isPhoneNumberDigitsCorrect(String phoneNumber) {
		if ((phoneNumber.length() < 10) 
				|| (phoneNumber.length() > 10)) return false;
		return true;
	}
	
	/**
	 * <p>
	 * @deprecated
	 * @param Primary and secondary user's phone number
	 * @return True if the <strong>phoneNumber characters</strong> length is equal 10
	 * @return False if the <strong>phoneNumber characters</strong> length is less than 10
	 * </p>
	 */
	protected boolean isPhoneNumberDigitsCorrect(String mainPhoneNumber, String secondPhoneNumber) {
		if (((mainPhoneNumber.length() == 0) || (mainPhoneNumber.equals(PLACEHOLDER))
				&& (secondPhoneNumber.length() == 0) || (secondPhoneNumber.equals(PLACEHOLDER)))
				
				|| ((mainPhoneNumber.length() == 0) || (mainPhoneNumber.equals(PLACEHOLDER))
						|| (secondPhoneNumber.length() == 0) || (secondPhoneNumber.equals(PLACEHOLDER))))
		{
			JOptionPane.showMessageDialog(null,
					"Algún número telefónico no es correcto.\nRevisa tus datos.\n\n",
					"Número(s) telefónico incorrecto",
					JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		return true;
	}
	
	/**
	 * <p>
	 * @param CURP of the user
	 * @return True if the <strong>CURP characters length</strong> is equal to 18
	 * @return False if the <strong>CURP characters length</strong> is less than 18
	 * @see {@link #isCurpValidate(String)}
	 * </p>
	 */
	protected boolean isCurpValidate(String curp) {
		final int SIZE_CHARACTERES = 18;
		if (curp.length() < SIZE_CHARACTERES 
			|| curp.length() > SIZE_CHARACTERES) return false;
		return true;
	}
	
	/**
	 * <p>
	 * @params MexicoStates[], residenceState
	 * @return <strong>authentic = false</strong> or <strong>authentic = true</strong>
	 * </p>
	 */
	protected boolean isStateResidenceExist(String MexicoStates[], String residenceState) {
		for (int i = 0; i < MexicoStates.length; i++) 
		{
			if (MexicoStates[i].equals(residenceState)) 
			{
				return true;
			}
		}
		/**<strong>authentic = false</strong>**/
		return false;
	}
	/**
	 * <p>
	 * @see category 1: months they're have 31th days
	 * @see category 2: months they're have 30th days
	 * @see category 3: months they're have 28th days
	 * @params day, month and year
	 * @return <strong>Authorization = false</strong> or <strong>Authorization = true</strong> 
	 *         for use the application
	 * </p>
	 */
	protected boolean isAgeClientAuthorized(int day, String month, int year) {
		boolean authorized = false;
		
		//does the date exist?
		if (findNonExistingDate(day, month, year))
		{
			//are they of legal age?
			if (validate(day, month, year))
			{
				return authorized = true;
			}
		}
		return authorized;
	}
	
	/**
	 * </p>
	 * @deprecated
	 * @params day, month and year
	 * @return <strong>Authorization = false</strong> or <strong>Authorization = true</strong> 
	 *         for use the application
	 * </p>
	 */
	protected boolean isAgeClientAuthorized1(int day, String month, int year) {
		boolean authorized = false;
		
		if (!(findNonExistingDate(day, month, year))) 
		{
			for (int i = 0; i < MONTHS_OF_THE_YEAR_CATEGORY1.length; i++) 
			{
				if (month.equals(MONTHS_OF_THE_YEAR_CATEGORY1[i])) 
				{
					if (validate(day, month, year))
					{
						return authorized = true;
					}
				}
				else 
				{
					for (int j = 0; j < MONTHS_OF_THE_YEAR_CATEGORY2.length; j++)
					{
						if (month.equals(MONTHS_OF_THE_YEAR_CATEGORY2[j]))
						{
							if (validate(day, month, year))
							{
								return authorized = true;
							}
						}
						else
						{
							if (month.equals(MONTHS_OF_THE_YEAR_CATEGORY3))
							{
								if (validate(day, month, year))
								{
									return authorized = true;
								}
							}
						}
					}
				}
			}
		}
		return authorized;
	}
	
	/**
	 * <p> 
	 * <h3>@see this method analyzes and finds a possible error in the entry date</h3>
	 * @param day, this parameter is provided by the user
	 * @param month, this parameter is provided by the user
	 * @param year, this parameter is provided by the user
	 * @return true, if the input date exist
	 * @return false, if the input date doesn't exist</p>
	 */
	private boolean findNonExistingDate(int day, String month, int year) {
		boolean existingDate = false;
		
		if (getActualMonth().equals("Febrero"))
		{
			if ((day > 0) && (day <= 28))
			{
				return existingDate = true;
			}
		}
		else
		{
			for (int i = 0; i < MONTHS_OF_THE_YEAR_CATEGORY1.length; i++)
			{
				if (month.equals(MONTHS_OF_THE_YEAR_CATEGORY1[i]))
				{
					if ((day > 0) && (day <= 31))
					{
						return existingDate = true;
					}
				}
		    }
			
			for (int j = 0; j < MONTHS_OF_THE_YEAR_CATEGORY2.length; j++)
			{
				if (month.equals(MONTHS_OF_THE_YEAR_CATEGORY2[j]))
				{
					if ((day > 0) && (day <= 30))
					{
						return existingDate = true;
					}
				}
			}
		}
		
		//print popup message
		JOptionPane.showMessageDialog(null, 
				"Error.\nLa fecha: "+day+"/"+month+"/"+year+" no existe,\nPor favor, intente de nuevo.\n\n",
				"Register error", 
				JOptionPane.ERROR_MESSAGE);
		
		return existingDate;
	}
	
	/**
	 * <p> 
	 * @params ACTUAL_YEAR, ACTUAL_DAT. Attributes by the system
	 * @param year, day, provide by the user
	 * @return true, if the method determined that the date is valid
	 * @return false, if he method determined that the date is not invalid</p>
	 */
	private boolean validate(int day, String month, int year) {	
		boolean access = false;
		
		final int COLUMN = 3;
		final int ROW = 4;
		int[] entryMonth = {0,0}; //January -> default
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COLUMN; j++) {
				
				while (month.equals(MONTHS_BIDIMENSIONAL_FORMAT[i][j])) {
					entryMonth[0] = i;
					entryMonth[1] = j;
				
					if ((ACTUAL_YEAR - year) >= LEGAL_AGE) {//BASE CONDITION
						//CASE 1
						if ((entryMonth[0] == POSITION_OF_ACTUAL_MONTH[0])
								&& (entryMonth[1] == POSITION_OF_ACTUAL_MONTH[1])) {
							
							if (day <= ACTUAL_DAY) return access = true;
							
							return access = false;
						}
						//CASE 2 (multiple cases)
						if (((entryMonth[0] == 0 && POSITION_OF_ACTUAL_MONTH[0] == 0) && (entryMonth[1] > POSITION_OF_ACTUAL_MONTH[1]))
								|| ((entryMonth[0] > POSITION_OF_ACTUAL_MONTH[0]) 
										|| (entryMonth[1] > POSITION_OF_ACTUAL_MONTH[1]))) {
							
							if ((ACTUAL_YEAR - year) > LEGAL_AGE) return access = true;
							return access = false;
						}
						//CASE 3 (multiple cases)
						if (((entryMonth[0] == 0 && POSITION_OF_ACTUAL_MONTH[0] == 0) && (entryMonth[1] < POSITION_OF_ACTUAL_MONTH[1]))
								|| ((entryMonth[0] < POSITION_OF_ACTUAL_MONTH[0]) 
										|| (entryMonth[1] < POSITION_OF_ACTUAL_MONTH[1]))) {

							return access = true;
						}
						
						/*if ((entryMonth[0] == 0 && POSITION_OF_ACTUAL_MONTH[0] == 0) 
								&& (entryMonth[1] < POSITION_OF_ACTUAL_MONTH[1])) {
							return access = true;
						}else {
							if (entryMonth[0] < POSITION_OF_ACTUAL_MONTH[0]) {
								return access = true;
							}
						}*/
					}
					break;
				}
			}//COLUMN ITERATORR
		}//ROW ITERATOR
		
		return access;
	}
}