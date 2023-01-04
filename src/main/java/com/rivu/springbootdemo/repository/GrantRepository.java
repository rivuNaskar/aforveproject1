package com.rivu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rivu.springbootdemo.entity.GrantEntity;

public interface GrantRepository  extends JpaRepository<GrantEntity, Long>{
	List<GrantEntity> findByPlanId(long planId);
	
	List<GrantEntity>  findByGrantStatusAndAllocationStatusAndPlanId(String grantStatus,String allocationStatus,long planId);

}
