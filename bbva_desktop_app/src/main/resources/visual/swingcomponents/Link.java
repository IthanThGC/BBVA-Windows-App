package main.resources.visual.swingcomponents;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Link extends JFrame {
	
	private static final long serialVersionUID = -506218233201107626L;
	private String textLink = "";
	private String link = null;
	private URI uri;
	
	public Link(String link) {
		try {
			uri = new URI((String) link);
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * =========================
	 * SETTER AND GETTER METHODS
	 * =========================
	 * */
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public String getLink() {
		return link;
	}
	
	public void setTextLink(String textLink) {
		this.textLink = textLink;
	}
	
	public String getTextLink() {
		return textLink;
	}
	
	private URI getURI() {
		return uri;
	}
	
	/*
	 * =========================
	 * CONTROLLER METHODS
	 * =========================
	 * */
	
	public void openWebSite() throws URISyntaxException {
		if(Desktop.isDesktopSupported()) {
			Desktop desktop = Desktop.getDesktop();
			try {
				desktop.browse(getURI());
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else {
			JOptionPane.showMessageDialog(null,"Error\n\nLo sentimos pero ocurrio una falla en el sistema,\npor el momento no podemos procesar su solicitur.\n\n",
					"Falla interna", JOptionPane.ERROR_MESSAGE);
		}
	}
}
