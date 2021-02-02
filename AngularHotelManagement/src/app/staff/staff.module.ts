import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StaffDetailsComponent } from './staff-details/staff-details.component';
import { FormsModule } from '@angular/forms';
import { StaffProfileComponent } from './staff-profile/staff-profile.component';
import { UpdateStaffProfileComponent } from './update-staff-profile/update-staff.component';



@NgModule({
  declarations: [StaffDetailsComponent, StaffProfileComponent,UpdateStaffProfileComponent],
  imports: [
    CommonModule,FormsModule
  ],
  exports:[StaffDetailsComponent,StaffProfileComponent]
})
export class StaffModule { }
