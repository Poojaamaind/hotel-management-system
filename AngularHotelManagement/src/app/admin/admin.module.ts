import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { staffListComponent } from './staff-list/staff-list.component';
import { UpdateStaffComponent } from './update-staff/update-staff.component';
import { AdminListComponent } from './admin-list/admin-list.component';
import { AddStaffComponent } from './add-staff/add-staff.component';
import { FormsModule } from '@angular/forms';
import { AdminViewComponent } from './admin-view/admin-view.component';
import { RouterModule } from '@angular/router';
import { CustomersListComponent } from '../customers/customers-list/customers-list.component';
import { Routes } from '@angular/router';
import { AdminProfileComponent } from './admin-profile/admin-profile.component';
import { UpdateAdminComponent } from './update-admin/update-admin.component';
import { StaffDetailsComponent } from './staff-details/staff-details.component';

// const routes: Routes = [
//   { path:'',redirectTo:'login',pathMatch:'full'},
  
//   { path:'adminList',component:AdminListComponent},
//   { path:'staffList',component:staffListComponent},
//   { path:'updateStaff',component:UpdateStaffComponent},
//   { path:'addStaff',component:AddStaffComponent},
//   { path:'customList',component:CustomersListComponent},
//   { path:'adminView',component:AdminViewComponent},


// ];

@NgModule({
  declarations: [staffListComponent, UpdateStaffComponent, AdminListComponent,AddStaffComponent,AdminViewComponent, AdminProfileComponent, UpdateAdminComponent, StaffDetailsComponent],
  imports: [
    CommonModule,FormsModule
  ],
  exports:[
   AdminListComponent,staffListComponent,UpdateStaffComponent,AddStaffComponent,AdminViewComponent,
   AdminProfileComponent,UpdateAdminComponent,StaffDetailsComponent
  ]
})
export class AdminModule { }
