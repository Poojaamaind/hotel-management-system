import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Staff } from 'src/app/Models/Staff';
import { AdminService } from 'src/app/Services/admin.service';
import { StaffService } from 'src/app/Services/staff.service';

@Component({
  selector: 'app-update-staff',
  templateUrl: './update-staff.component.html',
  styleUrls: ['./update-staff.component.css']
})
export class UpdateStaffProfileComponent implements OnInit {

  staff:Staff;
  staffId:number;
  fname:string;
  username:string;
  lname:string;
  constructor(private svc:StaffService,private route:ActivatedRoute,private asvc:AdminService,
    private router:Router) { }

    ngOnInit(): void {
      this.username=sessionStorage.getItem('staffDetails');
      this.staff=new Staff();
      console.log(this.username);
      console.log(this.staff);
      
      this.svc.getStaffByusername(this.username)
      .subscribe(data=>{
        console.log(data);
        this.staff=data;
        this.fname=this.staff.staffFirstName;
        this.lname=this.staff.staffLastName;
      }, error=>console.log(error));

}

updateStaff() {
  //console.log(this.password)
  this.svc.updateStaff(this.staff)
    .subscribe(data => console.log(data), error => console.log(error));
     this.staff = new Staff();
     this.router.navigate(['/ProfileStaff'])
}
}
