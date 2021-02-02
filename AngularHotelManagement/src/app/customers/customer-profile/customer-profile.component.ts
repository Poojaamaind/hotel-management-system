import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/Models/Customers';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-customer-profile',
  templateUrl: './customer-profile.component.html',
  styleUrls: ['./customer-profile.component.css']
})
export class CustomerProfileComponent implements OnInit {

  username:string;
  fname:string;
  lname:string;
  password:string;
  customer:Customer;
  customerId:number;
  constructor(private csvc:CustomerService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.username=sessionStorage.getItem('customerDetails');
    this.customer=new Customer();
    console.log(this.username);
    // this.username=this.route.snapshot.params['username'];
    // this.password=this.route.snapshot.params['password'];

    this.csvc.getCUstomerByusername(this.username)
    .subscribe(data=>{
      console.log(data)
      this.customer=data;
      this.fname=this.customer.customerFirstName;
      this.lname=this.customer.customerLastName;
      this.customerId=this.customer.customerId;
      console.log(this.customerId);
    }, error=>console.log(error));
    

  }


}
