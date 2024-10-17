import { Component } from '@angular/core';
import { Feedback } from '../feedback';
import { FeedbackService } from '../feedback.service';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})
export class FeedbackComponent {
  stars: number[] = [1, 2, 3, 4, 5];
  rating: number = 0;
  comments: string = '';
  isFeedbackSubmitted: boolean = false;

  constructor(private s :FeedbackService){}

  setRating(rating: number) {
    this.rating = rating;
  }

  submitFeedback() {
    if (this.rating > 0 && this.comments.trim() !== '') {
      this.isFeedbackSubmitted = true;
      alert('Thank you for the feedback');
      this.clearFeedback();

    } else {
      alert('Please select a rating and provide comments');
    }
  }

  onSubmit(){
    if(this.comments&&this.rating){
      const f = new Feedback(this.rating,this.comments);
    // console.log(this.BEMSID);
    this.s.postFeedback(f).subscribe({
      next:(_)=>{
        alert("Feeback submitted successfully")
      },error:(err)=>console.error(err)
        
      
      
    })
    }
    else{
      alert("Invalid input");
    }
  }


  clearFeedback() {
    this.rating = 0;
    this.comments = '';
    this.isFeedbackSubmitted = false;
  }

}
