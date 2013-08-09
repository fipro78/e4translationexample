package com.beone.e4.translation.control;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.e4.core.services.translation.TranslationService;
import org.eclipse.e4.tools.services.Translation;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import com.beone.e4.translation.LocalizationHelper;
import com.beone.e4.translation.osgi.OsgiMessages;

/**
 * Item that is added as a ToolControl to the TrimBar of the
 * Window. Shows an input field which allows to enter a
 * locale String and a Button to send the action to update
 * the Locale.
 */
public class LocaleChangeItem {

	Button button;
	
	@Inject
	public LocaleChangeItem(
			Composite parent, final MApplication mApplication) {
		
		final Text input = new Text(parent, SWT.BORDER);
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == 13) {
					updateLocale(
							mApplication.getContext().getParent(),
							input.getText());
				}
			}
		});
	
		button = new Button(parent, SWT.PUSH);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				updateLocale(
						mApplication.getContext().getParent(),
						input.getText());
			};
		});
	}

	/**
	 * Set the new locale String to the OSGi context.
	 * @param context The OSGi context to set the locale 
	 * 			String to. This is the parent of the
	 * 			application context. 
	 * @param input The new locale String to set.
	 */
	private void updateLocale( 
			IEclipseContext context, String input) {
		
		context.set(TranslationService.LOCALE, input);
	}
	
	@Inject
	public void translate(@Translation OsgiMessages messages) {
		LocalizationHelper.updateButtonText(
				button, messages.button_change_locale);
	}
}
