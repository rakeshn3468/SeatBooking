import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { SignInService } from '../sign-in.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit{
  @Output() sideNavToggled = new EventEmitter<boolean>();
  menuStatus : boolean = true;

  firstName!:string;
  Bems_ID!:number;
  lastName!:string;
  constructor(private signinService:SignInService){}

  ngOnInit() {
    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }

    this.signinService.getUserDetails(this.Bems_ID).subscribe(data=>{
      this.firstName = data.first_name;
      this.lastName = data.last_name;
    })
    
  }

  SideNavToggle(){
    this.menuStatus = !this.menuStatus;
    this.sideNavToggled.emit(this.menuStatus); 
  }

}
