package org.fipro.e4.translation;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

/**
 * Helper class that checks if the {@link Control} to localize
 * is created and not disposed before setting the text.
 */
public class LocalizationHelper {

	/**
	 * Update the text of a {@link Label}. Checks if the given
	 * {@link Label} instance is <code>null</code> or disposed 
	 * before setting the text.
	 * 
	 * @param label The {@link Label} to set the text to
	 * @param text The text to set.
	 */
	public static void updateLabelText(Label label, String text) {
		if (label != null && !label.isDisposed())
			label.setText(text);
	}

	/**
	 * Update the text of a {@link Text}. Checks if the given
	 * {@link Text} instance is <code>null</code> or disposed 
	 * before setting the text.
	 * 
	 * @param textControl The {@link Text} to set the text to
	 * @param text The text to set.
	 */
	public static void updateTextText(Text textControl, String text) {
		if (textControl != null && !textControl.isDisposed())
			textControl.setText(text);
	}

	/**
	 * Update the text of a {@link Button}. Checks if the given 
	 * {@link Button} instance is <code>null</code> or disposed 
	 * before setting the text.
	 * 
	 * @param button The {@link Button} to set the text to
	 * @param text The text to set.
	 */
	public static void updateButtonText(Button button, String text) {
		if (button != null && !button.isDisposed())
			button.setText(text);
	}
}
