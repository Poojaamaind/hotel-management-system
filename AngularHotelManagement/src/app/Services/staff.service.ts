import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credentilas } from '../Models/Credentilas';
import { Staff } from '../Models/Staff';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getStaffById(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/staff/'+id);
  }

  AuthenticateStaffLogin(user: Credentilas): Observable<Object> {
    return this.http.post(this.baseUrl+'/staff/login/', user);
  }
  getAllStaffs(): Observable<any> {
    return this.http.get(this.baseUrl+'/staff');
  }

  deleteStaff(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/staff/'+id);
  }

  updateStaff(staff: Object): Observable<Object> {
    return this.http.put(this.baseUrl+'/staff/', staff);
  }

  getStaffByusername(username: String): Observable<any> {
    return this.http.get(this.baseUrl+'/staff/profile/'+username);
  }
}
