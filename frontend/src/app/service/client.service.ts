import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Client } from '../model/client';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  url = "http://localhost:8090/api/clients";
  url_confirm="http://localhost:8090/confirm-registration-client";

  constructor(private http: HttpClient) { }
  getById(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.url}/${id}`);
  }
  activateById(id:number) :Observable<Client>{
    return this.http.get<Client>(`${this.url_confirm}/${id}`);
  }
}
