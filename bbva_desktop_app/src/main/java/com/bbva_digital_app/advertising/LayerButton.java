package main.java.com.bbva_digital_app.advertising;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.resources.visual.swingcomponents.RoundedPanel;

public class LayerButton extends JPanel {
	
	private static final long serialVersionUID = 4735359284665422449L;
	
	private  JPanel buttonLayer = new JPanel();
	
	//bounds
	private int positionX = 200;
	private static final int positionY = 25;
	private static final int width = 40;
	private static final int height = 20;
	
	//visibility
	//private boolean visibility = false;
	
	//color
	private Color background_layer_button = null;
	
	/**
	 * <strong>getter and setter methods</strong>
	 * @param positionX
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public void setBackgroundColor(Color background_layer_button) {
		this.background_layer_button = background_layer_button;
	}
	
	private Color getBackgroundColor() {
		return background_layer_button;
	}
	
	public LayerButton() {
		super();
		setOpaque(false);
	}

	/**
	 * @see Build the layer button
	 * @return JPabel 
	 */
		
	public JPanel paintJPanelComponent() {
		buttonLayer = new RoundedPanel();
		buttonLayer.setBounds(getPositionX(), positionY, width, height);
		((RoundedPanel) buttonLayer).setCornerRadius(15);
		buttonLayer.setBackground(getBackgroundColor());
		buttonLayer.setLayout(null);
		return buttonLayer;
	}
	
	public void getProperties() {
		 JOptionPane.showMessageDialog(null, 
				"Bounds: \n\tPositionX: "+getPositionX()+"\n\tPositionY: "+positionY+"\n\tWidth: "+width+"\n\tHeight: "+height
				+"\nBackgroundColor: "+getBackgroundColor()
				+"\nVisible: "+isVisible()+"\n\n",
				"", JOptionPane.INFORMATION_MESSAGE);
	}
}
