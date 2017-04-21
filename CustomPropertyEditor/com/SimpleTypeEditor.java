package com;

import java.beans.PropertyEditorSupport;

public class SimpleTypeEditor extends PropertyEditorSupport {
	

	public void setAsText(String text) {
		System.out.println("Inside set as text "+text);
		
		text = text.toUpperCase();
		
		SimpleType type = new SimpleType(text);
		setValue(type);
	}
}
