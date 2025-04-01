package main.java.com.bbva_digital_app.register.client;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.java.com.bbva_digital_app.access.ClientRedirection;
import main.java.com.bbva_digital_app.access.LoginApplication;
import main.java.com.bbva_digital_app.popup.RegisterAdditionalEmail;
import main.resources.control.manager.clientControl.registerClient.ManagerSpecialCasesData;
import main.resources.control.manager.dialogs.Dialogs;
import main.resources.visual.manager.classes.ColorManager;
import main.resources.visual.manager.classes.FontManager;
import main.resources.visual.manager.classes.IconImageManager;
import main.resources.visual.swingcomponents.Link;
import main.resources.visual.swingcomponents.RoundedJPasswordField;
import main.resources.visual.swingcomponents.RoundedJTextField;
import main.resources.visual.swingcomponents.RoundedPanel;

public class LaunchRegister1 extends JFrame {

	private static final long serialVersionUID = 2536853007280556436L;

	private JPanel Frame;
	
	//Instance to show the data client
	private PreviewDataClient dataClient;
		
	//Instance of another JFrame
	private LoginApplication login;
	private ClientRedirection redirection;
	
	//external web resources
	//1: Online consult curp
	private final String LINK_CONSULT_CURP_OFFICIAL_SITE = "https://www.gob.mx/curp/";
	private final Link CONSULT_MY_CURP = new Link(LINK_CONSULT_CURP_OFFICIAL_SITE);
	//2: Online consult postal code (cp)
	private final String LINK_CONSULT_CP_OFFICIAL_SITE = "https://www.correosdemexico.gob.mx/sslservicios/consultacp/descarga.aspx";
	private final Link CONSULT_MY_CP = new Link(LINK_CONSULT_CP_OFFICIAL_SITE);
	
	//visual resources
	private IconImageManager icon = new IconImageManager();
	private ColorManager colorFont = new ColorManager();
	private ColorManager background = new ColorManager();
	private FontManager fontStyle = new FontManager();
	//private Dialogs dialog = new Dialogs();
	private RegisterAdditionalEmail additionalEmail = new RegisterAdditionalEmail();
	
	//control resources
	private ManagerSpecialCasesData manager = new ManagerSpecialCasesData();
	
	private int sectionForm = 0;
	private JPanel Container;
	private JPanel content_logo;
	private JLabel lbl_official_logo;
	
	private JPanel header, footer;
	private JPanel container_form;
	private JPanel container_form_section1;
	private JPanel container_form_section2;
	private JPanel container_form_section3;
	private JPanel container_form_section4;	
	private JPanel container_layer_register_client;
	private JPanel btn_move_right, btn_move_left;
	private JPanel btn_move_left_inactive;
	
	//direction buttons components
	private JLabel lbl_close_and_back;
	private JLabel lbl_title_header;
	private JLabel lbl_indications_form;
	private JLabel lbl_text_right, lbl_text_left, lbl_icon_move_right;
	private JLabel lbl_text_left_inactive;
	private boolean move_to_right = false;
	private boolean move_to_left = false;
	private JLabel lbl_have_account;
	private JLabel lbl_login_app;
	
	//components for section1
	private JLabel lbl_input_name,lbl_input_lastnameP,lbl_input_lastnameM;
	private JLabel lbl_input_dateborn;
	private JLabel lbl_input_curp, lbl_consult_curp;
	public JTextField txt_client_name, txt_last_name_p, txt_last_name_m;
	public JTextField txt_curp_client;
	public JComboBox<Object> box_day_items, box_month_items, box_year_items;
	
	//components for section2
	private JLabel lbl_state_residence, lbl_city_residence, lbl_street_residence;
	private JLabel lbl_cp, lbl_num_exterior, lbl_num_interior;
	private JLabel lbl_consult_cp; 
	private JTextField txt_state_residence, txt_city_residence, txt_street_residence, txt_cp_residence;
	private JTextField txt_num_exterior, txt_num_interior;
	
	//components for section3
	private JLabel lbl_email_address;
	private JLabel lbl_edit_secon_email_address;
	private JLabel lbl_phone_number_principal, lbl_phone_number_secundary;
	private JLabel lbl_input_second_email_address, lbl_second_email_address;
	private JTextField txt_email_address, txt_phone_number_principal, txt_phone_number_secundary;
	
	//components for section4
	private JLabel lbl_input_password, lbl_input_confirm_password;
	private JPasswordField jpsf_password, jpsf_confirm_password;
	private JTextField txt_password, txt_confirm_password;
	private JCheckBox checkBox_password_visibility;
	
	//@see Layer to create account
	private JLabel lbl_subtitile_create_account;
	private JPanel button_create_account;
	private JLabel lbl_text_button_create_account;
	private JSeparator separator_position_top, separator_position_bottom;
	//link to terms and conditions of product 
    private JLabel lbl_consult_terms_conditions, open_external_resource;
	private JCheckBox terms_conditions_licenses;
	
	private ArrayList<Object> placeholder = new ArrayList<Object>();
	private ArrayList<Object> contentTextField = new ArrayList<Object>();
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run()
			{
				try 
				{
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					LaunchRegister1 frame = new LaunchRegister1();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public LaunchRegister1() 
	{
		addWindowListener(new WindowAdapter() 
		{
			public void windowOpened(WindowEvent e) 
			{
				initialEventsInSectionForm();
			}
		});
		addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				showCancelRegisterWarningMessage();
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LaunchRegister1.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Registrarse");
		setType(Type.POPUP);
		setResizable(false);
		setLocation(165, getY() + 40);
		setSize(1020, 670);
		Frame = new JPanel();
		Frame.setBackground(new Color(7,33,70));
		Frame.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		JTextField txt = new JTextField();
		txt.setEditable(false);
		txt.setBounds(0,0,0,0);
		Frame.add(txt);
		
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
		lbl_official_logo.setBounds(0,0,400,500);
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
				showCancelRegisterWarningMessage();
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
		lbl_have_account.setBounds(0,85,604,25);
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
				login = new LoginApplication();
				login.setVisible(true);
				dispose();
			}
		});
		lbl_login_app.setBounds(250,115,98,22);
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
		
		container_form_section1 = new JPanel();
		container_form_section1.setBounds(0,0,604,342);
		container_form_section1.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form_section1.setLayout(null);
		container_form_section1.setVisible(true);
		container_form.add(container_form_section1);
		
		container_form_section2 = new JPanel();
		container_form_section2.setBounds(0,0,604,342);
		container_form_section2.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form_section2.setLayout(null);
		container_form_section2.setVisible(false);
		container_form.add(container_form_section2);
		
		container_form_section3 = new JPanel();
		container_form_section3.setBounds(0,0,604,342);
		container_form_section3.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form_section3.setLayout(null);
		container_form_section3.setVisible(false);
		container_form.add(container_form_section3);
		
