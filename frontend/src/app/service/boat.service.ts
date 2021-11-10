import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../model/boat';

@Injectable({
  providedIn: 'root'
})
export class BoatService {
  urlBoats = "http://localhost:8080/api/boats";

  constructor(private http: HttpClient) { }

  getBoats(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats);
  }

}
