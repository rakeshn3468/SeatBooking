import { Component } from '@angular/core';
import { BookingDetailsService } from '../booking-details.service';

@Component({
  selector: 'app-request-booking',
  templateUrl: './request-booking.component.html',
  styleUrls: ['./request-booking.component.css']
})
export class RequestBookingComponent {

  bookings: any[] = [];
  isApproved!: boolean;

  // booking_ID!:number;

  constructor(private bookingService: BookingDetailsService) { }

  ngOnInit() {
    this.bookingService.getRequestBooking(3,false).subscribe(
      (data) => {
        this.bookings = data
          .filter((booking: { booking_ID: number; }) => !this.approvedBookings.includes(booking.booking_ID));
      },
      (error) => {
        console.error('Error fetching bookings:', error);
      }
    );
    
  }

  approvedBookings: number[] = [];

  approveRequest() {
    // this.approvedBookings.push(booking_ID);
    // this.bookings = this.bookings.filter(booking => booking.booking_ID !== booking_ID);
    alert('Request Approved Successfully');
    // this.isApproved = true;
  }
  
  declineRequest(booking_ID:number){

    this.bookingService.Reject(booking_ID).subscribe(
    (data)=>{
      alert('Request Has been rejected');
    }
    )
  }


}
