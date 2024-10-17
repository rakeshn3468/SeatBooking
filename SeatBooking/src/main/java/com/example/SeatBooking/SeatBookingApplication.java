package com.example.SeatBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SeatBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeatBookingApplication.class, args);
	}

}
