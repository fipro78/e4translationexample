package org.fipro.e4.translation.registry;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.nls.BaseMessageRegistry;
import org.eclipse.e4.core.services.nls.Translation;
import org.fipro.e4.translation.implementation.ImplementationMessages;

@Creatable
public class ImplementationMessageRegistry extends BaseMessageRegistry<ImplementationMessages> {

	@Override
	@Inject
	public void updateMessages(@Translation ImplementationMessages messages) {
		super.updateMessages(messages);
	}
}
