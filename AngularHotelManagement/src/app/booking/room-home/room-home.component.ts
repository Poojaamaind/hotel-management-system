import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/Models/Customers';
import { Reservation } from 'src/app/Models/Reservation';
import { CustomerService } from 'src/app/Services/customer.service';
import { ReservationService } from 'src/app/Services/reservation.service';

@Component({
  selector: 'app-room-home',
  templateUrl: './room-home.component.html',
  styleUrls: ['./room-home.component.css']
})
export class RoomHomeComponent implements OnInit {
  username:string;
  fname:string;
  lname:string;
  password:string;
  customer:Customer;
  customerId:number;
  reservation:Reservation;
  message:string='';
  constructor(private csvc:CustomerService,private route: ActivatedRoute,
    private rsvc:ReservationService,private r:Router) { }

  ngOnInit(): void {
    this.username=sessionStorage.getItem('customerDetails');
    this.customer=new Customer();
    console.log(this.username);
  this.reservation=new Reservation();
    // this.username=this.route.snapshot.params['username'];
    // this.password=this.route.snapshot.params['password'];

    this.csvc.getCUstomerByusername(this.username)
    .subscribe(data=>{
      console.log(data)
      this.customer=data;
      this.reservation.FirstName=this.customer.customerFirstName;
      this.reservation.LastName=this.customer.customerLastName;
    //  this.reservation.phoneNumber=this.customer.phoneNumber;
      this.reservation.userName=this.customer.userName;
      this.reservation.customerId=this.customer.customerId;
      this.fname=this.customer.customerFirstName;
      this.lname=this.customer.customerLastName;
      this.customerId=this.customer.customerId;
      console.log(this.customerId);
    }, error=>console.log(error));
    

  }

  saveProduct() {
    this.rsvc.AddRoom(this.reservation)
      .subscribe(data => console.log(data), error => console.log(error));
    this.reservation = new Reservation();
    console.log(this.reservation);
    this.message="Booking SucceessFUll "
  }

  onSubmit() {
    this.saveProduct();    
  }

}
