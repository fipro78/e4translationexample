package org.fipro.e4.translation.registry;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.core.services.nls.BaseMessageRegistry;
import org.eclipse.e4.core.services.nls.Translation;
import org.fipro.e4.translation.location.LocationMessages;

@Creatable
public class LocationMessageRegistry extends BaseMessageRegistry<LocationMessages> {

	@Override
	@Inject
	public void updateMessages(@Translation LocationMessages messages) {
		super.updateMessages(messages);
	}
}
