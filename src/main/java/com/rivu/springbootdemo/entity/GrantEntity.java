package com.rivu.springbootdemo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.rivu.springbootdemo.constant.AppConstant;

import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@RequiredArgsConstructor
@Entity
@Table(name=AppConstant.GRAND_ENTITY_TABLE)
public class GrantEntity implements Serializable {
	
	@Id
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private long id;
	
	@Column(name="emp_no")
	private long employeNumber;
	
	@Column(name="number_of_grants")
	private long numberOfGrants;
	
	@Column(name="band")
	private String  band;
	
	@Column(name="grant_price")
	private double grantPrice;
	
	@Column(name="grant_status")
	private String grantStatus;
	
	@Column(name="accepted")
	private boolean accepted;
	
	@Column(name="accepted_date")
	private Date acceptedDate;
	
	@Column(name="log_in_status")
	private String logInStatus;
	
	@Column(name="frequency")
	private long frequency;
	
	@Column(name = "vesting_tenure")
	private long vestingTenure;
	
	@Column(name="plan_id")
	private long planId;
	
	@Column(name="allocation_status")
	private String allocationStatus;

}
