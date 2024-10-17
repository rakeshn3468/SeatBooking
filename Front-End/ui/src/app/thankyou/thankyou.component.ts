import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-thankyou',
  templateUrl: './thankyou.component.html',
  styleUrls: ['./thankyou.component.css']
})
export class ThankyouComponent {
  showGif: boolean = true;
    constructor(private router: Router) {}
    

    returnToHomePage() {
        this.router.navigate(['/home']); 
    }

}
