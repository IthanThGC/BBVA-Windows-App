package main.java.com.bbva_digital_app.popup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import main.resources.control.manager.dialogs.Dialogs;
import main.resources.visual.manager.classes.ColorManager;
import main.resources.visual.manager.classes.FontManager;
import main.resources.visual.manager.classes.IconImageManager;
import main.resources.visual.swingcomponents.RoundedPanel;

public class RegisterAdditionalEmail extends JDialog {

	private static final long serialVersionUID = 1781823567010680310L;

	private final JPanel Container = new JPanel();
	
	private Dialogs dialog = new Dialogs();
	private IconImageManager icon = new IconImageManager();
	
	private JPanel content_header;
	private JPanel content_input_email;
	private JPanel content_footer;
	
	private JLabel lbl_header_title;
	
	@SuppressWarnings("rawtypes")
	private JComboBox box_email_domains;
	private JTextField txt_email_address;
	private JLabel lbl_email_ilustration;
	
	private JLabel lbl_button_cancel_text, lbl_button_save_text;
	private RoundedPanel btn_save, btn_cancel;
	
	private boolean emailError              = false;
	private boolean emailAdded              = false;
	protected String additionalEmail        = null;
	private static final String PLACEHOLDER = "Dirección de correo electrónico"; 

	/**
	 * @see visual resources 
	 */
	private ColorManager background = new ColorManager();
	private ColorManager colorFont = new ColorManager();
	private FontManager fontStyle = new FontManager();

	/**
	 * Launch the application.
	 */
	
	/*public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			RegisterAdditionalEmail dialog = new RegisterAdditionalEmail();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public RegisterAdditionalEmail() {
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				setDomainsItems();
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				if (windowClosingWarningPopupMessage() == JOptionPane.YES_OPTION) {
					dispose();
				}else {
					setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Información de contacto");
		setType(Type.POPUP);
		setResizable(false);
		setLocation(getX()+410, getY()+200);
		setSize(525, 330);
		getContentPane().setLayout(new BorderLayout());
		Container.setBorder(new EmptyBorder(5, 5, 5, 5));
		Container.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		getContentPane().add(Container, BorderLayout.CENTER);
		Container.setLayout(null);

		content_header = new JPanel();
		content_header.setBounds(0,0,508,90);
		content_header.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_header.setLayout(null);
		Container.add(content_header);
		
		content_input_email = new JPanel();
		content_input_email.setBounds(0,90,508,123);
		content_input_email.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_input_email.setLayout(null);
		Container.add(content_input_email);
		
		content_footer = new JPanel();
		content_footer.setBounds(0,213,508,78);
		content_footer.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_footer.setLayout(null);
		Container.add(content_footer);
		
		lbl_header_title = new JLabel();
		lbl_header_title.setBounds(0,0,508,90);
		lbl_header_title.setIcon(icon.PREVIEW_DATA_BBVA_LOGO_LIGHT_BACKGROUND);
		//lbl_header_title.setText("Añade un correo electrónico");
		lbl_header_title.setFont(new Font("Segoe UI Semibold", Font.BOLD, 22));
		lbl_header_title.setForeground(new Color(0,167,179));
		lbl_header_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_header_title.setVerticalAlignment(SwingConstants.CENTER);
		content_header.add(lbl_header_title);
		
		lbl_email_ilustration = new JLabel();
		lbl_email_ilustration.setBounds(28,11,479,40);
		lbl_email_ilustration.setIcon(icon.ADDITIONAL_EMAIL_CORRECT_LIGHT_VERSION);
		lbl_email_ilustration.setText("Correo electrónico secundario *");
		lbl_email_ilustration.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 19));
		lbl_email_ilustration.setForeground(new Color(0, 0, 0));
		lbl_email_ilustration.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_email_ilustration.setVerticalAlignment(SwingConstants.CENTER);
		content_input_email.add(lbl_email_ilustration);
		
		JTextField txt = new JTextField();
		txt.setBounds(0, 0, 0, 0);
		Container.add(txt);
		
		txt_email_address = new JTextField();
		txt_email_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_email_address.setEditable(true);
				txt_email_address.setForeground(new Color(0,0,0));
				txt_email_address.setFont(fontStyle.TEXTFIELD_STANDARD);
				
				if (!getEmailError()) 
				{
					if (txt_email_address.getText().equals(PLACEHOLDER))
					{
						txt_email_address.setText("");
					}
					else 
					{
						txt_email_address.setText(txt_email_address.getText() + "");
					}
				}
				else 
				{
					setEmailError(false);
					txt_email_address.setText("");
					lbl_email_ilustration.setIcon(icon.ADDITIONAL_EMAIL_CORRECT_LIGHT_VERSION);
				}
			}
		});
		txt_email_address.setBounds(28,64,288,37);
		txt_email_address.setText(PLACEHOLDER);
		txt_email_address.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		txt_email_address.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_email_address.setBackground(new Color(255,255,255));
		txt_email_address.setEditable(false);
		txt_email_address.setOpaque(false);
		content_input_email.add(txt_email_address);
		
		box_email_domains = new JComboBox();
		box_email_domains.addItem(makeObj("Dominio"));
		box_email_domains.setBounds(333,65,150,35);
		box_email_domains.setFont(new Font("Nirmala UI", Font.PLAIN, 16));
		content_input_email.add(box_email_domains);
		
		/*lbl_icon_arrow = new JLabel();
		lbl_icon_arrow.setBounds(265,32,30,35);
		lbl_icon_arrow.setIcon(icon.CANCEL_OPERATION_REGISTER_ADDITIONAL_EMAIL_EXITED);
		lbl_icon_arrow.setHorizontalAlignment(SwingConstants.CENTER);
		content_footer.add(lbl_icon_arrow);*/
		
