package org.fipro.e4.translation.parts;

import java.util.Locale;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.fipro.e4.translation.LocalizationHelper;
import org.fipro.e4.translation.osgi.OsgiMessages;

/**
 * Example showing the usage of the new message extension by using 
 * OSGi ResourceBundles configured in the MANIFEST.MF
 */
public class OsgiExample {

	//the labels that will be localized
	private Label myFirstLabel;
	private Label mySecondLabel;
	private Label myThirdLabel;

	//create the label instances in the constructor because
	//the method injection is executed before @PostConstruct
	@Inject
	public OsgiExample(Composite parent, IEclipseContext context) {
		myFirstLabel = new Label(parent, SWT.WRAP);
		mySecondLabel = new Label(parent, SWT.NONE);
		myThirdLabel = new Label(parent, SWT.NONE);
	}
	
	//the method that will perform the dynamic locale changes
	@Inject
	public void translate(@Translation OsgiMessages messages) {
		LocalizationHelper.updateLabelText(
				myFirstLabel, messages.firstLabelMessage);
		LocalizationHelper.updateLabelText(
				mySecondLabel, messages.secondLabelMessage);
		LocalizationHelper.updateLabelText(
				myThirdLabel, messages.third_label_message);
	}
	
	@Focus
	public void onFocus() {
		if (myFirstLabel != null) {
			myFirstLabel.setFocus();
		}
	}
	
	@Inject
	@Optional
	private void getNotified(@Named(TranslationService.LOCALE) String s) {
		System.out.println("Injected via context: " + s);
	} 
	
	@Inject
	@Optional
	private void getNotified(@UIEventTopic(ILocaleChangeService.LOCALE_CHANGE) Locale s) {
		System.out.println("Injected via event broker: " + s);
	} 
}