package com.rivu.springbootdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.dto.ExerciseDto;
import com.rivu.springbootdemo.entity.ExerciseEntity;
import com.rivu.springbootdemo.entity.GrantEntity;

@Service
public class MySqlTemplate implements MySqlService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<ExerciseDto> getTotalAllocation() {
		String sqlQuery = "SELECT plan_entity.id,grant_entity.id AS grantId,sum(allocation_entity.number_of_allocation) AS totalAllocation\r\n"
				+ "FROM plan_entity LEFT JOIN grant_entity ON grant_entity.plan_id=plan_entity.id\r\n"
				+ "LEFT JOIN  allocation_entity ON  grant_entity.id=allocation_entity.grant_id\r\n"
				+ "WHERE allocation_entity.allocation_status=\"APPROVED\"\r\n"
				+ "GROUP BY allocation_entity.grant_id;\r\n";
		List<ExerciseDto> listEntity = jdbcTemplate.query(sqlQuery, new BeanPropertyRowMapper(ExerciseDto.class));

		return listEntity;
	}

	public void updateGrantStatus() {
		String sqlQuery = "UPDATE grant_entity SET grant_status=\"ALLOCATED\" WHERE log_in_status=\"OPEN\"";
		jdbcTemplate.update(sqlQuery);

	}
}
