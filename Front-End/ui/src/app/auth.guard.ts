// auth.guard.ts
import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';

@Injectable({
  providedIn: 'root',
})
export class AuthGuard implements CanActivate {
  authService: any;
  constructor(private router: Router) {}

  canActivate(): boolean {
    // Check if the user is authenticated here (replace with your authentication logic)
    const isAuthenticated = this.authService.isAuthenticated(); // Example: Check if the user is authenticated using a service
  
    if (isAuthenticated) {
      return true; // Allow access to the route
    } else {
      this.router.navigate(['']); // Redirect to the login page if not authenticated
      return false; // Deny access to the route
    }
  }
  
}
