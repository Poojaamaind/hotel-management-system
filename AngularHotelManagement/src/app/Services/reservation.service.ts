import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Reservation } from '../Models/Reservation';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  httpOptions = {
    headers: new HttpHeaders({
     'Content-Type':  'application/json',
    //  'Authorization': 'my-auth-token'
    })
  };

  private baseUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getAllReservations(): Observable<any> {
    return this.http.get(this.baseUrl+'/reservation');
  }

 
  getReservation(id: number): Observable<any> {
    return this.http.get(this.baseUrl+'/reservation/'+id);
  }

  AddRoom(product: Object): Observable<Object> {
    return this.http.post(this.baseUrl+'/reservation', product);
  }
}
