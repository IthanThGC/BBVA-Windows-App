package main.resources.control.manager.clientControl;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Administrator extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4186807177181994443L;
	public Icon BBVA_ICON_WINDOW = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/LogoBBVA/iconApp.png"));
	public Icon BBVA_LOGO_OFFICIAL = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/LogoBBVA/bbva_logo_startapp.png"));
	
	//BENEFITS ABOUT APPLICATION - ICONS
	public Icon BENEFITS_BBVA_LOGO_OFFICIAL = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/BenefitsBBVAWindow/benefitsLogoBBVA.png"));
	
	public Icon READ_MORE_ABOUT_BENEFITS_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/BenefitsBBVAWindow/read_more_entered.png"));
	public Icon READ_MORE_ABOUT_BENEFITS_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/BenefitsBBVAWindow/read_more_exited.png"));

	public Icon REGISTER_ACCOUNT_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/BenefitsBBVAWindow/register_entered.png"));
	public Icon REGISTER_ACCOUNT_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/BenefitsBBVAWindow/register_exited.png"));

	//REGISTER ACCOUNT - ICONS
	public Icon bbva_official_logo_register = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/x1.png"));

	public Icon icon_consult_external_web_site_exited = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/consult_curp_exited.png"));
	public Icon icon_consult_external_web_site_entered = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/consult_curp_entered.png"));
	
	public Icon arrow_left_inactive = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/arrow_left_not_enabled.png"));
	public Icon arrow_right_exited = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/arrow_right_exited.png"));
	public Icon arrow_right_entered = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/arrow_right_entered.png"));
	public Icon arrow_left_exited = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/arrow_left_exited.png"));
	public Icon arrow_left_entered = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/arrow_left_entered.png"));
	
	public Icon ADDITIONAL_EMAIL_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/add_additional_email_entered.png"));
	public Icon ADDITIONAL_EMAIL_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/add_additional_email_exited.png"));
	
	public Icon UPDATE_ADDITIONAL_EMAIL_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/update_password_entered.png"));
	public Icon UPDATE_ADDITIONAL_EMAIL_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/RegisterAccountWindow/update_password_exited.png"));

	//POPUP WINDOW -> ADDITIONAL EMAIL WINDOW ICONS
	public Icon ADDITIONAL_EMAIL_REGISTER_LEFT_ARROW_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/AdditionalEmailWindow/cancel_operation_entered.png"));
	public Icon ADDITIONAL_EMAIL_REGISTER_LEFT_ARROW_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/AdditionalEmailWindow/cancel_operation_exited.png"));
	public Icon ADDITIONAL_EMAIL_REGISTER_BBVA_LOGO_BANNER = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/AdditionalEmailWindow/bbva_logo_header.png"));

	public Icon INPUT_CORRECT = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/AdditionalEmailWindow/correct_email_icon.png"));
	public Icon INPUT_INCORRECT = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/AdditionalEmailWindow/error_email_icon.png"));

	//POPUP WINDOW -> ERROR MESSAGE REGISTER
	public Icon ERROR_DIALOG = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V2/PopupWindow/ErrorMessageRegisterWindow/error_dialog.png"));

	//REGISTER ACCOUNT - DIALOGS
	public final String titleFormSection1 = "Proporciona tus datos generales";
	public final String titleFormSection2 = "¿Donde resides acutalmente?";
	public final String titleFormSection3 = "Proporcionanos tus datos de contacto";
	//Al parecer no ha ingresado ningún dato o hay datos faltantes.\nPor favor, ingrese la información marcada con *.\n\nLe sugerimos revisar he intentar de nuevo.\n\n
	public final String errorInRegisterFormMessage = "Información incompleta.\nVerifica e intenta de nuevo.\n\n";
	
	public final String MESSAGE_ERROR_IN_SELECTED_DOMAIN_ITEM = "Datos incompletos.\nAl parecer no seleccionaste el dominio de\ntu dirección de email.\n\nVerifica e intenta de nuevo.\n";
	public final String MESSAGE_ERROR_IN_ALL_REGISTER_ADDITIONAL_EMAIL = "No ingresaste ningún dato.\nPor favor, ingresa la información que se solicita.\n\n";
	
	//LOGIN APPLICATION - ICONS
	//public final Icon BBVA_OFFIAL_LOGO = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/"));
	public final Icon USERNAME = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/user_icon.png"));
	public final Icon PASSWORD_BLOCKED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/blocked_pass_ico.png"));
	public final Icon PASSWORD_UNLOCKED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/visible_pass_ico.png"));

	public final Icon PASSWORD_VISIBILITY_VISIBLE_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/visibility_visible_entered_ico.png"));
	public final Icon PASSWORD_VISIBILITY_VISIBLE_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/visibility_visible_exited_ico.png"));
	public final Icon PASSWORD_VISIBILITY_HIDDEN_ENTERED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/visibility_hidden_entered_ico.png"));
	public final Icon PASSWORD_VISIBILITY_HIDDEN_EXITED = new ImageIcon(Administrator.class.getResource("/Resources/Visual/Icons/V1/LoginApplicationWindow/visibility_hidden_exited_ico.png"));

	public Administrator() {
		/*Empty*/
	}
	
	
}
