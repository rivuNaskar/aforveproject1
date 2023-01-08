package com.rivu.springbootdemo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class VestingDto implements Serializable {
	
	private double vestingFactor;
	private long planId;

}
