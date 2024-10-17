import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { signin } from './signin';

@Injectable({
  providedIn: 'root'
})
export class SignInService {

  private _baseUrl = "http://localhost:8080"; // Make sure this is the correct API endpoint

  constructor(private http: HttpClient) {}




  loginUser(login:signin):Observable<signin>{
    // console.log(login);
    return this.http.post<signin>(`${this._baseUrl}/employees/login`,login);
  }

  getUserDetails(bemsId: number): Observable<any> {
    return this.http.get(`${this._baseUrl}/employees/name/${bemsId}`);
  }

  getProfile(bemsId:number):Observable<any>{
    return this.http.get(`${this._baseUrl}/employees/profile/${bemsId}`);
  }

  getColleagues(managerName: string): Observable<any> {
  return this.http.get(`${this._baseUrl}/employees/manager/${managerName}`);
}



}
