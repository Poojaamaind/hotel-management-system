import { ComponentFixture, TestBed } from '@angular/core/testing';

import { staffListComponent } from './staff-list.component';

describe('StaffListComponent', () => {
  let component: staffListComponent;
  let fixture: ComponentFixture<staffListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ staffListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(staffListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
