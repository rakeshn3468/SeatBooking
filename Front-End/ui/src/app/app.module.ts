import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { FloorLayoutComponent } from './floor-layout/floor-layout.component';
import { HomePageComponent } from './home-page/home-page.component';
import { SideNavComponent } from './side-nav/side-nav.component';
import { HeaderComponent } from './header/header.component';
import { ProfileComponent } from './profile/profile.component';
import { ColleagueComponent } from './colleague/colleague.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { RequestBookingComponent } from './request-booking/request-booking.component';
import { DatePipe } from '@angular/common';
import { UserBookingHistoryComponent } from './user-booking-history/user-booking-history.component';


@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    SignUpComponent,
    SignInComponent,
    AdminLoginComponent,
    NewBookingComponent,
    FloorLayoutComponent,
    HomePageComponent,
    SideNavComponent,
    HeaderComponent,
    ProfileComponent,
    ColleagueComponent,
    FeedbackComponent,
    ConfirmPageComponent,
    ThankyouComponent,
    AdminHomeComponent,
    BookingHistoryComponent,
    RequestBookingComponent,
    UserBookingHistoryComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,HttpClientModule,RouterModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
