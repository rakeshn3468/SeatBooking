import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BookingDetails } from './booking-details';
import { Observable } from 'rxjs';
import { Tower } from './tower';
import { Floor } from './floor';

@Injectable({
  providedIn: 'root'
})
export class BookingDetailsService {
  private _baseUrl = "http://localhost:8080";

  constructor(private http: HttpClient) {}

  registerBooking(book:BookingDetails):Observable<BookingDetails>{
    return this.http.post<BookingDetails>(`${this._baseUrl}/booking/duration`,book);
  }

  getAllBooking():Observable<any>{
    return this.http.get<any>(`${this._baseUrl}/booking`);
  }

  checkSeatAvailability(towerName: string, floorNumber: number, seatID: number): Observable<any> {
     
    return this.http.get<any>(`${this._baseUrl}/booking/${towerName}/${floorNumber}/${seatID}`);
  }

  getEmployeesWithNullManagerAndTeamLead(): Observable<number[]> {
    return this.http.get<number[]>(`${this._baseUrl}/employees/managers`);
  }

  getBookingHistory(bemsId:number):Observable<any>{
    return this.http.get<any>(`${this._baseUrl}/booking/bems/${bemsId}`);

  }


  getEmployeesWithNullTeamLead():Observable<number[]>{
    return this.http.get<number[]>(`${this._baseUrl}/employees/team-leads`);
  }

  getRequestBooking(duration:number,status:boolean):Observable<any>{
    return this.http.get<any>(`${this._baseUrl}/booking/${duration}/${status}`);
  }

  Reject(bookingId:number):Observable<any>{
    return this.http.delete<any>(`${this._baseUrl}/booking/reject/${bookingId}`);
  }

  getEmployeesWithManagerAndTeamLead():Observable<number[]>{
    return this.http.get<number[]>(`${this._baseUrl}/employees/individuals`);
  }

  addTower(a:Tower):Observable<any>{
    return this.http.post<any>(`${this._baseUrl}/tower/add`,a);
  }

  addFloors(f:Floor):Observable<any>{
    return this.http.post<any>(`${this._baseUrl}/floor/add`,f);
  }


}
