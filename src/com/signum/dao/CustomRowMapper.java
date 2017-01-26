package com.signum.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.signum.models.DoorType;

public class CustomRowMapper implements RowMapper<DoorType> {

	@Override
	public DoorType mapRow(ResultSet rs, int arg1) throws SQLException {
		DoorType doorType = new DoorType();
		doorType.setCost(rs.getFloat("cost"));
		doorType.setHashCode(rs.getString("hashcode"));
		doorType.setId(String.valueOf(rs.getInt("id")));
		return doorType;
	}
}
