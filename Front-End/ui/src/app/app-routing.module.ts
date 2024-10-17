import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignUpComponent } from './sign-up/sign-up.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { AdminLoginComponent } from './admin-login/admin-login.component';
import { AuthGuard } from './auth.guard';
import { NewBookingComponent } from './new-booking/new-booking.component';
import { HomePageComponent } from './home-page/home-page.component';
import { ProfileComponent } from './profile/profile.component';
import { ColleagueComponent } from './colleague/colleague.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { ConfirmPageComponent } from './confirm-page/confirm-page.component';
import { ThankyouComponent } from './thankyou/thankyou.component';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { BookingHistoryComponent } from './booking-history/booking-history.component';
import { RequestBookingComponent } from './request-booking/request-booking.component';
import { UserBookingHistoryComponent } from './user-booking-history/user-booking-history.component';

const routes: Routes = [
  {path:'',component:LandingPageComponent},
  {path:'sign-up',component:SignUpComponent},
  {path:'sign-in',component:SignInComponent},
  {path:'admin-login',component:AdminLoginComponent},
  {path:'new-booking',component:NewBookingComponent},
  {path:'home',component:HomePageComponent},
  {path:'profile',component:ProfileComponent},
  {path:'colleague',component:ColleagueComponent},
  {path:'feedback',component:FeedbackComponent},
  {path:'confirmPage',component:ConfirmPageComponent},
  {path:'thankyou',component:ThankyouComponent},
  {path:'admin-home',component:AdminHomeComponent},
  {path:'booking-history',component:BookingHistoryComponent},
  {path:'request',component:RequestBookingComponent},
  {path:'userHistory',component:UserBookingHistoryComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
