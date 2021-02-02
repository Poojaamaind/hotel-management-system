import { Injectable } from '@angular/core';
import { HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Credentilas } from '../Models/Credentilas';
import { Customer } from '../Models/Customers';
@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  
  httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json',
    //  'Authorization': 'my-auth-token'
    })
  };

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<any> {
    return this.http.get(this.baseUrl+'/customers');
  }

  getCUstomerByusername(username: String): Observable<any> {
    return this.http.get(this.baseUrl+'/customers/profile/'+username);
  }

  getCustomer(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/customers/'+id);
  }

  AuthenticateCustomerLogin(user: Credentilas): Observable<Object> {
    return this.http.post(this.baseUrl+'/customers/login/', user);
  }

  RegisterCustomer(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl+'/customers/register/', Customer);
  }


  // updateCustomersDetails(product: Object): Observable<Object> {
  //   return this.http.put(this.baseUrl+'/customers/', Customer);
  // }

  deleteCustomer(id: number): Observable<any> {
    return this.http.delete(this.baseUrl+'/customers/'+id);
  }

  updateCustomer(customer: Object): Observable<Object> {
    return this.http.put(this.baseUrl+'/customers/', customer);
  }

  
}
