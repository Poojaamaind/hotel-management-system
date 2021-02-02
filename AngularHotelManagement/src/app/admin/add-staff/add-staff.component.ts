import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Staff } from 'src/app/Models/Staff';
import { AdminService } from 'src/app/Services/admin.service';

@Component({
  selector: 'app-add-staff',
  templateUrl: './add-staff.component.html',
  styleUrls: ['./add-staff.component.css']
})
export class AddStaffComponent implements OnInit {

  constructor(private adsvc:AdminService,
              private router:Router) { }

  staff: Staff= new Staff();
  ss:string
  submitted 

  ngOnInit() {
  }

  saveStaff() {
    console.log(this.staff);
    this.adsvc.NewStaffRegister(this.staff)
      .subscribe(data => console.log(data), error => console.log(error));
  //  this.ss =JSON.stringify(new Staff()).toString();
  this.staff= new Staff();
    this.router.navigate(['/staffList']);
  }

  onSubmit() {
    this.saveStaff();    
  }


}
