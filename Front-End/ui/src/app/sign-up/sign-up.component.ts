import { Component, OnInit } from '@angular/core';
import { Users } from '../users';
import { SignUpService } from '../sign-up.service';
// import { signin } from '../signIn';
import { Router, RouterModule, Routes } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  Bems_ID!:number;
  First_Name!:string;
  Last_Name!:string;
  Email!:string;
  Password!:string;
  Confirm_Password!:string;
  Manager_Name: string | null = null;
  Team_Lead_Name: string | null = null;

  

  constructor( private signupService:SignUpService,private router: Router){


  }
  ngOnInit()  {
    
  }
  users: Users[] = [];

  
  
  // initialisation
  selectedRole: string = 'none';
  managerNameDisplay: string = 'none';
  tlNameDisplay: string = 'none';

  //hiding details based on the role
  onRoleChange() {
    if (this.selectedRole === 'I') {
      this.managerNameDisplay = 'block';
      this.tlNameDisplay = 'block';
    } else if (this.selectedRole === 'manager') {
      this.managerNameDisplay = 'none';
      this.tlNameDisplay = 'none';
    } else if (this.selectedRole === 'TL') {
      this.managerNameDisplay = 'block';
      this.tlNameDisplay = 'none';
    }
  }

  signUpButton() {
    //if any of the value is null give error
    if (
      this.Bems_ID &&
      this.First_Name &&
      this.Last_Name &&
      this.Email &&
      this.Password &&
      this.Confirm_Password
    ) {
      

      //to assign null value based on the roles
      if (this.selectedRole === 'I') {
        this.Manager_Name = this.Manager_Name;
        this.Team_Lead_Name = this.Team_Lead_Name;
      } else if (this.selectedRole === 'manager') {
        this.Manager_Name = null;
        this.Team_Lead_Name = null;
      } else if (this.selectedRole === 'TL') {
        this.Manager_Name = this.Manager_Name; 
        this.Team_Lead_Name = null; 
      }
  
      //using of constructor
      const user = new Users(
        this.Bems_ID,
        this.First_Name,
        this.Last_Name,
        this.Email,
        this.Password,
        this.Confirm_Password,
        this.Team_Lead_Name,
        this.Manager_Name
      );

      if((this.Password.length<6)){
        alert('Password is too short as you :) :)');
        return;
      }
        
      //confirm password and password match alerts :)
      if (this.Password !== this.Confirm_Password) {
        alert("Password and Confirm Password do not match.");
        return; 
      }

      //using service methods to register
      this.signupService.registerUser(user).subscribe({
        next: (_) => {
          
          alert("Successfully Registered!! Redirecting to sign-in page");
          this.router.navigate(['sign-in']);
          
        },
        error: (err) => console.error(err),
      });
    }
    else{
      alert('Credentials are missing')
    }
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////////
  







  


}
