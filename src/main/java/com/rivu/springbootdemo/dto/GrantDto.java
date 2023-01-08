package com.rivu.springbootdemo.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Data
public class GrantDto implements Serializable {
	
	private long id;
	
	private long employeNumber;
	
	private long noOfGrants;
	
	private long band;
	
	private double grantPrice;
	
	private String logInStatus;
	
	private long frequency;
	
	private long vestingTenure;
    
	private long planId;
}
