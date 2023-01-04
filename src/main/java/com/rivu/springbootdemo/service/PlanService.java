package com.rivu.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.entity.PlanEntity;
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
	
	public PlanEntity getCurrentActivePlan(boolean status){
		return planEntityRepository.findByIsCurrentPlan(status);
		
		
	}
	
	
}
