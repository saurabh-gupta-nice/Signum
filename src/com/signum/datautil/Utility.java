package com.signum.datautil;

import java.util.List;


public class Utility {

	public List<String> getConstant(int sequence) {
		switch(sequence) {
			case 1:
				break;
			default:
				throw new IllegalArgumentException("No such Sequence exists");
		}
		return null;
	}
	
}
