package main.resources.visual.swingcomponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {

	private static final long serialVersionUID = -2711565966797049997L;
	private int cornerRadius;
    /** Stroke size. it is recommended to set it to 1 for better view */
    protected int strokeSize = 1;
    /** Color of shadow */
    private Color BackgroundColor;
    //private Color ForegroundColor;
    /** Sets if it drops shadow */
    protected boolean shady = true;
    /** Sets if it has an High Quality view */
    protected boolean highQuality = true;
    
    /** Distance between shadow border and opaque panel border */
    protected int shadowGap = 10;
    /** The offset of shadow.  */
    protected int shadowOffset = 5;
    /** The transparency value of shadow. ( 0 - 255) */
    protected int shadowAlpha = 150;

	//FOLLOWING CODES GOES HERE
    public RoundedPanel() {
        super();
        setOpaque(false);
    }
    
    public void setCornerRadius(int cornerRadius) {
    	this.cornerRadius = cornerRadius;
    }
    
    public void setBackgroundColor(Color BackgroundColor) {
    	this.BackgroundColor = BackgroundColor;
    }
    
    public int getCornerRadius() {
    	return cornerRadius;
    }
    
    public Color getBackgroundColor() {
    	return BackgroundColor;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        //int shadowGap = this.shadowGap;
        Dimension arcs = new Dimension(cornerRadius,cornerRadius);
  
        Graphics2D graphics = (Graphics2D) g;
        
        if(BackgroundColor != null) {
        	graphics.setColor(BackgroundColor);
        }else {
        	graphics.setColor(getBackground());
        }

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
       if (shady) {
            graphics.setBackground(getBackground());
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        /*graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap,
        height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
        height - shadowGap, arcs.width, arcs.height);*/

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
}

/*
 *package VisualConstructor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
	
	variables of the JPanel
	private Color BackgroundColor;
	private int cornerRadius    = 15;
	
	variables of the JPanel border painted
	private boolean paintBorder = true;
	private boolean borderPaintedSet = false;
	
	public static final String BORDER_PAINTED_CHANGED_PROPERTY = "borderPainted";
	
	public RoundedPanel(LayoutManager layout, int cornerRadius) {
		super(layout);
		this.cornerRadius = cornerRadius;
	}
	
	public RoundedPanel(LayoutManager layout, int cornerRadius, Color BackgroundColor) {
		super(layout);
		this.cornerRadius = cornerRadius;
		this.BackgroundColor = BackgroundColor;
	}
	
	public RoundedPanel(int cornerRadius) {
		this.cornerRadius = cornerRadius;
	}
	
	public RoundedPanel(int cornerRadius, Color BackgroundColor) {
		this.cornerRadius = cornerRadius;
		this.BackgroundColor = BackgroundColor;
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Dimension arcs = new Dimension(cornerRadius, cornerRadius);
		int width = getWidth();
		int height = getHeight();
		Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Draws the rounded panel with borders.
        if(BackgroundColor != null) {
        	graphics.setColor(BackgroundColor);
        }else {
        	graphics.setColor(getBackground());
        }
        
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);
	}
	
	public boolean isBorderPainted() {
		return paintBorder;
	}
	
	public void setBorderPainted(boolean paintBorder) {
		boolean oldValue = paintBorder;
		this.paintBorder = paintBorder;
		borderPaintedSet = true;
		firePropertyChange(BORDER_PAINTED_CHANGED_PROPERTY, oldValue, paintBorder);
		if(paintBorder != oldValue) {
			revalidate();
			repaint();
		}
	}
	
	protected void paintBorder(Graphics g) {
		if(isBorderPainted()) {
			super.paintBorder(g);
		}
	}
}
 
 ***/
 