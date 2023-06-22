package com.rivu.springbootdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rivu.springbootdemo.dto.ExerciseDto;
import com.rivu.springbootdemo.entity.AllocationEntity;
import com.rivu.springbootdemo.entity.ExerciseEntity;
import com.rivu.springbootdemo.entity.PlanEntity;
import com.rivu.springbootdemo.repository.AllocationRepository;
import com.rivu.springbootdemo.repository.ExerciseRepository;

@Service
public class ExerciseService {

	@Autowired
	private ExerciseRepository exerciseRepository;
	@Autowired
	private AllocationRepository allocationRepository;

	@Autowired
	private MySqlTemplate mySqlTemplate;

	@Autowired
	private PlanService planService;
	

	public void approveExercise() {

		ExerciseEntity exerciseEntity = new ExerciseEntity();

		List<ExerciseDto> listExerciseDto = mySqlTemplate.getTotalAllocation();
		System.out.println(listExerciseDto);
		listExerciseDto.forEach(listExercise -> {
			Optional<PlanEntity> optional = planService.getPlanById(listExercise.getId());
			PlanEntity planEntity = optional.get();
			System.out.println(planEntity);
			exerciseEntity.setGrantId(listExercise.getGrantId());
			exerciseEntity.setVestedOption(listExercise.getTotalAllocation()*planEntity.getVestingFactor());
			
			

		});
		 exerciseRepository.save(exerciseEntity);
	}

}
