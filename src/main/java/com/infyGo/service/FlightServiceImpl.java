package com.infyGo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infyGo.entity.Flight;
import com.infyGo.repository.FlightRepository;
import com.infyGo.repository.FlightRepositoryImpl;

@Service("flightService")
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository fr = new FlightRepositoryImpl();

	@Override
	public String addFlight(Flight flight) {
		fr.addFlight(flight);
		return "Flight Inserted of ID: " + flight.getFlightId();
	}

	@Override
	public Flight searchFlight(String flightId) {
		return fr.searchFlight(flightId);
	}

}
