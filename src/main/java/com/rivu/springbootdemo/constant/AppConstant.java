package com.rivu.springbootdemo.constant;

public interface AppConstant {
	//table name of esop ===
	public static String GRAND_ENTITY_TABLE="grant_entity";
	
	public static String EMPLOYE_ENTITY_TABLE="employe_entity";
	
	public static String 	PLAN_ENTITY="plan_entity";
	
	public static String ALLOCATION_ENTITY="allocation_entity";
	
  // API forward Slash
	
	public static String FORWORD_SLASH="/";
	
	
	// API for grant entity
	
	public static String SAVE_GRANT_DETAILS="/saveGrantDetails";
	
	public static String GET_GRANT_DETAILES_BASED_ON_ID="/getGrantStatusByGrantId";
	
	public static String UPDATE_GRANT_STATUS="/upDateGrantStatus";
	
	public static String GRANT_ALLOCATION_BY_PLAN_ID="/getGrantAllocationByPlanId";
	
	//API for planEntity
	public static String SAVE_PLAN_DETAILS="/savePlanDetails";
	
	public static String GET_ACTIVE_PLAN="/getCurrentActivePlan";
	
	//Api for  Allocation Entity
     
	public static String PREPARE_AND_PROCESS_ALLOCATION="/prepareAndProcessAllocation";
}
