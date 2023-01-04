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
@Entity
@Data
@Table(name = AppConstant.PLAN_ENTITY)
public class PlanEntity implements Serializable {

	@Id
	@GenericGenerator(name = "auto", strategy = "increment")
	@GeneratedValue(generator = "auto")
	@Column(name = "id")
	private long id;

	@Column(name = "plan_year")
	private long planYear;

	@Column(name = "plan_started_date")
	private Date planStartedDate;

	@Column(name = "plan_end_date")
	private Date planeEndDate;

	@Column(name = "is_current_plan")
	private boolean isCurrentPlan;

}
