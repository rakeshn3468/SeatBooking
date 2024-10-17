package com.example.SeatBooking.Repositories;

import com.example.SeatBooking.Entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
  List<Booking> findBookingsBySeatIdAndTowerNameAndFloorNumber(Integer seatId, String towerName, Integer floorNumber);
  List<Booking> findByAvailabilityStatusAndDurationGreaterThanEqual(boolean availabilityStatus,int duration);

  List<Booking> getBookingsByBemsId(int bemsId);


}




