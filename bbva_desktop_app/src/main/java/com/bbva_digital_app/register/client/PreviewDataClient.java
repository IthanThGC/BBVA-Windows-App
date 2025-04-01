package main.java.com.bbva_digital_app.register.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.resources.visual.manager.classes.*;
import main.resources.visual.swingcomponents.RoundedPanel;

public class PreviewDataClient extends JFrame {
		
	private static final long serialVersionUID = 6828217009479454004L;
			
	private JPanel contentPane;
	
	private boolean edit, skip;
	
	//Visual resources
	private IconImageManager icon = new IconImageManager();
	private final ColorManager COLOR = new ColorManager();
	
	private JPanel header;
	private JPanel containerPreviewData;
	private JPanel footer;
	
	private JLabel lbl_bbva_logo;
	private JLabel lbl_title_window;
	private JLabel lbl_subtitle_window;
	
	private JPanel container_card1_preview_data;
	private JPanel container_card2_preview_data;
	private JPanel container_card3_preview_data;
	
	private JPanel content_title_card1;
	private JPanel content_title_card2;
	private JPanel content_title_card3;
	
	private JPanel content_data_client_card1;
	private JPanel content_data_client_card2_part1, content_data_client_card2_part2;
	private JPanel content_data_client_card3;
	
	private JLabel lbl_set_icon_left, lbl_set_icon_right;
	private JLabel lbl_back_mssg, lbl_next_mssg;
	
	private JLabel lbl_title_card1;
	private JLabel lbl_title_card2;
	private JLabel lbl_title_card3;
	
	/*
	 * 
	 */
	private JLabel lbl_name_client, lbl_set_name_client;
	
	private JLabel lbl_borndate_client, lbl_set_borndate_client;
	
	private JLabel lbl_curp_client, lbl_set_curp_client;
	/*
	 * 
	 */
	private JLabel lbl_state_address_residence_client, lbl_set_state_residence_client;
	
	private JLabel lbl_city_residence_client, lbl_set_city_residence_client;
	
	private JLabel lbl_street_address_residence_client, lbl_set_street_address_residence_client;
	
	private JLabel lbl_num_exterior_address_client, lbl_num_inte_address_client;
	private JLabel lbl_set_num_exterior_address_residence_client, lbl_set_num_inte_address_residence_client;
		
	private JLabel lbl_cp_address_residence_client;
	private JLabel lbl_set_cp_residence_client;
	/*
	 * 
	 */
	private JLabel lbl_primary_email_address, lbl_set_primary_email_address;
	private JLabel lbl_secondary_email_address, lbl_set_secondary_email_address;
	
	private JLabel lbl_primary_phone_number, lbl_set_primary_phone_number;
	private JLabel lbl_secondary_phone_number, lbl_set_secondary_phone_number;
	/*
	 * 
	 */
	private JPanel btn_edit, btn_skip, btn_continue;
	private JLabel btn_text_edit, btn_text_skip, btn_text_continue;
		
	/*
	 *  @see Client attributes
	 **/
	private final String NOT_ENABLED_MESSAGE = "No se proporciono";
	private final String NOT_ENABLED_ADDITIONAL_MESSAGE = "no se añadio este dato";
	/**
	 * 
	 */
	private String fullNameClient = "Nombre del cliente no disponible";
	private String dateBornClient = "Fecha de nacimiento no disponible";
	/**
	 * 
	 */
    private String curpClient = NOT_ENABLED_MESSAGE;
    /**
     * 
     */
    private String stateResidenceClient  = NOT_ENABLED_MESSAGE;
    private String cityResidenceClient   = NOT_ENABLED_MESSAGE;
    private String streetResidenceClient = NOT_ENABLED_MESSAGE;
    private String cpResidenceClient     = NOT_ENABLED_MESSAGE;
    private String numExteriorAddress    = NOT_ENABLED_MESSAGE;
    private String numInteriorAddress    = NOT_ENABLED_MESSAGE;
    /**
     * 
     */
    private String mainEmailAddressClient      = NOT_ENABLED_MESSAGE;
    private String secundaryEmailAddressClient = NOT_ENABLED_ADDITIONAL_MESSAGE;
    
