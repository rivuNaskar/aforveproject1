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
@RequiredArgsConstructor
@Data
@Entity
@Table(name=AppConstant.ALLOCATION_ENTITY)
public class AllocationEntity implements Serializable {
	
	@Id
	@GenericGenerator(name="auto",strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private long id;
	
	@Column(name="grant_id")
	private long grantId;
	
	@Column(name="number_of_allocation")
	private long numberOfAlloCation;
	
	@Column(name="planed_allocation_date")
	private Date planedAllocationDate;
	
	@Column(name="actual_allocation_date")
	private  Date actualAllocationDate;
	
	@Column(name="allocation_year")
	private String allocationYear;
	
	@Column(name="allocation_status")
	private String allocationStatus;

}
