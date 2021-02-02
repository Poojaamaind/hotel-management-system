import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Staff } from 'src/app/Models/Staff';
import { StaffService } from 'src/app/Services/staff.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-staff-list',
  templateUrl: './staff-list.component.html',
  styleUrls: ['./staff-list.component.css']
})
export class staffListComponent implements OnInit {

 staffs:Observable<Staff[]>;

   constructor(private router:Router,
    private staffsvc:StaffService,
    private location:Location) { }

  ngOnInit(): void {
    this.fetchStaff();
  }
  fetchStaff()
  {
    this.staffs=this.staffsvc.getAllStaffs();
  }

  AddNewStaff(){
    this.router.navigate(['/addStaff']);
  }

  deleteStaff(id: number) {
    alert(id);
    console.log(id);
   this.staffsvc.deleteStaff(id)
     .subscribe(
       data => {
         console.log(data);
       this.fetchStaff();
       },
       error => console.log(error));
 }

 staffDetails(staffId: number) {
  this.router.navigate(['adminStaffView', staffId]);
}

updateStaff(staff: Staff){
  this.router.navigate(['updateStaff', staff]);
}
  

goBack()
{
  this.router.navigate(['adminView']);
}

}
