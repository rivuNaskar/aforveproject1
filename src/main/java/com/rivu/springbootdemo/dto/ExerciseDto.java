package com.rivu.springbootdemo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ExerciseDto implements Serializable {
	 private long id;
	 
	 private long grantId;
	 
	 private long totalAllocation;
	
	

}
