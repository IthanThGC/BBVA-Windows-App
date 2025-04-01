package main.resources.visual.manager.classes;

import java.awt.Font;

import javax.swing.JOptionPane;

public class FontManager {
	private Font font;
		
	public final Font YU_GOTHIC_UI_SEMILIGHT_PLAIN_SZ18 = new Font("Yu Gothic UI Semilight",Font.PLAIN,18);
    public final Font NIRMALA_UI_BOLD_SZ26 = new Font("Nirmala UI",Font.BOLD,26);
    
    public final Font PLACEHOLDER_STANDARD = new Font("Nirmala UI", Font.PLAIN, 16);
    public final Font TEXTFIELD_STANDARD = new Font("Yu Gothic UI Semilight", Font.PLAIN, 17);
	
    public FontManager() {
    	this.font = null;
    }
    
    public void setFont(Font font) {
    	if (font.toString().equals(YU_GOTHIC_UI_SEMILIGHT_PLAIN_SZ18.toString()))
    	{
    		this.font = YU_GOTHIC_UI_SEMILIGHT_PLAIN_SZ18;
    	}
    	else if (font.toString().equals(NIRMALA_UI_BOLD_SZ26.toString()))
    	{
    		this.font = NIRMALA_UI_BOLD_SZ26;
    	}
    }
    
    public Font getFont() {
    	return font;
    }
  
	public Font getFont(Font font) {
		
		switch(font.toString())
		{
	    	case "YU_GOTHIC_UI_SEMILIGHT_PLAIN_SZ18":
	    		this.font = YU_GOTHIC_UI_SEMILIGHT_PLAIN_SZ18;
	    		break;
	    	case "NIRMALA_UI_BOLD_SZ26":
	    		this.font = NIRMALA_UI_BOLD_SZ26;
	    		break;
	    	case "PLACEHOLDER_STANDARD":
	    		this.font = PLACEHOLDER_STANDARD;
	    		break;
	    	case "TEXTFIELD_STANDARD":
	    		this.font = TEXTFIELD_STANDARD;
	    		break;
		}
		
		return font;
	}
	
	public void showPopupWarningMessage(Font font) {
		JOptionPane.showInternalOptionDialog(
				null, 
				"La fuente '"+font+"'\nno se encontro en el repisitorio.\n\n"
						+ "Revise que este escrito correctamente o intene con otra fuente.\n\n",
				"FontManager error",
				JOptionPane.YES_OPTION, 0, null, new Object[] {"Entendido"}, "Entendido");
	}
}
