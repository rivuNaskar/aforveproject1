package com.rivu.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rivu.springbootdemo.constant.AppConstant;
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

	@GetMapping(value=AppConstant.GET_ACTIVE_PLAN)
	public  @ResponseBody  PlanEntity getActivePlan(@RequestHeader(name = "status") boolean status) {
		return planService.getCurrentActivePlan(status);
	}
}
