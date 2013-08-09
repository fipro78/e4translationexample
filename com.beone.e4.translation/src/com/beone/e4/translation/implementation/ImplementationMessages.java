package com.beone.e4.translation.implementation;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

import org.eclipse.e4.tools.services.Message;

@Message(contributorURI="bundleclass://com.beone.e4.translation/com.beone.e4.translation.resources.MockBundle")
public class ImplementationMessages {

	public String first_label_message;
	public String second_label_message;
	public String third_label_message;
	
	@PostConstruct
	public void format() {
		first_label_message = MessageFormat.format(first_label_message, "Class Based ResourceBundles"); //$NON-NLS-1$
	}

}
