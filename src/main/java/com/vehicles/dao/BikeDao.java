package com.vehicles.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicles.entity.Bike;
import com.vehicles.repository.BikeRepository;
@Repository
public class BikeDao {
	@Autowired
	BikeRepository br;
	public String setBike(List<Bike> bike) {
		br.saveAll(bike);
		return "Successfully Added";
		
	}
	public List<Bike> getBike() {
		return br.findAll();
	}
	public String addFuelType(Bike fuel) {
		br.save(fuel);
		return "Saved";
	}
	public Bike getById(int x) {
		return br.findById(x).get();
	}
	public String del(int y) {
		br.deleteById(y);
		return "Successfully Deleted";
	}

}
