import { Component } from '@angular/core';


@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent {

  title = 'HomepageNew';
  sideNavStatus: boolean = true;
  english : boolean = false;
  hindi : boolean = false;



  englishWelcome() {
    this.english = true;
    this.hindi = false;
  }

  hindiWelcome() {
    this.english = false;
    this.hindi = true;
  }

  persons = [
    {
      name:'Rakesh Nagaraj',
      imgUrl:'./assets/RakeshN.jpg.crdownload',
      professionTitle:'JAVA Fullstack Developer',
      exp: '2 Months',
      hobby: 'Cricket'
    },
    {
      name:'Rakesh Shekar',
      imgUrl:'./assets/RakeshS.webp.crdownload',
      professionTitle:'JAVA Fullstack Developer',
      exp: '2 Months',
      hobby: 'Volleyball'
    },
    {
      name:'Sahithi Shanmukhi',
      imgUrl:'./assets/Shanmukhi.webp.crdownload',
      professionTitle:'JAVA Fullstack Developer',
      exp: '2 Months',
      hobby: 'Dancing'
    },
    {
      name:'Thanmayi Yogesha',
      imgUrl:'./assets/Thanmayi.jpg.crdownload',
      professionTitle:'JAVA Fullstack Developer',
      exp: '2 Months',
      hobby: 'Travelling'
    },
    {
      name:'Pradeep Kumar S',
      imgUrl:'./assets/Pradeep.jpg.crdownload',
      professionTitle:'JAVA Fullstack Developer',
      exp: '2 Months',
      hobby: 'Whistling'
    }
  ]

  trainers = [
    'Vyshnavi',
'Pravanjan Padhihari',
'Bharath KL',
'Vamsi Krishna Samuru',
'Satyendra Kumar Patel',
'Bharat Kumar Pydi',
'Mithun Mandayam Comar',
'Radheshyam Baliga Bantwal',
'Vijay Kundapur',
'Shrey Baxi',
'Ganesh Bandi',
'Manjunath Sharanappa Koralli',
'Inbarasu Aravindan',
'Aaditya Kumar',
'Ravi Ranjan Kumar',
'Suresh Kumar Ramachandran',
'Prabhat Kumar',
'Surya Patro',
'Damien',
'Prajwal',
'Karthik',
'Hassan',
'Chaitanya'
]


}
