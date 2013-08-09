package com.beone.e4.translation.resources;

import java.util.HashMap;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

public class ListMockBundle extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		List<String> keys = MockStore.getKeys();
		
		Map<String, String> map = new HashMap<String, String>();
		for(int i = 0; i < keys.size(); i++) {
			String key = keys.get(i);
			String value = 
					MockStore.translate(
							keys.get(i), getLocale());
			if (value != null) {
				map.put(key, value);
			}
		}
		
		Object[][] result = new Object[map.size()][2];
		int counter = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			result[counter][0] = entry.getKey();
			result[counter][1] = entry.getValue();
			
			counter++;
		}
		return result;
	}
}
