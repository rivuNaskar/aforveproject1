package com.rivu.springbootdemo.entity;

import java.io.Serializable;

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
@Table(name=AppConstant.EXERCISE_ENTITY)
public class ExerciseEntity implements Serializable {
	@Id
	@GenericGenerator(name="auto" ,strategy="increment")
	@GeneratedValue(generator = "auto")
	@Column(name="")
	private long id;
	
	@Column(name="grant_id")
	private long grantId;
	
	@Column(name="vested_option")
	private double vestedOption;

}
