package com.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicles.entity.Bike;
import com.vehicles.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	BikeService bs;

	@PostMapping(value = "/setBike")
	public String setBike(@RequestBody List<Bike> bike) {
		return bs.setBike(bike);
	}
	@GetMapping(value="/getBike")
	public List<Bike> getBike() {
		return bs.getBike();
	}
	@PostMapping(value="/addFuelType")
	public String addFuelType(@RequestBody Bike fuel) {
		return bs.addFuelType(fuel);
	}
	@GetMapping(value="/getById/{x}")
	public Bike getById(@PathVariable int x) {
		return bs.getById(x);
	}
	@DeleteMapping(value="/del/{y}")
	public String del(@PathVariable int y) {
		return bs.del(y);
	}
	@GetMapping(value="/getByBrand/{brand}")
	public List<Bike> getByBrand(@PathVariable String brand) {
		return bs.getByBrand(brand);
	}
	@GetMapping(value="/getPrice/{p1}/{p2}")
	public List<Bike> getByPrice(@PathVariable int p1,@PathVariable int p2) {
		return bs.getByPrice(p1,p2);
	}
	@GetMapping(value="/getBrand/{c}")
	public List<String> getBrandByColor(@PathVariable String c) {
		return bs.getBrandByColor(c);
	}
	@GetMapping(value="/getMax")
	public Bike getMax() {
		return bs.getMax();
	}
	@GetMapping(value="/getMin")
	public Bike getMin() {
		return bs.getMin();
	}
	@GetMapping(value="getReducedPrice/{x}")
	public List<Bike> getReducedBike(@PathVariable int x) {
		return bs.getReducedBike(x);
		
	}
	
}
