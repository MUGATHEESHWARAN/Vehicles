package com.vehicles.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vehicles.customexception.BrandNotFoundException;
import com.vehicles.customexception.IdNotFoundException;
import com.vehicles.customexception.InvalidBoardException;
import com.vehicles.entity.Bus;
import com.vehicles.service.BusService;

@RestController
@RequestMapping("/bus")
public class BusController {
	@Autowired
	BusService bs;
	@PatchMapping("/setBus")
	public String setBus(@RequestBody Bus bus) throws InvalidBoardException {
		return bs.setBus(bus);
	}
	@PostMapping("/setAllBus")
	public String setAllBus(@RequestBody List<Bus> b) throws InvalidBoardException {
		return bs.setAllBus(b);
	}
	@GetMapping("/getAllBus")
	public List<Bus> getAllBus() {
		return bs.getAllBus();
	}
	@GetMapping("/getById/{id}")
	public Bus getById(@PathVariable int id) throws IdNotFoundException {
		return bs.getById(id);
	}
	@GetMapping("getByBrand/{b}")
	public List<Bus> getByBrand(@PathVariable String b) throws BrandNotFoundException {
		return bs.getByBrand(b);
	}
	@PutMapping("/update/{id}")
	public String update(@PathVariable int id,@RequestBody Bus b) throws IdNotFoundException, InvalidBoardException {
		return bs.update(id,b);
		
		
	}
}
