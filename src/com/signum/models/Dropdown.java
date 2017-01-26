package com.signum.models;

public class Dropdown {
	
	private String key;
	private String label;
	public Dropdown(String key, String label) {
		super();
		this.key = key;
		this.label = label;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public String toString() {
		return "Dropdown [key=" + key + ", label=" + label + "]";
	}
	
	

}
