package main.java.com.bbva_digital_app.advertising;

import java.awt.Color;
import java.awt.Cursor;
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
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import main.java.com.bbva_digital_app.register.client.LaunchRegister1;
import main.resources.control.manager.dialogs.Dialogs;
import main.resources.visual.manager.classes.ColorManager;
import main.resources.visual.manager.classes.IconImageManager;
import main.resources.visual.swingcomponents.RoundedPanel;

public class LaunchBenefitsApplication extends JFrame {
	
	/**
	 * @author Ethan Anwar
	 */

	private static final long serialVersionUID = -2813526882883886967L;
	
	/**
	 * @see control variable that helps us to obtain the GUI 
	 * layer in which the user is at that moment.
	 */
	private int layer = 0;
	
	/**
	 * <strong>Global control variables</strong>
	 * 
	 * <p> Control variables are declared which help us to 
	 * understand the direction context, i.e., 
	 * 
	 * if the software detects a move_to_right it is because 
	 * the user is navigating to the right and the same to the 
	 * left with move_to_right. </p>
	 * 
	 * @see control variable to direction context
	 */
	private boolean move_to_left = false;
	private boolean move_to_right = false;
	private String event = "";
	
	//instance to another pages
	private LaunchRegister1 registerAccount;
	private BenefitsBBVA benefitsPage;
	
	/*
	        GUI ORGANIZATION'S MAP         ::::     Swing components 
	         
    =================================================================
      
    MainFrame
    
     1) Header                             ::::     JPanel
        
       1.1 IllustrationContainer           ::::     JPanel
          
           1.2 Illustration                ::::     JLabel [Icon]
     
     2) Content
       
       2.1 BenefitsDescriptionContent      ::::     JPanel
       
           2.1.2 ParagraphRowTop           ::::     JLabel   
           
           2.1.3 ParagraphRowCenter        ::::     JLabel   
         
           2.1.4 ParagraphRowBottom        ::::     JLabel        
     
     3) Footer
     
       3.1 FooterContainer                 ::::     JPanel
       
           3.1.2 LayerRedirectionPanel     ::::     JPanel
           
               3.2.3 LeftDirectionArrow    ::::     JLabel [Icon]
               
               3.2.4 FirstPositionLayer    ::::     JButton [RoundedPanel]
              
               3.2.5 SecondPositionLayer   ::::     JButton [RoundedPanel]
               
               3.2.6 ThirdPositionLayer    ::::     JButton [RoundedPanel]
               
               3.2.7 FourthPositionLayer   ::::     JButton [RoundedPanel]
               
               3.2.8 FifthPositionLayer    ::::     JButton [RoundedPanel]
               
               3.2.9 RightDirectionArrow   ::::     JLabel [Icon]
   
           3.1.3 LeavePage                 ::::     JLabel
            
    =================================================================
    */
	
	private JPanel MainFrame;
	
	// 1
	private JPanel Header;
	
	    // 1.1 
	    private JPanel IllustrationContainer;
	    
	        // 1.2
	        private JLabel Illustration;
	        
	// 2
	private JPanel Content;
	
	    // 2.1
	    private JPanel BenefitsDescriptionContent;
	    
	        // 2.1.2 
	        private JLabel ParagraphRowTop;
	        
	        // 2.1.3 
	        private JLabel ParagraphRowCenter;
	        
	        // 2.1.4 
	        private JLabel ParagraphRowBottom;
	
	// 3
	private JPanel Footer;
	
	    // 3.1
	    private JPanel FooterContainer;
	    
	        // 3.1.2
	        private JPanel LayerRedirectionPanel;
	        
	            // 3.2.3 
	            private JLabel LeftDirectionArrow;
	                
	            // 3.2.4 
	            private JPanel FirstPositionButton;
	            
	            // 3.2.5 
	            private JPanel SecondPositionButton;
	            
	            // 3.2.6 
	            private JPanel ThirdPositionButton;
	            
	            // 3.2.7 
	            private JPanel FourthPositionLayer;
	            
	            // 3.2.8 
	            private JPanel FifthPositionLayer;
	            
