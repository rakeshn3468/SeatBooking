package com.example.SeatBooking.Services;

import com.example.SeatBooking.Entities.Seat;
import com.example.SeatBooking.Repositories.SeatRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Optional;

@Service
public class SeatService {
  private SeatRepository seatRepository;

  public SeatService(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  public List<Seat> getAllSeat() {
    return this.seatRepository.findAll();
  }

  public Seat addSeat(Seat seat) {
    return this.seatRepository.save(seat);
  }

  public ResponseEntity<Seat> updateSeat(Integer Seat_ID, Seat seat) {
    Optional<Seat> existSeat = this.seatRepository.findById(Seat_ID);
    if (existSeat.isPresent()) {
      Seat toUpdate = existSeat.get();
      toUpdate.setSeat_ID(seat.getSeat_ID());
      toUpdate.setFloor_Number(seat.getFloor_Number());
      Seat updated = this.seatRepository.save(toUpdate);
      return ResponseEntity.ok(updated);
    } else {
      throw new MissingResourceException("Not Found", Seat.class.getName(), "Seat_ID");
    }
  }

  public ResponseEntity<Seat> deleteSeat(Integer Seat_ID) {
    Optional<Seat> exist = this.seatRepository.findById(Seat_ID);
    if (exist.isPresent()) {
      Seat toDelete = exist.get();
      this.seatRepository.delete(toDelete);
      return ResponseEntity.noContent().build();

    } else {
      throw new MissingResourceException("Not found", Seat.class.getName(), "Seat_ID");
    }

  }
}
