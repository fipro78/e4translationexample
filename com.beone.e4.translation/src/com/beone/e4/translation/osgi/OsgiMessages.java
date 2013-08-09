package com.beone.e4.translation.osgi;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

public class OsgiMessages {

	public String first_label_message;
	public String second_label_message;
	public String third_label_message;
	public String button_change_locale;
	
	@PostConstruct
	public void format() {
		first_label_message = MessageFormat.format(first_label_message, "OSGi ResourceBundles"); //$NON-NLS-1$
	}
}
