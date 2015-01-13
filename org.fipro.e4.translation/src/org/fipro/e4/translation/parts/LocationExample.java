package org.fipro.e4.translation.parts;

import javax.inject.Inject;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.fipro.e4.translation.registry.LocationMessageRegistry;

/**
 * Example showing the usage of the new message extension by using 
 * ResourceBundles located in the same plugin at a different location.
 */
public class LocationExample {
	
	@Inject
	LocationMessageRegistry registry;

	@Inject
	public LocationExample(Composite parent) {
		Label myFirstLabel = new Label(parent, SWT.WRAP);
		Label mySecondLabel = new Label(parent, SWT.NONE);
		Label myThirdLabel = new Label(parent, SWT.NONE);

		// bind myFirstLabel via method reference
		registry.register(myFirstLabel::setText, (m) -> m.first_label_message);
		// bind mySecondLabel via method name
		registry.register(mySecondLabel, "setText", "second_label_message");
		// bind myThirdLabel via property name
		registry.registerProperty(myThirdLabel, "text", "third_label_message");
	}
}