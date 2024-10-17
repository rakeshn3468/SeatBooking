import { Component, OnInit } from '@angular/core';
import { BookingDetails } from '../booking-details';
import { Router } from '@angular/router';

@Component({
  selector: 'app-confirm-page',
  templateUrl: './confirm-page.component.html',
  styleUrls: ['./confirm-page.component.css']
})
export class ConfirmPageComponent implements OnInit {
  bookingDetails: BookingDetails | null = null;

  Seat_Id!:number;
  from_date!:Date;
  to_date!:Date;
  tower!:string;
  floor!:number;

  constructor(private router:Router){}


  ngOnInit() {
    const storedDetails = localStorage.getItem('bookingDetails');
    if (storedDetails) {
      this.bookingDetails = JSON.parse(storedDetails);
      this.Seat_Id = this.bookingDetails?.seatId || 0; // Assign a default value if seatId is undefined
      this.tower = this.bookingDetails?.towerName || '';
      this.floor = this.bookingDetails?.floorNumber || 0;
      this.from_date = this.bookingDetails?.booking_date ? new Date(this.bookingDetails.booking_date) : new Date(); // Assign a default date if booking_date is undefined
      this.to_date = this.bookingDetails?.to_date ? new Date(this.bookingDetails.to_date) : new Date(); // Assign a default date if to_date is undefined
    }
  }
  
  
  confirmBooking(){
    this.router.navigate(['thankyou'])
  }

}
