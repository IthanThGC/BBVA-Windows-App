package main.visual.gui.LaunchRegister;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.java.com.bbva_digital_app.popup.RegisterAdditionalEmail;
import main.java.com.bbva_digital_app.register.client.LaunchRegister1;
import main.resources.visual.manager.classes.*;
import main.resources.visual.swingcomponents.RoundedJTextField;

public class LaunchRegisterVisualGui extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel Frame;
	
	    //Instance to show the data client
		//private PreviewDataClient dataClient;
			
		//Instance of another JFrame
		/*private LoginApplication login;
		private ClientRedirection redirection;*/
		
		//external web resources
		/*1: Online consult curp
		private final String LINK_CONSULT_CURP_OFFICIAL_SITE = "https://www.gob.mx/curp/";
		
		private final Link CONSULT_MY_CURP = new Link(LINK_CONSULT_CURP_OFFICIAL_SITE);
		
		//2: Online consult postal code (cp)
		
		private final String LINK_CONSULT_CP_OFFICIAL_SITE = "https://www.correosdemexico.gob.mx/sslservicios/consultacp/descarga.aspx";
		private final Link CONSULT_MY_CP = new Link(LINK_CONSULT_CP_OFFICIAL_SITE);*/
		
		//visual resources
		private IconImageManager icon = new IconImageManager();
		private ColorManager colorFont = new ColorManager();
		private ColorManager background = new ColorManager();
		private FontManager fontStyle = new FontManager();
		//private Dialogs dialog = new Dialogs();
		private RegisterAdditionalEmail additionalEmail = new RegisterAdditionalEmail();
		
		//control resources
		//private ManagerSpecialCasesData manager = new ManagerSpecialCasesData();
		
		private JPanel Container;
		private JPanel content_logo;
		private JLabel lbl_official_logo;
		
		private JPanel header, footer;
		private JPanel container_form;
		
		private JPanel container_form_section3;
		
		/*private int sectionForm = 0;
		private JPanel container_form_section1;
		private JPanel container_form_section2;
		private JPanel container_form_section4;	
		private JPanel container_layer_register_client;
		private JPanel btn_move_right, btn_move_left;
		private JPanel btn_move_left_inactive;*/
		
		//direction buttons components
		private JLabel lbl_close_and_back;
		private JLabel lbl_title_header;
		private JLabel lbl_indications_form;
		/*private JLabel lbl_text_right, lbl_text_left, lbl_icon_move_right;
		private JLabel lbl_text_left_inactive;
		private boolean move_to_right = false;
		private boolean move_to_left = false;*/
		private JLabel lbl_have_account;
		private JLabel lbl_login_app;
		
		//components for section1
		/*private JLabel lbl_input_name,lbl_input_lastnameP,lbl_input_lastnameM;
		private JLabel lbl_input_dateborn;
		private JLabel lbl_input_curp, lbl_consult_curp;*/
		public JTextField txt_client_name, txt_last_name_p, txt_last_name_m;
		public JTextField txt_curp_client;
		public JComboBox<Object> box_day_items, box_month_items, box_year_items;
		
		//components for section2
		/*private JLabel lbl_state_residence, lbl_city_residence, lbl_street_residence;
		private JLabel lbl_cp, lbl_num_exterior, lbl_num_interior;
		private JLabel lbl_consult_cp; 
		private JTextField txt_state_residence, txt_city_residence, txt_street_residence, txt_cp_residence;
		private JTextField txt_num_exterior, txt_num_interior;*/
		
		//components for section3
		private JLabel lbl_email_address;
		private JLabel lbl_phone_number_principal, lbl_phone_number_secundary;
		private JLabel lbl_input_email_address_secundary, lbl_email_address_secundary_update;
		private JTextField txt_email_address, txt_phone_number_principal, txt_phone_number_secundary;
		
		//components for section4
		//private JLabel lbl_input_password, lbl_input_confirm_password;
		
		/*private JPasswordField jpsf_password, jpsf_confirm_password;
		private JTextField txt_password, txt_confirm_password;
		private JCheckBox checkBox_password_visibility;*/
		
		//@see Layer to create account
		/*private JLabel lbl_subtitile_create_account;
		private JPanel button_create_account;
		private JLabel lbl_text_button_create_account;
		private JSeparator separator_position_top, separator_position_bottom;*/
		//link to terms and conditions of product 
	  
		//private JLabel lbl_consult_terms_conditions, open_external_resource;
		//private JCheckBox terms_conditions_licenses;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LaunchRegisterVisualGui frame = new LaunchRegisterVisualGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LaunchRegisterVisualGui() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LaunchRegister1.class.getResource("/main/resources/visual/icons/V2/bbva_logo/iconApp.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Registro | BBVA Digital");
		setType(Type.POPUP);
		setResizable(false);
		setBounds(165,50,1020,670);
		Frame = new JPanel();
		Frame.setBackground(new Color(7,33,70));
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		JButton btn = new JButton();
		btn.setBounds(0,0,0,0);
		btn.setEnabled(true);
		Frame.add(btn);
		
		Container = new JPanel();
		Container.setBounds(0,0,1004,631);
		Container.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
		Container.setLayout(null);
		Frame.add(Container);
		
		//PRESENTATION BBVA LOGO
		
		content_logo = new JPanel();
		content_logo.setBounds(0,0,400,631);
		content_logo.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
		content_logo.setLayout(null);
		Container.add(content_logo);
		
		lbl_official_logo = new JLabel();
		lbl_official_logo.setForeground(new Color(0, 183, 196));
		lbl_official_logo.setBounds(0,0,400,631);
		lbl_official_logo.setIcon(icon.BBVA_OFFICIAL_LOGO_REGISTER_OP1);
		lbl_official_logo.setHorizontalAlignment(SwingConstants.LEFT);
		content_logo.add(lbl_official_logo);
		
		//HEADER
		
		header = new JPanel();
		header.setBounds(400,0,604,130);
		header.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		header.setLayout(null);
		Container.add(header);
		
		lbl_close_and_back = new JLabel();
		lbl_close_and_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_close_and_back.setIcon(icon.RETURN_TO_REDIRECTION_PAGE_ENTERED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_close_and_back.setIcon(icon.RETURN_TO_REDIRECTION_PAGE_EXITED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				//showCancelRegisterWarningMessage();
			}
		});
		lbl_close_and_back.setBounds(13,29,15,40);
		lbl_close_and_back.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl_close_and_back.setIcon(icon.RETURN_TO_REDIRECTION_PAGE_EXITED);
		lbl_close_and_back.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close_and_back.setVerticalAlignment(SwingConstants.CENTER);
		header.add(lbl_close_and_back);
		
		lbl_title_header = new JLabel();
		lbl_title_header.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_title_header.setBounds(0, 0, 604, 70);
		lbl_title_header.setText("Inicia tu registro en BBVA Digital");
		lbl_title_header.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 34));
		//lbl_title_header.setForeground(new Color(0,167,179));
		lbl_title_header.setForeground(new Color(5,51,101));
		lbl_title_header.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lbl_title_header);
		
		lbl_indications_form = new JLabel();
		lbl_indications_form.setText("Este es un subtitulo de prueba");
		lbl_indications_form.setBounds(0, 80, 604, 50);
		lbl_indications_form.setFont(new Font("Microsoft YaHei", Font.PLAIN, 22));
		lbl_indications_form.setForeground(new Color(0, 0, 0));
		lbl_indications_form.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lbl_indications_form);
		
		//FOOTER
		
		footer = new JPanel();
		footer.setBounds(400,472,604,159);
		footer.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		footer.setLayout(null);
		Container.add(footer);
		
		lbl_have_account = new JLabel();
		lbl_have_account.setBounds(0,50,604,25);
		lbl_have_account.setText("¿Ya tienes una cuenta en BBVA Digital?");
		lbl_have_account.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));
		lbl_have_account.setForeground(new Color(0,0,0));
		lbl_have_account.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_have_account.setVerticalAlignment(SwingConstants.CENTER);
		footer.add(lbl_have_account);
		
		lbl_login_app = new JLabel();
		lbl_login_app.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				/*login = new LoginApplication();
				login.setVisible(true);*/
			}
		});
		lbl_login_app.setBounds(250,80,98,22);
		lbl_login_app.setText("Iniciar sesión");
		lbl_login_app.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		//lbl_login_app.setForeground(new Color(0,167,179));
		lbl_login_app.setForeground(new Color(0, 156, 165));
		lbl_login_app.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login_app.setVerticalAlignment(SwingConstants.CENTER);
		lbl_login_app.setCursor(new Cursor(Cursor.HAND_CURSOR));
		footer.add(lbl_login_app);
		
		/*SECTIONS OF FORM*/
		
		container_form = new JPanel();
		container_form.setBounds(400,130,604,342);
		container_form.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form.setLayout(null);
		container_form.setVisible(true);
		Container.add(container_form);
				
				/*
				 * @see The layer to create account client
				 * */
				
				/*
				 * @see The layer to create account client
				 * */
				/*container_layer_register_client = new JPanel();
				container_layer_register_client.setBounds(0,0,604,342);
				container_layer_register_client.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
				container_layer_register_client.setLayout(null);
				container_layer_register_client.setVisible(false);
				container_form.add(container_layer_register_client);
				
			    lbl_subtitile_create_account = new JLabel();
				lbl_subtitile_create_account.setText("A un clic de crear tu cuenta");
				lbl_subtitile_create_account.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_subtitile_create_account.setForeground(new Color(0, 183, 196));
				lbl_subtitile_create_account.setFont(new Font("Microsoft JhengHei UI Light", Font.PLAIN, 34));
				lbl_subtitile_create_account.setBounds(0, 40, 585, 43);
				container_layer_register_client.add(lbl_subtitile_create_account);
			
				button_create_account = new RoundedPanel();
				button_create_account.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						button_create_account.setBackground(new Color(11, 61, 115));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						button_create_account.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
					}
					@Override
					public void mouseClicked(MouseEvent e) {
						
						if (terms_conditions_licenses.isSelected())
						{
							System.out.print("Next step: create account\n");
						}
						else
						{
							if (showUserLicencePopupMessage() == JOptionPane.NO_OPTION)
							{
								showCancelRegisterWarningMessage();
							}
						}
					}
				});
				button_create_account.setBounds(173,130,235,55);
				((RoundedPanel) button_create_account).setCornerRadius(12);
				button_create_account.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
				button_create_account.setOpaque(false);
				button_create_account.setLayout(null);
				button_create_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
				container_layer_register_client.add(button_create_account);
				
				lbl_text_button_create_account = new JLabel();
				lbl_text_button_create_account.setBounds(5,5,230,50);
				lbl_text_button_create_account.setText("Crear mi cuenta");
				lbl_text_button_create_account.setFont(new Font("Yu Gothic UI", Font.PLAIN, 21));
				lbl_text_button_create_account.setForeground(new Color(255,255,255));
				lbl_text_button_create_account.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_text_button_create_account.setVerticalAlignment(SwingConstants.CENTER);
				button_create_account.add(lbl_text_button_create_account);
				
				lbl_consult_terms_conditions = new JLabel();
				lbl_consult_terms_conditions.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						open_external_resource.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_ENTERED);
						lbl_consult_terms_conditions.setForeground(new Color(0,0,0));
					}
					@Override
					public void mouseExited(MouseEvent e) {
						open_external_resource.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_EXITED);
						lbl_consult_terms_conditions.setForeground(Color.DARK_GRAY);
					}
				});
				lbl_consult_terms_conditions.setBounds(143, 240, 317, 30);
				lbl_consult_terms_conditions.setText("Consulta los términos y condiciones");
				lbl_consult_terms_conditions.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
				lbl_consult_terms_conditions.setForeground(Color.DARK_GRAY);
				lbl_consult_terms_conditions.setHorizontalAlignment(SwingConstants.LEFT);
				lbl_consult_terms_conditions.setVerticalAlignment(SwingConstants.CENTER);
				lbl_consult_terms_conditions.setCursor(new Cursor(Cursor.HAND_CURSOR));
				container_layer_register_client.add(lbl_consult_terms_conditions);
				
				open_external_resource = new JLabel();
				open_external_resource.setBounds(430, 242, 30, 30);
				open_external_resource.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_EXITED);
				open_external_resource.setHorizontalAlignment(SwingConstants.CENTER);
				open_external_resource.setVerticalAlignment(SwingConstants.CENTER);
				container_layer_register_client.add(open_external_resource);
				
				terms_conditions_licenses = new JCheckBox();
				terms_conditions_licenses.setBounds(0, 275, 585, 30);
				terms_conditions_licenses.setText(" Aceptar los términos y condiciones");
				terms_conditions_licenses.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
				terms_conditions_licenses.setForeground(new Color(0,0,0));
				terms_conditions_licenses.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
				terms_conditions_licenses.setHorizontalAlignment(SwingConstants.CENTER);
				terms_conditions_licenses.setVerticalAlignment(SwingConstants.CENTER);
				terms_conditions_licenses.setSelected(false);
				container_layer_register_client.add(terms_conditions_licenses);
				
				separator_position_top = new JSeparator();
				separator_position_top.setBounds(41, 20, 500, 1);
				separator_position_top.setForeground(new Color(0, 0, 0));
				separator_position_top.setBackground(new Color(0, 0, 0));
				container_layer_register_client.add(separator_position_top);
				
				separator_position_bottom = new JSeparator();
				separator_position_bottom.setBounds(41, 320, 500, 1);
				separator_position_bottom.setForeground(Color.BLACK);
				separator_position_bottom.setBackground(Color.BLACK);
				container_layer_register_client.add(separator_position_bottom);*/
		
		/*
		 * FINISH THE SECTION 2
		 * AND START THE SECTION 3
		 */
		
		container_form_section3 = new JPanel();
		container_form_section3.setBounds(0,0,604,342);
		container_form_section3.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form_section3.setLayout(null);
		container_form_section3.setVisible(true);
		container_form.add(container_form_section3);
		
		lbl_email_address = new JLabel();
		lbl_email_address.setBounds(27,31,247,40);
		lbl_email_address.setText("Correo electrónico *");
		lbl_email_address.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_email_address.setForeground(new Color(0, 0, 0));
		lbl_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_email_address.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section3.add(lbl_email_address);
		
		lbl_input_email_address_secundary = new JLabel();
		lbl_input_email_address_secundary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_input_email_address_secundary.setForeground(new Color(7,33,70));
				lbl_input_email_address_secundary.setIcon(icon.ADDITIONAL_EMAIL_ENTERED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_input_email_address_secundary.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				lbl_input_email_address_secundary.setIcon(icon.ADDITIONAL_EMAIL_EXITED);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (additionalEmail.getAdditionalEmail() == null) additionalEmail.setVisible(true);
				
				//get update email
				additionalEmail.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						if (additionalEmail.getAdditionalEmail() != null) updateAdditionalEmail();
					}
					@Override
					public void windowClosed(WindowEvent e) {
						if (additionalEmail.getAdditionalEmail() != null) updateAdditionalEmail();
					}
				});
			}
		});
		lbl_input_email_address_secundary.setBounds(370,31,210,40);
		lbl_input_email_address_secundary.setIcon(icon.ADDITIONAL_EMAIL_EXITED);
		lbl_input_email_address_secundary.setText("Añadir email adicional");
		lbl_input_email_address_secundary.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_input_email_address_secundary.setForeground(new Color(0, 0, 0));
		lbl_input_email_address_secundary.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_email_address_secundary.setVerticalAlignment(SwingConstants.CENTER);
		lbl_input_email_address_secundary.setCursor(new Cursor(Cursor.HAND_CURSOR));
		container_form_section3.add(lbl_input_email_address_secundary);
		
		lbl_email_address_secundary_update = new JLabel();
		lbl_email_address_secundary_update.setBounds(27,110,320,40);
		lbl_email_address_secundary_update.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_email_address_secundary_update.setForeground(new Color(0, 0, 0));
		lbl_email_address_secundary_update.setVerticalAlignment(SwingConstants.CENTER);
		lbl_email_address_secundary_update.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_email_address_secundary_update.setVisible(false);
		container_form_section3.add(lbl_email_address_secundary_update);
		
		lbl_phone_number_principal = new JLabel();
		lbl_phone_number_principal.setBounds(27,133,300,40);
		lbl_phone_number_principal.setText("Número teléfonico principal *");
		lbl_phone_number_principal.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_phone_number_principal.setForeground(new Color(0, 0, 0));
		lbl_phone_number_principal.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_phone_number_principal.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section3.add(lbl_phone_number_principal);
		
		lbl_phone_number_secundary = new JLabel();
		lbl_phone_number_secundary.setBounds(27,232,300,40);
		lbl_phone_number_secundary.setText("Número teléfonico secundario");
		lbl_phone_number_secundary.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_phone_number_secundary.setForeground(new Color(0, 0, 0));
		lbl_phone_number_secundary.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_phone_number_secundary.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section3.add(lbl_phone_number_secundary);
		
		txt_email_address = new RoundedJTextField(1);
		txt_email_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_email_address.setEditable(true);
				txt_email_address.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_email_address.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				/*if(txt_email_address.getText().equals(getPlaceHolder().get(10).toString())) {
					txt_email_address.setText("");
				}else {
					txt_email_address.setText(txt_email_address.getText()+"");
				}*/
			}
		});
		txt_email_address.setBounds(27,72,320,37);
		txt_email_address.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_email_address.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_email_address.setBackground(new Color(255,255,255));
		txt_email_address.setEditable(false);
		txt_email_address.setOpaque(false);
		container_form_section3.add(txt_email_address);
		
		txt_phone_number_principal = new RoundedJTextField(1);
		txt_phone_number_principal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_phone_number_principal.setEditable(true);
				txt_phone_number_principal.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_phone_number_principal.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				/*if(txt_phone_number_principal.getText().equals(getPlaceHolder().get(11).toString())) {
					txt_phone_number_principal.setText("");
				}else {
					txt_phone_number_principal.setText(txt_phone_number_principal.getText()+"");
				}*/
			}
		});
		txt_phone_number_principal.setBounds(27,170,320,37);
		txt_phone_number_principal.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_phone_number_principal.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_phone_number_principal.setBackground(new Color(255,255,255));
		txt_phone_number_principal.setEditable(false);
		txt_phone_number_principal.setOpaque(false);
		container_form_section3.add(txt_phone_number_principal);
		
		txt_phone_number_secundary = new RoundedJTextField(1);
		txt_phone_number_secundary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_phone_number_secundary.setEditable(true);
				txt_phone_number_secundary.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_phone_number_secundary.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				/*if(txt_phone_number_secundary.getText().equals(getPlaceHolder().get(12).toString())) {
					txt_phone_number_secundary.setText("");
				}else {
					txt_phone_number_secundary.setText(txt_phone_number_secundary.getText()+"");
				}*/
			}
		});
		txt_phone_number_secundary.setBounds(27,271,320,37);
		txt_phone_number_secundary.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_phone_number_secundary.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_phone_number_secundary.setBackground(new Color(255,255,255));
		txt_phone_number_secundary.setEditable(false);
		txt_phone_number_secundary.setOpaque(false);
		container_form_section3.add(txt_phone_number_secundary);
	}
	
	private void updateAdditionalEmail() {
		System.out.print("hola");
		if (additionalEmail.isEmailAdded())
		{
			lbl_phone_number_principal.setBounds(27,153,300,40);
			lbl_phone_number_secundary.setBounds(27,255,300,40);
			txt_phone_number_principal.setBounds(27,193,320,37);
			txt_phone_number_secundary.setBounds(27,294,320,37);
			
			//hidden visual component
			lbl_input_email_address_secundary.setVisible(false);

			//get and show the update email address
			lbl_email_address_secundary_update.setVisible(true);
			lbl_email_address_secundary_update.setText(additionalEmail.getAdditionalEmail());
		}
		
		/*lbl_input_email_address_secundary.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lbl_phone_number_principal.setBounds(27,153,300,40);
				lbl_phone_number_secundary.setBounds(27,255,300,40);
				txt_phone_number_principal.setBounds(27,193,320,37);
				txt_phone_number_secundary.setBounds(27,294,320,37);
				
				//hidden visual component
				lbl_input_email_address_secundary.setVisible(false);

				//get and show the update email address
				lbl_email_address_secundary_update.setText(additionalEmail.getAdditionalEmail());
			}
		});*/
	}
	
	/*private void passwordVisibilityEvents() {
		if(checkBox_password_visibility.isSelected()) {
			txt_password.setText(String.valueOf(jpsf_password.getPassword()));
			txt_password.setVisible(true);
			jpsf_password.setVisible(false);
			txt_confirm_password.setText(String.valueOf(jpsf_confirm_password.getPassword()));
			txt_confirm_password.setVisible(true);
			jpsf_confirm_password.setVisible(false);
		}else {
			jpsf_password.setText(txt_password.getText());
			jpsf_password.setVisible(true);
			txt_password.setVisible(false);
			jpsf_confirm_password.setText(txt_confirm_password.getText());
			jpsf_confirm_password.setVisible(true);
			txt_confirm_password.setVisible(false);
		}
	}
	
	private boolean isPasswordCoencident() {
		Object password = String.valueOf(jpsf_password.getPassword());
	    Object confirmPassword = String.valueOf(jpsf_confirm_password.getPassword());
	    
	    //is password visible?
		if (checkBox_password_visibility.isSelected()) 
		{
			password = txt_password.getText();
			confirmPassword = txt_confirm_password.getText();
		}
		
		//is coincide both password?
		if (!((password.toString().length() == 0) && (confirmPassword.toString().length() == 0))) 
		{
			if (password.equals(confirmPassword)) 
			{
				return true;
			}
		}
		return false;
	}
	
	private int warningTermsConditionsMessage() {
		return JOptionPane.showInternalOptionDialog(null,
				"Para crear tu cuenta debes aceptar los términos\n"
				+ "y condiciones expresados por el Grupo BBVA.\n\n¿Estás de acuerdo con los términos y condiciones?\n\n",
				"Políticas de usuario",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new Object[] {"Estoy de acuerdo","No estoy de acuerdo"}, "Estoy de acuerdo");
	}*/
}
