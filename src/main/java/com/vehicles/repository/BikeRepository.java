package com.vehicles.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.vehicles.entity.Bike;

public interface BikeRepository extends JpaRepositoryImplementation<Bike, Integer> {
	

}
