 
package org.fipro.e4.translation.parts;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.fipro.e4.translation.LocalizationHelper;
import org.fipro.e4.translation.implementation.ImplementationMessages;

public class ImplementationExample {
	
	private Label myFirstLabel;
	private Label mySecondLabel;
	private Label myThirdLabel;

	@Inject
	public ImplementationExample(Composite parent) {
		myFirstLabel = new Label(parent, SWT.WRAP);
		mySecondLabel = new Label(parent, SWT.NONE);
		myThirdLabel = new Label(parent, SWT.NONE);
	}
	
	@Inject
	public void translate(@Translation ImplementationMessages messages) {
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