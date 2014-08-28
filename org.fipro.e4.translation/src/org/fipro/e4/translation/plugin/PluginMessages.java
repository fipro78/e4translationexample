package org.fipro.e4.translation.plugin;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

import org.eclipse.e4.core.services.nls.Message;

@Message(contributionURI="platform:/plugin/org.fipro.e4.translation.extension")
public class PluginMessages {

	public String first_label_message;
	public String second_label_message;
	public String third_label_message;
	
	@PostConstruct
	public void format() {
		first_label_message = MessageFormat.format(first_label_message, "OSGi ResourceBundles"); //$NON-NLS-1$
	}

}
