package org.fipro.e4.translation.parts;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.fipro.e4.translation.registry.MessageRegistry;
import org.fipro.e4.translation.registry.NamedMessageRegistry;

/**
 * Example showing the usage of the new message extension by using 
 * a ResourceBundle that is named and located like the messages class.
 * <p>
 * This example also shows how to implement the <i>Eclipse translation 
 * pattern</i> when creating the UI in the method annotated with
 * <code>@PostConstruct</code>
 */
public class NamedExample {
	
	@Inject
	NamedMessageRegistry registry;

	@Inject
	MessageRegistry mRegistry;

	@PostConstruct
	public void postConstruct(Composite parent) {
		Label myFirstLabel = new Label(parent, SWT.WRAP);
		Label mySecondLabel = new Label(parent, SWT.NONE);
		Label myThirdLabel = new Label(parent, SWT.NONE);
		
		Label myCustomLabel = new Label(parent, SWT.NONE);
		
		// bind myFirstLabel via method reference
		registry.register(myFirstLabel::setText, (m) -> m.first_label_message);
		// bind mySecondLabel via method name
		registry.register(mySecondLabel, "setText", "second_label_message");
		// bind myThirdLabel via property name
		registry.registerProperty(myThirdLabel, "text", "third_label_message");

		mRegistry.register(myCustomLabel::setText, (m) -> m.customMessage);
	}
	
}