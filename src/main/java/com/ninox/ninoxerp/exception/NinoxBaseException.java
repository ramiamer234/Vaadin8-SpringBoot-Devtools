package com.ninox.ninoxerp.exception;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class NinoxBaseException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	private String errorCoded = "SYSTEM_ERROR";
	
	public NinoxBaseException() {
		super();
	}
	
	public NinoxBaseException(String errorCode) {
		this.errorCoded = errorCode;
		Label lblNotification = (Label) UI.getCurrent().getSession().getAttribute("lblNotification");
		if(lblNotification != null) {
			lblNotification.setIcon(new ThemeResource(""));
			lblNotification.setCaption(errorCode);
		}
	}
	
	public String getErrorCode() {
		return errorCoded;
	}

}
