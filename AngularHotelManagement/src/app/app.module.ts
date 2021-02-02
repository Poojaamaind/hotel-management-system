import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { UserModule } from './user/user.module';
import { HttpClientModule } from '@angular/common/http'; 
import { AdminModule } from './admin/admin.module';
import { StaffModule } from './staff/staff.module';
import { CustomersModule } from './customers/customers.module';
import { StaffDetailsComponent } from './staff/staff-details/staff-details.component';
import { BookingModule } from './booking/booking.module';




@NgModule({
  declarations: [
    AppComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,FormsModule,
    UserModule,HttpClientModule,
    AdminModule,StaffModule,
    CustomersModule,StaffModule,BookingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
