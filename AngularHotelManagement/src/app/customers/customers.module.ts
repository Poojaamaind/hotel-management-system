import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomersListComponent } from './customers-list/customers-list.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { UpdateCustomersComponent } from './update-customers/update-customers.component';
import { FormsModule } from '@angular/forms';
import { CustomerProfileComponent } from './customer-profile/customer-profile.component';



@NgModule({
  declarations: [CustomersListComponent, CustomerDetailsComponent, UpdateCustomersComponent, CustomerProfileComponent],
  imports: [
    CommonModule,FormsModule
  ],
  exports:[CustomersListComponent,CustomerDetailsComponent,UpdateCustomersComponent,CustomerProfileComponent]
})
export class CustomersModule { }
