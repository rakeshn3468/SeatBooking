import { Component, EventEmitter, OnInit, Output, ViewChild } from '@angular/core';

import { FloorLayoutComponent } from '../floor-layout/floor-layout.component';
import { BookingDetailsService } from '../booking-details.service';
import { BookingDetails } from '../booking-details';
import { SignInComponent } from '../sign-in/sign-in.component';
import { HttpClient } from '@angular/common/http';

interface Tower {
  towerName: string;
}

interface Floor{
  floor_Number:number;
}

@Component({
  selector: 'app-new-booking',
  templateUrl: './new-booking.component.html',
  styleUrls: ['./new-booking.component.css']
})



export class NewBookingComponent implements OnInit{


  Bems_ID:number=1;
  Duration:number=0;
  Availability_Status:boolean=false;
  Booking_ID!:number;
  selectedTower!: string;
  selectedFloor!: number;
  fromDate!: Date;
  toDate!: Date;
  towerNames: string[] = [];
  floorNumbers: number[] = [];




  constructor(private bookingService:BookingDetailsService,private http: HttpClient){}
  ngOnInit() {
    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }

    this.fetchTowerData();
    this.fetchFloorData();

  }


  fetchTowerData() {
    this.http.get<Tower[]>('http://localhost:8080/tower').subscribe(
      (data) => {
        console.log(data);
        this.towerNames = data.map(item => item.towerName);
      },
      (error) => {
        console.error('Error fetching tower data:', error);
      }
    );
  }

  fetchFloorData(){
    this.http.get<Floor[]>('http://localhost:8080/floor').subscribe(
      (data)=>{
        console.log(data)
        this.floorNumbers=data.map(item=>item.floor_Number);
      },
      (error)=>{
        console.error('Error occured while fetching floors')
      }
    )
  }




  @ViewChild(FloorLayoutComponent) floorPlanComponent!: FloorLayoutComponent;


  
  

  book() {
    // Trigger booking process and log the selected values
    console.log(`Seat Number: ${this.floorPlanComponent.selectedSeat}`);
    console.log(`Floor: ${this.selectedFloor}`);
    console.log(`Tower: ${this.selectedTower}`);
    console.log(`From Date: ${this.fromDate}`);
    console.log(`To Date: ${this.toDate}`);

    if(this.selectedTower&&this.selectedTower &&this.floorPlanComponent.selectedSeat&&this.toDate&&this.fromDate){
      const details=new BookingDetails(this.floorPlanComponent.selectedSeat,this.selectedTower,this.selectedFloor,this.Bems_ID,this.Duration,this.Availability_Status,this.fromDate,this.Booking_ID,this.toDate);
      this.bookingService.registerBooking(details).subscribe({
        next:(_)=>{
          alert('booking confirmed');
          localStorage.setItem('bookingDetails', JSON.stringify(details));
          window.location.href = '/confirmPage';

        },error:(err)=>{
          console.error(err);
        }
      })
    }





  }

}