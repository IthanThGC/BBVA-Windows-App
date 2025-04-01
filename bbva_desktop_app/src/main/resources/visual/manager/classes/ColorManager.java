package main.resources.visual.manager.classes;

import java.awt.Color;

public class ColorManager {
	
	private Color clr;
	
	public final Color PRIMARY_COLOR_FONT_TEXT_WHITE = new Color(255,255,255);
	public final Color PRIMARY_COLOR_FONT_TEXT_BLACK = new Color(0,0,0);
	
	public final Color PLACEHOLDER_COLOR_FONT_TEXT_GRAY = Color.GRAY;
	
	public final Color BACKGROUND_COLOR_BBVA_OFFICIAL = new Color(7,33,70);
	public final Color BACKGROUND_LIGHT_COLOR_BBVA_OFFICIAL = new Color(245,249,255);
	
	public final Color FOREGROUND_COLOR_BBVA_DEFAULT_COLOR = new Color(5,51,101);
	public final Color BACKGROUND_COLOR_BBVA_DEFAULT_COLOR = new Color(5,51,101);
	
	public ColorManager() {
		this.clr = null;
	}
	
	public Color getTextColor() {
		return clr;
	}
}
