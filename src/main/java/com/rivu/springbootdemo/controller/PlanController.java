package com.rivu.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rivu.springbootdemo.constant.AppConstant;
import com.rivu.springbootdemo.dto.VestingDto;
import com.rivu.springbootdemo.entity.PlanEntity;

import com.rivu.springbootdemo.service.PlanService;

@RestController
@RequestMapping(value = AppConstant.FORWORD_SLASH)
public class PlanController {

	@Autowired
	private PlanService planService;

	@PostMapping(value = AppConstant.SAVE_PLAN_DETAILS)
	public void savePlanDetails(@RequestBody PlanEntity planEntity) {
		planService.savePlanDetails(planEntity);

	}
	
	@PutMapping(value=AppConstant.VESTING_FACTOR)
	public void updateVestingFactor(@RequestBody  VestingDto vestingDto) {
		 
		planService.upDateVestingFactor(vestingDto );
		
	}
	
	@GetMapping(value=AppConstant.GET_PLAN_BY_PLAN_ID)
	public @ResponseBody Optional<PlanEntity> getById(@RequestHeader(name = "id")  long id){
		return planService.getPlanById(id);
		
	}


}
