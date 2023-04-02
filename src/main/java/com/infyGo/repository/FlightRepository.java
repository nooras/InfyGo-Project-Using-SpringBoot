package com.infyGo.repository;

import com.infyGo.entity.Flight;

public interface FlightRepository {
	public void addFlight(Flight flight);
	
	public Flight searchFlight(String flightId);
}
