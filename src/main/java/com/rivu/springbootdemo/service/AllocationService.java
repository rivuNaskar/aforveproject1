package com.rivu.springbootdemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.entity.PlanEntity;
import com.rivu.springbootdemo.repository.AllocationRepository;
import com.rivu.springbootdemo.repository.GrantRepository;

@Service
public class AllocationService {

	@Autowired
	private AllocationRepository allocationRepository;

	@Autowired
	private PlanService planService;

	@Autowired
	private GrantRepository grantRepository;
	
	
	@Autowired
	private GrantService grantService;

	public void prepareAndProcessAllocation() {

		PlanEntity plan = getCurrentActivePlan();
		List<GrantEntity> grantEntityList = getGrantAllocationByGrantId(plan.getId());
		List<AllocationEntity> allocationList = new ArrayList<>();
		for(GrantEntity entity : grantEntityList) {
			AllocationEntity allocationEntity = prepareAllocation(entity, allocationList);
			//grantService.getGrantStatusByGrantId(grant.getId());
			allocationRepository.save(allocationEntity);
		}
		
		}
		
		
		

	

	private List<GrantEntity> getGrantAllocationByGrantId(long id) {
		return grantRepository.findByGrantStatusAndAllocationStatusAndPlanId("ACTIVE", "open", id);
	}

	public PlanEntity getCurrentActivePlan() {
		return planService.getCurrentActivePlan(true);
	}

//	public List<GrantEntity> getGrantAllocationByGrantId(long id) {
//		GrantService grantService = new GrantService();
//		return grantService.getGrantAllocationByPlanId(id);
//
//	}

	public AllocationEntity prepareAllocation(GrantEntity grantEntity, List<AllocationEntity> allocationList) {
		if (grantEntity.getGrantStatus().equalsIgnoreCase("ACTIVE")
				&& grantEntity.getAllocationStatus().equalsIgnoreCase("open")) {
			{
				AllocationEntity allocation = new AllocationEntity();
				allocation.setGrantId(grantEntity.getId());
				
				allocation.setActualAllocationDate(new Date());
				allocation.setNumberOfAlloCation(grantEntity.getNumberOfGrants() / grantEntity.getFrequency());
				allocation.setAllocationStatus("Active");
				allocation.setGrantId(grantEntity.getId());
				allocation.setAllocationYear("2023");
				allocation.setPlanedAllocationDate(new Date());
				allocationList.add(allocation);
				System.out.println(allocation);
				return allocation;
			}
		}
		allocationRepository.saveAll(allocationList);
		return null;

	}
	
	
	//@Scheduled(fixedDelay = 1000000)
	@PostConstruct
	public void initAllocation() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executed !");
				prepareAndProcessAllocation();
			}
			
		}).start();
	}
	
	

}
