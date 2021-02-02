import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { HttpHeaders } from '@angular/common/http';
import { Credentilas } from '../Models/Credentilas';
import { Admin } from '../Models/Admin';
import { Staff } from '../Models/Staff';

@Injectable({
  providedIn: 'root'
})

export class AdminService {
  

   httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json',
    //  'Authorization': 'my-auth-token'
    })
  };
  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAdmin(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/admin/'+id);
  }

  updateAdmin(admin: Object): Observable<Object> {
    return this.http.put(this.baseUrl+'/admin/', admin);
  }

  getAdminByusernameAndPassword(username: String,password:string): Observable<any> {
    return this.http.get(this.baseUrl+'/admin/'+username+password);
  }

  getAdminByusername(username: String): Observable<any> {
    return this.http.get(this.baseUrl+'/admin/profile/'+username);
  }

  AuthenticateAdminLogin(user: Credentilas): Observable<Object> {
    return this.http.post(this.baseUrl+'/admin/login/', user);
  }

  RegisterNewAdmin(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl+'/admin/register/', Admin);
  }

  NewStaffRegister(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl+'/admin/addStaff/', product);
  }

  // updateAdminDetails(product: Object): Observable<Object> {
  //   return this.http.put(this.baseUrl+'/admin/', Admin);
  // }

  deleteAdmin(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/admin/'+id);
  }

  getAllAdmins(): Observable<any> {
    return this.http.get(this.baseUrl+'/admin/');
  }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.baseUrl+'/customers/');
  }

  
}