		container_form_section4 = new JPanel();
		container_form_section4.setBounds(0,0,604,342);
		container_form_section4.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_form_section4.setLayout(null);
		container_form_section4.setVisible(false);
		container_form.add(container_form_section4);
		
		/*******************************/
		
		lbl_input_name = new JLabel();
		lbl_input_name.setBounds(27,31,247,40);
		lbl_input_name.setText("Nombre(s) *");
		lbl_input_name.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_name.setForeground(new Color(0, 0, 0));
		lbl_input_name.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_name.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section1.add(lbl_input_name);
		
		lbl_input_lastnameP = new JLabel();
		lbl_input_lastnameP.setBounds(27,133,247,40);
		lbl_input_lastnameP.setText("Apellido paterno *");
		lbl_input_lastnameP.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_lastnameP.setForeground(new Color(0, 0, 0));
		lbl_input_lastnameP.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_lastnameP.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section1.add(lbl_input_lastnameP);
		
		lbl_input_lastnameM = new JLabel();
		lbl_input_lastnameM.setBounds(27,237,247,40);
		lbl_input_lastnameM.setText("Apellido  materno *");
		lbl_input_lastnameM.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_lastnameM.setForeground(new Color(0, 0, 0));
		lbl_input_lastnameM.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_lastnameM.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section1.add(lbl_input_lastnameM);
		
