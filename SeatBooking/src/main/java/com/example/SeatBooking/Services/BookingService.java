package com.example.SeatBooking.Services;

import com.example.SeatBooking.Entities.Booking;
import com.example.SeatBooking.Repositories.BookingRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service

public class BookingService {
  private BookingRepository bookingRepository;

  public BookingService(BookingRepository bookingRepository) {
    this.bookingRepository = bookingRepository;
  }

  public List<Booking> getAllBooking() {
    return this.bookingRepository.findAll();
  }

  public Booking addBookingDetails(Booking booking) {
    return this.bookingRepository.save(booking);
  }

  public ResponseEntity<Booking> updateBooking(Integer bookingId, Booking booking) {
    Optional<Booking> exist = this.bookingRepository.findById(bookingId);
    if (exist.isPresent()) {
      Booking toUpdate = exist.get();
      toUpdate.setAvailabilityStatus(booking.getAvailabilityStatus());
      toUpdate.setBooking_date(booking.getBooking_date());
      toUpdate.setDuration(booking.getDuration());
      toUpdate.setBemsId(booking.getBemsId());
      toUpdate.setTo_date(booking.getTo_date());
      toUpdate.setSeatId(booking.getSeatId());
      toUpdate.setTowerName(booking.getTowerName());
      toUpdate.setFloorNumber(booking.getFloorNumber());
      Booking b = this.bookingRepository.save(toUpdate);
      return ResponseEntity.ok(b);
    } else {
      throw new MissingResourceException("not found", Booking.class.getName(), "Booking_ID");
    }
  }

  public ResponseEntity<Booking> deleteBooking(Integer bookingId) {
    Optional<Booking> exist = this.bookingRepository.findById(bookingId);
    if (exist.isPresent()) {
      Booking toDelete = exist.get();
      this.bookingRepository.delete(toDelete);
      return ResponseEntity.noContent().build();

    } else {
      throw new MissingResourceException("not found", Booking.class.getName(), "Booking_ID");
    }


  }


  public Booking updateDuration(Booking booking) {
    return this.bookingRepository.save(booking);
  }

  public List<Booking> findBookings(Integer seatId, String towerName, Integer floorNumber) {
    return this.bookingRepository.findBookingsBySeatIdAndTowerNameAndFloorNumber(seatId, towerName, floorNumber);
  }



  public List<Booking> getBookingsWithDurationGreaterThanEqual(int duration,boolean status) {
    return bookingRepository.findByAvailabilityStatusAndDurationGreaterThanEqual(status,duration);
  }




  public ResponseEntity<Booking> rejectRequest(Integer booking) {
    Optional<Booking> exist=this.bookingRepository.findById(booking);
    if(exist.isPresent()){
      Booking b= exist.get();
      this.bookingRepository.delete(b);
      return ResponseEntity.ok().build();
    }
    else{
      throw new MissingResourceException("gjsb",Booking.class.getName(),"Booking_Id");
    }
  }

  public List<Booking> getBookingsByBemsId(int bemsId) {
    return this.bookingRepository.getBookingsByBemsId(bemsId);
  }
}
