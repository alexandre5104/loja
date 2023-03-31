package com.faxb.helpers;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;

public class MessagesHelper {

	@Inject
	private FacesContext facesContext;
	
	public void addFlash(FacesMessage facesMessage) {
		facesContext.getExternalContext()
			.getFlash()
				.setKeepMessages(true);
		facesContext
			.addMessage(null, facesMessage);
	}

}
