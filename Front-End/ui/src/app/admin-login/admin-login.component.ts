import { Component } from '@angular/core';
import { signin } from '../signin';
import { SignInService } from '../sign-in.service';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';

@Component({
  selector: 'app-admin-login',
  templateUrl: './admin-login.component.html',
  styleUrls: ['./admin-login.component.css']
})
export class AdminLoginComponent {
  Bems_ID!:number;
  First_Name!:string;
  Last_Name!:string;
  Email!:string;
  Password!:string;
  Confirm_Password!:string;
  Manager_Name: string | null = null;
  Team_Lead_Name: string | null = null;

  

  constructor( private adminService:AdminService,private router: Router){


  }
  ngOnInit()  {
    
  }
 



    signInButton() {
    console.log("Button clicked");
    if (this.Bems_ID && this.Password) {
        console.log("Credentials are present");
        const login = new signin(this.Bems_ID, this.Password);

        this.adminService.loginAdmin(login).subscribe({
            next: (data) => {
                console.log("Login successful");
                alert('Login Successful');
                
                this.router.navigate(['admin-home']);
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
