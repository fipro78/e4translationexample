 
package org.fipro.e4.translation.handlers;

import java.util.Locale;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.translation.TranslationService;

public class LocaleSwitchHandler {
	@Execute
	public void execute(ILocaleChangeService lcs, @Named(TranslationService.LOCALE) Locale locale) {
		Locale input = (locale != null && locale.equals(Locale.GERMAN)) ? Locale.ENGLISH : Locale.GERMAN; 
		lcs.changeApplicationLocale(input);
	}

	@CanExecute
	public boolean canExecute() {
		return true;
	}
}