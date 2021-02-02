import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdminViewComponent } from './admin/admin-view/admin-view.component';
import { AddStaffComponent } from './admin/add-staff/add-staff.component';

import { AdminListComponent } from './admin/admin-list/admin-list.component';
import { staffListComponent } from './admin/staff-list/staff-list.component';
import { UpdateStaffComponent } from './admin/update-staff/update-staff.component';
import { CustomerDetailsComponent } from './customers/customer-details/customer-details.component';
import { CustomersListComponent } from './customers/customers-list/customers-list.component';
import { UpdateCustomersComponent } from './customers/update-customers/update-customers.component';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { AdminProfileComponent } from './admin/admin-profile/admin-profile.component';
import { UpdateAdminComponent } from './admin/update-admin/update-admin.component';
import { CustomerProfileComponent } from './customers/customer-profile/customer-profile.component';
import { StaffDetailsComponent } from './staff/staff-details/staff-details.component';
import { UpdateStaffProfileComponent } from './staff/update-staff-profile/update-staff.component';
import { StaffProfileComponent } from './staff/staff-profile/staff-profile.component';
import { RoomHomeComponent } from './booking/room-home/room-home.component';
import { BookRoomComponent } from './booking/book-room/book-room.component';

const routes: Routes = [
  { path:'',redirectTo:'login',pathMatch:'full'},
  { path:'login',component:LoginComponent},
  { path:'register',component:RegisterComponent},
  { path:'logout',component:LoginComponent},
  { path:'adminList',component:AdminListComponent},
  { path:'staffList',component:staffListComponent},
  { path:'updateStaff',component:UpdateStaffComponent},
  { path:'addStaff',component:AddStaffComponent},
  { path:'customerList',component:CustomersListComponent},
  { path:'customerDetails/:id',component:CustomerDetailsComponent},
  { path:'updateCustomer',component:UpdateCustomersComponent},
  { path:'adminView',component:AdminViewComponent},
  { path:'adminProfile',component:AdminProfileComponent},
  { path:'updateAdmin',component:UpdateAdminComponent},
  { path:'customerProfile',component:CustomerProfileComponent},
  { path:'staffProfile/:id',component:StaffDetailsComponent},
  { path:'ProfileStaff',component:StaffProfileComponent},
  { path:'adminStaffView/:staffId',component:StaffDetailsComponent},
  { path:'staffUpdate',component:UpdateStaffProfileComponent},
  { path:'roomHome',component:RoomHomeComponent},
  { path:'bookRoom',component:BookRoomComponent},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
