package org.fipro.e4.translation;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.IWorkbench;
import org.eclipse.e4.ui.workbench.UIEvents;
import org.eclipse.e4.ui.workbench.modeling.EPartService;
import org.eclipse.e4.ui.workbench.modeling.IWindowCloseHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.event.Event;

// @PostConstruct will not work as workbench gets instantiated after the processing of the add-ons
// hence this approach uses method injection

public class WindowCloseListenerAddon {

	@Inject
	MApplication application;
	
	@Inject
	EPartService partService;
	
	// as the IWorkbench is not available at creation time, we need to annotate it with
	// @Optional so it gets reinjected once it is created
	
	@Inject
	@Optional
	IWorkbench workbench;
	
	// while initializing a class, all annotated methods are sequentially called
	// therefore we need to annotate the following methods with @Optional as the
	// events are not present at the creation time of this add-on instance
	
	@Inject
	@Optional
	private void subscribeApplicationCompleted(@UIEventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) Event event) {
		if (workbench != null ){
			registerCloseHandler(application);
		}
	}
	
	@Inject
	@Optional
	private void subscribeTopicChildrenChanged(@UIEventTopic(UIEvents.ElementContainer.TOPIC_CHILDREN) Event event) {
		Object changedObj = event.getProperty(UIEvents.EventTags.ELEMENT);
		
		// only interested in changes to application
		if (changedObj instanceof MApplication) {
			MApplication application = (MApplication) changedObj;
			if (workbench != null ) {
				registerCloseHandler(application);
			}
		}
	}

	private void registerCloseHandler(MApplication application) {
		
		// each window gets its own close handler as we want to add a modal confirm dialog
		for (MWindow window : application.getChildren()) {

			final Shell shell = (Shell) window.getWidget();
			
			IWindowCloseHandler closeHandler = new IWindowCloseHandler() {

				@Override
				public boolean close(MWindow window) {
					boolean close = true;
					if (partService.getDirtyParts().size() > 0) {
						close = MessageDialog.openConfirm(shell, "Unsaved data", "Really close?");
					}
					if (close) {
						workbench.close();
					}
					return close;
				}
			};
			
			window.getContext().set(IWindowCloseHandler.class, closeHandler);
		}
	}
}