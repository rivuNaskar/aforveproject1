package com.rivu.springbootdemo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.rivu.springbootdemo.dto.GrantDto;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.service.GrantService;
import com.rivu.springbootdemo.service.MySqlTemplate;
import com.rivu.springbootdemo.service.PlanService;

@RestController
@RequestMapping(value = AppConstant.FORWORD_SLASH)
public class GrantController {

	@Autowired
	private GrantService grantService;
	@Autowired
	private MySqlTemplate mySql;

	private static final Logger LOGGER = LoggerFactory.getLogger(GrantController.class);

	@PostMapping(value = AppConstant.SAVE_GRANT_DETAILS)
	public void saveGrantDetails(@RequestBody List<GrantDto> grantDto) {
		grantService.saveGrantDetails(grantDto);
	}

	@GetMapping(value = AppConstant.GET_GRANT_DETAILES_BASED_ON_ID)
	public Optional<GrantEntity> getGrantDetails(@RequestHeader(name = "id") long id) {
		return grantService.getGrantStatusByGrantId(id);

	}

	@PutMapping(value = AppConstant.UPDATE_GRANT_STATUS)
	public void upDateGrantStatus(@RequestBody List<Long> grantId) {
		grantService.updateGrantStatusBasedOnId(grantId);
	}

	@PutMapping(value = AppConstant.UPDATE_ALLOCATION)
	public  @ResponseBody  List<GrantEntity>  upDateStatus() {
		return grantService.upDateAllocationStatus();
	}
	


}
