package main.java.com.bbva_digital_app.advertising;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.border.EmptyBorder;

import main.java.com.bbva_digital_app.register.client.LaunchRegister1;
import main.java.com.bbva_digital_app.access.ClientRedirection;
import main.resources.visual.manager.classes.*;
import main.resources.visual.swingcomponents.RoundedPanel;

public class BenefitsBBVA extends JFrame {

	private static final long serialVersionUID = -3746615331506868734L;
	
	//declaration of external windows
	private LaunchBenefitsApplication LaunchBenefits;
	private LaunchRegister1 createAccount;
	private ClientRedirection redirection;
	
	//instance of visual resource
	private IconImageManager ICON = new IconImageManager();
	private ColorManager background = new ColorManager();
	private ColorManager foreground = new ColorManager();
	
	/*
	  User interface organization's map    ::::     Swing components 
    =================================================================
   
    Frame
   
     1) container_presentation_sec         ::::     JPanel
     
       1.1 content_presentation            ::::     JPanel
   
           1.2 benefits_bbva_icon          ::::     JLabel
   
     2) container_interactive_sec          ::::     JPanel
   
       2.1 content_interactive             ::::     JPanel
     
           2.2 header                      ::::     JPanel
   
               2.2.1 title_header_row1     ::::     JLabel
               
               2.2.2 title_header_row2     ::::     JLabel
               
               2.2.3 paragraph_row1        ::::     JLabel
               
               2.2.4 paragraph_row2        ::::     JLabel
     
           2.3 center                      ::::     JPanel
   
               2.3.1 readBenefits          ::::     JButton
               
               2.3.2 skip                  ::::     JButton
   
           2.4 footer                      ::::     JPanel
               
               2.4.1 copyright             ::::     JLabel
   
    =================================================================
    */
	
	private JPanel Frame;
	
	// 1)
	private JPanel container_presentation_sec;
	
	    // 1.1)
		private JPanel content_presentation;
		
		    // 1.2)
			private JLabel benefits_bbva_icon;
			
    // 2)
	private JPanel container_interactive_sec;
	
	    // 2.1)
		private JPanel content_interactive;
		
		    // 2.2)
			private JPanel header;
			
			    // 2.2.1)
				private JLabel title_header_row1;

				// 2.2.2)
				private JLabel title_header_row2;
				
				// 2.2.3)
				private JLabel paragraph_row1;
				
				// 2.2.4)
				private JLabel paragraph_row2;
				
			// 2.3)
			private JPanel center;
			
			    // 2.3.1)
				private JPanel readBenefits; /*(button)*/
				
				//2.3.2)
				private JPanel skip;         /*(button)*/
				
			// 2.4)
			private JPanel footer;
			
			    // 2.4.1)
				private JLabel copyright;
	
	//==========================================================
	
