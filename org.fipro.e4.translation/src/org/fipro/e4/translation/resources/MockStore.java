package org.fipro.e4.translation.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@SuppressWarnings("nls")
public class MockStore {

	private static List<String> mockKeys = new ArrayList<String>();
	private static Map<String, String> mockStore = new HashMap<String, String>();

	static {
		mockKeys.add("application");
		mockKeys.add("part.title");
		mockKeys.add("first.label.message");
		mockKeys.add("second.label.message");
		mockKeys.add("third.label.message");
		
		mockStore.put("application", "Translation Service Example (Mock)");
		mockStore.put("part.title", "Part Title (Mock)");
		mockStore.put("first.label.message", "Example showing the usage of the new message extension by using\n\n{0}");
		mockStore.put("second.label.message", "Second Label Message (Mock)");
		mockStore.put("third.label.message", "Third Label Message (Mock)");

		mockStore.put("application_de", "Translation Service Beispiel (Mock de)");
		mockStore.put("part.title_de", "Part Titel (Mock de)");
		mockStore.put("first.label.message_de", "Beispiel das die Verwendung der neuen message extension zeigt, unter Verwendung von\n\n{0}");
		mockStore.put("second.label.message_de", "Zweite Label Beschriftung (Mock de)");

		mockStore.put("application_de_DE", "Translation Service Beispiel (Mock de_DE)");
		mockStore.put("part.title_de_DE", "Part Titel (Mock de_DE)");
		mockStore.put("second.label.message_de_DE", "Zweite Label Beschriftung (Mock de_DE)");
	}
	
	public static String translate(String key, Locale locale) {
		String suffix = locale.toString();
		suffix = suffix.length() > 0 ? "_" + suffix : "";
		return mockStore.get(key + suffix);
	}
	
	public static List<String> getKeys() {
		return mockKeys;
	}
}
