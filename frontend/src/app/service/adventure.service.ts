import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {
  urlAdventures = "http://localhost:8090/api/adventures";

  constructor(private http: HttpClient) { }

  getAdventures(): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(this.urlAdventures);
  }
  getAdventure(id:number):Observable<Adventure>{
    return this.http.get<Adventure>(`${this.urlAdventures}/${id}`);
  }
}