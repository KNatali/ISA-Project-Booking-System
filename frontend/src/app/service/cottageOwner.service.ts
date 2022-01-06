import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CottageReservation } from '../model/cottageReservation';
import { Cottage } from '../model/cottage';
import { CottageOwner } from '../model/cottageOwner';
import { CottageFastReservation } from '../model/cottageFastReservation';
import { Client } from '../model/client';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { TimePeriod } from '../model/timePeriod';

@Injectable({
  providedIn: 'root'
})
export class CottageOwnerService {
  urlCottageOwner = "http://localhost:8090/api/cottageOwner";
  urlCottageOwner_cottages = "http://localhost:8090/api/cottageOwners/cottages/client";

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

  changePassword(id: number, newPassword: string): Observable<CottageOwner> {
    return this.http.post<CottageOwner>(`${this.urlCottageOwner}/` + `changePassword` + `/${id}`, { newPassword });
  }
  getCottageOwnerCottages(id: number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`http://localhost:8090/api/cottageOwners/` + `cottages` + `/${id}`);
  }

  getCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`http://localhost:8090/api/cottageOwners/` + `reservations` + `/${id}`);
  }

  getCottageOwnerFastReservations(id: number): Observable<CottageFastReservation[]> {
    return this.http.get<CottageFastReservation[]>(`${this.urlCottageOwner}/` + `fastReservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(`http://localhost:8090/api/cottageOwners/` + `reservationClient` + `/${clientId}`);
  }
  getCottageOwnerCottagesClient(id: number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`${this.urlCottageOwner_cottages}/${id}`);
  }

  getCompletedCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`http://localhost:8090/api/cottageOwners/` + `completedReservations` + `/${id}`);
  }
  getActiveCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`http://localhost:8090/api/cottageOwners/` + `activeReservations` + `/${id}`);
  }
  getUpcomingCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(`http://localhost:8090/api/cottageOwners/` + `upcomingReservations` + `/${id}`);
  }
  sortByName(): Observable<CottageOwner[]> {
    return this.http.get<CottageOwner[]>(this.urlCottageOwner + "/sort-by-name");
  }
  sortByGrade(): Observable<CottageOwner[]> {
    return this.http.get<CottageOwner[]>(this.urlCottageOwner + "/sort-by-grade");
  }
  sortByCity(): Observable<CottageOwner[]> {
    return this.http.get<CottageOwner[]>(this.urlCottageOwner + "/sort-by-city");
  }
  sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottageOwner}/` + `profileDeleteRequest`, request);
  }
  /*sendReservationReport(report: CottageOwnerReport): Observable<CottageOwnerReport> {
    return this.http.post<CottageOwnerReport>(`${this.urlCottageOwner}/` + `sendReservationReport`, report);
  }*/
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottageOwner}/` + `setUnavailability` + `/${id}`, period);
  }
  getUnavailabilityByCottageOwner(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlCottageOwner}/` + `getUnavailability` + `/${id}`);
  }
}
