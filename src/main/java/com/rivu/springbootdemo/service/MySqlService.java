 package com.rivu.springbootdemo.service;

import java.util.List;

import javax.persistence.Entity;

import org.hibernate.dialect.MySQLStorageEngine;

import com.rivu.springbootdemo.dto.ExerciseDto;
import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.entity.GrantEntity;

public interface MySqlService {
	
	List<ExerciseDto> getTotalAllocation();
	
	 
	

}
