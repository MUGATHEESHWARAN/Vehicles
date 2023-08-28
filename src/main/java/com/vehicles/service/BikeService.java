package com.vehicles.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicles.dao.BikeDao;
import com.vehicles.entity.Bike;
@Service
public class BikeService {
	@Autowired
	BikeDao bd;

	public String setBike(List<Bike> bike) {
		return bd.setBike(bike);
	}
	public List<Bike> getBike() {
		return bd.getBike();
	}
	public String addFuelType(Bike fuel) {
		return bd.addFuelType(fuel);
	}
	public Bike getById(int x) {
		return bd.getById(x);
	}
	public String del(int y) {
		return bd.del(y);
	}
	public List<Bike> getByBrand(String brand) {
		List<Bike> x=getBike();
		List<Bike>y=x.stream().filter(m->m.getBrand().equalsIgnoreCase(brand)).collect(Collectors.toList());
		return y;
	}
	public List<Bike> getByPrice(int p1, int p2) {
		List<Bike> x=getBike();
		List<Bike>y=x.stream().filter(m->m.getPrice()>p1 && m.getPrice()<p2).collect(Collectors.toList());
		return y;
	}
	public List<String> getBrandByColor(String c) {
		List<Bike> x=getBike();
		List<String>y=x.stream().filter(m->m.getColor().equalsIgnoreCase(c)).map(m->m.getBrand()).collect(Collectors.toList());
		return y;
	}
	public Bike getMax() {
		List<Bike> x=getBike();
		Bike z=x.stream().max(Comparator.comparingInt(Bike::getPrice)).get();
		return z;
	}
	public Bike getMin() {
		List<Bike> x=getBike();
		Bike z=x.stream().min(Comparator.comparingInt(Bike::getPrice)).get();
		return z;
	}
	public List<Bike> getReducedBike(int x) {
		List<Bike> p=getBike();
		List<Bike>a=p.stream().peek(y->y.setPrice(y.getPrice()-y.getPrice()*x/100)).collect(Collectors.toList());
		return a;
	}
	
}
