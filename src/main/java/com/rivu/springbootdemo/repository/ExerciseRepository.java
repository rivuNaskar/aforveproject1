package com.rivu.springbootdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rivu.springbootdemo.entity.ExerciseEntity;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

}
