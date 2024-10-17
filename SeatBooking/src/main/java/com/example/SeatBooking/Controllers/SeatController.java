package com.example.SeatBooking.Controllers;

import com.example.SeatBooking.Entities.Seat;
import com.example.SeatBooking.Services.SeatService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.MissingResourceException;

@RestController
@RequestMapping("/seat")
public class SeatController {
  private SeatService seatservice;

  public SeatController(SeatService seatservice) {
    this.seatservice = seatservice;
  }
  @GetMapping
  public List<Seat> getAllSeat(){ return this.seatservice.getAllSeat();}

  @PostMapping("/add")
  public Seat addSeat(@RequestBody Seat seat){ return this.seatservice.addSeat(seat);}

  @PutMapping("/{Seat_ID}")
  public ResponseEntity<Seat> updateSeat(@PathVariable Integer Seat_ID, @RequestBody Seat seat)
  {
    try{
      return this.seatservice.updateSeat(Seat_ID, seat);
    }
    catch(MissingResourceException e)
    {
      return ResponseEntity.notFound().build();
    }
  }

  @DeleteMapping
  public ResponseEntity<Seat> deleteSeat(@PathVariable Integer Seat_ID){
    try{
      return this.seatservice.deleteSeat(Seat_ID);
    }
    catch (MissingResourceException e)
    {
      return ResponseEntity.notFound().build();
    }
  }

}
