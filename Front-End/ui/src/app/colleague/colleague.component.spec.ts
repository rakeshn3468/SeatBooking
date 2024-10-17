import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColleagueComponent } from './colleague.component';

describe('ColleagueComponent', () => {
  let component: ColleagueComponent;
  let fixture: ComponentFixture<ColleagueComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColleagueComponent]
    });
    fixture = TestBed.createComponent(ColleagueComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
