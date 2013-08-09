package com.beone.e4.translation.fragment;

import java.text.MessageFormat;

import javax.annotation.PostConstruct;

import org.eclipse.e4.tools.services.Message;

@Message(contributorURI="platform:/fragment/com.beone.e4.translation.fragment")
public class FragmentMessages {

	public String first_label_message;
	public String second_label_message;
	public String third_label_message;
	
	@PostConstruct
	public void format() {
		first_label_message = MessageFormat.format(first_label_message, "OSGi ResourceBundles"); //$NON-NLS-1$
	}
	
}
