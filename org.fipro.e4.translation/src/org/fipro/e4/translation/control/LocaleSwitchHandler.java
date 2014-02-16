 
package org.fipro.e4.translation.control;

import javax.inject.Named;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.core.services.translation.TranslationService;

public class LocaleSwitchHandler {
	@Execute
	public void execute(ILocaleChangeService lcs, @Named(TranslationService.LOCALE) String locale) {
		String input = (locale != null && locale.equals("de")) ? "en" : "de";   //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
		lcs.changeApplicationLocale(input);
	}
		
}