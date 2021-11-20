import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CottageOwner } from '../model/cottageOwner';

@Injectable({
  providedIn: 'root'
})
export class CottageOwnerService {
  urlCottageOwner = "http://localhost:8090/api/cottageOwner";

  constructor(private http: HttpClient) { }
  getCottageOwners():Observable<CottageOwner[]>{
    return this.http.get<CottageOwner[]>(this.urlCottageOwner);
  }

  getById(id: number): Observable<CottageOwner> {
    return this.http.get<CottageOwner>(`${this.urlCottageOwner}/${id}`);
  }

  updateCottageOwner(id: number, editedCottageOwner: CottageOwner): Observable<CottageOwner> {
    return this.http.put<CottageOwner>(`${this.urlCottageOwner}/${id}`, editedCottageOwner);
  }

}