	            // 3.2.9 
	            private JLabel RightDirectionArrow;
	     
	        // 3.1.3
	        private JLabel LeavePage;
	
	/**
	 * <p>Visual resources</p>
	 */
	private static final IconImageManager ICON = new IconImageManager(); 
	private static final ColorManager BACKGROUND = new ColorManager(); 
	private static final ColorManager FOREGROUND = new ColorManager();
	private static final Color BACKGROUND_LAYER_BUTTON = Color.LIGHT_GRAY;
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
					LaunchBenefitsApplication frame = new LaunchBenefitsApplication("");
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
	public LaunchBenefitsApplication(String event) 
	{
		addWindowListener(new WindowAdapter() 
		{			
			public void windowClosing(WindowEvent e) 
			{
				closeWindowAndInvokeRedirection();
			}
			
			public void windowOpened(WindowEvent e) 
			{		
				setEvent(event);

				if (isEventEqualsLaunch())
				{
					setFirstLayerSection();
					visibilityRedirectionArrowEvents();
				}
				else
				{
					applyNotAvailableEvents();
				}
			}
		});
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(LaunchBenefitsApplication.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Beneficios BBVA Digital");
		setType(Type.POPUP);
		setResizable(false);
		setBounds(240, 30, 900, 700);
		MainFrame = new JPanel();
		MainFrame.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		MainFrame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(MainFrame);
		MainFrame.setLayout(null);
		
		/**
		 * @see <p>Containers</p>
		 */
		
		Header = new JPanel();
		Header.setBounds(0, 0, 884, 400);
		Header.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		Header.setLayout(null);
		MainFrame.add(Header);
		
		Content = new JPanel();
		Content.setBounds(0, 400, 884, 180);
		Content.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		Content.setLayout(null);
		MainFrame.add(Content);
		
		Footer = new JPanel();
		Footer.setBounds(0, 580, 884, 80);
		Footer.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		Footer.setLayout(null);
		MainFrame.add(Footer);
		
		/**
		 * @see <p>Illustration section</p>
		 */
		
		IllustrationContainer = new JPanel();
		IllustrationContainer.setBounds(5, 5, Header.getWidth() - 10, Header.getHeight() - 10);
		IllustrationContainer.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		IllustrationContainer.setLayout(null);
		Header.add(IllustrationContainer);
		
		Illustration = new JLabel();
		Illustration.setBounds(0, 0, IllustrationContainer.getWidth(), IllustrationContainer.getHeight());
		Illustration.setIcon(ICON.NOT_AVAILABLE_CONTENT);
		Illustration.setHorizontalAlignment(SwingConstants.CENTER);
		Illustration.setVerticalAlignment(SwingConstants.CENTER);
		IllustrationContainer.add(Illustration);
		
		/**
		 * @see <p>Benefits description section</p>
		 */
		
		BenefitsDescriptionContent = new JPanel();
		BenefitsDescriptionContent.setBounds(5, 5, Content.getWidth() - 10, Content.getHeight() - 10);
		BenefitsDescriptionContent.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		BenefitsDescriptionContent.setLayout(null);
		Content.add(BenefitsDescriptionContent);
		
		ParagraphRowTop = new JLabel();
		ParagraphRowTop.setBounds(100, 20, BenefitsDescriptionContent.getWidth() - 200, 30);
		ParagraphRowTop.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		ParagraphRowTop.setForeground(FOREGROUND.PRIMARY_COLOR_FONT_TEXT_BLACK);
		ParagraphRowTop.setHorizontalAlignment(SwingConstants.LEFT);
		ParagraphRowTop.setVerticalAlignment(SwingConstants.CENTER);
		BenefitsDescriptionContent.add(ParagraphRowTop);
		
		ParagraphRowCenter = new JLabel();
		ParagraphRowCenter.setBounds(100, 65, BenefitsDescriptionContent.getWidth() - 200, 30);
		ParagraphRowCenter.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		ParagraphRowCenter.setForeground(FOREGROUND.PRIMARY_COLOR_FONT_TEXT_BLACK);
		ParagraphRowCenter.setHorizontalAlignment(SwingConstants.LEFT);
		ParagraphRowCenter.setVerticalAlignment(SwingConstants.CENTER);
		BenefitsDescriptionContent.add(ParagraphRowCenter);
		
		ParagraphRowBottom = new JLabel();
		ParagraphRowBottom.setBounds(100, 105, 720, 30);
		ParagraphRowBottom.setFont(new Font("Microsoft YaHei UI Light", Font.PLAIN, 20));
		ParagraphRowBottom.setForeground(FOREGROUND.PRIMARY_COLOR_FONT_TEXT_BLACK);
		ParagraphRowBottom.setHorizontalAlignment(SwingConstants.LEFT);
		ParagraphRowBottom.setVerticalAlignment(SwingConstants.CENTER);
		BenefitsDescriptionContent.add(ParagraphRowBottom);

		/**
		 * @see <p>Footer container</p>

		 */
		
		FooterContainer = new JPanel();
		FooterContainer.setBounds(5, 5, Footer.getWidth() -  10, Footer.getHeight() -  10);
		FooterContainer.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		FooterContainer.setLayout(null);
		Footer.add(FooterContainer);
		
		/**
		 * @see <p>Layer redirection section</p>
		 */
		
		LayerRedirectionPanel = new JPanel();
		LayerRedirectionPanel.setBounds(87, 0, 650, 69);
		LayerRedirectionPanel.setBackground(BACKGROUND.BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL);
		LayerRedirectionPanel.setLayout(null);
		FooterContainer.add(LayerRedirectionPanel);
		
		//createLayerButton(layer_button, initial_position_x);
				
		FirstPositionButton = new RoundedPanel();
		FirstPositionButton.setBounds(200, 25, 40, 20);
		((RoundedPanel) FirstPositionButton).setCornerRadius(15);
		FirstPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
		FirstPositionButton.setLayout(null);
		LayerRedirectionPanel.add(FirstPositionButton);
		
		SecondPositionButton = new RoundedPanel();
		SecondPositionButton.setBounds(270, 25, 40, 20);
		((RoundedPanel) SecondPositionButton).setCornerRadius(15);
		SecondPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
		SecondPositionButton.setLayout(null);
		LayerRedirectionPanel.add(SecondPositionButton);
		
		ThirdPositionButton = new RoundedPanel();
		ThirdPositionButton.setBounds(340, 25, 40, 20);
		((RoundedPanel) ThirdPositionButton).setCornerRadius(15);
		ThirdPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
		ThirdPositionButton.setLayout(null);
		LayerRedirectionPanel.add(ThirdPositionButton);
		
		FourthPositionLayer = new RoundedPanel();
		FourthPositionLayer.setBounds(410, 25, 40, 20);
		((RoundedPanel) FourthPositionLayer).setCornerRadius(15);
		FourthPositionLayer.setBackground(BACKGROUND_LAYER_BUTTON);
		FourthPositionLayer.setLayout(null);
		LayerRedirectionPanel.add(FourthPositionLayer);
		
		FifthPositionLayer = new RoundedPanel();
		FifthPositionLayer.setBounds(480, 25, 40, 20);
		((RoundedPanel) FifthPositionLayer).setCornerRadius(15);
		FifthPositionLayer.setBackground(BACKGROUND_LAYER_BUTTON);
		FifthPositionLayer.setLayout(null);
		LayerRedirectionPanel.add(FifthPositionLayer);
		
		LeftDirectionArrow = new JLabel();
		LeftDirectionArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (isEventEqualsLaunch())
				{
					setMoveToRight(false);
					setMoveToLeft(true);
					changeLayerSection();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (isEventEqualsLaunch()) 
				{
					LeftDirectionArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
					LeftDirectionArrow.setIcon(ICON.LEFT_ARROW_LAYER_BENEFIT_ENTERED);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				if (isEventEqualsLaunch()) 
				{
					LeftDirectionArrow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					LeftDirectionArrow.setIcon(ICON.LEFT_ARROW_LAYER_BENEFIT_EXITED);
				}
			}
		});
		LeftDirectionArrow.setBounds(145, 20, 20, 30);
		LeftDirectionArrow.setIcon(ICON.LEFT_ARROW_LAYER_BENEFIT_EXITED);
		LeftDirectionArrow.setHorizontalAlignment(SwingConstants.CENTER);
		LeftDirectionArrow.setVerticalAlignment(SwingConstants.CENTER);
		LeftDirectionArrow.setVisible(true);
		LayerRedirectionPanel.add(LeftDirectionArrow);
				
		RightDirectionArrow = new JLabel();
		RightDirectionArrow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if (isEventEqualsLaunch()) 
				{
					setMoveToRight(true);
					setMoveToLeft(false);
					changeLayerSection();
				}
			}
			
