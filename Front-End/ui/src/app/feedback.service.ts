// import { Injectable } from '@angular/core';

import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Feedback } from './feedback';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {
  private baseUrl = "http://localhost:8080";
  constructor(
    private router:Router,
    private http:HttpClient
    
  ) {}

  postFeedback(l:Feedback):Observable<Feedback>{
    console.log(l);
    return this.http.post<Feedback>(`${this.baseUrl}/feedback/add`,l)
  }
}

