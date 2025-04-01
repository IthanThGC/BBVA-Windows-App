package main.java.com.bbva_digital_app.access;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.java.com.bbva_digital_app.advertising.BenefitsBBVA;
import main.resources.visual.manager.classes.*;
import main.resources.visual.swingcomponents.*;

public class ClientRedirection extends JFrame {

	private static final long serialVersionUID = -8454025501829308453L;

	private JPanel Frame;
	
	//instance to access and create account
	private LoginApplication login;
	private BenefitsBBVA showBenefits; 

	//web site
	private final String LINK_TO_OFFICIAL_WEB_SITE = "https://www.bbva.mx/";
	private Link link;
	
	//Visual resources
	private IconImageManager icon = new IconImageManager();
	private ColorManager background = new ColorManager();
	
	private JLabel banner_bbva;
	
	private JPanel container;
	
	private JPanel container_central;
	private JPanel content_central;
	
	private JPanel content_buttons_redirection;
	
	private JLabel lbl_login_application;
	private JLabel lbl_register_account;
	private JLabel lbl_redirection_web_site;
	private JLabel lbl_icon_open_wb_st;
	private JPanel panel_login_application;
	private JPanel panel_register_account;
	private JPanel panel_redirection_web_site;
	
	private JLabel lbl_info_about_copyright;
	private JLabel lbl_software_version; 
	
