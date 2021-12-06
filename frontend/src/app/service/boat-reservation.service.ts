import { Injectable } from '@angular/core';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BoatReservation } from '../model/boat-reservation';

@Injectable({
  providedIn: 'root'
})
export class BoatReservationService {
  url = "http://localhost:8090/api/boat-reservations";
  constructor(private http: HttpClient) { }
  sortByPrice(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-price/"+id);
  }
  sortByDate(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-date/"+id);
  }
  sortByDuration(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-duration/"+id);
  }
}
