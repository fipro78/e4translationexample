package org.fipro.e4.translation.control;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.fipro.e4.translation.registry.OsgiMessageRegistry;

/**
 * Item that is added as a ToolControl to the TrimBar of the
 * Window. Shows an input field which allows to enter a
 * locale String and a Button to send the action to update
 * the Locale.
 */
public class LocaleChangeItem {

	@Inject
	ILocaleChangeService lcs;

	@PostConstruct
	public void postConstruct(Composite parent, OsgiMessageRegistry registry) {
		
		final Text input = new Text(parent, SWT.BORDER);
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent event) {
				if (event.keyCode == SWT.CR
						|| event.keyCode == SWT.KEYPAD_CR) {
					lcs.changeApplicationLocale(input.getText());
				}
			}
		});
	
		Button button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lcs.changeApplicationLocale(input.getText());
			};
		});
		
		registry.register(button::setText, (m) -> m.buttonChangeLocale);
	}
}
