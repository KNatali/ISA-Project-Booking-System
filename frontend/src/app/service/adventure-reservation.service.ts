import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AdventureReservation } from '../model/AdventureReservation';

@Injectable({
  providedIn: 'root'
})
export class AdventureReservationService {
  url = "http://localhost:8090/api/adventure-reservations";
  constructor(private http: HttpClient) { }
  
  activeReservations(id:number):Observable<AdventureReservation[]>{
    return this.http.get<AdventureReservation[]>(this.url+"/active/"+id);
  }
  sortByPrice(id:number):Observable<AdventureReservation[]>{
    return this.http.get<AdventureReservation[]>(this.url+"/sort-by-price/"+id);
  }
  sortByDate(id:number):Observable<AdventureReservation[]>{
    return this.http.get<AdventureReservation[]>(this.url+"/sort-by-date/"+id);
  }
}
