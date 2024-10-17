import { Component, OnInit } from '@angular/core';
import { SignInService } from '../sign-in.service';

@Component({
  selector: 'app-colleague',
  templateUrl: './colleague.component.html',
  styleUrls: ['./colleague.component.css']
})
export class ColleagueComponent implements OnInit {
  colleagues!: any[];
  Bems_ID!:number;
  Manager_Name!:string;

  constructor (private service:SignInService){};

  ngOnInit(): void {
    const storedBems_ID = localStorage.getItem('Bems_ID');
    if (storedBems_ID) {
      this.Bems_ID = +storedBems_ID; 
    }

    
    this.service.getProfile(this.Bems_ID).subscribe(data => {
        console.log(data)
        const managerName = data.Manager_Name;
        console.log(managerName);

        this.service.getColleagues(managerName).subscribe(colleagueData => {
            this.colleagues = colleagueData;
        });
    });
}

    

    
   
  }


