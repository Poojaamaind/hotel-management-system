import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Admin } from 'src/app/Models/Admin';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-update-admin',
  templateUrl: './update-admin.component.html',
  styleUrls: ['./update-admin.component.css']
})
export class UpdateAdminComponent implements OnInit {

  username:string;
  userName:string
  fname:string;
  lname:string;
  password:string;
  admin:Admin;
  constructor(private adsvc:AdminService,private route: ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
     
    this.username=sessionStorage.getItem('adminDetails');
    this.admin=new Admin();

    this.adsvc.getAdminByusername(this.username)
    .subscribe(data=>{
      console.log(data)
      this.admin=data;
      this.fname=this.admin.adminFirstName;
      this.lname=this.admin.adminLastName;
    }, error=>console.log(error));
  }

  updateAdmin() {
    console.log(this.password)
    this.adsvc.updateAdmin(this.admin)
      .subscribe(data => console.log(data), error => console.log(error));
       this.admin = new Admin();
       this.router.navigate(['/adminProfile'])
  }

}
