 
package org.fipro.e4.translation.parts;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.core.services.nls.ILocaleChangeService;
import org.eclipse.e4.ui.di.UIEventTopic;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.MUIElement;
import org.eclipse.e4.ui.model.application.ui.MUILabel;
import org.eclipse.e4.ui.model.application.ui.advanced.MPerspective;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;

public class SharedElementsPart {

	List sharedElements = null;
	
	@Inject
	EModelService modelService;

	@PostConstruct
	public void postConstruct(Composite parent, MApplication app, MWindow window) {
		sharedElements = new List(parent, SWT.SINGLE);
		
		for (MUIElement element : window.getSharedElements()) {
			if (element instanceof MUILabel) {
				sharedElements.add(((MUILabel)element).getLocalizedLabel());
			}
		}
		
		Button button = new Button(parent, SWT.PUSH);
		button.setText("Kill perspective");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MPerspective element = 
				        (MPerspective) modelService.find("org.fipro.e4.translation.perspective.additionalwindowperspectivelefttoright", app);
				if (element != null) {
					modelService.removePerspectiveModel(element, window);
				}
				updateSharedElements(window);
			}
		});
	}
	
	@Inject
	@Optional
	private void getNotifiedByEvent(@UIEventTopic(ILocaleChangeService.LOCALE_CHANGE) Locale s, MWindow window) {
		updateSharedElements(window);
	}
	
	private void updateSharedElements(MWindow window) {
		sharedElements.removeAll();
		for (MUIElement element : window.getSharedElements()) {
			if (element instanceof MUILabel) {
				sharedElements.add(((MUILabel)element).getLocalizedLabel());
			}
		}
	}
}