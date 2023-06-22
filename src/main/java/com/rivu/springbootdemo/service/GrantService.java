package com.rivu.springbootdemo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.dto.GrantDto;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.repository.GrantRepository;

@Service
public class GrantService {

	@Autowired
	private GrantRepository grantRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(GrantService.class);

	/**
	 * This is the method of save grant Details which takes List of grant dto as a
	 * input and save the entitylist;
	 * 
	 * @param grantDtoList
	 */
	public void saveGrantDetails(List<GrantDto> grantDtoList) {

		LOGGER.info("Inside the saveGrantDetails{} of grantService" + grantDtoList);
		List<GrantEntity> grantEntityList = new ArrayList<>();
		grantDtoList.stream().forEach(grantDto -> {
			GrantEntity grantEntity = new GrantEntity();
			grantEntity.setBand(grantDto.getBand());
			grantEntity.setEmployeNumber(grantDto.getEmployeNumber());
			grantEntity.setFrequency(grantDto.getFrequency());
			grantEntity.setGrantPrice(grantDto.getGrantPrice());
			grantEntity.setLogInStatus(grantDto.getLogInStatus());
			grantEntity.setNumberOfGrants(grantDto.getNoOfGrants());
			grantEntity.setVestingTenure(grantDto.getVestingTenure());
			grantEntity.setAcceptedDate(new Date());
			grantEntity.setAllocationStatus("OPEN");
			grantEntity.setGrantStatus("None");
			grantEntity.setAccepted(false);
			grantEntity.setPlanId(grantDto.getPlanId());

			grantEntityList.add(grantEntity);

		});
		grantRepository.saveAll(grantEntityList);

	}

	/**
	 * This method will take the grant id as a input and return the grant details
	 * based on grant id
	 * 
	 * @param id
	 */
	public Optional<GrantEntity> getGrantStatusByGrantId(long id) {
		LOGGER.info("Inside the getGrantStatusByGrantId{} in grantService" + id);
		return grantRepository.findById(id);
	}

	public List<GrantEntity> upDateAllocationStatus() {
		LOGGER.info("Inside the upDateAllocationStatus{} in grantService ");
		List<GrantEntity> grantEntityList = new ArrayList<>();

		grantEntityList.stream().forEach(grantEntity -> {

			grantEntity.setAllocationStatus("ALLOCATED");

			grantEntityList.add(grantEntity);
		});
		return grantRepository.saveAll(grantEntityList);

	}

	/**
	 * This method will update GrantStatus based on List of GrantId
	 * 
	 * @param grantIdList
	 */
	public void updateGrantStatusBasedOnId(List<Long> grantIdList) {
		LOGGER.info("Inside the updateStatusBasedOnId{} in grantService ");
		List<GrantEntity> grantEntityList = new ArrayList<>();

		grantIdList.stream().forEach(grantId -> {
			Optional<GrantEntity> optional = grantRepository.findById(grantId);
			GrantEntity grantEntity = optional.get();
			grantEntity.setGrantStatus("Activated");
			grantEntityList.add(grantEntity);

		});
		grantRepository.saveAll(grantEntityList);
	}

}
