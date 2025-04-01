package main.resources.control.manager.dialogs;

import javax.swing.JOptionPane;

public class Dialogs {
	
	private static String titleDialog = null;
	private static String bodyDialog = null;
	
	/**
	 * @see Message to print in GUI Frame
	 */
	public final String NOT_AVAILABLE_CONTENT_MESSAGE = "Lo sentimos, no hay nada por mostrar en estos momentos";

	/**
	 * @see DIALOGS FOR JLABELS TITLE IN REGISTER FORM
	 */
	public static final String TITLE_FORM_SECTION1 = "Proporciona tus datos generales";
	public static final String TITLE_FORM_SECTION2 = "¿En donde resides actualmente?";
	public static final String TITLE_FORM_SECTION3 = "Proporcione su información de contacto";
	public static final String TITLE_FORM_SECTION4 = "Establece una contraseña de seguridad";

	/**
	 * @see ERROR TITLES FOR POPUP MESSAGE 
	 */
	public static final String TITLE_ERROR_IN_USER_REGISTER_FORM        = "Proceso de registro erróneo";
	/**/
	public static final String TITLE_ERROR_IN_REGISTER_ADDITIONAL_EMAIL = "Registro de email erróneo";
	/**/
	public static final String TITLE_PASSWORD_IS_NOT_COENCIDENT         = "Contreaseñas no coinciden";
	/**/
	public static final String TITLE_AGE_IS_NOT_AUTHORIZED              = "Autorización denegada";
	/**/
	public static final String TITLE_CURP_IS_NOT_CORRECT                = "CURP errónea";
	/**/
	public static final String TITLE_PHONE_NUMBER_LENGTH_NOT_CORRECT    = "Información de contacto errónea";
	
	/**
	 * @see ERROR DIALOGS FOR POPUP MESSAGE 
	 */
	public static final String DIALOG_ERROR_IN_USER_REGISTER_FORM             = "Información incompleta.\nPor favor verifique que no falte ningún dato.\n\n";
	/**/
	public static final String DIALOG_ERROR_IN_REGISTER_ADDITIONAL_EMAIL      = "No ingresaste tu email.\nPor favor, ingresa la información completa.\n\n";
	/**/
	public static final String DIALOG_ERROR_IN_SELECT_DOMAIN_ADDITIONAL_EMAIL = "No selecionaste un dominio\nPor favor, seleciona el dominio de tu email.\n\n";
	/**/
	public static final String DIALOG_PASSWORD_IS_NOT_COENCIDENT              = "Las contraseñas no coinciden.\nRevise e intente de nuevo.\n\n";
	/**/
	public static final String DIALOG_AGE_IS_NOT_AUTHORIZED                   = "Lo sentimos pero no cuentas con la edad necesaria\npara utilizar una applicación bancaria.\n\n"
	                                                                		+ "Debes contar con al menos 18 años de edad cumplidos.\n\n";
	/**/
	public static final String DIALOG_CURP_IS_NOT_CORRECT                     = "Al parecer tu código único de registro de\npoblación (CURP) no es correcto.\n\n"
	                                                                   		+ "Verifique e intente de nuevo.\n\n";
	/**/
	public static final String DIALOG_PHONE_NUMBER_LENGTH_NOT_CORRECT         = "El número telefónico debe tener al menos 10 digítos.\n\n";
	
	public Dialogs() {
		//empty constructor
	}
	
	public void showPopupErrorMessage(String titleMessage, String contentMessage) {
		JOptionPane.showMessageDialog(null, 
				contentMessage,
				titleMessage,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void showPopupErrorMessage(String titleMessage, String contentMessage, int n) {
		JOptionPane.showMessageDialog(null, 
				contentMessage+n+" carácteres",
				titleMessage,
				JOptionPane.ERROR_MESSAGE);
	}
	
	public String showPresentationMessage(String titleMessage) {
		return titleMessage;
	}
	
	
	public String getTitleDialog() {
		return titleDialog;
	}
	
	public String getBodyDialog() {
		return bodyDialog;
	}
	
	public String getDialog(Object dlg) {
		return bodyDialog;
	}
}
