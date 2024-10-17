import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestBookingComponent } from './request-booking.component';

describe('RequestBookingComponent', () => {
  let component: RequestBookingComponent;
  let fixture: ComponentFixture<RequestBookingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RequestBookingComponent]
    });
    fixture = TestBed.createComponent(RequestBookingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
