import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CottageReservationListComponent } from '../cottage-reservation-list/cottage-reservation-list.component';
import { Observable } from 'rxjs';
import { CottageReservation } from '../model/cottage-reservation';
@Injectable({
  providedIn: 'root'
})
export class CottageReservationService {
  url = "http://localhost:8090/api/cottages-reservations";
  constructor(private http: HttpClient) { }
  sortByPrice(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.url + "/sort-by-price/" + id);
  }
  sortByDate(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.url + "/sort-by-date/" + id);
  }
  sortByDuration(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.url + "/sort-by-duration/" + id);
  }
  activeReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.url + "/active/" + id);
  }
}
