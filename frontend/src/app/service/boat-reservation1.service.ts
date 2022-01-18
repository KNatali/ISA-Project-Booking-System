import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BoatReservation } from '../model/boatReservation';

@Injectable({
  providedIn: 'root'
})
export class BoatReservation1Service {
  urlReservation = "http://localhost:8090/api/boatReservation";

  constructor(private http: HttpClient) { }
  saveReservation(reservation: BoatReservation): Observable<BoatReservation> {
    return this.http.put<BoatReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
}
