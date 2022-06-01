import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CottageReservationListComponent } from '../cottage-reservation-list/cottage-reservation-list.component';
import { Observable } from 'rxjs';
import { CottageReservation } from '../model/cottage-reservation';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageReservationCreate } from '../model/cottageReservationCreate';
import { ReserveCottageFastReservation } from '../model/reserveCottageFastReservation';
@Injectable({
  providedIn: 'root'
})
export class CottageReservationService {
  url = "http://localhost:8090/api/cottages-reservations";
  urlReservation = "http://localhost:8090/api/cottageReservation";
  url_fast="http://localhost:8090/api/cottages/fastReservations";

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
  saveFastReservation(reservation: CottageFastReservation): Observable<CottageFastReservation> {
    return this.http.put<CottageFastReservation>(`${this.urlReservation}` + '/addFastReservation', reservation);
  }
  saveReservation(reservation: CottageReservation): Observable<CottageReservation> {
    return this.http.put<CottageReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
  getById(id: number): Observable<CottageReservation> {
    return this.http.get<CottageReservation>(`${this.urlReservation}/${id}`);
  }
  addCottageReservationClient(res:CottageReservationCreate){
    return this.http.post<CottageReservationCreate>(this.urlReservation+"/client/addReservation",res);
  }
  getFastReservation(id:number):Observable<CottageFastReservation[]>{
    return this.http.get<CottageFastReservation[]>(`${this.url_fast}/${id}`);
  }
  reserveCottageFastReservation(res:ReserveCottageFastReservation){
    return this.http.post<ReserveCottageFastReservation>(this.url_fast+"/reserve",res);
  }
}
