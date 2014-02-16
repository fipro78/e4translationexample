package com.beone.e4.translation.parts;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.model.application.ui.basic.MPart;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.beone.e4.translation.LocalizationHelper;
import com.beone.e4.translation.location.LocationMessages;

/**
 * Example showing the usage of the new message extension by using 
 * ResourceBundles located in the same plugin at a different location.
 */
public class LocationExample {
	
	private Label myFirstLabel;
	private Label mySecondLabel;
	private Label myThirdLabel;

	@Inject
	public LocationExample(Composite parent) {
		myFirstLabel = new Label(parent, SWT.WRAP);
		mySecondLabel = new Label(parent, SWT.NONE);
		myThirdLabel = new Label(parent, SWT.NONE);
	}
	
	@Inject
	public void translate(@Translation LocationMessages messages, MPart part) {
		LocalizationHelper.updateLabelText(myFirstLabel, messages.first_label_message);
		LocalizationHelper.updateLabelText(mySecondLabel, messages.second_label_message);
		LocalizationHelper.updateLabelText(myThirdLabel, messages.third_label_message);
	}
	
	@Focus
	public void onFocus() {
		if (myFirstLabel != null) {
			myFirstLabel.setFocus();
		}
	}

}