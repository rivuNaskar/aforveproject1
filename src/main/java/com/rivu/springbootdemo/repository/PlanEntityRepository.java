package com.rivu.springbootdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivu.springbootdemo.entity.PlanEntity;

public interface PlanEntityRepository extends JpaRepository<PlanEntity, Long> {
	PlanEntity findByIsCurrentPlan(boolean isCurrentPlan);
	

}