		btn_cancel = new RoundedPanel();
		btn_cancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_cancel.setBackground(new Color(6, 63, 125));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_cancel.setBackground(new Color(5, 51, 101));
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btn_cancel.setBounds(265,27,105,40);
		((RoundedPanel) btn_cancel).setCornerRadius(7);
		btn_cancel.setBackground(new Color(5, 51, 101));
		btn_cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_cancel.setLayout(null);
		content_footer.add(btn_cancel);
		
		lbl_button_cancel_text = new JLabel();
		lbl_button_cancel_text.setBounds(5, 5, 100, 35);
		lbl_button_cancel_text.setText("Cancelar");
		lbl_button_cancel_text.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lbl_button_cancel_text.setForeground(new Color(255, 255, 255));
		lbl_button_cancel_text.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_button_cancel_text.setVerticalAlignment(SwingConstants.CENTER);
		lbl_button_cancel_text.setIcon(null);
		btn_cancel.add(lbl_button_cancel_text);
		
		btn_save = new RoundedPanel();
		btn_save.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_save.setBackground(new Color(6, 63, 125));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				btn_save.setBackground(colorFont.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((!isEmailEmptyOrNull(txt_email_address))
						&& (!isUnselectedDomainItem(box_email_domains))
						&& (!getEmailError())) 
				{
					setEmailError(false);
					setAdditionalEmail(txt_email_address);
				}
				else 
				{
					if (isEmailEmptyOrNull(txt_email_address)) 
					{
						eventsErrorInputEmail();
					}
					else 
					{
						if (isUnselectedDomainItem(box_email_domains)) 
						{
							eventsErrorInputDomain();
						}
					}
				}
			}
		});
		btn_save.setBounds(378,27,105,40);
		((RoundedPanel) btn_save).setCornerRadius(7);
		btn_save.setBackground(new Color(5, 51, 101));
		btn_save.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_save.setLayout(null);
		content_footer.add(btn_save);
		
		lbl_button_save_text = new JLabel();
		lbl_button_save_text.setBounds(5, 5, 100, 35);
		lbl_button_save_text.setText("Guardar");
		lbl_button_save_text.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 17));
		lbl_button_save_text.setForeground(new Color(255, 255, 255));
		lbl_button_save_text.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_button_save_text.setVerticalAlignment(SwingConstants.CENTER);
		lbl_button_save_text.setIcon(null);
		btn_save.add(lbl_button_save_text);
	}
	
	/**
	 * <strong>Methods controllers</strong>
	 * <p>The description about the methods:</p>
	 * <ul>
	 *   <li>{@link #eventsErrorInputEmail()}</li>
	 *   <li>{@link #eventsErrorInputDomain()}</li>
	 *   <li>{@link #setDomainsItems()}</li>
	 * </ul>
	 */

	/**
	 * <strong>Method makeObj()</strong>
	 * <p>@param Selected item from the JComboBox
	 * @return Conversion from String to Object</p>
	 */
	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}
	
	/**
	 * <strong>Method eventsErrorInputEmail()</strong>
	 * <p>This method managed the visual and internal 
	 * event when the system detected email error</p>
	 */
	@SuppressWarnings("static-access")
	private void eventsErrorInputEmail() {
		//email error detected
		setEmailError(true);
		
		//apply modifies to GUI components
		txt_email_address.setForeground(new Color(236, 112, 99));
		txt_email_address.setText("Campo obligatorio");
		txt_email_address.setFont(new Font("Nirmala UI Bold", Font.PLAIN, 16));
		lbl_email_ilustration.setIcon(icon.ADDITIONAL_EMAIL_INCORRECT);
		
		//build and show popup error message
		dialog.showPopupErrorMessage(dialog.TITLE_ERROR_IN_REGISTER_ADDITIONAL_EMAIL, 
				dialog.DIALOG_ERROR_IN_REGISTER_ADDITIONAL_EMAIL);
	}
	
	/**
	 * <strong>Method eventsErrorInputDomain()</strong>
	 * <p>This method managed the visual and internal 
	 * event when the system detected a domain error</p>
	 */
	@SuppressWarnings("static-access")
	private void eventsErrorInputDomain() {
		//domain error detected
		setEmailError(true);
		
		//build and show popup error message
		dialog.showPopupErrorMessage(dialog.TITLE_ERROR_IN_REGISTER_ADDITIONAL_EMAIL, 
				dialog.DIALOG_ERROR_IN_SELECT_DOMAIN_ADDITIONAL_EMAIL);
	}
	
	private int windowClosingWarningPopupMessage() {
		return JOptionPane.showInternalOptionDialog(null,	 
			    	"Su información de contacto se perderá",
				    "Aviso del sistema",
			    	JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,null,
		    		new Object[] {"Salir", "Cancelar"}, "Cancelar");
	}
	
	/**
	 * <strong>Method setDomainsItems()</strong>
	 * <p>This method is initialized when the JFrame
	 * is activated, build and put an array with the
	 * list of email domain</p>
	 */
	@SuppressWarnings("unchecked")
	private void setDomainsItems() {
		String domains[] = {
				"@gmail.com" , "@hotmail.com",
				"@icloud.com", "@outlook.com", 
			    "@proton.com"
		};
		
		for (int i = 0; i < domains.length; i++) 
		{
			box_email_domains.addItem(makeObj(String.valueOf(domains[i])));
		}
	}
	
	/**
	 * @param email
	 * @return True if the input email is empty
	 * @return False if the input email is not empty
	 */
	private boolean isEmailEmptyOrNull(final JTextField email) {
		if ((email.getText().length() == 0) 
				|| (email.getText().equals(PLACEHOLDER))) return true;
		
		return false;
	}
	
	/**
	 * @param item
	 * @return True if the email domain's JComboBox is not selected
	 * @return False if the email domain's JComboBox is selected
	 */
	@SuppressWarnings("rawtypes")
	private boolean isUnselectedDomainItem(final JComboBox item) {
		if (item.getSelectedIndex() == 0) return true;
		
		return false;
	}
	
	/*
	 * @param domain
	 * @return The selected email´s domain
	 */
	@SuppressWarnings("rawtypes")
	private String getSelectedDomainItem(final JComboBox domain) {
		return domain.getSelectedItem().toString();
	}
	
	/**
	 * @param additionalEmail
	 */
	private void setAdditionalEmail(JTextField additionalEmail) {
		//set full email
		this.additionalEmail = additionalEmail.getText().
				concat(getSelectedDomainItem(box_email_domains));
		
		//set flag attribute
		setEmailAdded(true);
		
		dispose();
	}
	
	public String getAdditionalEmail() {
		return additionalEmail;
	}
	
	/**
	 * @see flag error attribute 
	 */
	private void setEmailError(boolean emailError) {
		this.emailError = emailError;
	}
	
	private boolean getEmailError() {
		return emailError;
	}
	
	/**
	 * @see setter and getter methods of boolean attribute -> emailAdded
	 */
	private void setEmailAdded(boolean emailAdded) {
		this.emailAdded = emailAdded;
	}
	
	public boolean isEmailAdded() {
		return emailAdded;
	}
}
