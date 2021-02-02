import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/Models/Customers';
import { CustomerService } from 'src/app/Services/customer.service';

@Component({
  selector: 'app-customer-details',
  templateUrl: './customer-details.component.html',
  styleUrls: ['./customer-details.component.css']
})
export class CustomerDetailsComponent implements OnInit {

  id:number;
  customer:Customer;
  username:string;
  fname:string;
  lname:string;
  password:string;


  constructor(private router:Router,
      private route: ActivatedRoute,
              private custsvc:CustomerService) { }

  ngOnInit(): void {
    this.customer=new Customer();
    this.id = this.route.snapshot.params['id'];

    this.custsvc.getCustomer(this.id)
    .subscribe(data=>{
      console.log(data)
      this.customer=data;
      this.fname=this.customer.customerFirstName;
      this.lname=this.customer.customerLastName;

    }, error=>console.log(error));

  }

  list() {
    this.router.navigate(['customerList']);
  }

}
