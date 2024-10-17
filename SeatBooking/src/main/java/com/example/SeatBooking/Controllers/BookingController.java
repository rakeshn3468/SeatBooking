package com.example.SeatBooking.Controllers;

import com.example.SeatBooking.Entities.Booking;
import com.example.SeatBooking.Services.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/booking")
public class BookingController {


  private BookingService bookingService;

  public BookingController(BookingService bookingService) {
    this.bookingService = bookingService;
  }

  @GetMapping
  public List<Booking> getAll(){
    return this.bookingService.getAllBooking();
  }

  @PostMapping("/add")
  public Booking addBook(@RequestBody  Booking booking){
    return this.bookingService.addBookingDetails(booking);
  }

  @PutMapping("/{Booking_ID}")
  public ResponseEntity<Booking> update(@PathVariable Integer Booking_ID,@RequestBody Booking booking){
    try{
      return this.bookingService.updateBooking(Booking_ID,booking);
    }
    catch(MissingResourceException e){
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping("/{Booking_ID}")
  public ResponseEntity<Booking> delete(@PathVariable Integer Booking_ID){
    try{
      return this.bookingService.deleteBooking(Booking_ID);
    }
    catch(MissingResourceException e){
      return ResponseEntity.notFound().build();
    }

  }

  // BookingController.java

  @GetMapping("/bems/{bemsId}")
  public List<Booking> getBookingsByBemsId(@PathVariable int bemsId) {
    return bookingService.getBookingsByBemsId(bemsId);
  }



  // In BookingController.java
  @PostMapping("/duration")
  public Booking addBooking(@RequestBody Booking booking) {
    // Calculate the Duration based on Booking_date and To_date
    long durationInMillis = booking.getTo_date().getTime() - booking.getBooking_date().getTime();
    int durationInDays = (int) (durationInMillis / (1000 * 60 * 60 * 24))+1;
    booking.setDuration(durationInDays);
    booking.setAvailabilityStatus(false);

    // Save the booking
    return this.bookingService.updateDuration(booking);
  }

  @GetMapping("/{Tower_Name}/{Floor_Number}/{Seat_ID}")
  public ResponseEntity<Map<String, String>> checkSeatAvailability(
    @PathVariable String Tower_Name,
    @PathVariable Integer Floor_Number,
    @PathVariable Integer Seat_ID) {

    List<Booking> bookings = bookingService.findBookings(Seat_ID, Tower_Name, Floor_Number);

    if (!bookings.isEmpty()) {
      boolean allAvailable = bookings.stream().allMatch(Booking::getAvailabilityStatus);

      if (allAvailable) {
        return ResponseEntity.ok(Collections.singletonMap("message", "The seat is available."));
      } else {
        return ResponseEntity.ok(Collections.singletonMap("message", "The seat is not available."));
      }
    } else {
      return ResponseEntity.ok(Collections.singletonMap("message", "The seat is available."));
    }
  }



  @GetMapping("/{duration}/{status}")
  public List<Booking> getBookingsWithDurationGreaterThanEqual(@PathVariable int duration,@PathVariable boolean status ) {
    return this.bookingService.getBookingsWithDurationGreaterThanEqual(duration,status);
  }





  @DeleteMapping("/reject/{bookingId}")
  public ResponseEntity<Booking> rejectRequest( @PathVariable  Integer bookingId){
    try{
      return this.bookingService.rejectRequest(bookingId);
    }
    catch(MissingResourceException e){
      return ResponseEntity.noContent().build();
    }
  }

}


