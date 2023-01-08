package com.rivu.springbootdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rivu.springbootdemo.constant.AppConstant;
import com.rivu.springbootdemo.entity.ExerciseEntity;
import com.rivu.springbootdemo.service.ExerciseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class ExerciseController {
	
	@Autowired
	private ExerciseService exerciseService;
	
	@PostMapping(value=AppConstant.SET_EXERCISE)
	public  void approveExercise() {
		exerciseService.approveExercise();
	}

}
