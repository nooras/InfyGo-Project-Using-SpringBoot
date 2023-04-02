package com.infyGo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infyGo.entity.Flight;

@Repository
public class FlightRepositoryImpl implements FlightRepository {
	
	List<Flight> flightList = new ArrayList<>();

	@Override
	public void addFlight(Flight flight) {
		flightList.add(flight);
	}

	@Override
	public Flight searchFlight(String flightId) {
		for(Flight f: flightList) {
			if(flightId.equalsIgnoreCase(f.getFlightId())) {
				return f;
			}
		}
		return null;
	}

}