	//private Color BackgroundColorFrame = new Color(7, 33, 70); //0, 66, 132
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ClientRedirection frame = new ClientRedirection();
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
	public ClientRedirection() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientRedirection.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setTitle("BBVA Windows App");
		setType(Type.POPUP);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(270, 60, 815, 630);
		Frame = new JPanel();
		Frame.setBackground(background.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		container = new JPanel();
		container.setBounds(0, 0, 799, 591);
		container.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
		container.setLayout(null);
		Frame.add(container);
				
		banner_bbva = new JLabel();
		banner_bbva.setBounds(0, 0, 799, 160);
		banner_bbva.setIcon(icon.BBVA_APP_FOR_WINDOWS_BANNER);
		banner_bbva.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(banner_bbva);
		
		container_central = new RoundedPanel();
		container_central.setBounds(179,180,440,260);
		container_central.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		((RoundedPanel) container_central ).setCornerRadius(40);
		container_central.setOpaque(false);
		container_central.setLayout(null);
		container.add(container_central);
		
		content_central = new JPanel(); 
		content_central.setSize(410, 237);
		content_central.setLocation(16, 13);
		content_central.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_central.setLayout(null);
		container_central.add(content_central);
		
		content_buttons_redirection = new JPanel(); 
		content_buttons_redirection.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_buttons_redirection.setBounds(0,0,410,237);
		content_buttons_redirection.setLayout(null);
		content_central.add(content_buttons_redirection);
		
		panel_login_application = new RoundedPanel();
		panel_login_application.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				panel_login_application.setBackground(new Color(19, 53, 101));
			}
			public void mouseExited(MouseEvent e) 
			{
				panel_login_application.setBackground(background.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
			}
			public void mouseClicked(MouseEvent e) 
			{
				login = new LoginApplication();
				login.setVisible(true);
				dispose();
			}
		});
		panel_login_application.setBounds(73, 20, 260, 50);
		panel_login_application.setBackground(background.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
		((RoundedPanel) panel_login_application).setCornerRadius(10);
		panel_login_application.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_login_application.setLayout(null);
		content_buttons_redirection.add(panel_login_application);
		
		lbl_login_application = new JLabel();
		lbl_login_application.setBounds(5,5,255,45);
		lbl_login_application.setText("Iniciar sesión");
		lbl_login_application.setFont(new Font("Yu Gothic UI", Font.PLAIN, 22));
		lbl_login_application.setForeground(new Color(255,255,255));
		lbl_login_application.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_login_application.setVerticalAlignment(SwingConstants.CENTER);
		panel_login_application.add(lbl_login_application);
		
		panel_register_account = new RoundedPanel();
		panel_register_account.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				panel_register_account.setBackground(new Color(228, 229, 229));
			}
			public void mouseExited(MouseEvent e) 
			{
				panel_register_account.setBackground(new Color(234, 237, 237));
			}
			public void mouseClicked(MouseEvent e) 
			{
				showBenefits = new BenefitsBBVA();
				showBenefits.setVisible(true);
				dispose();
			}
		});
		panel_register_account.setBounds(73, 90, 260, 50);
		panel_register_account.setBackground(new Color(234, 237, 237));
		((RoundedPanel) panel_register_account).setCornerRadius(10);
		panel_register_account.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_register_account.setLayout(null);
		content_buttons_redirection.add(panel_register_account);

		lbl_register_account = new JLabel();
		lbl_register_account.setBounds(5,5,255,45);
		lbl_register_account.setText("Crear una cuenta");
		lbl_register_account.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 19));
		lbl_register_account.setForeground(new Color(0,0,0));
		lbl_register_account.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_register_account.setVerticalAlignment(SwingConstants.CENTER);
		panel_register_account.add(lbl_register_account);
		
		panel_redirection_web_site = new RoundedPanel();
		panel_redirection_web_site.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				panel_redirection_web_site.setBackground(new Color(228, 229, 229));
				lbl_icon_open_wb_st.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_ENTERED);
			}
			public void mouseExited(MouseEvent e)
			{
				panel_redirection_web_site.setBackground(new Color(234, 237, 237));
				lbl_icon_open_wb_st.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_EXITED);
			}
			public void mouseClicked(MouseEvent e1) 
			{
				try 
				{
					link = new Link(LINK_TO_OFFICIAL_WEB_SITE);
					link.openWebSite();
				}
				catch(URISyntaxException e)
				{
					JOptionPane.showMessageDialog(null,
							"Lo sentimos.\nTuvimos problemas al intentar abrir el sitio web.\n\n"+e.getCause()+"\n\n",
							"Error de sistema",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_redirection_web_site.setBounds(73, 160, 260, 50);
		panel_redirection_web_site.setBackground(new Color(234, 237, 237));
		((RoundedPanel) panel_redirection_web_site).setCornerRadius(10);
		panel_redirection_web_site.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panel_redirection_web_site.setLayout(null);
		content_buttons_redirection.add(panel_redirection_web_site);

		lbl_redirection_web_site = new JLabel();
		lbl_redirection_web_site.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_redirection_web_site.setText("Abrir sitio web oficial");
		lbl_redirection_web_site.setBounds(5,5,245,45);
		lbl_redirection_web_site.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 19));
		lbl_redirection_web_site.setForeground(new Color(0,0,0));
		lbl_redirection_web_site.setVerticalAlignment(SwingConstants.CENTER);
		panel_redirection_web_site.add(lbl_redirection_web_site);
		
		lbl_icon_open_wb_st = new JLabel();
		lbl_icon_open_wb_st.setBounds(222,5,30,45);
		lbl_icon_open_wb_st.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_icon_open_wb_st.setVerticalAlignment(SwingConstants.CENTER);
		lbl_icon_open_wb_st.setIcon(icon.OPEN_EXTERNAL_WEB_SITE_ABOUT_BBVA_EXITED);
		panel_redirection_web_site.add(lbl_icon_open_wb_st);
		
		lbl_software_version = new JLabel();
		lbl_software_version.setBounds(0, 516, 799, 30);
		lbl_software_version.setText("Versión 1.1.001");
		lbl_software_version.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 14));
		lbl_software_version.setForeground(Color.WHITE);
		lbl_software_version.setVerticalAlignment(SwingConstants.BOTTOM);
		lbl_software_version.setHorizontalAlignment(SwingConstants.CENTER);
		container.add(lbl_software_version);
		
		lbl_info_about_copyright = new JLabel();
		lbl_info_about_copyright.setBounds(0, 550, 799, 30);
		lbl_info_about_copyright.setText("Copyright © 2025 Grupo BBVA. Todos los derechos reservados");
		lbl_info_about_copyright.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		lbl_info_about_copyright.setForeground(new Color(255,255,255));
		lbl_info_about_copyright.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_info_about_copyright.setVerticalAlignment(SwingConstants.CENTER);
		container.add(lbl_info_about_copyright);
		
	}
}
