package main.resources.visual.swingcomponents;

import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextField;

public class RoundedJTextField extends JTextField {
	
	private static final long serialVersionUID = 7379739482786720485L;
	private Shape shape;
	
	public RoundedJTextField(int size) {
		super(size);
		setOpaque(false);
	}
	
	public RoundedJTextField(double size) {
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

/*public class RoundedJTextField extends JTextField {
	
	private int cornerRadius;
    // Stroke size. it is recommended to set it to 1 for better view 
    protected int strokeSize = 1;
    // Color of shadow 
    private Color BackgroundColor;
    // Sets if it drops shadow 
    protected boolean shady = true;
    // Sets if it has an High Quality view 
    protected boolean highQuality = true;
    
    // Distance between shadow border and opaque panel border 
    protected int shadowGap = 10;
    // The offset of shadow.  
    protected int shadowOffset = 5;
    // The transparency value of shadow. ( 0 - 255) 
    protected int shadowAlpha = 150;
    
    public RoundedJTextField() {
    	super();
    	setOpaque(true);
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
    	int shadowGap = this.shadowGap;
    	Dimension arcs = new Dimension(cornerRadius,cornerRadius);
    	
    	Graphics2D graphics = (Graphics2D) g;
    	
    	if(BackgroundColor != null) {
    		graphics.setColor(BackgroundColor);
    	}else {
    		graphics.setColor(getBackground());
    	}
    	
    	if(highQuality) {
    		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
    	            RenderingHints.VALUE_ANTIALIAS_ON);
    	}
    	
    	if(shady) {
    		graphics.setBackground(getBackground());
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
    	}else {
    		shadowGap = 1;
    	}
    	
    	//Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
}*/
