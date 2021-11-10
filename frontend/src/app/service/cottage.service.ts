import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cottage } from '../model/cottage';

@Injectable({
  providedIn: 'root'
})
export class CottageService {
  urlCottage="http://localhost:8080/api/cottages";

  constructor(private http:HttpClient) { }

  getCottages():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottage);
  }
}
