import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { AdventureReservation } from '../model/AdventureReservation';
import { AdventureFastReservation } from '../model/adventureFastReservation';
import { EditAdventureFastReservation } from '../model/editAdventureFastReservation';
import { AdventureReservationCreate } from '../model/adventureReservationCreate';
import { ReserveAdventureFastReservation } from '../model/reserveAdventureFastReservation';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdventureReservationService {
  url =  environment.url+"adventure-reservations";
  urlReservation = environment.url+"adventureReservation";
  url_fast= environment.url+"adventure/fastReservations";
  constructor(private http: HttpClient) { }

  allAdventureReservations(): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(this.urlReservation + "/all");
  }

  activeReservations(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(this.url + "/active/" + id);
  }
  sortByPrice(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(this.url + "/sort-by-price/" + id);
  }
  sortByDate(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(this.url + "/sort-by-date/" + id);
  }
  saveFastReservation(reservation: AdventureFastReservation): Observable<AdventureFastReservation> {
    return this.http.put<AdventureFastReservation>(`${this.urlReservation}` + '/addFastReservation', reservation);
  }
  saveReservation(reservation: AdventureReservation): Observable<AdventureReservation> {
    return this.http.put<AdventureReservation>(`${this.urlReservation}` + '/addReservation', reservation);
  }
  editFastReservation(reservation: EditAdventureFastReservation): Observable<AdventureFastReservation> {
    return this.http.post<AdventureFastReservation>(`${this.urlReservation}` + '/editFastReservation', reservation);
  }
  getById(id: number): Observable<AdventureReservation> {
    return this.http.get<AdventureReservation>(`${this.urlReservation}/${id}`);
  }
  addAdventureReservationClient(res:AdventureReservationCreate){
    return this.http.post<AdventureReservationCreate>(this.urlReservation+"/client/addReservation",res);
  }
  getFastReservation(id:number):Observable<AdventureFastReservation[]>{
    return this.http.get<AdventureFastReservation[]>(`${this.url_fast}/${id}`);
  }
  reserveAdventureFastReservation(res:ReserveAdventureFastReservation){
    return this.http.post<ReserveAdventureFastReservation>(this.url_fast+"/reserve",res);
  }
  cancelReservation(id:number):Observable<void>{
    return this.http.delete<void>(`${this.urlReservation}`+"/delete-by-client/"+`${id}`);
  }

}
