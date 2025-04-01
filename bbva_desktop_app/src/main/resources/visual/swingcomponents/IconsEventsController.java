package main.resources.visual.swingcomponents;

import main.java.com.bbva_digital_app.access.LoginApplication;

public class IconsEventsController extends LoginApplication {
	
	private static final long serialVersionUID = 1L;
	
	//initially we don't see our password
	private boolean status_visibility_password = false;
	//private Administrator icon;
	
	public IconsEventsController() {
		//empty constructor
	}
	
	public void setPasswordVisible(boolean status_visibility_password) {
		this.status_visibility_password = status_visibility_password;
	}
	
	public boolean isPasswordVisible() {
		return status_visibility_password;
	}
	
	/*public void setIconPasswordVisbility(Administrator icon) {
		this.icon = icon;
	}
	
	public Icon setIconPasswordVisbility() {
		return icon;
	}*/
}
