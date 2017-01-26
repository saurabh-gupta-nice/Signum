package com.signum.services;

import java.util.List;

import com.signum.models.Dropdown;

public interface DoorService {

	public List<Dropdown> getNextDropDown(String currentSelection, int seq);
}
