import { Component, OnInit } from '@angular/core';
import { Admin } from 'src/app/Models/Admin';
import { AdminService } from 'src/app/Services/admin.service';
import { Router,ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-admin-profile',
  templateUrl: './admin-profile.component.html',
  styleUrls: ['./admin-profile.component.css']
})
export class AdminProfileComponent implements OnInit {

  username:string;
  fname:string;
  lname:string;
  password:string;
  admin:Admin;
  constructor(private adsvc:AdminService,private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.username=sessionStorage.getItem('adminDetails');
    this.admin=new Admin();
    console.log(this.username);
    // this.username=this.route.snapshot.params['username'];
    // this.password=this.route.snapshot.params['password'];

    this.adsvc.getAdminByusername(this.username)
    .subscribe(data=>{
      console.log(data)
      this.admin=data;
      this.fname=this.admin.adminFirstName;
      this.lname=this.admin.adminLastName;
    }, error=>console.log(error));
    

  }

 

}
