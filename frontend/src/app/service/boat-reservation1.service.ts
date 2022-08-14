import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BoatReservation } from '../model/boatReservation';

@Injectable({
  providedIn: 'root'
})
export class BoatReservation1Service {
  urlReservation = environment.url+"boatReservation";

  constructor(private http: HttpClient) { }
  saveReservation(reservation: BoatReservation): Observable<BoatReservation> {
    return this.http.put<BoatReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
}