			@Override
			public void mouseEntered(MouseEvent e) 
			{
				if (isEventEqualsLaunch()) 
				{
					RightDirectionArrow.setCursor(new Cursor(Cursor.HAND_CURSOR));
					RightDirectionArrow.setIcon(ICON.RIGHT_ARROW_LAYER_BENEFIT_ENTERED);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) 
			{
				if (isEventEqualsLaunch()) 
				{
					RightDirectionArrow.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					RightDirectionArrow.setIcon(ICON.RIGHT_ARROW_LAYER_BENEFIT_EXITED);
				}
			}
		});
		RightDirectionArrow.setBounds(554, 20, 20, 30);
		RightDirectionArrow.setIcon(ICON.RIGHT_ARROW_LAYER_BENEFIT_EXITED);
		RightDirectionArrow.setHorizontalAlignment(SwingConstants.CENTER);
		RightDirectionArrow.setVerticalAlignment(SwingConstants.CENTER);
		RightDirectionArrow.setVisible(true);
		LayerRedirectionPanel.add(RightDirectionArrow);
		
		LeavePage = new JLabel();
		LeavePage.setIcon(null);
		LeavePage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				registerAccount = new LaunchRegister1();
				registerAccount.setVisible(true);
				dispose();
			}
		});
		LeavePage.setBounds(LayerRedirectionPanel.getWidth() + LayerRedirectionPanel.getX(), 20, 100, 30);
		LeavePage.setCursor(new Cursor(Cursor.HAND_CURSOR));
		LeavePage.setText("Registrarme");
		LeavePage.setFont(new Font("Yu Gothic UI", Font.PLAIN, 18));
		LeavePage.setForeground(FOREGROUND.FOREGROUND_COLOR_BBVA_DEFAULT_COLOR);
		LeavePage.setHorizontalAlignment(SwingConstants.CENTER);
		LeavePage.setVerticalAlignment(SwingConstants.TOP);
		FooterContainer.add(LeavePage);
		
		JLabel LeavePageIcon = new JLabel();
		LeavePageIcon.setBounds(LeavePage.getX() + LeavePage.getWidth(), 20, 30, 30);
		LeavePageIcon.setIcon(ICON.LEAVE_PAGE);
		LeavePageIcon.setHorizontalAlignment(SwingConstants.CENTER);
		LeavePageIcon.setVerticalAlignment(SwingConstants.BOTTOM);
		FooterContainer.add(LeavePageIcon);
	}
	
	/**
	 * :::: GETTER AND SETTER METHODS ::::
	 */
	
	private void setLayer(int layer) {
		this.layer = layer;
	}
	
	private int getLayer() {
		return layer;
	}
	
	private void setMoveToRight(boolean move_to_right) {
		this.move_to_right = move_to_right;
	}
	
	private boolean getMoveToRight() {
		return move_to_right;
	}
	
	private void setMoveToLeft(boolean move_to_left) {
		this.move_to_left = move_to_left;
	}
	
	private boolean getMoveToLeft() {
		return move_to_left;
	}
	
	private void setEvent(String event) {
		this.event = event;
	}
	
	private String getEvent() {
		return event;
	}
	
	/*
	 * :::: CONTROLLER METHODS ::::
	 */
	private void setFirstLayerSection() {
		setLayer(0);
		layerButtonEvents();
		
		Illustration.setIcon(ICON.CONTROL_ACCESS_BENEFITS);
		ParagraphRowTop.setText("● Tendras acceso a tu cuenta en cualquier momento");
		ParagraphRowCenter.setText("● Gestiona tu cuenta BBVA Digital desde cualquier computadora");
		ParagraphRowBottom.setText("● No estarás sujeto a horarios bancarios, lo que ofrece una gran comodidad");
	}
	
	private void changeLayerSection() {
		
		if (getMoveToRight() && !getMoveToLeft()) 
		{			
			switch(getLayer()) 
			{
		    	case 0:
		    		setLayer(1);
		    		Illustration.setIcon(ICON.CONTROL_INFORMATION_BENEFITS);
		    		ParagraphRowTop.setText("● La aplicación de escritorio ofrece múltiples capas de seguridad");
		    		ParagraphRowCenter.setText("● Autenticación de dos factores y encriptación de datos");
		    		ParagraphRowBottom.setText("● Tu información financiera estará protegida con BBVA Digital");
		    		break;
		    	case 1:
		    		setLayer(2);
		    		Illustration.setIcon(ICON.CONTROL_DATA_BENEFITS);
		    		ParagraphRowTop.setText("● La app de escritorio proporciona una visión detallada y clara de las cuentas");
		    		ParagraphRowCenter.setText("● Control total sobre saldos, movimientos y límites de gasto");
		    		ParagraphRowBottom.setText("● toda la información que necesitas con total transparencia");
		    		break;
		    	case 2:
		    		setLayer(3);
		    		Illustration.setIcon(ICON.GLOBAL_TRANSFERERS_BENEFITS);
		    		ParagraphRowTop.setText("● Podrás ealizar transferencias internacionales rápidas y sin costos");
		    		ParagraphRowCenter.setText("● No tienes la necesidad de acudir a una sucursal física");
		    		ParagraphRowBottom.setText("● Te facilita mucho el envío de dinero al extranjero");
		    		break;
		    	case 3:
		    		setLayer(4);
		    		Illustration.setIcon(ICON.OPTIMIZED_RESOURCES_BENEFITS);
		    		ParagraphRowTop.setText("● Ahorra tiempo usando nuestra app de escritorio desde cualquier lugar");
		    		ParagraphRowCenter.setText("● No es necesario acudir o contactar al banco, tu eres tu propio banco");
		    		ParagraphRowBottom.setText("● Todo lo que haces un un banco ahora lo podrás hacer en tu computadora");
		    		break;
		    	default:
		    		System.out.print("error inswitch block 1");
			}
		}
		else 
		{
			if (getMoveToLeft() && !getMoveToRight()) 
			{				
				switch(getLayer()) 
				{
			    	case 4:
			    		setLayer(3);
			    		Illustration.setIcon(ICON.GLOBAL_TRANSFERERS_BENEFITS);
			    		ParagraphRowTop.setText("● Podrás ealizar transferencias internacionales rápidas y sin costos");
			    		ParagraphRowCenter.setText("● No tienes la necesidad de acudir a una sucursal física");
			    		ParagraphRowBottom.setText("● Te facilita mucho el envío de dinero al extranjero");
			    		break;
			    	case 3:
			    		setLayer(2);
			    		Illustration.setIcon(ICON.CONTROL_DATA_BENEFITS);
			    		ParagraphRowTop.setText("● La app de escritorio proporciona una visión detallada y clara de las cuentas");
			    		ParagraphRowCenter.setText("● Control total sobre saldos, movimientos y límites de gasto");
			    		ParagraphRowBottom.setText("● toda la información que necesitas con total transparencia");
			    		break;
			    	case 2:
			    		setLayer(1);
			    		Illustration.setIcon(ICON.CONTROL_INFORMATION_BENEFITS);
			    		ParagraphRowTop.setText("● La aplicación de escritorio ofrece múltiples capas de seguridad");
			    		ParagraphRowCenter.setText("● Autenticación de dos factores y encriptación de datos");
			    		ParagraphRowBottom.setText("● Tu información financiera estará protegida con BBVA Digital.");
			    		break;
			    	case 1:
			    		//setLayer(0);
			    		setFirstLayerSection();
			    		break;
			    	default:
			    		System.out.print("error inswitch block 2");
				}
			}
		}
		
		layerButtonEvents();
		visibilityRedirectionArrowEvents();
	}
	
	private void visibilityRedirectionArrowEvents() {
		
		if ((getLayer() > 0) && (getLayer() < 4))
		{
			LeftDirectionArrow.setVisible(true);
			RightDirectionArrow.setVisible(true);
			return;
		}
		
		if (getLayer() == 0)
		{
			LeftDirectionArrow.setVisible(false);
		}
		
		if (getLayer() == 4)
		{
			RightDirectionArrow.setVisible(false);
		}
	}
	
	/**
	 * <p> @see {used for verify if the class was launched from another 
	 * application's site </p>
	 * 
	 * @return True if the class was launched from another class
	 * @return False if the class wasn't launched from another class
	 */
	private boolean isEventEqualsLaunch() {	
		return getEvent().equals("launch");
	}
	
	/**
	 * <p> @see these events is used it when the class wasn't launched
	 * from another class </p>
	 */
	private void applyNotAvailableEvents() {
		final Dialogs NOT_AVAILABLE = new Dialogs(); 
		
		//modify illustration icon
		Illustration.setIcon(ICON.NOT_AVAILABLE_CONTENT);
		
		//modify message to user
		ParagraphRowTop.setText(NOT_AVAILABLE.showPresentationMessage(NOT_AVAILABLE.NOT_AVAILABLE_CONTENT_MESSAGE));
		ParagraphRowTop.setHorizontalAlignment(SwingConstants.CENTER);
		ParagraphRowTop.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		
		//apply changes to redirection arrow
		RightDirectionArrow.setIcon(ICON.RIGHT_ARROW_LAYER_BENEFIT_EXITED);
		LeftDirectionArrow.setIcon(ICON.LEFT_ARROW_LAYER_BENEFIT_EXITED);
	}
	
	/**
	 * @deprecated
	 * @param layer_button
	 * @param initial_position_x
	 */
	private void createLayerButton(LayerButton[] layer_button, int initial_position_x) {
		
		for (int i = 0; i < layer_button.length; i++)
		{
			layer_button[i] = new LayerButton();
			
			//set positionX
			if (i > 0) 
			{
				layer_button[i].setPositionX(initial_position_x = initial_position_x + 70);
			}
			
			//set background Color
			if (isEventEqualsLaunch())
			{
				if (i == 0) 
				{
					layer_button[0].setBackgroundColor(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
				}
				else 
				{
					layer_button[i].setBackgroundColor(BACKGROUND_LAYER_BUTTON);
				}
			}
			else 
			{
				layer_button[i].setBackgroundColor(BACKGROUND_LAYER_BUTTON);
			}
			
			//print button at window
			LayerRedirectionPanel.add(layer_button[i].paintJPanelComponent());
		}
		
		initial_position_x = 200;
	}
	
	private void layerButtonEvents() {
		
		switch(getLayer())
		{
    		case 0:
    			FirstPositionButton.setBackground(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
    			SecondPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
	    		break;
	    	case 1:
    			SecondPositionButton.setBackground(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
	    		FirstPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
	    		ThirdPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
    			break;
	    	case 2:
	    		ThirdPositionButton.setBackground(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
				SecondPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
				FourthPositionLayer.setBackground(BACKGROUND_LAYER_BUTTON);
	    		break;
	    	case 3:
				FourthPositionLayer.setBackground(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
	    		FifthPositionLayer.setBackground(BACKGROUND_LAYER_BUTTON);
	    		ThirdPositionButton.setBackground(BACKGROUND_LAYER_BUTTON);
				break;
	    	case 4:
	    		FifthPositionLayer.setBackground(BACKGROUND.BACKGROUND_COLOR_BBVA_DEFAULT_COLOR);
				FourthPositionLayer.setBackground(BACKGROUND_LAYER_BUTTON);
	    		break;
	    	default:
	    		System.out.print("error in switch block");
		}
	}
	
	private void closeWindowAndInvokeRedirection() {
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		benefitsPage = new BenefitsBBVA();
		benefitsPage.setVisible(true);
		dispose();
	}
}
