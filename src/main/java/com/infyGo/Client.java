package com.infyGo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infyGo.entity.Flight;
import com.infyGo.service.FlightServiceImpl;

@SpringBootApplication
public class Client {
	public static void main(String[] args) {
		FlightServiceImpl service = null;
		AbstractApplicationContext context = (AbstractApplicationContext) SpringApplication
				.run(Client.class, args);
		service = (FlightServiceImpl) context.getBean("flightService");
		
		Flight flight = new Flight();
		flight.setFlightId(String.valueOf(Flight.getIdCounter()));
		
		Scanner sc= new Scanner(System.in);    //System.in is a standard input stream 
		
		System.out.println("Enter Destination:  ");  
		flight.setDestination(sc.next());  
		
		System.out.println("Enter Source: ");  
		flight.setSource(sc.next());
		
		System.out.println("Enter Airline: ");  
		flight.setAirlines(sc.next());  
		
		System.out.println("Enter Total Seat Count: ");  
		flight.setSeatCount(sc.nextInt()); 
		
		System.out.println("Enter Fare per seat: ");  
		flight.setFare((double) sc.nextInt()); 
		
		System.out.println("Enter Date: Ex: 12/02/2024 dd/MM/yyyy ");  
		String date = sc.next();  
		// Define a formatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Parse the date string to LocalDate using the formatter
        LocalDate theDate = LocalDate.parse(date, formatter);
		flight.setJourneyDate(theDate);
		
		System.out.println("Adding Flight Details...");
		System.out.println(service.addFlight(flight));
		
		System.out.println("Searching Flight Details of 1001...");
		Flight searchFlight = service.searchFlight("1001");
		System.out.println("Id: " + searchFlight.getFlightId());
		System.out.println("Destination: " + searchFlight.getDestination());
		System.out.println("Source: " + searchFlight.getSource());
		System.out.println("Airlines: " + searchFlight.getAirlines());
		System.out.println("Seat Count: " + searchFlight.getSeatCount());
		
		LocalDate jd = searchFlight.getJourneyDate();
		System.out.println("Date: " + jd);
		System.out.println("Fare: " + (jd.getMonthValue() == 12 || jd.getMonthValue() == 1 ? searchFlight.getFare() * 0.20 +  searchFlight.getFare() : searchFlight.getFare()));
		
		context.close();
		sc.close();
	}

}

/*

OUTPUT:

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::               (v2.7.10)

2023-04-02 12:17:41.888  INFO 13164 --- [           main] com.infyGo.Client                        : Starting Client using Java 1.8.0_281 on DESKTOP-BDS3F58 with PID 13164 (C:\Users\Lenovo\Desktop\spring-projects\InfyGo-Project-Using-SpringBoot\target\classes started by Lenovo in C:\Users\Lenovo\Desktop\spring-projects\InfyGo-Project-Using-SpringBoot)
2023-04-02 12:17:41.894  INFO 13164 --- [           main] com.infyGo.Client                        : No active profile set, falling back to 1 default profile: "default"
2023-04-02 12:17:43.694  INFO 13164 --- [           main] com.infyGo.Client                        : Started Client in 2.671 seconds (JVM running for 4.008)
Enter Destination:  
Japan
Enter Source: 
Mumbai
Enter Airline: 
InfyGo
Enter Total Seat Count: 
25
Enter Fare per seat: 
2500
Enter Date: Ex: 12/02/2024 dd/MM/yyyy 
12/01/2023
Adding Flight Details...
Before proceeding part of the Around advice.
2023-04-02 12:18:03.458  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : In AfterReturning Advice, Joinpoint signature :String com.infyGo.service.FlightServiceImpl.addFlight(Flight)
2023-04-02 12:18:03.461  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : In After Advice, Joinpoint signature :String com.infyGo.service.FlightServiceImpl.addFlight(Flight)
2023-04-02 12:18:03.462  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : Report generated at time 2 Apr, 2023 12:18:03 PM
After proceeding part of the Around advice.
Flight Inserted of ID: 1001
Searching Flight Details of 1001...
Before proceeding part of the Around advice.
2023-04-02 12:18:03.463  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : In AfterReturning Advice, Joinpoint signature :Flight com.infyGo.service.FlightServiceImpl.searchFlight(String)
2023-04-02 12:18:03.463  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : In After Advice, Joinpoint signature :Flight com.infyGo.service.FlightServiceImpl.searchFlight(String)
2023-04-02 12:18:03.463  INFO 13164 --- [           main] com.infyGo.util.LoggingAspect            : Report generated at time 2 Apr, 2023 12:18:03 PM
After proceeding part of the Around advice.
Id: 1001
Destination: Japan
Source: Mumbai
Airlines: InfyGo
Seat Count: 25
Date: 2023-01-12
Fare: 3000.0

*/
