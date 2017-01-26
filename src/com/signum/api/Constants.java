package com.signum.api;

import java.util.ArrayList;
import java.util.List;

import com.signum.models.Dropdown;

public class Constants {

	public enum Material {
		METAL("M","Metal"),
		TIMBER("T","Timber"),
		MIX("X","Timber mix with metal");
		String code, label;
		
		Material(String code, String label) {
			this.code = code;
			this.label = label;
		}
		
		String getCode() {
			return this.code;
		}
		
		String getLabel() {
			return this.label;
		}
		
		int getSequence() {
			return 2;
		}
		
		public static Material getMaterial(String label) {
			for(Material m: Material.values()) {
				if(m.label.equalsIgnoreCase(label)) {
					return m;
				} 
			}
			return null;
		}

		
		public static List<Dropdown> getDropdowns() {
			List<Dropdown> allOptions =new ArrayList<>();
			for(Material material: Material.values()) {
				Dropdown dropdown = new Dropdown(material.code, material.label);
				allOptions.add(dropdown);
			}
			return allOptions;
		}
		
		
	}
	
	public enum Product {
		HINGED("H","Hinged"),
		SLIDING("S","Sliding"),
		FOLDING("F","Folding"),
		ROLLING("R","Rolling");
		String code, label;
		
		Product(String code, String label) {
			this.code = code;
			this.label = label;
		}
		
		String getCode() {
			return this.code;
		}
		
		String getLabel() {
			return this.label;
		}
		
		int getSequence() {
			return 1;
		}
		
		public static Product getProduct(String label) {
			for(Product product: Product.values()) {
				if(product.getLabel().equalsIgnoreCase(label)) {
					return product;
				}
			}
			return null;
		}
		
		public static List<Dropdown> getDropdowns() {
			List<Dropdown> allOptions =new ArrayList<>();
			for(Product material: Product.values()) {
			Dropdown dropdown = new Dropdown(material.code, material.label);
				allOptions.add(dropdown);
			}
			return allOptions;
		}
		
		
	}
	
	
	
	
}
