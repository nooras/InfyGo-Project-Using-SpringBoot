package com.infyGo.service;

import com.infyGo.entity.Flight;

public interface FlightService {

	public String addFlight(Flight flight);
	
	public Flight searchFlight(String flightId);
}
