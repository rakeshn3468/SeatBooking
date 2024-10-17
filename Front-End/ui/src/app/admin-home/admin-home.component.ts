import { Component } from '@angular/core';
import { BookingDetailsService } from '../booking-details.service';
import { Tower } from '../tower';
import { Floor } from '../floor';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  tower!:string;
  floor!:number;

  constructor(private bookingService:BookingDetailsService){}

  addTower(){
    if(this.tower){
      console.log(this.tower)
      const t=new Tower(this.tower);
      this.bookingService.addTower(t).subscribe(
        (data)=>{
          alert('Tower Added')
        }
      )

      }
    }
    addFloors(){
      if(this.floor){
        console.log(this.floor);
        const f=new Floor(this.floor);
        this.bookingService.addFloors(f).subscribe(
          (data)=>{
            alert('floor are added');
          }
        )
      }
    }
  }

    

