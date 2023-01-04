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
@Table(name = AppConstant.EMPLOYE_ENTITY_TABLE)
public class EmployeEntity implements Serializable {
	@Id
	@GenericGenerator(name="auto" , strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name="id")
	private long id;
	
	@Column(name="emp_no")
	private long employeNumber;
	
	@Column(name="band")
	private String band;
	
	@Column(name="designation")
	private String designation;
	
	@Column(name="employe_start_date")
	private Date employeStartDate;
	
	@Column(name="is_active")
	private Boolean isActive;

}
