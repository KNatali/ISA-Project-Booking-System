import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { CottageReservation } from '../model/cottage-reservation';
import { AdventureReservation } from '../model/AdventureReservation';
import { BoatReservation } from '../model/boat-reservation';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  url =environment.url+"clients";
  url_confirm = "http://localhost:8090/confirm-registration-client";
  url_changePassword = environment.url+"clients/change-password";
  url_cottage_res = environment.url+"cottages-reservations";
  url_boat_res =environment.url+"boat-reservations";
  url_adventure_res = environment.url+"adventure-reservations";
  url_delete_request=environment.url+"client/profileDeleteRequest";


  constructor(private http: HttpClient) { }
  getById(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.url}/${id}`);
  }
  save(del :ProfileDeleteRequest):Observable<ProfileDeleteRequest>{
    return this.http.post<ProfileDeleteRequest>(this.url_delete_request,del);
  }
  activateById(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.url_confirm}/${id}`);
  }
  updateClient(client: Client): Observable<Client> {
    return this.http.put<Client>(this.url + '/' + client.id, client)
  }
  changePassword(client: Client): Observable<Client> {
    return this.http.put<Client>(this.url_changePassword + '/' + client.id, client);
  }
  deleteById(id: number): Observable<void> {
    return this.http.delete<void>(`${this.url}/${id}`);
  }
  findAllCottageRes(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`${this.url_cottage_res}/${id}`);
  }
  findAllBoatRes(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`${this.url_boat_res}/${id}`);
  }
  findAllAdventureRes(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(`${this.url_adventure_res}/${id}`);
  }

}
