import { Component, EventEmitter, Output } from '@angular/core';
import { SignInService } from '../sign-in.service';
import { Router } from '@angular/router';
import { signin } from '../signin';

@Component({
  selector: 'app-sign-in',
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
    // @Output() bemsIdEmitter = new EventEmitter<number>();
  Bems_ID!:number;
 
  Password!:string;
  

  

  constructor( private signinService:SignInService,private router: Router){


  }
  ngOnInit()  {
    
  }
 



  signInButton() {
    console.log("Button clicked");
    console.log("Bems_ID:", this.Bems_ID); 
    
    if (this.Bems_ID && this.Password) {
      // console.log("Credentials are present");
      console.log(this.Bems_ID);
    
      const login = new signin(this.Bems_ID, this.Password);
  
      this.signinService.loginUser(login).subscribe({
          next: (data) => {
              console.log("Login successful");
              alert('Login Successful');
              localStorage.setItem('Bems_ID', this.Bems_ID.toString());
              this.router.navigate(['home']);
          },
          error: (error) => {
              console.log("Login failed:", error);
              alert('Login Failed. Please check your credentials.');
          },
      });
    } else {
      alert("Credentials are missing");
    }
  }
  
    
    
}



