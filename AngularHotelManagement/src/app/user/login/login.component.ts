import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from 'src/app/Services/admin.service';
import { CustomerService } from 'src/app/Services/customer.service';
import { StaffService } from 'src/app/Services/staff.service';
import { Credentilas } from '../../Models/Credentilas';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string;
  password:string;
  role:string;
  user:Credentilas=new Credentilas();
  constructor(private adminsvc:AdminService,
              private staffsvc:StaffService,
              private custsvc:CustomerService,
              private router:Router) { }

  ngOnInit(): void {
  }


  Login():any
  {
    //console.log(this.user.username);
 
    if(this.role=="Admin")
    {
      sessionStorage.setItem('adminDetails',this.user.username);
      this.adminsvc.AuthenticateAdminLogin(this.user)
      .subscribe(data => {
        console.log(data)
      }, error => console.log(error));
      this.router.navigate(['/adminView'])
      
    }
    else if (this.role=="Customer")
    {
      sessionStorage.setItem('customerDetails',this.user.username);
      this.custsvc.AuthenticateCustomerLogin(this.user)
      .subscribe(data => {
        console.log(data)
      }, error => console.log(error));
      this.router.navigate(['/customerProfile'])
    }
    else{

      sessionStorage.setItem('staffDetails',this.user.username);
      this.staffsvc.AuthenticateStaffLogin(this.user)
      .subscribe(data => {
        console.log(data)
      }, error => console.log(error));
      this.router.navigate(['/ProfileStaff'])

    }
  }

  onSubmit()
  {
    this.Login();
  }

}
