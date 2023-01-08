package com.rivu.springbootdemo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rivu.springbootdemo.entity.GrantEntity;

public interface GrantRepository  extends JpaRepository<GrantEntity, Long>{
	//List<GrantEntity> findById(List<Long> grantId);
	
	
	List<GrantEntity>  findByGrantStatusAndAllocationStatusAndPlanId(String grantStatus,String allocationStatus,long planId);

}
