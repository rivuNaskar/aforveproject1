package com.rivu.springbootdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rivu.springbootdemo.constant.AppConstant;
import com.rivu.springbootdemo.dto.ExerciseDto;
import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.service.AllocationService;
import com.rivu.springbootdemo.service.MySqlTemplate;
@RestController
@RequestMapping(value=AppConstant.FORWORD_SLASH)
public class AllocationController {
	
	@Autowired
	private AllocationService allocationService;
	
	@Autowired
	private MySqlTemplate mySql;
	
	@PutMapping(value = AppConstant.APPROVE_ALLOCATION)
	public void approveAllocation( @RequestBody  List<Long> allocationIdList) {
		allocationService.approveAllocation(allocationIdList);
		
	}
	
	
	@GetMapping(value=AppConstant.GET_TOTAL_ALLOCATION)
	public  @ResponseBody  List<ExerciseDto> getTotalAllocation() {
		return mySql.getTotalAllocation();
		
	}
	
	

}
