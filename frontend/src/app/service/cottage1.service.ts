import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cottage } from '../model/cottage1';

@Injectable({
  providedIn: 'root'
})
export class Cottage1Service {
  urlCottages="http://localhost:8090/api/cottages";
  urlCottage = "http://localhost:8090/api/cottageOwner/cottage";

  constructor(private http:HttpClient) { }

  addCottage(id: number, newCottage: Cottage): Observable<Cottage> {
    return this.http.put<Cottage>(`${this.urlCottages}/` + `add` + `/${id}`, newCottage);
  }
}
