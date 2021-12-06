import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { CottageReservation } from '../model/cottage-reservation';
import { BoatReservation } from '../model/boat-reservation';
import { AdventureReservation } from '../model/AdventureReservation';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  url = "http://localhost:8090/api/clients";
  url_confirm="http://localhost:8090/confirm-registration-client";
  url_changePassword="http://localhost:8090/api/clients/change-password";
  url_cottage_res="http://localhost:8090/api/cottages-reservations";
  url_boat_res="http://localhost:8090/api/boat-reservations";
  url_adventure_res="http://localhost:8090/api/adventure-reservations";
  constructor(private http: HttpClient) { }
  getById(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.url}/${id}`);
  }
  activateById(id:number) :Observable<Client>{
    return this.http.get<Client>(`${this.url_confirm}/${id}`);
  }
  updateClient(client:Client):Observable<Client>{
    return this.http.put<Client>(this.url+'/'+client.id,client)
  }
  changePassword(client:Client):Observable<Client>{
    return this.http.put<Client>(this.url_changePassword+'/'+client.id,client);
  }
  deleteById(id:number):Observable<void>{
    return this.http.delete<void>(`${this.url}/${id}`);
  }
  findAllCottageRes(id:number):Observable<CottageReservation[]>{
    return this.http.get<CottageReservation[]>(`${this.url_cottage_res}/${id}`);
  }
  findAllBoatRes(id:number):Observable<BoatReservation[]>{
    return this.http.get<BoatReservation[]>(`${this.url_boat_res}/${id}`);
  }
  findAllAdventureRes(id:number):Observable<AdventureReservation[]>{
    return this.http.get<AdventureReservation[]>(`${this.url_adventure_res}/${id}`);
  }
}
