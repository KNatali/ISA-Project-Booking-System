import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdditionalItem } from '../model/additionalItem';
import { Cottage } from '../model/cottage';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { CottageReservation } from '../model/cottageReservation';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { SearchAvailableCottageByGrade } from '../model/searchAvailableCottageByGrade';
import { SearchAvailableCottageByPrice } from '../model/searchAvailableCottageByPrice';
import { SearchForReservation } from '../model/searchForReservation';
import { TimePeriod } from '../model/timePeriod';
import { UnsubscribedItem } from '../model/unsubscribedItem';

@Injectable({
  providedIn: 'root'
})
export class CottageService {
  urlCottages=environment.url+"cottages";
  urlCottage = environment.url+"cottageOwner/cottage";
  urlCottage1 = environment.url+"cottageOwners/cottages";

  constructor(private http:HttpClient) { }

  searchCottagesForReservation(obj:SearchForReservation):Observable<Cottage[]>{
    return this.http.post<Cottage[]>(`${this.urlCottages}/` + `allAvailableCottages`,obj);
  }
  getSubscribedCottages(id:number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`${this.urlCottages}`+`/subscribed`+`/${id}`);
  }
  unsubscribe(obj:UnsubscribedItem):Observable<void>{
    return this.http.post<void>(this.urlCottages+"/unsubscribed",obj);
  }
  subscribe(obj:UnsubscribedItem):Observable<void>{
    return this.http.post<void>(this.urlCottages+"/subscribed",obj);
  }
  getCottages():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottages);
  }
  getCottage(id:number):Observable<Cottage>{
    return this.http.get<Cottage>(`${this.urlCottages}/${id}`);
  }
  findCottageByName(name:string):Observable<Cottage[]>{
    const params:HttpParams=new HttpParams().append('name',name);
    return this.http.get<Cottage[]>(this.urlCottages,{params});
  }
  findCottageByAddress(city:string):Observable<Cottage[]>{
    const params:HttpParams=new HttpParams().append('city',city);
    return this.http.get<Cottage[]>(this.urlCottages,{params});
  }
  sortByName():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottages+"/sort-by-name");
  }
  sortByGrade():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottages+"/sort-by-grade");
  }
  sortByCity():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottages+"/sort-by-city");
  }
  deleteCottage(id: number) {
    return this.http.delete(`${this.urlCottages}/` + `delete` + `/${id}`);
  }
  getCottageBehavioralRules(id: number): Observable<CottageBehavioralRules[]> {
    return this.http.get<CottageBehavioralRules[]>(`${this.urlCottage}/` + `rules` + `/${id}`);
  }
  getCottageAdditionalItems(id: number): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(`${this.urlCottage}/` + `cottageAdditionalItems` + `/${id}`);
  }
  updateCottage(id: number, data: Cottage): Observable<Cottage> {
    return this.http.post<Cottage>(`${this.urlCottage}/${id}`, data);
  }
  /*addCottage(id: number, newCottage: Cottage): Observable<Cottage> {
    return this.http.put<Cottage>(`${this.urlCottages}/` + `add` + `/${id}`, newCottage);
  }*/
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
    return this.http.get<CottageFastReservation[]>(`${this.urlCottage}/` + `fastReservations` + `/${id}`);
  }
  getCottageReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`${this.urlCottage}/` + `reservations` + `/${id}`);
  }
  getBehavioralRules(id: number): Observable<CottageBehavioralRules[]> {
    return this.http.get<CottageBehavioralRules[]>(`${this.urlCottage}/` + `cottageRules` + `/${id}`);
  }
  getAdditionalItems(id: number): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(`${this.urlCottage1}/` + `additionalItems` + `/${id}`);
  }
  updateCottages(id: number, data: Cottage): Observable<Cottage> {
    return this.http.post<Cottage>(`${this.urlCottage1}/${id}`, data);
  }
  addCottage(id: number, newCottage: Cottage): Observable<Cottage> {
    return this.http.put<Cottage>(`${this.urlCottages}/` + `add` + `/${id}`, newCottage);
  }
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottages}/` + `setUnavailability` + `/${id}`, period);
  }
  getUnavailabilityByCottage(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlCottages}/` + `getUnavailability` + `/${id}`);
  }
  sortByGradeAvailableCottage(obj:Cottage[]):Observable<Cottage[]>{
    return this.http.post<Cottage[]>(this.urlCottages+"/sort-by-grade",obj);
  }
  sortByPriceAvailableCottage(obj:Cottage[]):Observable<Cottage[]>{
    return this.http.post<Cottage[]>(this.urlCottages+"/sort-by-price",obj);
  }
  findByGradeAvailable(obj:SearchAvailableCottageByGrade):Observable<Cottage[]>{
    return this.http.post<Cottage[]>(this.urlCottages+"/find-available-by-grade",obj);
  }
  findByPriceAvailable(obj:SearchAvailableCottageByPrice):Observable<Cottage[]>{
    return this.http.post<Cottage[]>(this.urlCottages+"/find-available-by-price",obj);
  }
}
