package com.signum.models;

public class DoorType{
	
	String id;
	String hashCode;
	Float cost;
	public DoorType() {
		
	}
	public DoorType(String id, String name, Float cost) {
		super();
		this.id = id;
		this.hashCode = name;
		this.cost = cost;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHashCode() {
		return hashCode;
	}
	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}
	public Float getCost() {
		return cost;
	}
	public void setCost(Float cost) {
		this.cost = cost;
	}
	
	
	
	

}
