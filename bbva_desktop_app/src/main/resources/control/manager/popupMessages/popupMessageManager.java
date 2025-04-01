package main.resources.control.manager.popupMessages;

import javax.swing.JOptionPane;

import main.resources.control.manager.dialogs.Dialogs;

public class popupMessageManager extends Dialogs {
	
	private static Dialogs dialog = new Dialogs();
	
	public String WARNING_POPUP_MESSAGE;
	public String ERROR_IN_FORM_REGISTER;
	
	@SuppressWarnings("unused")
	private int WARNING_ACCEPT_TERMS_AND_CONDITIONS = 0;
	@SuppressWarnings("unused")
	private int EMPTY_OR_NULL_DATA_IN_FORM_REGISTER = 0;
	
	public String type;
	
	public popupMessageManager() {
		type = null;
	}
	
	@SuppressWarnings("static-access")
	public int getPopupMessages(String type) {
		this.type = type;
		
		if (this.type.equals(WARNING_POPUP_MESSAGE))
		{
			return WARNING_ACCEPT_TERMS_AND_CONDITIONS = 
					JOptionPane.showInternalOptionDialog(null,
					"Para crear tu cuenta debes aceptar los términos\n"
					+ "y condiciones expresados por el Grupo BBVA.\n\n¿Estás de acuerdo "
					+ "con los términos y condiciones?\n\n",
					"Políticas de usuario",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new Object[] {"Estoy de acuerdo","No estoy de acuerdo"}, "Estoy de acuerdo");
		}
		if (this.type.equals(ERROR_IN_FORM_REGISTER))
		{
			return EMPTY_OR_NULL_DATA_IN_FORM_REGISTER = 
					JOptionPane.showInternalOptionDialog(null,
							dialog.DIALOG_ERROR_IN_USER_REGISTER_FORM,
							dialog.TITLE_ERROR_IN_USER_REGISTER_FORM,
							JOptionPane.YES_OPTION, JOptionPane.ERROR_MESSAGE, null,
							new Object[] {"Aceptar"}, "Aceptar"); 
		}
		return 0;
	}
}
