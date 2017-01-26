package com.signum.dao;

import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.signum.models.DoorType;

public class DoorTypeDaoImpl implements DoorTypeDao {

	private JdbcTemplate jdbcTemplate;
	 
    public DoorTypeDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
 
	
	@Override
	public void saveOrUpdate(DoorType door) {
		
	        // insert
	        String sql = "INSERT INTO signum_doors (me)"
	                    + " VALUES (?, ?)";
	        Random random = new Random();
	        jdbcTemplate.update(sql, "1234" + random.nextInt(10), "door1");

	}

	@Override
	public void delete(int doorId) {
		// TODO Auto-generated method stub

	}

	@Override
	public DoorType get(int doorId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DoorType> list() {

		List<DoorType> doors = jdbcTemplate.query("select * from signum_doors", 
				new BeanPropertyRowMapper<DoorType>(DoorType.class));
		return doors;
	}

}
