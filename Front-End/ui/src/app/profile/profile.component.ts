import { Component, OnInit } from '@angular/core';
import { SignInService } from '../sign-in.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  First_Name!:string;
  Last_Name!:string;
  Email!:string
  Password!:string;
  Manager_Name!:string;
  Team_Lead_Name!:string;
  Bems_ID!:number;
  a!:number;
  constructor(private service:SignInService){}
  ngOnInit(){
    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }
    this.service.getProfile(this.Bems_ID).subscribe(data=>{
      console.log(data)
      this.First_Name=data.first_name;
      this.Last_Name=data.last_name;
      this.Email=data.Email;
      // this.Password=data.Password;
      // this.a=data.bemsId;
      // console.log(this.Manager_Name);

      this.Manager_Name=data.Manager_Name;


      this.Team_Lead_Name=data.TeamLead_Name
    }

    )
  }

}

// this.signinService.getUserDetails(this.Bems_ID).subscribe(data=>{
//   this.firstName = data.first_name;
//   this.lastName = data.last_name;
// })