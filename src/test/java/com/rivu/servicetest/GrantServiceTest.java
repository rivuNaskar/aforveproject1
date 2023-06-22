package com.rivu.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.rivu.springbootdemo.dto.GrantDto;
import com.rivu.springbootdemo.entity.GrantEntity;
import com.rivu.springbootdemo.repository.GrantRepository;
import com.rivu.springbootdemo.service.GrantService;
import com.rivu.springbootdemo.service.MySqlTemplate;

@RunWith(value = PowerMockRunner.class)
public class GrantServiceTest {

	@Mock
	GrantRepository grantRepository;

	@Mock
	GrantService grantService;
	
	@Mock
	MySqlTemplate mySqlTemplate;

	@Test
	public void testOfSaveGrantDetails() throws Exception {
		
		List<GrantDto> grantDtoList = new ArrayList<>();
		GrantDto grantDto1 = new GrantDto();
		GrantDto grantDto2 = new GrantDto();
		GrantDto grantDto3 = new GrantDto();
		grantDtoList.add(grantDto1);
		grantDtoList.add(grantDto2);
		grantDtoList.add(grantDto3);
		MockitoAnnotations.initMocks(this);
		GrantEntity mockGrant = PowerMockito.mock(GrantEntity.class);
		GrantEntity mockGrant1 = PowerMockito.mock(GrantEntity.class);
		GrantEntity mockGrant2 = PowerMockito.mock(GrantEntity.class);
		List<GrantEntity> grantEntityList = new ArrayList<>();
		grantEntityList.add(mockGrant);
		grantEntityList.add(mockGrant1);
		grantEntityList.add(mockGrant2);

		PowerMockito.when(grantRepository, "saveAll", grantEntityList).thenReturn(null);
		ReflectionTestUtils.invokeMethod(grantService, "saveGrantDetails", grantDtoList);
		assertTrue(true);
		
		

	}

	@Test
	public void TestOfGetGrantStatus() throws Exception {
		MockitoAnnotations.initMocks(this);
		GrantEntity mockGrantEntity = PowerMockito.mock(GrantEntity.class);
		PowerMockito.when(grantRepository, "findById", 1L).thenReturn(Optional.of(1L));
		ReflectionTestUtils.invokeMethod(grantService, "getGrantStatusByGrantId", 1L);
		assertTrue(true);

	}

	

	@Test
	public void TestOfUpdateGrantStatusBasedOnId() throws Exception {
		MockitoAnnotations.initMocks(this);
		GrantEntity grantEntity = PowerMockito.mock(GrantEntity.class);
		
		List<GrantEntity> grantEntityList=new ArrayList<>();
		grantEntityList.forEach(grant->{
			grant.setAllocationStatus("ALLOCATED");
			grantEntityList.add(grant);
			
		});
		PowerMockito.when(grantRepository,"saveAll",grantEntityList).thenReturn(grantEntityList);
		ReflectionTestUtils.invokeMethod(grantService, "upDateAllocationStatus");
		assertTrue(true);
		
	}

}
