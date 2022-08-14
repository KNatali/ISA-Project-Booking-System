import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdditionalItem } from '../model/additionalItem';
import { Cottage } from '../model/cottage1';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageRevision } from '../model/cottageRevision';

@Injectable({
  providedIn: 'root'
})
export class Cottage1Service {
  urlCottages=environment.url+"cottages";
  urlCottage = environment.url+"cottageOwners/cottages";
  urlCottageRule = environment.url+"cottageOwner/cottage";

  constructor(private http:HttpClient) { }

  /*addCottage(id: number, newCottage: Cottage): Observable<Cottage> {
    return this.http.put<Cottage>(`${this.urlCottages}/` + `add` + `/${id}`, newCottage);
  }
  getCottageOwnerCottages(id: number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`${this.urlCottage}`  + `/${id}`);
  }*/

  getCottages(): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(this.urlCottages);
  }
  getCottage(id: number): Observable<Cottage> {
    return this.http.get<Cottage>(`${this.urlCottages}/${id}`);
  }
  deleteCottage(id: number) {
    return this.http.delete(`${this.urlCottages}/` + `delete` + `/${id}`);
  }

  getCottageBehavioralRules(id: number): Observable<CottageBehavioralRules[]> {
    return this.http.get<CottageBehavioralRules[]>(`${this.urlCottageRule}/` + `cottageRules` + `/${id}`);
  }
  getCottageAdditionalItems(id: number): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(`${this.urlCottageRule}/` + `cottageAdditionalItems` + `/${id}`);
  }

  updateCottage(id: number, data: Cottage): Observable<Cottage> {
    return this.http.post<Cottage>(`${this.urlCottage}/${id}`, data);
  }
  addCottage(id: number, newCottage: Cottage): Observable<Cottage> {
    return this.http.put<Cottage>(`${this.urlCottages}/` + `add` + `/${id}`, newCottage);
  }

  findByCottageOwnerFirstAndLastName(firstName: string, lastName: string): Observable<Cottage[]> {
    const params = new HttpParams()
      .set('firstName', firstName)
      .set('lastName', lastName);
    return this.http.get<Cottage[]>(this.urlCottages, { params });
  }
  findByCottageOwner(cottageOwnerId: number): Observable<Cottage[]> {
    const params: HttpParams = new HttpParams().append('cottageOwnerId', cottageOwnerId);
    return this.http.get<Cottage[]>(this.urlCottages, { params });
  }
  getCottageFastReservations(id: number): Observable<CottageFastReservation[]> {
    return this.http.get<CottageFastReservation[]>(`${this.urlCottageRule}/` + `fastReservations` + `/${id}`);
  }

  getAllCottageRevisionsByCottage(id: number): Observable<CottageRevision[]> {
    return this.http.get<CottageRevision[]>(`${this.urlCottageRule}/allCottageRevisionsByCottage` + `/${id}`);
  }
}
