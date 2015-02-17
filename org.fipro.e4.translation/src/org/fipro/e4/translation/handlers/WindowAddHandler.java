 
package org.fipro.e4.translation.handlers;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MWindow;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

public class WindowAddHandler {
	
	@Execute
	public void execute(EModelService modelService, MApplication application) {
		// create a new window and set its size
		MWindow window = modelService.createModelElement(MWindow.class);
		window.setX(1025);
		window.setY(550);
		window.setWidth(400);
		window.setHeight(200);
		
		// need the contributor URI so the translation service is able to retrieve 
		// the translations
		window.setContributorURI("platform:/plugin/org.fipro.e4.translation");
		window.setLabel("%application");

		// add new Window to the application
		application.getChildren().add(window); 	
	}
		
}