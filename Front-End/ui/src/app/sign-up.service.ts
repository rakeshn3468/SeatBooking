import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Users } from './users';


@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private _baseUrl = "http://localhost:8080"; // Make sure this is the correct API endpoint

  constructor(private http: HttpClient) {}

  getAll(): Observable<Users[]> {
    return this.http.get<Users[]>(`${this._baseUrl}/employees`);
  }

  registerUser(users: Users):Observable<Users> {
    // console.log(users);
    return this.http.post<Users>(`${this._baseUrl}/employees/add`, users);
  }

  


}
