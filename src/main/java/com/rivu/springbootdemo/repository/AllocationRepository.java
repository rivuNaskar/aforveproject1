package com.rivu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.entity.GrantEntity;

public interface AllocationRepository extends JpaRepository<AllocationEntity, Long> {
	List<AllocationEntity> findBygrantId(long  grantId);


	

}
