package com.signum.dao;

import java.util.List;

import com.signum.models.DoorType;

public interface DoorTypeDao {

	public void saveOrUpdate(DoorType door);
    
    public void delete(int doorId);
     
    public DoorType get(int doorId);
     
    public List<DoorType> list();
}
