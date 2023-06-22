package com.rivu.springbootdemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.entity.PlanEntity;
import com.rivu.springbootdemo.repository.AllocationRepository;
import com.rivu.springbootdemo.repository.GrantRepository;
import com.rivu.springbootdemo.repository.PlanEntityRepository;

@Service
public class AllocationService {

	@Autowired
	private AllocationRepository allocationRepository;

	@Autowired
	private GrantService grantService;

	@Autowired
	private GrantRepository grantRepository;

	@Autowired
	private PlanEntityRepository planEntityRepository;

	@Autowired
	private MySqlTemplate mySqlTemplate;

	public final static Logger LOGGER = LoggerFactory.getLogger(AllocationService.class);

//	@Autowired
//	private GrantService grantService;
    
	public void prepareAndProcessAllocation() {
		LOGGER.info("inside the PrepareProcessAllocation{} in AllocationService");
		PlanEntity plan = getCurrentActivePlan(); // verified
		System.out.println("Plan Object  :  " + plan);// verified
		List<GrantEntity> grantEntityList = getGrantAllocationByGrantId(plan.getId()); // verified
		System.out.println("List  : " + grantEntityList); // verified
		List<AllocationEntity> allocationList = new ArrayList<>();
		System.out.println("Allocation List  :  " + allocationList);
		for (GrantEntity entity : grantEntityList) {
			prepareAllocation(entity, allocationList);
			// grantService.getGrantStatusByGrantId(grant.getId());
			// allocationRepository.save(allocationEntity);
			System.out.println("Entity  :  " + entity);
			allocationRepository.saveAll(allocationList);

			mySqlTemplate.updateGrantStatus();
			//grantService.upDateAllocationStatus();

		}
		// allocationList..out.println("Updated");

	}

	/**
	 * This method will return all the grant allocation based on grant id
	 * 
	 * @param id
	 * @return
	 */
	private List<GrantEntity> getGrantAllocationByGrantId(long id) {
		LOGGER.info("Inside the getGrantAllocationByGrantId{} on grantService " + id);
		System.out.println("Grant Id  :  " + id);
		return grantRepository.findByGrantStatusAndAllocationStatusAndPlanId("APPROVED", "PENDING", id);
	}

	public PlanEntity getCurrentActivePlan() {
		LOGGER.info("Inside the getCurrentActivePlan{} inside grantService ");
		System.out.println("Get Current Active Plan Executed !");
		return planEntityRepository.findByIsCurrentPlan(true);
	}

	public void prepareAllocation(GrantEntity grantEntity, List<AllocationEntity> allocationList) {
		if (grantEntity.getGrantStatus().equalsIgnoreCase("APPROVED")
				&& grantEntity.getAllocationStatus().equalsIgnoreCase("PENDING")) {
			{
				for (int i = 1; i <= 5; i++) {
					AllocationEntity allocation = new AllocationEntity();
					allocation.setGrantId(grantEntity.getId());

					allocation.setActualAllocationDate(new Date());
					allocation.setNumberOfAlloCation(grantEntity.getNumberOfGrants() / grantEntity.getFrequency());
					allocation.setAllocationStatus("PENDING");
					// allocation.setGrantId(grantEntity.getPlanId());

					allocation.setAllocationYear(2023 + i);
					allocation.setPlanedAllocationDate(new Date());
					allocationList.add(allocation);
					System.out.println(allocation);
					// return allocation;
				}
			}
		}

		// allocationRepository.saveAll(allocationList);
		// return null;

	}

	@Scheduled(fixedDelay = 1000)
	// @PostConstruct
	public void initAllocation() {
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Executed !");
				prepareAndProcessAllocation();
			}

		}).start();
	}

	public void approveAllocation(List<Long> allocationIdList) {
		List<AllocationEntity> allocationEntityList = new ArrayList<>();
		allocationIdList.stream().forEach(allocationId -> {
			Optional<AllocationEntity> optional = allocationRepository.findById(allocationId);
			AllocationEntity allocationEntity = optional.get();
			allocationEntity.setAllocationStatus("APPROVED");
			allocationEntity.setActualAllocationDate(new Date());
			allocationEntityList.add(allocationEntity);

		});
		allocationRepository.saveAll(allocationEntityList);
	}

	public List<AllocationEntity> findByGrantId(long grantId) {
		return allocationRepository.findBygrantId(grantId);
	}

}
