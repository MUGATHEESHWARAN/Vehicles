package com.vehicles.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.vehicles.customexception.BrandNotFoundException;
import com.vehicles.customexception.IdNotFoundException;
import com.vehicles.customexception.InvalidBoardException;
import com.vehicles.dao.BusDao;
import com.vehicles.entity.Bus;

@Service
public class BusService {
	@Autowired
	BusDao bd;

	public String setBus(Bus bus) throws InvalidBoardException {
		try {
			if (bus.getBoard().equalsIgnoreCase("white")) {
				return bd.setBus(bus);
			} else {
				throw new InvalidBoardException("Invalid Data");
			}
		} catch (InvalidBoardException ex) {
			return "INVALID DATA";
		}

	}

	public String setAllBus(List<Bus> b) throws InvalidBoardException {
		List<Bus> s = b.stream().filter(x -> x.getBoard().equalsIgnoreCase("White")).collect(Collectors.toList());
		if (s.isEmpty()) {
			throw new InvalidBoardException("INVALID DATA");
		} else {
			return bd.setAllBus(s);
		}
	}

	public List<Bus> getAllBus() {
		return bd.getAllBus();
	}

	public Bus getById(int id) throws IdNotFoundException {
		return bd.getById(id);
	}

	public List<Bus> getByBrand(String b) throws BrandNotFoundException {
		List<Bus> x = bd.getByBrand(b);
		if (x.isEmpty()) {
			throw new BrandNotFoundException("BUS NOT FOUND");
		} else {
			return x;
		}

	}

	public String update(int id, Bus b) throws IdNotFoundException, InvalidBoardException {
		Bus x= getById(id);
		Bus y= b;
		x.setId(id);
		x.setName(y.getName());
		x.setBoard(y.getBoard());
		x.setBrand(y.getBrand());
		x.setType(y.getType());
		x.setNoPlate(y.getNoPlate());
		setBus(x);
		return "Updated";
	}
}
