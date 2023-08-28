package com.vehicles.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.vehicles.entity.Bus;

public interface BusRepository extends JpaRepositoryImplementation<Bus, Integer> {
	
	@Query(value="select * from bus_details where brand like ?", nativeQuery=true)
	List<Bus> getByBrand(String b);

}
