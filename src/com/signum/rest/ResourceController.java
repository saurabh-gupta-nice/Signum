package com.signum.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.signum.dao.DoorTypeDao;
import com.signum.models.DoorType;
import com.signum.models.Dropdown;
import com.signum.services.DoorService;

@RestController
public class ResourceController {

	@Autowired
	DoorTypeDao doorTypeDao;
	
	@Autowired
	DoorService doorService;
	
	@RequestMapping(value="/resource", method = RequestMethod.GET)
	public Map<String,String> getResources() {
		Map<String,String> resources = new HashMap<String,String>();
		resources.put("id","1234");
		resources.put("content", "hello");
		return resources;
	}
	
	@RequestMapping(value="/doors", method = RequestMethod.GET)
	public List<DoorType> getDoors() {
		List<DoorType> allDoors = new ArrayList<>();
		allDoors = doorTypeDao.list();
		
		return allDoors;
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Dropdown> getProducts(){
		return doorService.getNextDropDown(null, -1);
	}
	
	@RequestMapping(value = "/dropdown/{seq}/{code}", method = RequestMethod.GET)
	public List<Dropdown> getNextDropdown(@PathVariable int seq, @PathVariable String code){
		if(code == null) {
			throw new IllegalArgumentException("code cannot be null");
		} else {
			return doorService.getNextDropDown(code, seq);
		}
	}
}
