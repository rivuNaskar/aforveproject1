package com.rivu.springbootdemo.constant;

public interface AppConstant {
	// table name of esop ===
	public static String GRAND_ENTITY_TABLE = "grant_entity";

	public static String EMPLOYE_ENTITY_TABLE = "employe_entity";

	public static String PLAN_ENTITY = "plan_entity";

	public static String ALLOCATION_ENTITY = "allocation_entity";
	
	public static String EXERCISE_ENTITY="exrecise_entity";

	// API forward Slash

	public static String FORWORD_SLASH = "/";

	// API for grant entity

	public static String SAVE_GRANT_DETAILS = "/saveGrantDetails";

	public static String GET_GRANT_DETAILES_BASED_ON_ID = "/getGrantStatusByGrantId";

	public static String UPDATE_GRANT_STATUS = "/updateGrantStatusBasedOnId";

	// API for planEntity
	public static String SAVE_PLAN_DETAILS = "/savePlanDetails";
	public static String GET_PLAN_BY_PLAN_ID="/getPlanById";

	// Api for Allocation Entity

	public static String APPROVE_ALLOCATION = "/approveAllocation";
	public static String UPDATE_ALLOCATION="/updateAllocationGrant";
	
	//Api for vesting factor
	public static String VESTING_FACTOR="/upDateVestingFactor";
	
	//Api for jdbc template
	public static String GET_TOTAL_ALLOCATION="/getTotalAllocation";
	
	//Api for Exercise
	public static String SET_EXERCISE="/approveExercise";

}
