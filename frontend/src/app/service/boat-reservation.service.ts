import { SearchForReservation } from './../model/searchForReservation';
import { Injectable } from '@angular/core';

import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { BoatReservation } from '../model/boat-reservation';
import { BoatFastReservation } from '../model/boatFastReservation';

import { EditBoatFastReservation } from '../model/editBoatFastReservation';

import { BoatReservationCreate } from '../model/boatReservationCreate';
import { ReserveBoatFastReservation } from '../model/reserveBoatFastReservation';


@Injectable({
  providedIn: 'root'
})
export class BoatReservationService {
  url = "http://localhost:8090/api/boat-reservations";
  urlReservation = "http://localhost:8090/api/boatReservation";
  url_fast="http://localhost:8090/api/boat/fastReservations";

  constructor(private http: HttpClient) { }
  addBoatReservationClient(res:BoatReservationCreate){
    return this.http.post<BoatReservationCreate>(this.urlReservation+"/client/addReservation",res);
  }

  sortByPrice(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-price/"+id);
  }
  sortByDate(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-date/"+id);
  }
  sortByDuration(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/sort-by-duration/"+id);
  }
  activeReservation(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(this.url+"/active/"+id);
  }
  saveReservation(reservation: BoatReservation): Observable<BoatReservation> {
    return this.http.put<BoatReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
  saveFastReservation(reservation: BoatFastReservation): Observable<BoatFastReservation> {
    return this.http.put<BoatFastReservation>(`${this.urlReservation}` + '/addFastReservation', reservation);
  }
  editFastReservation(reservation: EditBoatFastReservation): Observable<BoatFastReservation> {
    return this.http.post<BoatFastReservation>(`${this.urlReservation}` + '/editFastReservation', reservation);
  }
  getById(id: number): Observable<BoatReservation> {
    return this.http.get<BoatReservation>(`${this.urlReservation}/${id}`);
  }
  getFastReservation(id:number):Observable<BoatFastReservation[]>{
    return this.http.get<BoatFastReservation[]>(`${this.url_fast}/${id}`);
  }
  reserveAdventureFastReservation(res:ReserveBoatFastReservation){
    return this.http.post<ReserveBoatFastReservation>(this.url_fast+"/reserve",res);
  }
}
