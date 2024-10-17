import { Component, OnInit } from '@angular/core';
import { BookingDetailsService } from '../booking-details.service';

@Component({
  selector: 'app-user-booking-history',
  templateUrl: './user-booking-history.component.html',
  styleUrls: ['./user-booking-history.component.css']
})
export class UserBookingHistoryComponent implements OnInit {
  bookings: any[] = [];
  Bems_ID!:number;
  constructor(private bookingService: BookingDetailsService) { }
  ngOnInit(): void {

    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }

    this.bookingService.getBookingHistory(this.Bems_ID).subscribe(
      (data) => {
        this.bookings = data;
      },
      (error) => {
        console.error('Error fetching booking data:', error);
      }
    );

    
  }


}
