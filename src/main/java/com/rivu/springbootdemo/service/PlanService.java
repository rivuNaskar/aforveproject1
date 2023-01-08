package com.rivu.springbootdemo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.Column;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.dto.VestingDto;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.entity.PlanEntity;
import com.rivu.springbootdemo.repository.GrantRepository;
import com.rivu.springbootdemo.repository.PlanEntityRepository;

@Service
public class PlanService {
	
	@Autowired
	private PlanEntityRepository planEntityRepository;
	
	
	
	private static final Logger LOGGER=LoggerFactory.getLogger(PlanService.class);
	
	
	/**
	 * This method save plandetails from planentity
	 * @param planEntity
	 */
	public void savePlanDetails(PlanEntity planEntity) {
		LOGGER.info("Inside the savePlanDetails{} of PlanService"+planEntity);
		planEntityRepository.save(planEntity);
	}
	
    public void upDateVestingFactor(VestingDto vestingDto ) {
    	
    	
    	 Optional<PlanEntity> optional = planEntityRepository.findById(vestingDto.getPlanId());
    	 PlanEntity planEntity=optional.get();
    	  
    	planEntity.setVestingFactor(vestingDto.getVestingFactor());
    	planEntity.setVestedDate(new Date());
    
    	planEntityRepository.save(planEntity);
    
    	
    }
    
    public Optional<PlanEntity> getPlanById(long id) {
    	return planEntityRepository.findById(id);
    }
	
	
}
