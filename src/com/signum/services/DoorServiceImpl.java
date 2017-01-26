package com.signum.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.signum.api.Constants.Material;
import com.signum.api.Constants.Product;
import com.signum.dao.DoorTypeDao;
import com.signum.models.DoorType;
import com.signum.models.Dropdown;


@Service("doorService")
public class DoorServiceImpl implements DoorService {

	@Autowired
	DoorTypeDao doorTypeDao;
	
	@Override
	public List<Dropdown> getNextDropDown(String currentSelection, int seq) {
		if(currentSelection == null && seq == -1) {
			return getAllDropDowns(1);
		} else if(currentSelection.isEmpty() && seq == -1) {
			return getAllDropDowns(1);
		} else {
			List<Dropdown> possibleOptions = getAllDropDowns(seq+1);
			System.out.println("dropdown options : " + possibleOptions.toString());
			List<String> allHashcodes = getAllHashCode(currentSelection, seq);
			Iterator<Dropdown> optionIterartor = possibleOptions.iterator();
			while(optionIterartor.hasNext()) {
				Dropdown dropdown = optionIterartor.next();
				boolean keep= false;
				for(String code: allHashcodes) {
					String codes[] = code.split("#");
					if(codes[seq].equalsIgnoreCase(dropdown.getKey())) {
						keep=true;
						break;
					}
				}
				if(!keep) {
					System.out.println("removed " + dropdown.getLabel());
					optionIterartor.remove();
				}
			}
			return possibleOptions;
		}
		
		
	}
	
	private List<String> getAllHashCode(String currentSelection, int seq ) {
		List<DoorType> allDoors = doorTypeDao.list();
		List<String> allHashCodes = new ArrayList<>();
		for(DoorType door: allDoors) {
			String codes[] = door.getHashCode().split("#");
			if(codes[seq-1].equalsIgnoreCase(currentSelection)) {
				allHashCodes.add(door.getHashCode());
			}
			
		}
		return allHashCodes;
	}
	
	private List<Dropdown> getAllDropDowns(int seq) {
		switch(seq) {
			case 1:
				return Product.getDropdowns();
			case 2:
				return Material.getDropdowns();
			default:
				throw new IllegalArgumentException("No such sequence exists");
				
		}
	}
	
	
}
