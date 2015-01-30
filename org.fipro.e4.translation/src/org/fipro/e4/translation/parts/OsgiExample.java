package org.fipro.e4.translation.parts;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.fipro.e4.translation.registry.OsgiMessageRegistry;

/**
 * Example showing the usage of the new message extension by using 
 * OSGi ResourceBundles configured in the MANIFEST.MF
 */
public class OsgiExample {

	@Inject
	OsgiMessageRegistry registry;

	@PostConstruct
	public void init(Composite parent) {
		Label myFirstLabel = new Label(parent, SWT.WRAP);
		Label mySecondLabel = new Label(parent, SWT.NONE);
		Label myThirdLabel = new Label(parent, SWT.NONE);
		
		// bind myFirstLabel via method reference
		registry.register(myFirstLabel::setText, (m) -> m.firstLabelMessage);
		// bind mySecondLabel via method name
		registry.register(mySecondLabel, "setText", "secondLabelMessage");
		// bind myThirdLabel via property name
		registry.registerProperty(myThirdLabel, "text", "third_label_message");
	}
	
	@Inject
	@Optional
	private void getNotifiedByInjection(@Named(TranslationService.LOCALE) Locale s) {
		System.out.println("Injected via context: " + s);
	} 
	
	@Inject
	@Optional
	private void getNotifiedByEvent(@UIEventTopic(ILocaleChangeService.LOCALE_CHANGE) Locale s) {
		System.out.println("Injected via event broker: " + s);
	} 
}