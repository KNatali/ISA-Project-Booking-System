import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageReservation } from '../model/cottageReservation';
import { EditCottageFastReservation } from '../model/editCottageFastReservation';

@Injectable({
  providedIn: 'root'
})
export class CottageReservation1Service {

  urlReservation = environment.url+"cottageReservation";

  constructor(private http: HttpClient) { }
  saveReservation(reservation: CottageReservation): Observable<CottageReservation> {
    return this.http.put<CottageReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
  editFastReservation(reservation: EditCottageFastReservation): Observable<CottageFastReservation> {
    return this.http.post<CottageFastReservation>(`${this.urlReservation}` + '/editFastReservation', reservation);
  }
}
