package com.beone.e4.translation.location;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.nls.Message;

@Message(contributorURI="platform:/plugin/com.beone.e4.translation/resources/another")
public class LocationMessages {

	public String first_label_message;
	public String second_label_message;
	public String third_label_message;
	
	public String part_title;
	
	@PostConstruct
	public void format() {
		first_label_message = MessageFormat.format(first_label_message, "Plugin ResourceBundles"); //$NON-NLS-1$
	}
}
