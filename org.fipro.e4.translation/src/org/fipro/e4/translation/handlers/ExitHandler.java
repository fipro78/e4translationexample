package org.fipro.e4.translation.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.workbench.IWorkbench;

public class ExitHandler {

	@Execute
	public void execute() {
		// wb.close();
	}

	@CanExecute
	public boolean doIt() {
		return true;
	}
}