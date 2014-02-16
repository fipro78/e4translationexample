package org.fipro.e4.translation.control;

import javax.inject.Inject;

import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.nls.Translation;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.fipro.e4.translation.LocalizationHelper;
import org.fipro.e4.translation.osgi.OsgiMessages;

/**
 * Item that is added as a ToolControl to the TrimBar of the
 * Window. Shows an input field which allows to enter a
 * locale String and a Button to send the action to update
 * the Locale.
 */
public class LocaleChangeItem {

	Button button;
	
	@Inject
	ILocaleChangeService lcs;
	
	@Inject
	public LocaleChangeItem(Composite parent) {
		
		final Text input = new Text(parent, SWT.BORDER);
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					lcs.changeApplicationLocale(input.getText());
				}
			}
		});
	
		button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				lcs.changeApplicationLocale(input.getText());
			};
		});
	}

	@Inject
	public void translate(@Translation OsgiMessages messages) {
		LocalizationHelper.updateButtonText(button, messages.button_change_locale);
	}
}