		txt_client_name = new RoundedJTextField(1);
		txt_client_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_client_name.setEditable(true);
				txt_client_name.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_client_name.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if(txt_client_name.getText().equals(getPlaceHolder().get(0).toString())) {
					txt_client_name.setText("");
				}else {
					txt_client_name.setText(txt_client_name.getText()+"");
				}
			}
		});
		txt_client_name.setBounds(27,72,247,37);
		txt_client_name.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_client_name.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_client_name.setBackground(new Color(255,255,255));
		txt_client_name.setEditable(false);
		txt_client_name.setOpaque(false);
		container_form_section1.add(txt_client_name);
		
		txt_last_name_p = new RoundedJTextField(1);
		txt_last_name_p.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_last_name_p.setEditable(true);
				txt_last_name_p.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_last_name_p.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));

				if(txt_last_name_p.getText().equals(getPlaceHolder().get(1).toString())) {
					txt_last_name_p.setText("");
				}else {
					txt_last_name_p.setText(txt_last_name_p.getText()+"");
				}
			}
		});
		txt_last_name_p.setBounds(27,173,247,37);
		txt_last_name_p.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_last_name_p.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_last_name_p.setBackground(new Color(255,255,255));
		txt_last_name_p.setEditable(false);
		txt_last_name_p.setOpaque(false);
		container_form_section1.add(txt_last_name_p);
		
		txt_last_name_m = new RoundedJTextField(1);
		txt_last_name_m.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_last_name_m.setEditable(true);
				txt_last_name_m.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_last_name_m.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if(txt_last_name_m.getText().equals(getPlaceHolder().get(2).toString())) {
					txt_last_name_m.setText("");
				}else {
					txt_last_name_m.setText(txt_last_name_m.getText()+"");
				}
			}
		});
		txt_last_name_m.setBounds(27,278,247,37);		
		txt_last_name_m.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_last_name_m.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_last_name_m.setBackground(new Color(255,255,255));
		txt_last_name_m.setEditable(false);
		txt_last_name_m.setOpaque(false);
		container_form_section1.add(txt_last_name_m);
		
		lbl_input_curp = new JLabel();
		lbl_input_curp.setText("CURP *");
		lbl_input_curp.setBounds(307,237,270,40);
		lbl_input_curp.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_curp.setForeground(new Color(0, 0, 0));
		lbl_input_curp.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_curp.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section1.add(lbl_input_curp);
		
		lbl_consult_curp = new JLabel();
		lbl_consult_curp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_consult_curp.setIcon(icon.icon_consult_external_web_site_entered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_consult_curp.setIcon(icon.icon_consult_external_web_site_exited);
			}
			@Override
			public void mouseClicked(MouseEvent e1) {
				lbl_consult_curp.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				try {
					CONSULT_MY_CURP.openWebSite();
				}catch(URISyntaxException e) {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos.\nOcurrio un error al abrir el sitio web.\n\nProblema: "+e.getReason()+"\n\n",
							"Error de software",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lbl_consult_curp.setBounds(547,237,30,40);
		lbl_consult_curp.setIcon(icon.icon_consult_external_web_site_exited);
		lbl_consult_curp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_consult_curp.setVerticalAlignment(SwingConstants.CENTER);
		lbl_consult_curp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		container_form_section1.add(lbl_consult_curp);
		
		txt_curp_client = new RoundedJTextField(1);
		txt_curp_client.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_curp_client.setEditable(true);
				txt_curp_client.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_curp_client.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if(txt_curp_client.getText().equals(getPlaceHolder().get(3).toString())) {
					txt_curp_client.setText("");
				}else {
					txt_curp_client.setText(txt_curp_client.getText()+"");
				}
			}
		});
		txt_curp_client.setBounds(307,278,270,37);
		txt_curp_client.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_curp_client.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_curp_client.setBackground(new Color(255,255,255));
		txt_curp_client.setEditable(false);
		txt_curp_client.setOpaque(false);
		container_form_section1.add(txt_curp_client);
		
		lbl_input_dateborn = new JLabel();
		lbl_input_dateborn.setBounds(307,31,270,40);
		lbl_input_dateborn.setText("Fecha de nacimiento *");
		lbl_input_dateborn.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_dateborn.setForeground(new Color(0, 0, 0));
		lbl_input_dateborn.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_dateborn.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section1.add(lbl_input_dateborn);
		
		box_day_items = new JComboBox();	
		box_day_items.addItem(makeObj("Día"));
		box_day_items.setName("box_day_items");
		box_day_items.setFont(new Font("Leelawadee UI", Font.PLAIN, 15));
		box_day_items.setBackground(new Color(255,255,255));
		box_day_items.setBounds(307,72,70,30);
		container_form_section1.add(box_day_items);

		box_month_items = new JComboBox();	
		box_month_items.addItem(makeObj("Mes"));
		box_month_items.setName("box_month_items");
		box_month_items.setBounds(387,72,110,30);
		box_month_items.setFont(new Font("Leelawadee UI", Font.PLAIN, 15));
		box_month_items.setBackground(new Color(255,255,255));
		container_form_section1.add(box_month_items);

	    box_year_items = new JComboBox();	
		box_year_items.addItem(makeObj("Año"));
		box_year_items.setBounds(507,72,70,30);
		box_year_items.setName("box_year_items");
		box_year_items.setFont(new Font("Leelawadee UI", Font.PLAIN, 15));
		box_year_items.setBackground(new Color(255,255,255));
		container_form_section1.add(box_year_items);
		
		/*
		 * FINISH THE SECTION 1
		 * AND START THE SECTION 2
		 */
		
		lbl_state_residence = new JLabel();
		lbl_state_residence.setBounds(27,31,247,40);
		lbl_state_residence.setText("Estado *");
		lbl_state_residence.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_state_residence.setForeground(new Color(0, 0, 0));
		lbl_state_residence.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_state_residence.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_state_residence);
		
		lbl_city_residence = new JLabel();
		lbl_city_residence.setBounds(27,133,247,40);
		lbl_city_residence.setText("Ciudad / Municipio *");
		lbl_city_residence.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_city_residence.setForeground(new Color(0, 0, 0));
		lbl_city_residence.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_city_residence.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_city_residence);
		
		txt_state_residence = new RoundedJTextField(1);
		txt_state_residence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_state_residence.setEditable(true);
				txt_state_residence.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_state_residence.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if(txt_state_residence.getText().equals(getPlaceHolder().get(4).toString())) {
					txt_state_residence.setText("");
				}else {
					txt_state_residence.setText(txt_state_residence.getText()+"");
				}
			}
		});
		txt_state_residence.setBounds(27,72,247,37);
		txt_state_residence.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_state_residence.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_state_residence.setEditable(false);
		txt_state_residence.setOpaque(false);
		txt_state_residence.setBackground(new Color(255,255,255));
		container_form_section2.add(txt_state_residence);
		
		txt_city_residence = new RoundedJTextField(1);
		txt_city_residence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_city_residence.setEditable(true);
				txt_city_residence.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_city_residence.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if(txt_city_residence.getText().equals(getPlaceHolder().get(5).toString())) {
					txt_city_residence.setText("");
				}else {
					txt_city_residence.setText(txt_city_residence.getText()+"");
				}
			}
		});
		txt_city_residence.setBounds(27,173,247,37);
		txt_city_residence.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_city_residence.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_city_residence.setEditable(false);
		txt_city_residence.setOpaque(false);
		txt_city_residence.setBackground(new Color(255,255,255));
		container_form_section2.add(txt_city_residence);
		
		lbl_street_residence = new JLabel();
		lbl_street_residence.setBounds(27,237,247,40);//x:290 y: 31
		lbl_street_residence.setText("Calle / Avenida *");
		lbl_street_residence.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_street_residence.setForeground(new Color(0, 0, 0));
		lbl_street_residence.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_street_residence.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_street_residence);
		
		txt_street_residence = new RoundedJTextField(1);
		txt_street_residence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_street_residence.setEditable(true);
				txt_street_residence.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_street_residence.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_street_residence.getText().equals(getPlaceHolder().get(6).toString())) 
				{
					txt_street_residence.setText("");
				}
				else 
				{
					txt_street_residence.setText(txt_street_residence.getText()+"");
				}
			}
		});
		txt_street_residence.setBounds(27,278,247,37);//x:290 y: 72
		txt_street_residence.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_street_residence.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_street_residence.setEditable(false);
		txt_street_residence.setOpaque(false);
		txt_street_residence.setBackground(new Color(255,255,255));
		container_form_section2.add(txt_street_residence);
		
		lbl_cp = new JLabel();
		lbl_cp.setBounds(307,31,270,40);//y: 113
		lbl_cp.setText("Código postal *");
		lbl_cp.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_cp.setForeground(new Color(0, 0, 0));
		lbl_cp.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_cp.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_cp);
		
		lbl_consult_cp = new JLabel();
		lbl_consult_cp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_consult_cp.setIcon(icon.icon_consult_external_web_site_entered);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_consult_cp.setIcon(icon.icon_consult_external_web_site_exited);
			}
			@Override
			public void mouseClicked(MouseEvent e1) {
				lbl_consult_cp.setCursor(new Cursor(Cursor.WAIT_CURSOR));
				try {
					CONSULT_MY_CP.openWebSite();
				}catch(URISyntaxException e) {
					JOptionPane.showMessageDialog(null,
							"Lo sentimos.\nOcurrio un error al abrir el sitio web.\n\nProblema: "+e.getReason()+"\n\n",
							"Error de software",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		lbl_consult_cp.setBounds(545,31,30,40);//y: 113
		lbl_consult_cp.setIcon(icon.icon_consult_external_web_site_exited);
		lbl_consult_cp.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_consult_cp.setVerticalAlignment(SwingConstants.CENTER);
		lbl_consult_cp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		container_form_section2.add(lbl_consult_cp);
		
		txt_cp_residence = new RoundedJTextField(1);
		txt_cp_residence.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_cp_residence.setEditable(true);
				txt_cp_residence.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_cp_residence.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_cp_residence.getText().equals(getPlaceHolder().get(7).toString())) 
				{
					txt_cp_residence.setText("");
				}
				else 
				{
					txt_cp_residence.setText(txt_cp_residence.getText()+"");
				}
			}
		});
		txt_cp_residence.setBounds(307,72,270,33);//y: 153
		txt_cp_residence.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_cp_residence.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_cp_residence.setEditable(false);
		txt_cp_residence.setOpaque(false);
		txt_cp_residence.setBackground(new Color(255,255,255));
		container_form_section2.add(txt_cp_residence);
		
		lbl_num_exterior = new JLabel();
		lbl_num_exterior.setBounds(307,133,126,40);//y: 194
		lbl_num_exterior.setText("No. Exterior *");
		lbl_num_exterior.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_num_exterior.setForeground(new Color(0, 0, 0));
		lbl_num_exterior.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num_exterior.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_num_exterior);
		
		lbl_num_interior = new JLabel();
		lbl_num_interior.setBounds(453,133,126,40);//y: 194
		lbl_num_interior.setText("No. Interior");
		lbl_num_interior.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		lbl_num_interior.setForeground(new Color(0, 0, 0));
		lbl_num_interior.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num_interior.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section2.add(lbl_num_interior);
		
		txt_num_exterior = new RoundedJTextField(1);
		txt_num_exterior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_num_exterior.setEditable(true);
				txt_num_exterior.setForeground(new Color(0,0,0));
				txt_num_exterior.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_num_exterior.getText().equals(getPlaceHolder().get(8).toString())) 
				{
					txt_num_exterior.setText("");
				}
				else 
				{
					txt_num_exterior.setText(txt_num_exterior.getText()+"");
				}
			}
		});
		txt_num_exterior.setBounds(307,173,126,37);//y: 235
		txt_num_exterior.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_num_exterior.setEditable(false);
		txt_num_exterior.setOpaque(false);
		txt_num_exterior.setBackground(new Color(255,255,255));
		txt_num_exterior.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		container_form_section2.add(txt_num_exterior);
		
		txt_num_interior = new RoundedJTextField(1);
		txt_num_interior.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_num_interior.setEditable(true);
				txt_num_interior.setForeground(new Color(0,0,0));
				txt_num_interior.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_num_interior.getText().equals(getPlaceHolder().get(9).toString())) 
				{
					txt_num_interior.setText("");
				}
				else 
				{
					txt_num_interior.setText(txt_num_interior.getText()+"");
				}
			}
		});
		txt_num_interior.setBounds(453,173,126,37);//y: 235
		txt_num_interior.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_num_interior.setEditable(false);
		txt_num_interior.setOpaque(false);
		txt_num_interior.setBackground(new Color(255,255,255));
		txt_num_interior.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		container_form_section2.add(txt_num_interior);
		
		/*
		 * FINISH THE SECTION 2
		 * AND START THE SECTION 3
		 */
		
		lbl_email_address = new JLabel();
		lbl_email_address.setBounds(27,31,247,40);
		lbl_email_address.setText("Correo electrónico *");
		lbl_email_address.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_email_address.setForeground(new Color(0, 0, 0));
		lbl_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_email_address.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section3.add(lbl_email_address);
		
		txt_email_address = new RoundedJTextField(1);
		txt_email_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_email_address.setEditable(true);
				txt_email_address.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_email_address.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_email_address.getText().equals(getPlaceHolder().get(10).toString())) 
				{
					txt_email_address.setText("");
				}
				else 
				{
					txt_email_address.setText(txt_email_address.getText()+"");
				}
			}
		});
		txt_email_address.setBounds(27,72,320,37);
		txt_email_address.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_email_address.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_email_address.setBackground(new Color(255,255,255));
		txt_email_address.setEditable(false);
		txt_email_address.setOpaque(false);
		container_form_section3.add(txt_email_address);
		
		lbl_input_second_email_address = new JLabel();
		lbl_input_second_email_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_input_second_email_address.setForeground(new Color(7,33,70));
				lbl_input_second_email_address.setIcon(icon.ADDITIONAL_EMAIL_ENTERED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lbl_input_second_email_address.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				lbl_input_second_email_address.setIcon(icon.ADDITIONAL_EMAIL_EXITED);
			}
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (additionalEmail.getAdditionalEmail() == null) additionalEmail.setVisible(true);

                //get update email
				additionalEmail.addWindowListener(new WindowAdapter() {
					@Override
					public void windowClosed(WindowEvent e) 
					{
						if (additionalEmail.getAdditionalEmail() != null) updateAdditionalEmail();
					}
				});
			}
		});
		lbl_input_second_email_address.setBounds(370,31,210,40);
		lbl_input_second_email_address.setIcon(icon.ADDITIONAL_EMAIL_EXITED);
		lbl_input_second_email_address.setText("Añadir email adicional");
		lbl_input_second_email_address.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_input_second_email_address.setForeground(new Color(0, 0, 0));
		lbl_input_second_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_second_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_input_second_email_address.setCursor(new Cursor(Cursor.HAND_CURSOR));
		container_form_section3.add(lbl_input_second_email_address);
		
		lbl_second_email_address = new JLabel();
		lbl_second_email_address.setLocation(27,110);
		lbl_second_email_address.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		lbl_second_email_address.setForeground(new Color(0, 0, 0));
		lbl_second_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_second_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_second_email_address.setVisible(false);
		container_form_section3.add(lbl_second_email_address);
		
		lbl_edit_secon_email_address = new JLabel();
		lbl_edit_secon_email_address.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				additionalEmail.setVisible(true);
			}
		});
		lbl_edit_secon_email_address.setBounds((txt_email_address.getX() + txt_email_address.getWidth()) - 30, lbl_second_email_address.getY(), 40, 40);
		lbl_edit_secon_email_address.setIcon(icon.EDIT_SECOND_EMAIL);
		lbl_edit_secon_email_address.setForeground(getForeground());
		lbl_edit_secon_email_address.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_edit_secon_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_edit_secon_email_address.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lbl_edit_secon_email_address.setVisible(false);
		container_form_section3.add(lbl_edit_secon_email_address);
		
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
		
		txt_phone_number_principal = new RoundedJTextField(1);
		txt_phone_number_principal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				txt_phone_number_principal.setEditable(true);
				txt_phone_number_principal.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
				txt_phone_number_principal.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
				
				if (txt_phone_number_principal.getText().equals(getPlaceHolder().get(11).toString())) 
				{
					txt_phone_number_principal.setText("");
				}
				else 
				{
					txt_phone_number_principal.setText(txt_phone_number_principal.getText()+"");
				}
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
				
				if (txt_phone_number_secundary.getText().equals(getPlaceHolder().get(12).toString())) 
				{
					txt_phone_number_secundary.setText("");
				}
				else 
				{
					txt_phone_number_secundary.setText(txt_phone_number_secundary.getText()+"");
				}
			}
		});
		txt_phone_number_secundary.setBounds(27,271,320,37);
		txt_phone_number_secundary.setFont(fontStyle.getFont(fontStyle.PLACEHOLDER_STANDARD));
		txt_phone_number_secundary.setForeground(colorFont.PLACEHOLDER_COLOR_FONT_TEXT_GRAY);
		txt_phone_number_secundary.setBackground(new Color(255,255,255));
		txt_phone_number_secundary.setEditable(false);
		txt_phone_number_secundary.setOpaque(false);
		container_form_section3.add(txt_phone_number_secundary);
		
		/*
		 * FINISH THE SECTION 3
		 * AND START THE SECTION 4
		 */
		
		lbl_input_password = new JLabel();
		lbl_input_password.setBounds(150,40,300,40);
		lbl_input_password.setText("Contraseña");
		lbl_input_password.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_password.setForeground(new Color(0, 0, 0));
		lbl_input_password.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_password.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section4.add(lbl_input_password);
		
		lbl_input_confirm_password = new JLabel();
		lbl_input_confirm_password.setBounds(150,150,300,40);
		lbl_input_confirm_password.setText("Confirmar contraseña");
		lbl_input_confirm_password.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 18));
		lbl_input_confirm_password.setForeground(new Color(0, 0, 0));
		lbl_input_confirm_password.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_input_confirm_password.setVerticalAlignment(SwingConstants.CENTER);
		container_form_section4.add(lbl_input_confirm_password);
		
		jpsf_password = new RoundedJPasswordField(1);
		jpsf_password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jpsf_password.setEditable(true);
				jpsf_password.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}
		});
		jpsf_password.setBounds(150,91,300,37);
		jpsf_password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 8));
		jpsf_password.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		jpsf_password.setBackground(new Color(255,255,255));
		jpsf_password.setEditable(false);
		jpsf_password.setOpaque(false);
		container_form_section4.add(jpsf_password);
		
		jpsf_confirm_password = new RoundedJPasswordField(1);
		jpsf_confirm_password.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jpsf_confirm_password.setEditable(true);
				jpsf_confirm_password.setCursor(new Cursor(Cursor.TEXT_CURSOR));
			}
		});
		jpsf_confirm_password.setBounds(150,200,300,37);
		jpsf_confirm_password.setFont(new Font("Yu Gothic UI", Font.PLAIN, 8));
		jpsf_confirm_password.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		jpsf_confirm_password.setBackground(new Color(255,255,255));
		jpsf_confirm_password.setEditable(false);
		jpsf_confirm_password.setOpaque(false);
		container_form_section4.add(jpsf_confirm_password);
		
		txt_password = new RoundedJTextField(1);
		txt_password.setBounds(150,91,300,37);
		txt_password.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
		txt_password.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		txt_password.setBackground(colorFont.PRIMARY_COLOR_FONT_TEXT_WHITE);
		txt_password.setVisible(false);
		txt_password.setEditable(true);
		txt_password.setOpaque(false);
		container_form_section4.add(txt_password);
		
		txt_confirm_password = new RoundedJTextField(1);
		txt_confirm_password.setBounds(150,200,300,37);
		txt_confirm_password.setFont(fontStyle.getFont(fontStyle.TEXTFIELD_STANDARD));
		txt_confirm_password.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		txt_confirm_password.setBackground(colorFont.PRIMARY_COLOR_FONT_TEXT_WHITE);
		txt_confirm_password.setVisible(false);
		txt_confirm_password.setEditable(true);
		txt_confirm_password.setOpaque(false);
		container_form_section4.add(txt_confirm_password);
		
		JSeparator jsp = new JSeparator();
		jsp.setBounds(153,280,172,1);
		jsp.setBackground(new Color(31, 97, 141));
		jsp.setForeground(new Color(31, 97, 141));
		jsp.setVisible(false);
		container_form_section4.add(jsp);
		
		checkBox_password_visibility = new JCheckBox();
		checkBox_password_visibility.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordVisibilityEvents();
			}
		});
		checkBox_password_visibility.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				checkBox_password_visibility.setForeground(new Color(31, 97, 141));
				//jsp.setVisible(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				checkBox_password_visibility.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);	
				jsp.setVisible(false);
			}
		});
		checkBox_password_visibility.setBounds(150,255,180,25);
		checkBox_password_visibility.setText("Mostrar contraseña");
		checkBox_password_visibility.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 18));
		checkBox_password_visibility.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		checkBox_password_visibility.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		checkBox_password_visibility.setBorderPainted(false);
		checkBox_password_visibility.setSelected(false);
		checkBox_password_visibility.setCursor(new Cursor(Cursor.HAND_CURSOR));
		container_form_section4.add(checkBox_password_visibility);
		
		/*
		 * FINISH THE SECTION 4
		 */
		
		/*
		 * @see The layer to create account client
		 * */
		container_layer_register_client = new JPanel();
		container_layer_register_client.setBounds(0,0,604,342);
		container_layer_register_client.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_layer_register_client.setLayout(null);
		container_layer_register_client.setVisible(false);
		container_form.add(container_layer_register_client);
		
	    lbl_subtitile_create_account = new JLabel();
		lbl_subtitile_create_account.setText("A un clic de crear tu cuenta");
		lbl_subtitile_create_account.setBounds(0, 40, 604, 43);
		lbl_subtitile_create_account.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_subtitile_create_account.setForeground(new Color(0, 183, 196));
		lbl_subtitile_create_account.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 34));
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
		terms_conditions_licenses.setBounds(0, 285, 585, 30);
		terms_conditions_licenses.setText(" Aceptar los términos y condiciones");
		terms_conditions_licenses.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 15));
		terms_conditions_licenses.setForeground(new Color(0,0,0));
		terms_conditions_licenses.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		terms_conditions_licenses.setHorizontalAlignment(SwingConstants.CENTER);
		terms_conditions_licenses.setVerticalAlignment(SwingConstants.CENTER);
		terms_conditions_licenses.setSelected(false);
		container_layer_register_client.add(terms_conditions_licenses);
		
		separator_position_top = new JSeparator();
		separator_position_top.setBounds(41, 20, 520, 1);
		separator_position_top.setForeground(new Color(0, 0, 0));
		separator_position_top.setBackground(new Color(0, 0, 0));
		container_layer_register_client.add(separator_position_top);
		
		separator_position_bottom = new JSeparator();
		separator_position_bottom.setBounds(41, 340, 520, 1);
		separator_position_bottom.setForeground(Color.BLACK);
		separator_position_bottom.setBackground(Color.BLACK);
		container_layer_register_client.add(separator_position_bottom);
		
		/*
		 * Finish the register layer
		 * Start direction buttons declaration
		 * */
		
		btn_move_right = new RoundedPanel();
		btn_move_right.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_move_right.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btn_move_right.setBackground(new Color(212, 230, 241));
				lbl_icon_move_right.setIcon(icon.arrow_right_entered);
			}
			public void mouseExited(MouseEvent e) {
				btn_move_right.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				btn_move_right.setBackground(new Color(214, 234, 248));
				lbl_icon_move_right.setIcon(icon.arrow_right_exited);
			}
			public void mouseClicked(MouseEvent e) {
							
				setMoveToRight(true);
				setMoveToLeft(false);
				
				if (getSectionForm() != 4)
				{
					if (isInformationEmpty(getSectionForm()))
					{
						invokeErrorMessage(Dialogs.TITLE_ERROR_IN_USER_REGISTER_FORM,
								           Dialogs.DIALOG_ERROR_IN_USER_REGISTER_FORM);
					}
					else
					{
						moveToNextLayer();
					}
				}
				else 
				{
					if (isPasswordCoencident()) 
					{
						prepareDataToPreview();
					}
					else 
					{
						invokeErrorMessage(Dialogs.TITLE_PASSWORD_IS_NOT_COENCIDENT,
								           Dialogs.DIALOG_PASSWORD_IS_NOT_COENCIDENT);
					}
				}
			}
		});
		btn_move_right.setBounds(304, 11, 120, 40);
		btn_move_right.setBackground(new Color(214, 234, 248));
		((RoundedPanel) btn_move_right ).setCornerRadius(10);
		btn_move_right.setOpaque(false);
		btn_move_right.setLayout(null);
		footer.add(btn_move_right);
		
		btn_move_left = new RoundedPanel();
		btn_move_left.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(getSectionForm()==1) {
					btn_move_left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}else {
					btn_move_left.setCursor(new Cursor(Cursor.HAND_CURSOR));
					btn_move_left.setBackground(new Color(212, 230, 241));
					lbl_text_left.setIcon(icon.arrow_left_entered);
				}
			}
			public void mouseExited(MouseEvent e) {
				if(getSectionForm()==1) {
					btn_move_left.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}else{
					btn_move_left.setCursor(new Cursor(Cursor.HAND_CURSOR));
					btn_move_left.setBackground(new Color(214, 234, 248));
					lbl_text_left.setIcon(icon.arrow_left_exited);
				}
			}
			public void mouseClicked(MouseEvent e) {
				
				setMoveToRight(false);
				setMoveToLeft(true);
				
				moveToNextLayer();
			}
		});
		btn_move_left.setLayout(null);
		btn_move_left.setOpaque(false);
		((RoundedPanel) btn_move_left ).setCornerRadius(10);
		btn_move_left.setBackground(new Color(214, 234, 248));
		btn_move_left.setBounds(174, 11, 120, 40);
		btn_move_left.setVisible(false);
		footer.add(btn_move_left);
		
		lbl_text_right = new JLabel();
		lbl_text_right.setBounds(5,5,100,35);
		lbl_text_right.setText("Siguiente");
		lbl_text_right.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 17));
		lbl_text_right.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_text_right.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text_right.setVerticalAlignment(SwingConstants.CENTER);
		btn_move_right.add(lbl_text_right);
		
		lbl_icon_move_right = new JLabel();
		lbl_icon_move_right.setBounds(93,5,15,35);
		lbl_icon_move_right.setIcon(icon.arrow_right_exited);
		lbl_icon_move_right.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_icon_move_right.setVerticalAlignment(SwingConstants.CENTER);
		btn_move_right.add(lbl_icon_move_right);
		
		lbl_text_left = new JLabel();
		lbl_text_left.setBounds(5, 5, 115, 35);
		lbl_text_left.setText("Regresar");
		lbl_text_left.setIcon(icon.arrow_left_exited);
		lbl_text_left.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 17));
		lbl_text_left.setForeground(colorFont.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_text_left.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text_left.setVerticalAlignment(SwingConstants.CENTER);
		btn_move_left.add(lbl_text_left);
		
		/*
		 * SET DIRECTION BUTTONS (INACTIVE)
		 */
		
		btn_move_left_inactive = new RoundedPanel();
		btn_move_left_inactive.setBounds(174, 11, 120, 40);
		btn_move_left_inactive.setBackground(new Color(214, 234, 248));
		((RoundedPanel) btn_move_left_inactive ).setCornerRadius(10);
		btn_move_left_inactive.setOpaque(false);
		btn_move_left_inactive.setLayout(null);
		btn_move_left_inactive.setVisible(true);
		footer.add(btn_move_left_inactive);
		
		lbl_text_left_inactive = new JLabel();
		lbl_text_left_inactive.setIcon(icon.arrow_left_inactive);
		lbl_text_left_inactive.setBounds(5, 5, 115, 35);
		lbl_text_left_inactive.setText("Regresar");
		lbl_text_left_inactive.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 17));
		lbl_text_left_inactive.setForeground(Color.gray);
		lbl_text_left_inactive.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text_left_inactive.setVerticalAlignment(SwingConstants.CENTER);
		btn_move_left_inactive.add(lbl_text_left_inactive);
	}
	
	private void initialEventsInSectionForm() {
		lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION1));
		lbl_indications_form.setIcon(icon.REGISTER_USER);
		
		setSectionForm(1);

		//set lists
		addItemsComboBox();
		createPlaceHolderArray();
	}
	
	private void setSectionForm(int sectionForm) {
		this.sectionForm = sectionForm;
	}
	
	private int getSectionForm() {
		return sectionForm;
	}
	
	private void setMoveToRight(boolean move_to_right) {
		this.move_to_right = move_to_right;
	}
	
	private boolean getMoveToRight(){
		return move_to_right;
	}
	
	private void setMoveToLeft(boolean move_to_left) {
		this.move_to_left = move_to_left;
	}
	
	private boolean getMoveToLeft(){
		return move_to_left;
	}
	
	/**
	 * <h2>Add items to JComboBox</h2>
	 * @see {@link #addItemsComboBox()}
	 * <p>
	 * Set all the items​​corresponding to the 
	 * user's date of birth: day, month, year
	 * </p>
	 */
	private void addItemsComboBox() {
		ManagerSpecialCasesData yearControl = new ManagerSpecialCasesData();
		
		String ALL_MONTHS_OF_YEAR[] = {
				"Enero",   "Febrero",   "Marzo",
				"Abril",   "Mayo",      "Junio",
				"Julio",   "Agosto",    "Septiembre",
				"Octubre", "Noviembre", "Diciembre"
		};
		
		for (int i = 1; i <= 31; i++) 
		{
			box_day_items.addItem(makeObj(String.valueOf(i)));
		}
		
		for (int j = 0; j <= ALL_MONTHS_OF_YEAR.length - 1; j++)
		{
			box_month_items.addItem(makeObj(String.valueOf(ALL_MONTHS_OF_YEAR[j])));
		}
		
		for (int k = yearControl.getMinimumBornYear(); k <= yearControl.getLimitYearAuthorized(); k++)
		{
			box_year_items.addItem(makeObj(String.valueOf(k)));
		}
		
		//Initial values
		box_day_items.setSelectedIndex(0);
		box_month_items.setSelectedIndex(0);
		box_year_items.setSelectedIndex(0);
	}
	
	private Object makeObj(final String item) {
		return new Object() {
			public String toString() {
				return item;
			}
		};
	}
	
	private void createPlaceHolderArray() {
		//create the placeholder container array
		String items[] = {
				//for section1
				"Escriba su nombre(s)",
				"Escriba su apellido paterno",
				"Escriba su apellido materno",
				"Escriba su CURP",
				//for section2
				"Estado de residencia",
				"Localidad de residencia",
				"Nombre de la calle",
				"código postal del domicilio",
				"No. Exterior",
				"No. Interior",
				//for section3
				"Dirección de email",
				"Número teléfonico",
				"Número teléfonico"};
		
		for(int i = 0; i < items.length; i++) {
			placeholder.add(i,items[i]);
		}

		//once the array is defined, place each placeholder in its respective text box
		if(getPlaceHolder().size() != 0) putPlaceHolderInTextField();
	}
	
	public ArrayList<Object> getPlaceHolder() {
		return placeholder;
	}
	
	private void putPlaceHolderInTextField() {
		//section1
		txt_client_name.setText(placeholder.get(0).toString());
		txt_last_name_p.setText(placeholder.get(1).toString());
		txt_last_name_m.setText(placeholder.get(2).toString());
		txt_curp_client.setText(placeholder.get(3).toString());
		//section2
		txt_state_residence.setText(placeholder.get(4).toString());
		txt_city_residence.setText(placeholder.get(5).toString());
		//txt_colonia.setText(placeholder.get(6).toString());
		txt_street_residence.setText(placeholder.get(6).toString());
		txt_cp_residence.setText(placeholder.get(7).toString());
		txt_num_exterior.setText(placeholder.get(8).toString());
		txt_num_interior.setText(placeholder.get(9).toString());
		//section3
		txt_email_address.setText(placeholder.get(10).toString());
		txt_phone_number_principal.setText(placeholder.get(11).toString());
		txt_phone_number_secundary.setText(placeholder.get(12).toString());
	}
	
	private ArrayList<Object> getContentTextFieldList(){
		contentTextField.removeAll(contentTextField);
		
		contentTextField.add(txt_client_name.getText());
		contentTextField.add(txt_last_name_p.getText());
		contentTextField.add(txt_last_name_m.getText());
		contentTextField.add(txt_curp_client.getText());
		/**************************************************************/
		contentTextField.add(txt_state_residence.getText());
		contentTextField.add(txt_city_residence.getText());
		contentTextField.add(txt_street_residence.getText());
		contentTextField.add(txt_cp_residence.getText());
		contentTextField.add(txt_num_interior.getText());
		contentTextField.add(txt_num_exterior.getText());
		/**************************************************************/
		contentTextField.add(txt_email_address.getText());
		contentTextField.add(txt_phone_number_principal.getText());
		contentTextField.add(txt_phone_number_secundary.getText());
		
		return contentTextField;
	}
	
	private boolean isInformationEmpty(int layer) {
		boolean emptyData = false;
		
		final int INITIAL_POSITION_LAYER1 = 0;
		final int INITIAL_POSITION_LAYER2 = 4;
		final int INITIAL_POSITION_LAYER3 = 10;
		
		final int LAST_POSITION_LAYER1 = 3;
		final int LAST_POSITION_LAYER2 = 9;
		final int LAST_POSITION_LAYER3 = 12;
		
		switch(layer) 
		{
	    	case 1:
	    		for(int i = INITIAL_POSITION_LAYER1; i < LAST_POSITION_LAYER1; i++) 
				{
					if(getContentTextFieldList().get(i).equals(getPlaceHolder().get(i))
							|| getContentTextFieldList().get(i).equals("")
							|| isBornDateEmpty())
					{
						return emptyData = true;
					}
				}
	    		break;
	    	case 2:
	    		for(int j = INITIAL_POSITION_LAYER2; j < LAST_POSITION_LAYER2 - 1; j++) 
				{
					if(getContentTextFieldList().get(j).equals(getPlaceHolder().get(j))
							|| getContentTextFieldList().get(j).equals(""))
					{
						return emptyData = true;
					}
				}
				break;
	    	case 3:
				for(int k = INITIAL_POSITION_LAYER3; k < LAST_POSITION_LAYER3; k++) 
				{
					if(getContentTextFieldList().get(k).equals(getPlaceHolder().get(k))
							|| getContentTextFieldList().get(k).equals(""))
					{
						return emptyData = true;
					}
				}
				break;
			default:
				System.out.print("system error in isInformationEmpty()");
		}
		
		return emptyData;
	}
	
	private boolean isBornDateEmpty() {
		if(box_day_items.getSelectedIndex() != 0
				&& box_month_items.getSelectedIndex() != 0
				&& box_year_items.getSelectedIndex() != 0)
		{
			return false;
		}
		return true;
	}
	
	private void setDirectionButtons() {
		if(container_form_section1.isVisible() == false) 
		{
			btn_move_left_inactive.setVisible(false);
			btn_move_left.setVisible(true);
		}
		else 
		{
			btn_move_left_inactive.setVisible(true);
			btn_move_left.setVisible(false);
		}
		
	}
	
	private int getDayFromItemBox() {
		return box_day_items.getSelectedIndex();
	}
	
	private String getMonthFromItemBox() {
		return String.valueOf(box_month_items.getSelectedItem());
	}
	
	private int getYearFromItemBox() {
		String aux = String.valueOf(box_year_items.getSelectedItem());
		return Integer.parseInt(aux);
	}
	
	private void moveToNextLayer() {		
		
		if (getMoveToRight()) 
		{
			switch (getSectionForm()) {
			case 1:
				if (manager.isAgeClientAuthorized(getDayFromItemBox(),getMonthFromItemBox(),getYearFromItemBox()))
				{
					if (manager.isCurpValidate(txt_curp_client.getText()))
					{
						container_form_section1.setVisible(false);
						container_form_section2.setVisible(true);
						lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION2));
						lbl_indications_form.setIcon(icon.REGISTER_RESIDENCE);
						setSectionForm(2);
					}
					else
					{
						invokeErrorMessage(Dialogs.TITLE_CURP_IS_NOT_CORRECT,Dialogs.DIALOG_CURP_IS_NOT_CORRECT,txt_curp_client.getText().length());
					}
				}
				else
				{
					invokeErrorMessage(Dialogs.TITLE_AGE_IS_NOT_AUTHORIZED,Dialogs.DIALOG_AGE_IS_NOT_AUTHORIZED);
				}
				break;
			case 2:
				container_form_section2.setVisible(false);
				container_form_section3.setVisible(true);
				lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION3));
				lbl_indications_form.setIcon(icon.REGISTER_CONTACT);
				setSectionForm(3);
				break;
			case 3:
				if (!(manager.isPhoneNumberEmpty(txt_phone_number_secundary.getText())))
				{
					if (manager.isPhoneNumberDigitsCorrect(txt_phone_number_principal.getText())
							&& manager.isPhoneNumberDigitsCorrect(txt_phone_number_secundary.getText()))
					{
						container_form_section3.setVisible(false);
						container_form_section4.setVisible(true);
						lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION4));
						lbl_indications_form.setIcon(icon.REGISTER_PASSWORD);
						setSectionForm(4);
					}
					else
					{
						invokeErrorMessage(Dialogs.TITLE_PHONE_NUMBER_LENGTH_NOT_CORRECT,Dialogs.DIALOG_PHONE_NUMBER_LENGTH_NOT_CORRECT);
					}
				}
				else 
				{
					if (manager.isPhoneNumberDigitsCorrect(txt_phone_number_principal.getText()))
					{
						container_form_section3.setVisible(false);
						container_form_section4.setVisible(true);
						lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION4));
						lbl_indications_form.setIcon(icon.REGISTER_PASSWORD);
						setSectionForm(4);
					}
					else
					{
						invokeErrorMessage(Dialogs.TITLE_PHONE_NUMBER_LENGTH_NOT_CORRECT,Dialogs.DIALOG_PHONE_NUMBER_LENGTH_NOT_CORRECT);
					}
				}
				break;
			default:
				System.out.print("error in moveToNextLayer -> switch block");
			}
		}
		else
		{
			if (getMoveToLeft())
			{
				switch(getSectionForm()) 
				{
			    	case 4:
		     			container_form_section4.setVisible(false);
			    		container_form_section3.setVisible(true);
			       		lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION3));
			     		lbl_indications_form.setIcon(icon.REGISTER_CONTACT);
				    	setSectionForm(3);
				    	break;
			    	case 3:
			    		container_form_section3.setVisible(false);
			    		container_form_section2.setVisible(true);
				    	lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION2));
				    	lbl_indications_form.setIcon(icon.REGISTER_RESIDENCE);
				    	setSectionForm(2);
				    	break;
			    	case 2:
				    	container_form_section2.setVisible(false);
				    	container_form_section1.setVisible(true);
				    	lbl_indications_form.setText(createTitleMessage(Dialogs.TITLE_FORM_SECTION1));
				    	lbl_indications_form.setIcon(icon.REGISTER_USER);
				    	setSectionForm(1);
				    	break;
		    	    default:
					    System.out.print("error in moveToNextLayer -> switch block");
				}
			}
		}
		setDirectionButtons();
	}
	
	private void updateAdditionalEmail() {
		if (additionalEmail.isEmailAdded())
		{
			lbl_phone_number_principal.setBounds(27,153,300,40);
			lbl_phone_number_secundary.setBounds(27,255,300,40);
			txt_phone_number_principal.setBounds(27,193,320,37);
			txt_phone_number_secundary.setBounds(27,294,320,37);
			
			//get and show the update email address
			lbl_second_email_address.setText(additionalEmail.getAdditionalEmail());
			
			//modify JLabel's second email size
			lbl_second_email_address.setSize(lbl_edit_secon_email_address.getX() - 10, 40);
			
			//modify visual components
			lbl_input_second_email_address.setVisible(false);
			lbl_second_email_address.setVisible(true);
			lbl_edit_secon_email_address.setVisible(true);
		}
	}
	
	private void passwordVisibilityEvents() {
		if (checkBox_password_visibility.isSelected()) {
			txt_password.setText(String.valueOf(jpsf_password.getPassword()));
			txt_password.setVisible(true);
			jpsf_password.setVisible(false);
			txt_confirm_password.setText(String.valueOf(jpsf_confirm_password.getPassword()));
			txt_confirm_password.setVisible(true);
			jpsf_confirm_password.setVisible(false);
		}
		else 
		{
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
		
		//do both password match?
		if (!((password.toString().length() == 0) && (confirmPassword.toString().length() == 0))) 
		{
			if (password.equals(confirmPassword)) 
			{
				return true;
			}
		}
		return false;
	}
	
	/*
	 *  METHODS FOR PREPARE CLIENT'S DATA 	
	 *
	 **/
	private void prepareDataToPreview() {		
		dataClient = new PreviewDataClient();
		
		dataClient.setFullNameClient(
				txt_client_name.getText(),
				txt_last_name_p.getText(),
				txt_last_name_m.getText());
		
		if(!isBornDateEmpty())
		{
			dataClient.setDateBornClient(
					box_day_items.getSelectedItem().toString(),
					box_month_items.getSelectedItem().toString(),
					box_year_items.getSelectedItem().toString());
		}
		
		dataClient.setCurpClient(txt_curp_client.getText());
		/**/
		dataClient.setStateResidenceClient(txt_state_residence.getText());
		dataClient.setCityResidenceClient(txt_city_residence.getText());
		dataClient.setStreetResidenceClient(txt_street_residence.getText());
		dataClient.setPostalCodeResidenceClient(txt_cp_residence.getText());
		dataClient.setExteriorNumberAddress(txt_num_exterior.getText());
		/**/
		dataClient.setMainEmailClient(txt_email_address.getText());
		dataClient.setMainPhoneNumberClient(txt_phone_number_principal.getText());
		
		/*Optional information*/
		dataClient.setInteriorNumberAddress(txt_num_interior.getText());
		dataClient.setSecundaryEmailClient(lbl_second_email_address.getText());
		dataClient.setSecundaryPhoneNumberClient(txt_phone_number_secundary.getText());
		
		//build and show the GUI
		dataClient.buildWindowGui();
		dataClient.setVisible(true);
		
		/*
		 * @see Instance 'dataClient' of the class PreviewDataClient
		 * Evaluate user's decision about your information edition
		 * */
		dataClient.addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				if(dataClient.skipEditDataClient() && (!dataClient.editDataClient())) {
					finalizeRegistration();
				}
			}
		});
	}
	
	private void finalizeRegistration(){
		
		/*
		 * Modify position x and y
		 * */
		container_form.setBounds(400,130,604,371);//419,130,585,371
		footer.setBounds(400,501,604,130);
		
		/*
		 * change the position x,y and size
		 * */
		lbl_have_account.setBounds(0,0,604,50);
		lbl_have_account.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_login_app.setBounds(250,60,98,22);
		
		/*
		 * Modify visual attributes of the title JLabel component 
		 * */
		lbl_title_header.setText("Cuenta BBVA casi lista...");
		lbl_indications_form.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 23));
		lbl_indications_form.setIcon(null);
		lbl_indications_form.setText("Sugerencia, consulta las licencias de uso");
		
		/*
		 * Hide direction buttons 
		 * */
		btn_move_left.setVisible(false);
		btn_move_right.setVisible(false);
		
		/*
		 * Change the layer '4' to 'finish register'
		 * */
		container_form_section4.setVisible(false);
		container_layer_register_client.setVisible(true);
	} 
	
	private void invokeErrorMessage(String title, String message) {
		Dialogs popupMessage = new Dialogs();
		popupMessage.showPopupErrorMessage(title, message);
	}
	
	private void invokeErrorMessage(String title, String message, int n) {
		Dialogs popupMessage = new Dialogs();
		popupMessage.showPopupErrorMessage(title, message, n);
	}
	
	private String createTitleMessage(String title) {
		Dialogs titleMessage = new Dialogs();
		return titleMessage.showPresentationMessage(title);
	}
	
	private int showUserLicencePopupMessage() {
		return JOptionPane.showInternalOptionDialog(null,
				"Para crear tu cuenta debes aceptar los términos\n"
				+ "y condiciones expresados por el Grupo BBVA.\n\n",
				"Licencia de uso",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new Object[] {"Estoy de acuerdo", "No estoy de acuerdo"}, "Estoy de acuerdo");
	}
	
	private void showCancelRegisterWarningMessage() {
		int option = JOptionPane.showInternalOptionDialog(null,
		        		"¿Deseas abandonar el registro?\n\n"
		        	    	+ "Tus datos ingresados se borrarán,\n"
		         	    	+ "y deberas empezar de cero.\n\n",
			        	"Cancelar registro",
			        	JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
			        	new Object[] {"Salir del registro", "Continuar en el registro"}, "Continuar en el registro");
		
		if (option == JOptionPane.YES_OPTION)
		{
			redirection = new ClientRedirection();
			redirection.setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dispose();
		}
		else
		{
			//persist in the register page
			setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		}
	}
}
