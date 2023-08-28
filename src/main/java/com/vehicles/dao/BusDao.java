package com.vehicles.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.vehicles.customexception.IdNotFoundException;
import com.vehicles.entity.Bus;
import com.vehicles.repository.BusRepository;

@Repository
public class BusDao {
	@Autowired
	BusRepository br;
	public String setBus(Bus bus) {
		br.save(bus);
		return "Successfully Added";
	}
	public String setAllBus(List<Bus> b) {
		br.saveAll(b);
		return "List Of Bus Successfully Saved";
	}
	public List<Bus> getAllBus() {
		return br.findAll();
	}
	public Bus getById(int id) throws IdNotFoundException {
		return br.findById(id).orElseThrow(()-> new IdNotFoundException("INVALID ID"));
	}
	public List<Bus> getByBrand(String b) {
		return br.getByBrand(b);
	}
	
}