    //declaration excluded of the organization's map
	private JLabel lbl_text_read_benefits_button;
	private JLabel lbl_text_skip_button;
				
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					BenefitsBBVA Frame = new BenefitsBBVA();
					Frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the Frame.
	 */
	public BenefitsBBVA() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				closeWindowAndInvokeRedirection();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(BenefitsBBVA.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Beneficios BBVA Digital");
		setType(Type.POPUP);
		setResizable(false);
		setBounds(240,  60,  900,  630);
		Frame = new JPanel();
		Frame.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		Frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(Frame);
		Frame.setLayout(null);
		
		/*==========================================================================================*/
		
		container_presentation_sec = new JPanel();
		container_presentation_sec.setBounds(0, 0, 455, 530);
		container_presentation_sec.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_presentation_sec.setLayout(null);
		Frame.add(container_presentation_sec);
		
		content_presentation = new JPanel();
		content_presentation.setBounds(5, 5, 445, 514);
		content_presentation.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		content_presentation.setLayout(null);
		container_presentation_sec.add(content_presentation);
		
		benefits_bbva_icon = new JLabel();
		benefits_bbva_icon.setBounds(0, 5, 445, 509);
		benefits_bbva_icon.setIcon(ICON.BENEFITS_BBVA_DIGITAL_ILUSTRATION);
		benefits_bbva_icon.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		benefits_bbva_icon.setForeground(getForeground());
		benefits_bbva_icon.setHorizontalAlignment(SwingConstants.LEFT);
		content_presentation.add(benefits_bbva_icon);
		
		/*==========================================================================================*/
		
		container_interactive_sec = new JPanel();
		container_interactive_sec.setBounds(456, 0, 430, 530);
		container_interactive_sec.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		container_interactive_sec.setLayout(null);
		Frame.add(container_interactive_sec);
		
		content_interactive = new JPanel();
		content_interactive.setBounds(5, 5, 418, 514);
		content_interactive.setBackground(getBackground());
		content_interactive.setLayout(null);
		container_interactive_sec.add(content_interactive);
		
		/*==========================================================================================*/
		
		header = new JPanel();
		header.setBounds(0, 0, 418, 121);
		header.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		header.setLayout(null);
		content_interactive.add(header);
		
		title_header_row1 = new JLabel();
		title_header_row1.setBounds(0, 25, 390, 45);
		title_header_row1.setText("BBVA Digital ahora en");
		title_header_row1.setFont(new Font("Microsoft JhengHei",  Font.PLAIN,  32));
		title_header_row1.setForeground(foreground.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		title_header_row1.setHorizontalAlignment(SwingConstants.CENTER);
		title_header_row1.setVerticalAlignment(SwingConstants.TOP);
		header.add(title_header_row1);
		
		title_header_row2 = new JLabel();
		title_header_row2.setBounds(0, 70, 390, 45);
		title_header_row2.setText("Windows 8,  10 y 11");
		title_header_row2.setFont(new Font("Microsoft JhengHei",  Font.PLAIN,  32));
		title_header_row2.setForeground(foreground.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		title_header_row2.setHorizontalAlignment(SwingConstants.CENTER);
		title_header_row2.setVerticalAlignment(SwingConstants.TOP);
		header.add(title_header_row2);
		
		/*==========================================================================================*/
		
		center = new JPanel();
		center.setBounds(0, 121, 418, 393);
		center.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		center.setLayout(null);
		content_interactive.add(center);
		
		JSeparator jp = new JSeparator();
		jp.setBounds(4, 22, 380, 1);
		jp.setBackground(foreground.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
		jp.setForeground(foreground.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		center.add(jp);
		
		paragraph_row1 = new JLabel();
		paragraph_row1.setBounds(0, 59, 390, 40);
		paragraph_row1.setText("Una aplicación bancaria para Windows");
		paragraph_row1.setFont(new Font("Microsoft YaHei Light",  Font.PLAIN,  21));
		paragraph_row1.setForeground(Color.BLACK);
		paragraph_row1.setHorizontalAlignment(SwingConstants.CENTER);
		paragraph_row1.setVerticalAlignment(SwingConstants.CENTER);
		center.add(paragraph_row1);
		
		paragraph_row2 = new JLabel();
		paragraph_row2.setBounds(0, 92, 390, 40);
		paragraph_row2.setText("fácil de usar,  rapida e intuitiva");
		paragraph_row2.setFont(new Font("Microsoft YaHei Light",  Font.PLAIN,  21));
		paragraph_row2.setForeground(Color.BLACK);
		paragraph_row2.setHorizontalAlignment(SwingConstants.CENTER);
		paragraph_row2.setVerticalAlignment(SwingConstants.CENTER);
		center.add(paragraph_row2);
		
		readBenefits = new RoundedPanel();
		readBenefits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				readBenefits.setBackground(new Color(19, 53, 101));
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				readBenefits.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				LaunchBenefits = new LaunchBenefitsApplication("launch");
				LaunchBenefits.setVisible(true);
			}
		});
		readBenefits.setBounds(65, 184, 260, 50);
		((RoundedPanel) readBenefits).setCornerRadius(10);
		readBenefits.setBackground(background.BACKGROUND_COLOR_BBVA_OFFICIAL);
		readBenefits.setCursor(new Cursor(Cursor.HAND_CURSOR));
		readBenefits.setLayout(null);
		center.add(readBenefits);
		
		lbl_text_read_benefits_button = new JLabel();
		lbl_text_read_benefits_button.setBounds(5, 5, 255, 45);
		lbl_text_read_benefits_button.setText("Leer sobre los beneficios");
		lbl_text_read_benefits_button.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lbl_text_read_benefits_button.setForeground(foreground.PRIMARY_COLOR_FONT_TEXT_WHITE);
		lbl_text_read_benefits_button.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text_read_benefits_button.setVerticalAlignment(SwingConstants.CENTER);
		readBenefits.add(lbl_text_read_benefits_button);
		
		skip = new RoundedPanel();
		skip.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				skip.setBackground(new Color(210, 228, 255));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				skip.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				createAccount = new LaunchRegister1();
				createAccount.setVisible(true);
				dispose();
			}
		});
		skip.setBounds(65, 257, 260, 50);
		((RoundedPanel) skip).setCornerRadius(10);
		skip.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		//skip.setBackground(new Color(218, 233, 255));
		skip.setCursor(new Cursor(Cursor.HAND_CURSOR));
		skip.setLayout(null);
		center.add(skip);
		
		lbl_text_skip_button = new JLabel();
		lbl_text_skip_button.setBounds(5, 5, 255, 45);
		lbl_text_skip_button.setText("Quizás en otro momento");
		lbl_text_skip_button.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 19));
		lbl_text_skip_button.setForeground(foreground.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		lbl_text_skip_button.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_text_skip_button.setVerticalAlignment(SwingConstants.CENTER);
		skip.add(lbl_text_skip_button);
		
		/*==========================================================================================*/
		
		footer = new JPanel();
		footer.setBounds(0, 530, 876, 61);
		footer.setBackground(background.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		footer.setLayout(null);
		Frame.add(footer);
		
		copyright = new JLabel();
		copyright.setBounds(0, 0, 876, 61);
		copyright.setText("Copyright © 2025 Grupo BBVA. Todos los derechos reservados");
		copyright.setFont(new Font("Segoe UI Semilight",  Font.PLAIN,  14));
		copyright.setForeground(foreground.PRIMARY_COLOR_FONT_TEXT_BLACK);
		copyright.setHorizontalAlignment(SwingConstants.CENTER);
		copyright.setVerticalAlignment(SwingConstants.CENTER);
		footer.add(copyright);
		
		/*==========================================================================================*/
	}
	
	public void closeWindowAndInvokeRedirection() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		dispose();
		redirection = new ClientRedirection();
		redirection.setVisible(true);
	}
}