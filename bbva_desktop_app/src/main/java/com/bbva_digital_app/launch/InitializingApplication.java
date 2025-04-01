package main.java.com.bbva_digital_app.launch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import main.java.com.bbva_digital_app.access.ClientRedirection;
import main.resources.visual.manager.classes.IconImageManager;

public class InitializingApplication extends JDialog {

	private static final long serialVersionUID = -1103653594620482928L;

	private final JPanel containerWindow = new JPanel();
	private ClientRedirection redirection;
	
	private IconImageManager icon = new IconImageManager();
	private JLabel lbl_banner_logo_company;
	private JLabel lbl_loading_application_message;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws InterruptedException {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			InitializingApplication dialog = new InitializingApplication();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InitializingApplication() throws InterruptedException {
		setUndecorated(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				int delay = 10000; //milliseconds
				Timer time = new Timer();
				time.schedule(new TimerTask() {
					@Override
					public void run() {
						redirectToUser();
					}
				}, delay);
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(InitializingApplication.class.getResource("/main/resources/visual/icons/V2/bbva_logo/favicon.png")));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("BBVA Windows App");
		setResizable(false);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setBounds(330, 100, 712, 520);
		containerWindow.setBackground(new Color(7,33,70));//255,255,255
		getContentPane().add(containerWindow, BorderLayout.CENTER);
		containerWindow.setLayout(null);
			
		lbl_banner_logo_company = new JLabel();
		lbl_banner_logo_company.setBounds(0,0,712,450);
		lbl_banner_logo_company.setIcon(icon.BBVA_LOGO_OFFICIAL_INITIALIZING_APP);
		lbl_banner_logo_company.setHorizontalAlignment(SwingConstants.RIGHT);
		containerWindow.add(lbl_banner_logo_company);
		
		lbl_loading_application_message = new JLabel();
		lbl_loading_application_message.setVerticalAlignment(SwingConstants.TOP);
		lbl_loading_application_message.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_loading_application_message.setText("Cargando aplicación . . .");
		lbl_loading_application_message.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lbl_loading_application_message.setForeground(new Color(255,255,255));
		lbl_loading_application_message.setBounds(0,465,712,40);
		containerWindow.add(lbl_loading_application_message);
		
	}
	
	private void redirectToUser() {
        redirection = new ClientRedirection();
        redirection.setVisible(true);
		dispose();
	}
}
