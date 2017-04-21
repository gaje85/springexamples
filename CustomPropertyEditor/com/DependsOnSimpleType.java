package com;

public class DependsOnSimpleType {

	private SimpleType type;

	public void setType(SimpleType type) {
		this.type = type;
	}
	
	public String toString(){
		return type.toString();
	}
}
