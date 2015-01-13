package org.fipro.e4.translation.registry;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.nls.BaseMessageRegistry;
import org.eclipse.e4.core.services.nls.Translation;
import org.fipro.e4.translation.osgi.OsgiMessages;

@Creatable
public class OsgiMessageRegistry extends BaseMessageRegistry<OsgiMessages> {

	@Override
	@Inject
	public void updateMessages(@Translation OsgiMessages messages) {
		super.updateMessages(messages);
	}
}
