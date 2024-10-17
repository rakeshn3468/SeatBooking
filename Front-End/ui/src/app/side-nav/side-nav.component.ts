import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-side-nav',
  templateUrl: './side-nav.component.html',
  styleUrls: ['./side-nav.component.css']
})
export class SideNavComponent {

  @Input() sideNavStatus: boolean = true;
  list = [
    {
      number: '1',
      name: 'Home',
      icon: 'fa-solid fa-house',
      title: 'Click here to go to homepage',
      routeTo: '/home'
    },
   
    {
      number: '3',
      name: 'New Booking',
      icon: 'fa-solid fa-plus',
      title: 'Click here to book a new seat',
      routeTo: '/new-booking'
    },
    {
      number: '4',
      name: 'Feedback',
      icon: 'fa-solid fa-comments',
      title: 'Click here to give your valuable feedback on the app',
      routeTo: '/feedback'
    },


  ]

  constructor(){}

  ngOnInit(): void {
    
  }
  


}