    private String mainPhoneNumberClient       = NOT_ENABLED_MESSAGE;
    private String secundaryPhoneNumberClient  = NOT_ENABLED_ADDITIONAL_MESSAGE;
	/**
	 * 
	 */
    private final String PLACEHOLDER_NUM_INTE = "No. Del domicilio";
	private final String PLACEHOLDER_PHONE_NUMBER = "Número teléfonico";
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					PreviewDataClient frame = new PreviewDataClient();
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
	
	public PreviewDataClient() {
		//Empty constructor
		buildWindowGui();
	}
	
	public void buildWindowGui() {
		//Build the GUI
		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent e) {
				final Color FOREGROUND_NOT_ENABLED_INFO = new Color(231, 76, 60); 
				
				if ((numInteriorAddress.length() == 0) 
						|| (numInteriorAddress.equals(NOT_ENABLED_MESSAGE))) 
				{
					lbl_set_num_inte_address_residence_client.setForeground(FOREGROUND_NOT_ENABLED_INFO);
				}
				
				if ((secundaryPhoneNumberClient.length() == 0) 
						|| (secundaryPhoneNumberClient.equals(NOT_ENABLED_ADDITIONAL_MESSAGE))) 
				{
					lbl_set_secondary_phone_number.setForeground(FOREGROUND_NOT_ENABLED_INFO);
				}
				
				if ((secundaryEmailAddressClient.length() == 0) 
						|| (secundaryEmailAddressClient.equals(NOT_ENABLED_ADDITIONAL_MESSAGE))) 
				{
					lbl_set_secondary_email_address.setForeground(FOREGROUND_NOT_ENABLED_INFO);
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(PreviewDataClient.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Tu información");
		setType(Type.POPUP);
		setBounds(240, 120, 885, 553);
		contentPane = new JPanel();
		contentPane.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		header = new JPanel();
		header.setBounds(0,0,869,90);
		header.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		header.setLayout(null);
		contentPane.add(header);
		
		containerPreviewData = new JPanel();
		containerPreviewData.setBounds(0,90,869,363);
		containerPreviewData.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		containerPreviewData.setLayout(null);
		contentPane.add(containerPreviewData);
		
		footer = new JPanel();
		footer.setBounds(0,453,869,61);
		footer.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		footer.setLayout(null);
		contentPane.add(footer);
		
		lbl_bbva_logo = new JLabel();
		lbl_bbva_logo.setIcon(icon.PREVIEW_DATA_BBVA_LOGO_LIGHT_BACKGROUND);
		lbl_bbva_logo.setBounds(32,10,100,40);
		lbl_bbva_logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_bbva_logo.setVerticalAlignment(SwingConstants.CENTER);
		header.add(lbl_bbva_logo);
		
		lbl_title_window = new JLabel();
		lbl_title_window.setBounds(135,15,580,35);
		lbl_title_window.setText("Estimado usuario, para finalizar tu registro en BBVA-Digital,");
		lbl_title_window.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 21));
		lbl_title_window.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_title_window.setHorizontalAlignment(SwingConstants.CENTER);
		header.add(lbl_title_window);
		
		lbl_subtitle_window = new JLabel();
		lbl_subtitle_window.setSize(580,30);
		lbl_subtitle_window.setLocation(135, 50);
		lbl_subtitle_window.setText("por favor, verifique que todos sus datos sean correctos.");
		lbl_subtitle_window.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lbl_subtitle_window.setForeground(new Color(36, 113, 163));
		lbl_subtitle_window.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_subtitle_window.setVerticalAlignment(SwingConstants.TOP);
		header.add(lbl_subtitle_window);
		
		JSeparator jsp = new JSeparator();
		jsp.setSize(580, 1);
		jsp.setLocation(135, 0);
		jsp.setBackground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		jsp.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		containerPreviewData.add(jsp);
		
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		container_card1_preview_data = new JPanel();
		container_card1_preview_data.setBounds(10,20,270,343);
		container_card1_preview_data.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_card1_preview_data.setLayout(null);
		containerPreviewData.add(container_card1_preview_data);
		
		container_card2_preview_data = new JPanel();
		container_card2_preview_data.setBounds(300,20,270,343);
		container_card2_preview_data.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_card2_preview_data.setLayout(null);
		containerPreviewData.add(container_card2_preview_data);
		
		container_card3_preview_data = new JPanel();
		container_card3_preview_data.setBounds(590,20,270,343);
		container_card3_preview_data.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_card3_preview_data.setLayout(null);
		containerPreviewData.add(container_card3_preview_data);
		
		content_title_card1 = new JPanel();
		content_title_card1.setBounds(0,0,270,40);
		content_title_card1.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_title_card1.setLayout(null);
		container_card1_preview_data.add(content_title_card1);
		
		content_title_card2 = new JPanel();
		content_title_card2.setBounds(0,0,270,40);
		content_title_card2.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_title_card2.setLayout(null);
		container_card2_preview_data.add(content_title_card2);
		
		content_title_card3 = new JPanel();
		content_title_card3.setBounds(0,0,270,40);
		content_title_card3.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_title_card3.setLayout(null);
		container_card3_preview_data.add(content_title_card3);
		
		content_data_client_card1 = new JPanel();
		content_data_client_card1.setBounds(0,40,270,303);
		content_data_client_card1.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_data_client_card1.setLayout(null);
		container_card1_preview_data.add(content_data_client_card1);
		
		content_data_client_card2_part1 = new JPanel();
		content_data_client_card2_part1.setBounds(0,40,270,220);
		content_data_client_card2_part1.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_data_client_card2_part1.setLayout(null);
		container_card2_preview_data.add(content_data_client_card2_part1);
		
		content_data_client_card2_part2 = new JPanel();
		content_data_client_card2_part2.setBounds(0,40,270,220);
		content_data_client_card2_part2.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_data_client_card2_part2.setLayout(null);
		content_data_client_card2_part2.setVisible(false);
		container_card2_preview_data.add(content_data_client_card2_part2);
		
		content_data_client_card3 = new JPanel();
		content_data_client_card3.setBounds(0,40,270,303);
		content_data_client_card3.setBackground(COLOR.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_data_client_card3.setLayout(null);
		container_card3_preview_data.add(content_data_client_card3);
		
		lbl_back_mssg = new JLabel();
		lbl_back_mssg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_back_mssg.setForeground(Color.BLUE);
				lbl_set_icon_left.setIcon(icon.arrow_left_entered);
			}
			public void mouseExited(MouseEvent e) {
				lbl_back_mssg.setForeground(Color.BLACK);
				lbl_set_icon_left.setIcon(icon.arrow_left_exited);
			}
			public void mouseClicked(MouseEvent e) {
				content_data_client_card2_part1.setVisible(true);
				content_data_client_card2_part2.setVisible(false);
				lbl_next_mssg.setVisible(true);
				lbl_back_mssg.setVisible(false);
				lbl_set_icon_right.setVisible(true);
				lbl_set_icon_left.setVisible(false);
			}
		});
		lbl_back_mssg.setBounds(0,270,60,20);
		lbl_back_mssg.setText("Volver");
		lbl_back_mssg.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lbl_back_mssg.setForeground(getForeground());
		lbl_back_mssg.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_back_mssg.setVerticalAlignment(SwingConstants.CENTER);
		lbl_back_mssg.setVisible(false);
		container_card2_preview_data.add(lbl_back_mssg);
		
		lbl_next_mssg = new JLabel();
		lbl_next_mssg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbl_next_mssg.setForeground(Color.BLUE);
				lbl_set_icon_right.setIcon(icon.arrow_right_entered);
			}
			public void mouseExited(MouseEvent e) {
				lbl_next_mssg.setForeground(Color.BLACK);
				lbl_set_icon_right.setIcon(icon.arrow_right_exited);
			}
			public void mouseClicked(MouseEvent e) {
				content_data_client_card2_part1.setVisible(false);
				content_data_client_card2_part2.setVisible(true);
				lbl_next_mssg.setVisible(false);
				lbl_back_mssg.setVisible(true);
				lbl_set_icon_right.setVisible(false);
				lbl_set_icon_left.setVisible(true);
			}
		});
		lbl_next_mssg.setBounds(145,270,101,20);
		lbl_next_mssg.setText("Mostrar más");
		lbl_next_mssg.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		lbl_next_mssg.setForeground(getForeground());
		lbl_next_mssg.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_next_mssg.setVerticalAlignment(SwingConstants.CENTER);
		container_card2_preview_data.add(lbl_next_mssg);
		
		lbl_set_icon_left = new JLabel();
		lbl_set_icon_left.setBounds(0,269,20,25);
		lbl_set_icon_left.setIcon(icon.arrow_left_exited);
		lbl_set_icon_left.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_set_icon_left.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_icon_left.setVisible(false);
		container_card2_preview_data.add(lbl_set_icon_left);
		
		lbl_set_icon_right = new JLabel();
		lbl_set_icon_right.setBounds(225,270,20,25);
		lbl_set_icon_right.setIcon(icon.arrow_right_exited);
		lbl_set_icon_right.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_set_icon_right.setVerticalAlignment(SwingConstants.CENTER);
		container_card2_preview_data.add(lbl_set_icon_right);
		
	    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/*
		 * CARD 1 -> PREVIEW DATA CLIENTE -> GENERAL INFORMATION
		 */
		
		lbl_title_card1 = new JLabel();
		lbl_title_card1.setIcon(icon.PREVIEW_USER_DATA_DARK_BLUE_BACKGROUND);
		lbl_title_card1.setBounds(0,0,270,40);
		lbl_title_card1.setText("Tu información general");
		lbl_title_card1.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lbl_title_card1.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_title_card1.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_card1.setVerticalAlignment(SwingConstants.CENTER);
		content_title_card1.add(lbl_title_card1);
		
		lbl_name_client = new JLabel();
		lbl_name_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_name_client.setText("Nombre completo:");
		lbl_name_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_name_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_name_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_name_client.setBounds(0, 11, 270, 30);
		content_data_client_card1.add(lbl_name_client);
		
		lbl_set_name_client = new JLabel();
		lbl_set_name_client.setBounds(0, 41, 270, 30);
		lbl_set_name_client.setText(getFullNameClient());
		lbl_set_name_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_name_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_name_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_name_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card1.add(lbl_set_name_client);
		
		lbl_borndate_client = new JLabel();
		lbl_borndate_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_borndate_client.setText("Fecha de nacimiento:");
		lbl_borndate_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_borndate_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_borndate_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_borndate_client.setBounds(0, 84, 270, 30);
		content_data_client_card1.add(lbl_borndate_client);
		
		lbl_set_borndate_client = new JLabel();
		lbl_set_borndate_client.setBounds(0,114,270,30);
		lbl_set_borndate_client.setText(String.valueOf(getBornDateClient()));
		lbl_set_borndate_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_borndate_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_borndate_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_set_borndate_client.setVerticalAlignment(SwingConstants.CENTER);
		content_data_client_card1.add(lbl_set_borndate_client);
		
	    lbl_curp_client = new JLabel();
		lbl_curp_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_curp_client.setText("CURP:");
		lbl_curp_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_curp_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_curp_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_curp_client.setBounds(0, 155, 270, 30);
		content_data_client_card1.add(lbl_curp_client);
		
		lbl_set_curp_client = new JLabel();
		lbl_set_curp_client.setBounds(0, 185, 270, 30);
		lbl_set_curp_client.setText(getCurpClient());
		lbl_set_curp_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_curp_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_curp_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_curp_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card1.add(lbl_set_curp_client);
		
		/*
		 * CARD 2 -> PREVIEW DATA CLIENTE -> RESIDENCE INFORMATION
		 */
		
		lbl_title_card2 = new JLabel();
		lbl_title_card2.setIcon(icon.PREVIEW_LOCATION_USER_DATA_DARK_BLUE_BACKGROUND);
		lbl_title_card2.setBounds(0,0,270,40);
		lbl_title_card2.setText("Tu residencia actual");
		lbl_title_card2.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lbl_title_card2.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_title_card2.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_card2.setVerticalAlignment(SwingConstants.CENTER);
		content_title_card2.add(lbl_title_card2);
		
		lbl_state_address_residence_client = new JLabel();
		lbl_state_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_state_address_residence_client.setText("Estado:");
		lbl_state_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_state_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_state_address_residence_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_state_address_residence_client.setBounds(0, 11, 270, 30);
		content_data_client_card2_part1.add(lbl_state_address_residence_client);
		
		lbl_set_state_residence_client = new JLabel();
		lbl_set_state_residence_client.setBounds(0, 41, 270, 30);
		lbl_set_state_residence_client.setText(getStateResidenceClient());
		lbl_set_state_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_state_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_state_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_state_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part1.add(lbl_set_state_residence_client);
		
		lbl_city_residence_client = new JLabel();
		lbl_city_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_city_residence_client.setText("Ciudad / Municipio:");
		lbl_city_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_city_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_city_residence_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_city_residence_client.setBounds(0, 84, 270, 30);
		content_data_client_card2_part1.add(lbl_city_residence_client);
		
		lbl_set_city_residence_client = new JLabel();
		lbl_set_city_residence_client.setBounds(0, 114, 270, 30);
		lbl_set_city_residence_client.setText(getCityResidenceClient());
		lbl_set_city_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_city_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_city_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_city_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part1.add(lbl_set_city_residence_client);
		
		/*lbl_address_residence_client = new JLabel();
		lbl_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_address_residence_client.setText("Colonia:");
		lbl_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_address_residence_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_address_residence_client.setBounds(0, 82, 116, 30);
		content_data_client_card2_part1.add(lbl_address_residence_client);
		
		lbl_set_address_residence_client = new JLabel();
		lbl_set_address_residence_client.setBounds(0, 114, 116, 30);
		lbl_set_address_residence_client.setText(getNeighborhoodResidenceClient());
		lbl_set_address_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part1.add(lbl_set_address_residence_client);*/
		
		lbl_street_address_residence_client = new JLabel();
		lbl_street_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_street_address_residence_client.setText("Calle / Avenida ");
		lbl_street_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_street_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_street_address_residence_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_street_address_residence_client.setBounds(0, 155, 270, 30);
		content_data_client_card2_part1.add(lbl_street_address_residence_client);
		
		lbl_set_street_address_residence_client = new JLabel();
		lbl_set_street_address_residence_client.setBounds(0, 185, 270, 30);
		lbl_set_street_address_residence_client.setText(getStreetResidenceClient());
		lbl_set_street_address_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_street_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_street_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_street_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part1.add(lbl_set_street_address_residence_client);
		
		lbl_num_exterior_address_client = new JLabel();
		lbl_num_exterior_address_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_num_exterior_address_client.setText("Número exterior.:");
		lbl_num_exterior_address_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num_exterior_address_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_num_exterior_address_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_num_exterior_address_client.setBounds(0, 84, 270, 30);
		content_data_client_card2_part2.add(lbl_num_exterior_address_client);
		
		lbl_set_num_exterior_address_residence_client = new JLabel();
		lbl_set_num_exterior_address_residence_client.setBounds(0, 114, 270, 30);
		lbl_set_num_exterior_address_residence_client.setText(getNumberExteriorHomeResidenceClient());
		lbl_set_num_exterior_address_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_num_exterior_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_num_exterior_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_num_exterior_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part2.add(lbl_set_num_exterior_address_residence_client);
		
		lbl_num_inte_address_client = new JLabel();
		lbl_num_inte_address_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_num_inte_address_client.setText("Número interior.:");
		lbl_num_inte_address_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_num_inte_address_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_num_inte_address_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_num_inte_address_client.setBounds(0, 155, 270, 30);
		content_data_client_card2_part2.add(lbl_num_inte_address_client);
		
		lbl_set_num_inte_address_residence_client = new JLabel();
		lbl_set_num_inte_address_residence_client.setBounds(0, 185, 270, 30);
		lbl_set_num_inte_address_residence_client.setText(getNumberInteriorHomeResidenceClient());
		lbl_set_num_inte_address_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_num_inte_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_num_inte_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_num_inte_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part2.add(lbl_set_num_inte_address_residence_client);
		
		lbl_cp_address_residence_client = new JLabel();
		lbl_cp_address_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_cp_address_residence_client.setText("Código postal:");
		lbl_cp_address_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_cp_address_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_cp_address_residence_client.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_cp_address_residence_client.setBounds(0, 11, 270, 30);
		content_data_client_card2_part2.add(lbl_cp_address_residence_client);
		
		lbl_set_cp_residence_client = new JLabel();
		lbl_set_cp_residence_client.setBounds(0, 41, 270, 30);
		lbl_set_cp_residence_client.setText(getPostalCodeResidenceClient());
		lbl_set_cp_residence_client.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_cp_residence_client.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_cp_residence_client.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_cp_residence_client.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card2_part2.add(lbl_set_cp_residence_client);
		
		/*
		 * CARD 3 -> PREVIEW DATA CLIENTE -> CONTACT INFORMATION
		 */
		
		lbl_title_card3 = new JLabel();
		lbl_title_card3.setIcon(icon.PREVIEW_CONTACT_USER_DATA_DARK_BLUE_BACKGROUND);
		lbl_title_card3.setBounds(0,0,270,40);
		lbl_title_card3.setText("Información de contacto");
		lbl_title_card3.setFont(new Font("Yu Gothic UI", Font.BOLD, 18));
		lbl_title_card3.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_title_card3.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_title_card3.setVerticalAlignment(SwingConstants.CENTER);
		content_title_card3.add(lbl_title_card3);
		

		lbl_primary_email_address = new JLabel();
		lbl_primary_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_primary_email_address.setText("Email principal:");
		lbl_primary_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_primary_email_address.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_primary_email_address.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_primary_email_address.setBounds(0, 11, 270, 30);
		content_data_client_card3.add(lbl_primary_email_address);
		
		lbl_set_primary_email_address = new JLabel();
		lbl_set_primary_email_address.setBounds(0, 41, 270, 30);
		lbl_set_primary_email_address.setText(getPrincipalEmailClient());
		lbl_set_primary_email_address.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_primary_email_address.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_primary_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_primary_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card3.add(lbl_set_primary_email_address);
		
		lbl_secondary_email_address = new JLabel();
		lbl_secondary_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_secondary_email_address.setText("Email secundario:");
		lbl_secondary_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_secondary_email_address.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_secondary_email_address.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_secondary_email_address.setBounds(0, 84, 270, 30);
		content_data_client_card3.add(lbl_secondary_email_address);
		
		lbl_set_secondary_email_address = new JLabel();
		lbl_set_secondary_email_address.setBounds(0, 114, 270, 30);
		lbl_set_secondary_email_address.setText(getSecondEmailClient());
		lbl_set_secondary_email_address.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_secondary_email_address.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_secondary_email_address.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_secondary_email_address.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card3.add(lbl_set_secondary_email_address);
		
		lbl_primary_phone_number = new JLabel();
		lbl_primary_phone_number.setVerticalAlignment(SwingConstants.CENTER);
		lbl_primary_phone_number.setText("Número telefónico principal:");
		lbl_primary_phone_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_primary_phone_number.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_primary_phone_number.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_primary_phone_number.setBounds(0, 155, 270, 30);
		content_data_client_card3.add(lbl_primary_phone_number);
		
		lbl_set_primary_phone_number = new JLabel();
		lbl_set_primary_phone_number.setBounds(0, 185, 270, 30);
		lbl_set_primary_phone_number.setText(getPrincipalPhoneNumberClient());
		lbl_set_primary_phone_number.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_primary_phone_number.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_primary_phone_number.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_primary_phone_number.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card3.add(lbl_set_primary_phone_number);
		
		lbl_secondary_phone_number = new JLabel();
		lbl_secondary_phone_number.setVerticalAlignment(SwingConstants.CENTER);
		lbl_secondary_phone_number.setText("Número telefónico secundario:");
		lbl_secondary_phone_number.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_secondary_phone_number.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_secondary_phone_number.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		lbl_secondary_phone_number.setBounds(0, 220, 270, 30);
		content_data_client_card3.add(lbl_secondary_phone_number);
		
		lbl_set_secondary_phone_number = new JLabel();
		lbl_set_secondary_phone_number.setBounds(0, 250, 270, 30);
		lbl_set_secondary_phone_number.setText(getSecondPhoneNumberClient());
		lbl_set_secondary_phone_number.setFont(new Font("Yu Gothic UI", Font.PLAIN, 16));
		lbl_set_secondary_phone_number.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		lbl_set_secondary_phone_number.setVerticalAlignment(SwingConstants.CENTER);
		lbl_set_secondary_phone_number.setHorizontalAlignment(SwingConstants.LEFT);
		content_data_client_card3.add(lbl_set_secondary_phone_number);
		
		/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
		/*
		 * FOOTER
		 */
		
		JSeparator jsp_footer = new JSeparator();
		jsp_footer.setBounds(10,0,849,1);
		jsp_footer.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		jsp_footer.setBackground(COLOR.PRIMARY_COLOR_FONT_TEXT_BLACK);
		footer.add(jsp_footer);
		
		btn_edit = new RoundedPanel();
		btn_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_edit.setBackground(new Color(6, 63, 125));
			}
			public void mouseExited(MouseEvent e) {
				btn_edit.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
			}
			public void mouseClicked(MouseEvent e){
				setEditActions(true,false);
				dispose();
			}
		});
		btn_edit.setBounds(419,8,140,40);
		((RoundedPanel) btn_edit).setCornerRadius(5);
		btn_edit.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		btn_edit.setOpaque(false);
		btn_edit.setLayout(null);
		footer.add(btn_edit);
		
		btn_skip = new RoundedPanel();
		btn_skip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_skip.setBackground(new Color(6, 63, 125));
			}
			public void mouseExited(MouseEvent e) {
				btn_skip.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
			}
			public void mouseClicked(MouseEvent e){
				setEditActions(false,true);
				dispose();
			}
		});
		btn_skip.setBounds(568,8,141,40);
		((RoundedPanel) btn_skip).setCornerRadius(5);
		btn_skip.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		btn_skip.setOpaque(false);
		btn_skip.setLayout(null);
		footer.add(btn_skip);
		
		btn_continue = new RoundedPanel();
		btn_continue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btn_continue.setBackground(new Color(6, 63, 125));
			}
			public void mouseExited(MouseEvent e) {
				btn_continue.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
			}
			public void mouseClicked(MouseEvent e){
				setEditActions(false,true);
				dispose();
			}
		});
		btn_continue.setBounds(719,8,140,40);
		((RoundedPanel) btn_continue).setCornerRadius(5);
		btn_continue.setBackground(COLOR.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		btn_continue.setOpaque(false);
		btn_continue.setLayout(null);
		footer.add(btn_continue);
		
	    btn_text_edit = new JLabel();
	    btn_text_edit.setBounds(5,5,135,35);
	    btn_text_edit.setText("Editar mis datos");
	    btn_text_edit.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));	
	    btn_text_edit.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_WHITE);
	    btn_text_edit.setHorizontalAlignment(SwingConstants.CENTER);
	    btn_text_edit.setVerticalAlignment(SwingConstants.CENTER);
	    btn_edit.add(btn_text_edit);
	    
	    btn_text_skip = new JLabel();
	    btn_text_skip.setBounds(5,5,136,35);
	    btn_text_skip.setText("En otro momento");
	    btn_text_skip.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));	
	    btn_text_skip.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_WHITE);
	    btn_text_skip.setHorizontalAlignment(SwingConstants.CENTER);
	    btn_text_skip.setVerticalAlignment(SwingConstants.CENTER);
	    btn_skip.add(btn_text_skip);
	    
	    btn_text_continue = new JLabel();
	    btn_text_continue.setBounds(5,5,135,35);
	    btn_text_continue.setText("Continuar");
	    btn_text_continue.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 16));	
	    btn_text_continue.setForeground(COLOR.PRIMARY_COLOR_FONT_TEXT_WHITE);
	    btn_text_continue.setHorizontalAlignment(SwingConstants.CENTER);
	    btn_text_continue.setVerticalAlignment(SwingConstants.CENTER);
	    btn_continue.add(btn_text_continue);
	}
	
	private void setEditActions(boolean edit, boolean skip) {
		this.edit = edit;
		this.skip = skip;
	}
	
	public boolean editDataClient() {
		return edit;
	}
	
	public boolean skipEditDataClient() {
		return skip;
	}
		
	/*
     *   SETTER ATTRIBUTES CLIENT
     */
	public void setFullNameClient(String nombre, String apellidoP, String apellidoM){
		this.fullNameClient = apellidoP.concat(" ")
				.concat(apellidoM)
				.concat(" ").concat(nombre);
	}

	public void setDateBornClient(Object dd, Object mm, Object aaaa){
		this.dateBornClient = String.valueOf(dd)
				.concat(" / ").concat(String.valueOf(mm))
				.concat(" / ").concat(String.valueOf(aaaa));
	}
	
	public void setCurpClient(String curpClient) {
		this.curpClient = curpClient;
	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	public void setStateResidenceClient(String stateResidenceClient) {
		this.stateResidenceClient = stateResidenceClient;
	}
	
	public void setCityResidenceClient(String cityResidenceClient) {
		this.cityResidenceClient = cityResidenceClient;
	}
    
    public void setStreetResidenceClient(String streetResidenceClient) {
    	this.streetResidenceClient = streetResidenceClient;
    }
    
    public void setPostalCodeResidenceClient(String cpResidenceClient) {
    	this.cpResidenceClient = cpResidenceClient;
    }
    
    public void setExteriorNumberAddress(String numExteriorAddress) {
    	this.numExteriorAddress = numExteriorAddress;
    }
    
    public void setInteriorNumberAddress(String numInteriorAddress) {
    	if (!(numInteriorAddress.equals(PLACEHOLDER_NUM_INTE) 
    			|| numInteriorAddress.length() == 0)) 
    	{
    		this.numInteriorAddress = numInteriorAddress;
    	}
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public void setMainEmailClient(String mainEmailAddressClient) {
    	this.mainEmailAddressClient = mainEmailAddressClient;
    }
    
    public void setSecundaryEmailClient(String secundaryEmailAddressClient) {
    	if (!(secundaryEmailAddressClient.length() == 0)) 
    	{
    		this.secundaryEmailAddressClient = secundaryEmailAddressClient;
    	}
    }
    
    public void setMainPhoneNumberClient(String mainPhoneNumberClient) {
    	this.mainPhoneNumberClient = mainPhoneNumberClient;
    }
    
    public void setSecundaryPhoneNumberClient(String secundaryPhoneNumberClient) {
    	if (!(secundaryPhoneNumberClient.equals(PLACEHOLDER_PHONE_NUMBER) 
    			|| secundaryPhoneNumberClient.length() == 0)) 
    	{
    		this.secundaryPhoneNumberClient = secundaryPhoneNumberClient;
    	}
    }
    
    /*
     *   GETTER ATTRIBUTES CLIENT
     */
	public String getFullNameClient(){
		return fullNameClient;
	}
    
    public Object getBornDateClient() {
		return dateBornClient;
    }
    
    public String getCurpClient() {
    	return curpClient;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public String getStateResidenceClient() {
    	return stateResidenceClient;
    }

    public String getCityResidenceClient(){
    	return cityResidenceClient;
    }
    
    public String getStreetResidenceClient(){
    	return streetResidenceClient;
    }

    public String getPostalCodeResidenceClient(){
    	return cpResidenceClient;
    }

    public String getNumberExteriorHomeResidenceClient(){
    	return numExteriorAddress;
    }

    public String getNumberInteriorHomeResidenceClient(){
    	return numInteriorAddress;
    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public String getPrincipalEmailClient(){
    	return mainEmailAddressClient;
    }

    public String getSecondEmailClient(){
    	return secundaryEmailAddressClient;
    }

    public String getPrincipalPhoneNumberClient(){
    	return mainPhoneNumberClient;
    }

    public String getSecondPhoneNumberClient(){
    	return secundaryPhoneNumberClient;
    }   
}
