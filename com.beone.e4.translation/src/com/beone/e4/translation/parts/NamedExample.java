package com.beone.e4.translation.parts;

import javax.inject.Inject;

import org.eclipse.e4.tools.services.Translation;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.beone.e4.translation.LocalizationHelper;
import com.beone.e4.translation.named.NamedMessages;

/**
 * 
 */
public class NamedExample {
	
	//the labels that will be localized
	private Label myFirstLabel;
	private Label mySecondLabel;
	private Label myThirdLabel;

	//create the label instances in the constructor because
	//the method injection is executed before @PostConstruct
	@Inject
	public NamedExample(Composite parent) {
		myFirstLabel = new Label(parent, SWT.NONE);
		mySecondLabel = new Label(parent, SWT.NONE);
		myThirdLabel = new Label(parent, SWT.NONE);
	}
	
	//the method that will perform the dynamic locale changes
	@Inject
	public void translate(@Translation NamedMessages messages) {
		LocalizationHelper.updateLabelText(
				myFirstLabel, messages.first_label_message);
		LocalizationHelper.updateLabelText(
				mySecondLabel, messages.second_label_message);
		LocalizationHelper.updateLabelText(
				myThirdLabel, messages.third_label_message);
	}
	
	@Focus
	public void onFocus() {
		if (myFirstLabel != null) {
			myFirstLabel.setFocus();
		}
	}
}