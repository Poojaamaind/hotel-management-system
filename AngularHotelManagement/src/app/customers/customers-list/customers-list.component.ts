import { Component, OnInit } from '@angular/core';
import { Customer } from 'src/app/Models/Customers';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { CustomerService } from 'src/app/Services/customer.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-customers-list',
  templateUrl: './customers-list.component.html',
  styleUrls: ['./customers-list.component.css']
})
export class CustomersListComponent implements OnInit {

  customers:Observable<Customer[]>;
  constructor(private router:Router,
   private custsvc:CustomerService,
   private location:Location) { }

 ngOnInit(): void {
   this.fetchCustomers();
 }
 fetchCustomers()
 {
   this.customers=this.custsvc.getAllCustomers();
 }


 deleteCustomer(id: number) {
   alert(id);
   console.log(id);
  this.custsvc.deleteCustomer(id)
    .subscribe(
      data => {
        console.log(data);
      this.fetchCustomers();
      },
      error => console.log(error));
}


customerDetails(id: number) {
  this.router.navigate(['customerDetails', id]);
}

updateCustomer(customer: Customer){
  this.router.navigate(['updateCustomer', customer]);
}

goBack()
{
  this.router.navigate(['adminView']);
}

}
