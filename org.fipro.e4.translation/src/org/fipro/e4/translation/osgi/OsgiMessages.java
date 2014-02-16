package org.fipro.e4.translation.osgi;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

public class OsgiMessages {

	public String firstLabelMessage;
	public String secondLabelMessage;
	public String third_label_message;
	public String button_change_locale;
	
	@PostConstruct
	public void format() {
		firstLabelMessage = MessageFormat.format(firstLabelMessage, "OSGi ResourceBundles"); //$NON-NLS-1$
	}
}
