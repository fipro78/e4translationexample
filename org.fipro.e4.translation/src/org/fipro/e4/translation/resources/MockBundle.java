package org.fipro.e4.translation.resources;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ResourceBundle;

public class MockBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		//For every locale there need to be a corresponding
		//subclass. This way getLocale() is able to retrieve
		//the correct locale used for translation.
		return MockStore.translate(key, getLocale());
	}

	@Override
	public Enumeration<String> getKeys() {
		return new Enumeration<String>() {
			
			private Iterator<String> iterator = 
					MockStore.getKeys().iterator();
			
			@Override
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			@Override
			public String nextElement() {
				return iterator.next();
			}
		};
	}
}
