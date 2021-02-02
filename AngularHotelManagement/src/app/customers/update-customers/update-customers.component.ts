import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/Models/Customers';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-update-customers',
  templateUrl: './update-customers.component.html',
  styleUrls: ['./update-customers.component.css']
})
export class UpdateCustomersComponent implements OnInit {
  userPassword:string;
  username:string;
  userName:string
  fname:string;
  lname:string;
  password:string;
  customer:Customer;
  constructor(private csvc:CustomerService,
    private router:Router) { }

  ngOnInit(): void {
      
    this.username=sessionStorage.getItem('customerDetails');
    this.customer=new Customer();

    this.csvc.getCUstomerByusername(this.username)
    .subscribe(data=>{
      console.log(data)
      this.customer=data;
      this.userPassword=this.customer.userPassword;
      this.fname=this.customer.customerFirstName;
      this.lname=this.customer.customerLastName;
    }, error=>console.log(error));
  }

  updateCustomer()
  {
    console.log(this.userPassword);
    this.csvc.updateCustomer(this.customer)
      .subscribe(data => console.log(data), error => console.log(error));
       this.customer = new Customer();
       this.router.navigate(['/customerProfile'])
  }
}
