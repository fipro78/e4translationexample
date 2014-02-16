package com.beone.e4.translation.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.beone.e4.translation.LocalizationHelper;
import com.beone.e4.translation.named.Messages;
import com.beone.e4.translation.named.NamedMessages;

/**
 * Example showing the usage of the new message extension by using 
 * a ResourceBundle that is named and located like the messages class.
 * <p>
 * This example also shows how to implement the <i>Eclipse translation 
 * pattern</i> when creating the UI in the method annotated with
 * <code>@PostConstruct</code>
 */
public class NamedExample {
	
	//the labels that will be localized
	private Label myFirstLabel;
	private Label mySecondLabel;
	private Label myThirdLabel;
	
	private Label myCustomLabel;

	@PostConstruct
	public void postConstruct(Composite parent, @Translation NamedMessages messages, @Translation Messages m) {
		myFirstLabel = new Label(parent, SWT.WRAP);
		mySecondLabel = new Label(parent, SWT.NONE);
		myThirdLabel = new Label(parent, SWT.NONE);
		
		myCustomLabel = new Label(parent, SWT.NONE);
		
		//As the method annotated with @PostConstruct is created after method
		//injection, the translate() method won't be called automatically
		//here. This would result in an empty UI. So we need to call the
		//translate() method here manually to make everything work as intended.
		translate(messages, m);
	}
	
	//the method that will perform the dynamic locale changes
	@Inject
	public void translate(@Translation NamedMessages messages, @Translation Messages m) {
		LocalizationHelper.updateLabelText(
				myFirstLabel, messages.first_label_message);
		LocalizationHelper.updateLabelText(
				mySecondLabel, messages.second_label_message);
		LocalizationHelper.updateLabelText(
				myThirdLabel, messages.third_label_message);

		LocalizationHelper.updateLabelText(
				myCustomLabel, m.customMessage);
	}
	
	@Focus
	public void onFocus() {
		if (myFirstLabel != null) {
			myFirstLabel.setFocus();
		}
	}
}