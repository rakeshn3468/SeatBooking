package com.example.SeatBooking.Schedule;

import com.example.SeatBooking.Entities.Booking;
import com.example.SeatBooking.Repositories.BookingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AvailabilityUpdateTask {


  private BookingRepository bookingRepository;

  public AvailabilityUpdateTask(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  @Scheduled(fixedRate = 60000)
  public void updateAvailability() {
    System.out.println("Scheduled task running...");
    Date currentDate = new Date();
    List<Booking> bookings = this.bookingRepository.findAll();


    for (Booking booking : bookings) {


      boolean availabilityStatus = booking.getTo_date().before(currentDate);

      booking.setAvailabilityStatus(availabilityStatus);
      this.bookingRepository.save(booking);
    }
  }



}
