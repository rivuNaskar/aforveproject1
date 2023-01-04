package com.rivu.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivu.springbootdemo.constant.AppConstant;
import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.service.AllocationService;
@RestController
@RequestMapping(value=AppConstant.FORWORD_SLASH)
public class AllocationController {
	
	@Autowired
	private AllocationService allocationService;
	
	@PostMapping(value = AppConstant.PREPARE_AND_PROCESS_ALLOCATION)
	public void processAndUpdate() {
		//allocationService.prepareAndProcessAllocation();
	}

}
