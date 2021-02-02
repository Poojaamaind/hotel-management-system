import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateStaffProfileComponent } from './update-staff.component';

describe('UpdateStaffComponent', () => {
  let component: UpdateStaffProfileComponent;
  let fixture: ComponentFixture<UpdateStaffProfileComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateStaffProfileComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateStaffProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
