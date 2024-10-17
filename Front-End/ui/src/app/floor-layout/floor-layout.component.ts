import { Component, EventEmitter, Input, OnInit, Output, ViewChild } from '@angular/core';
import { NewBookingComponent } from '../new-booking/new-booking.component';
import { HttpClient } from '@angular/common/http';
import { BookingDetailsService } from '../booking-details.service';

@Component({
  selector: 'app-floor-layout',
  templateUrl: './floor-layout.component.html',
  styleUrls: ['./floor-layout.component.css']
})
export class FloorLayoutComponent implements OnInit {

  @Input() floor_Number!: number;
  @Input() tower_Name!: string;

  
  

  individualCabins = [1,2,3,4,5,6,7,8,9,10,11,12];
  managerCabins = [13,14,15];
  meetingRooms = [16,17];

  Bems_ID!:number;
  isNotAllowedToBookIndividualCabins!: boolean;
  isNotAllowedToBookManagerCabins!:boolean;
  isNotAllowedToBookManagerAndMeetingRooms!:boolean;

  allowedtoBookManagerByManager!:boolean;

  


  constructor(private http: HttpClient,private bookService:BookingDetailsService) {}
  ngOnInit(){

    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }
    this.bookService.getEmployeesWithNullManagerAndTeamLead().subscribe(
      bemsId=>{
        const isNotAllowedToBookIndividualCabins = bemsId.includes(this.Bems_ID);

        const yes=bemsId.includes(this.Bems_ID);
        this.allowedtoBookManagerByManager=yes;

      
        
        this.isNotAllowedToBookIndividualCabins = isNotAllowedToBookIndividualCabins;

      }, error => {
        console.error(error);
      }
    );
    this.bookService.getEmployeesWithNullTeamLead().subscribe(
      bemsId=>{
        const isNotAllowedToManagerCabins=bemsId.includes(this.Bems_ID);
        this.isNotAllowedToBookManagerCabins=isNotAllowedToManagerCabins;
      },error=>{
        console.error(error);
      }
      
    );
    this.bookService.getEmployeesWithManagerAndTeamLead().subscribe(
      bemsId=>{
        const isNotAllowedToBookManagerAndMeetingRoom=bemsId.includes(this.Bems_ID);
        this.isNotAllowedToBookManagerAndMeetingRooms=isNotAllowedToBookManagerAndMeetingRoom;
      },error=>{
        console.error(error);
      }
      
    )
    
  }
  

  public selectedSeat:any;
  public selectedSeatType:string="";
  public selectedSeats = new Set<number>(); // Store selected seats

  @Output() seatSelected = new EventEmitter<any>();

  

  getSeatID(individualSeatID: number){

    console.log(this.Bems_ID)
    if (this.isNotAllowedToBookIndividualCabins) {
      alert("Sorry Manager, You are not allowed to book individual cabins.");
      return;
    }
    if (this.selectedSeats.has(individualSeatID)) {
      this.selectedSeats.delete(individualSeatID);
      this.selectedSeat = null;
      this.selectedSeatType = "";
    } else {
      this.selectedSeats.clear(); 
      this.selectedSeat = individualSeatID;
      this.selectedSeatType = "Individual Seat No:";
      this.selectedSeats.add(individualSeatID);
    }
    this.seatSelected.emit({ seat: this.selectedSeat });
  
    // No need to alert the user with this information, you can use it for debugging
    console.log(this.floor_Number+' '+this.tower_Name+' '+this.selectedSeat);
  
    this.bookService.checkSeatAvailability(this.tower_Name,this.floor_Number,this.selectedSeat).subscribe({
      next: (response) => {
          const message = response['message'];
          if (message === "The seat is available.") {
              // alert("Selected seat is available");
          } else {
              alert("Sorry, Selected Seat is not avialble please select other seat");
              const seatElement = document.getElementById(`${individualSeatID}`);
    if (seatElement) {
      seatElement.classList.add('unavailable-seat');
    } else {
      console.error(`Seat element with ID seat-${individualSeatID} not found.`);
    }
          }
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
  
  
  getManagerSeatID(managerSeatID: number){
    if(this.isNotAllowedToBookManagerAndMeetingRooms){
      alert("Sorry you are not Allowed to Book Manager Seat");
      return;
    }



   

    if (this.selectedSeats.has(managerSeatID)) {
      this.selectedSeats.delete(managerSeatID);
      this.selectedSeat = null;
      this.selectedSeatType = "";
    } else {
      this.selectedSeats.clear(); 
      this.selectedSeat = managerSeatID;
      this.selectedSeatType = "Manager Seat No:";
      this.selectedSeats.add(managerSeatID);
    }
    
    this.seatSelected.emit({ seat: this.selectedSeat });
  
    this.bookService.checkSeatAvailability(this.tower_Name,this.floor_Number,this.selectedSeat).subscribe({
      next: (response) => {
        const message = response['message'];
        if (message === "The seat is available.") {
          // Seat is available, handle accordingly
        } else {
          alert("Not available");
  
          // Construct the ID of the seat element based on your HTML structure
          const seatElement = document.getElementById(`M${managerSeatID}`);
          if (seatElement) {
            seatElement.classList.add('unavailable-seat');
          } else {
            console.error(`Seat element with ID M${managerSeatID} not found.`);
          }
        }
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
  
  
  getMeetingRoomID(meetingRoomID: number){
    if(this.isNotAllowedToBookManagerAndMeetingRooms){
      alert("You are not allowed to Book Meeting Rooms");
      return ;
    }

    if (this.selectedSeats.has(meetingRoomID)) {
      this.selectedSeats.delete(meetingRoomID);
      this.selectedSeat = null;
      this.selectedSeatType = "";
    } else {
      this.selectedSeats.clear(); 
      this.selectedSeat = meetingRoomID;
      this.selectedSeatType = "Meeting Room No:";
      this.selectedSeats.add(meetingRoomID);
    }
    this.seatSelected.emit({ seat: this.selectedSeat });
    this.bookService.checkSeatAvailability(this.tower_Name,this.floor_Number,this.selectedSeat).subscribe({
      next: (response) => {
          const message = response['message'];
          if (message === "The seat is available.") {
              // alert("Selected seat is available");
          } else {
              alert("Not available");
              const seatElement = document.getElementById(`MR${meetingRoomID}`);
    if (seatElement) {
      seatElement.classList.add('unavailable-seat');
    } else {
      console.error(`Seat element with ID seat-${meetingRoomID} not found.`);
    }
          }
      },
      error: (err) => {
        console.error(err);
      }
    });
  }
  


bookSeat(){
  // Add any booking logic if needed
  this.selectedSeats.clear(); // Clear selectedSeats after booking
  this.selectedSeat = null; // Reset selected seat
}

// ... (existing code) ...


  isSeatSelected(seatID: number): boolean {
    return this.selectedSeats.has(seatID);
  }

}
