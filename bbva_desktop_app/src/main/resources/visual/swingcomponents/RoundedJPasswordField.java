package main.resources.visual.swingcomponents;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JPasswordField;

public class RoundedJPasswordField extends JPasswordField {
	
   private static final long serialVersionUID = 4496261558497308584L;
	private Shape shape;
	
	public RoundedJPasswordField(int size) {
		super(size);
		setOpaque(false);
	}
	
	public RoundedJPasswordField(double size) {
		super();
		setOpaque(false);
	}
	
	public void painComponent(Graphics g) {
		g.setColor(getBackground());
		g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
		super.paintComponent(g);
	}
	
	public void paintBorder(Graphics g) {
		g.setColor(getForeground());
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
	}
	
	public boolean contains(int x, int y) {
		if((shape == null) || (!shape.getBounds().equals(getBounds()))) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 15, 15);
		}
		
		return shape.contains(x, y);
	}
}
