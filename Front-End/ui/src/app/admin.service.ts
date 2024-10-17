import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Admin } from './admin';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  private _baseUrl = "http://localhost:8080"; // Make sure this is the correct API endpoint

  constructor(private http: HttpClient) {}

  loginAdmin(a:Admin):Observable<Admin>{
    return this.http.post<Admin>(`${this._baseUrl}/admin/login`,a);
  }

 
}
