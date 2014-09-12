package org.fipro.e4.translation;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.events.IEventBroker;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.IWindowCloseHandler;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

/**
 * Addon which registers an IWindowCloseHandler that closes all windows of the application.
 */
public class WindowCloseListenerAddon {

	@Inject
	@Optional
	void registerWindowCloseListener(
			final IEventBroker eventBroker, final MApplication application, final IWorkbench workbench) {
		final IWindowCloseHandler closeHandler = new IWindowCloseHandler() {

			@Override
			public boolean close(MWindow window) {
				if (workbench != null) {
					workbench.close();
				}
				return true;
			}
		};

		eventBroker.subscribe(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE, new EventHandler() {
			
			@Override
			public void handleEvent(Event event) {
				for (MWindow window : application.getChildren()) {
					window.getContext().set(IWindowCloseHandler.class, closeHandler);
				}
			}
		});
	}
}
