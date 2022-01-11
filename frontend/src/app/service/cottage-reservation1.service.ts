import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CottageReservation } from '../model/cottageReservation';

@Injectable({
  providedIn: 'root'
})
export class CottageReservation1Service {

  urlReservation = "http://localhost:8090/api/cottageReservation";

  constructor(private http: HttpClient) { }
  saveReservation(reservation: CottageReservation): Observable<CottageReservation> {
    return this.http.put<CottageReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
}
