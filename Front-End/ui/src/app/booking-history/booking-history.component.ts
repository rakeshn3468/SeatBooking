import { Component, OnInit } from '@angular/core';
import { BookingDetailsService } from '../booking-details.service';

@Component({
  selector: 'app-booking-history',
  templateUrl: './booking-history.component.html',
  styleUrls: ['./booking-history.component.css']
})
export class BookingHistoryComponent implements OnInit {
  bookings: any[] = [];

  constructor(private bookingService: BookingDetailsService) { }

  ngOnInit() {
    this.bookingService.getAllBooking().subscribe(
      (data) => {
        this.bookings = data;
      },
      (error) => {
        console.error('Error fetching booking data:', error);
      }
    );
    
  }


}
