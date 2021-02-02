import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Staff } from 'src/app/Models/Staff';
import { AdminService } from 'src/app/Services/admin.service';
import { StaffService } from 'src/app/Services/staff.service';

@Component({
  selector: 'app-staff-details',
  templateUrl: './staff-details.component.html',
  styleUrls: ['./staff-details.component.css']
})
export class StaffDetailsComponent implements OnInit {

  staff:Staff;
  staffId:number;
  fname:string;
  username:string;
  lname:string;
  constructor(private svc:StaffService,private route:ActivatedRoute,private asvc:AdminService,
    private router:Router) { }

  ngOnInit(): void {
  this.staff = new Staff();
  console.log(this.staffId);
  this.staffId = this.route.snapshot.params['staffId'];
  console.log(this.staffId);
  this.svc.getStaffById(this.staffId)
    .subscribe(data => {
      console.log(data);
      this.username=this.staff.username;
     
      this.staff = data;
     
      this.fname=this.staff.staffFirstName;
      this.lname=this.staff.staffLastName;
    }, error => console.log(error));
  }


  updateStaff() {
    console.log(this.staff);
    this.svc.updateStaff(this.staff)
      .subscribe(data => console.log(data), error => console.log(error));
    this.staff = new Staff();
    this.router.navigate(['/staffList'])
  }

  onSubmit() {
    this.updateStaff();    
  }
  

}
