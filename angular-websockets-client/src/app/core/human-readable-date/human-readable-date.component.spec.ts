import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HumanReadableDateComponent } from './human-readable-date.component';

describe('HumanReadableDateComponent', () => {
  let component: HumanReadableDateComponent;
  let fixture: ComponentFixture<HumanReadableDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HumanReadableDateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HumanReadableDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
