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
import { CottageOwnerReport } from '../model/cottageOwnerReport';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CottageOwnerService {
  urlCottageOwner = environment.url+"cottageOwner";
  urlCottageOwner_cottages = environment.url+"cottageOwners/cottages/client";
  urlCottages = environment.url+"cottages";
  urlCottageOwners=environment.url+"cottageOwners/";

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
    return this.http.post<CottageOwner>(this.urlCottageOwners+ `changePassword` + `/${id}`, { newPassword });
  }
  getCottageOwnerCottages(id: number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(this.urlCottageOwners + `cottages` + `/${id}`);
  }

  getCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.urlCottageOwners + `reservations` + `/${id}`);
  }

  getCottageOwnerFastReservations(id: number): Observable<CottageFastReservation[]> {
    return this.http.get<CottageFastReservation[]>(this.urlCottageOwners + `fastReservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(this.urlCottageOwners + `reservationClient` + `/${clientId}`);
  }
  getCottageOwnerCottagesClient(id: number): Observable<Cottage[]> {
    return this.http.get<Cottage[]>(`${this.urlCottageOwner_cottages}/${id}`);
  }

  getCompletedCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.urlCottageOwners + `completedReservations` + `/${id}`);
  }
  getActiveCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.urlCottageOwners + `activeReservations` + `/${id}`);
  }
  getUpcomingCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
    return this.http.get<CottageReservation[]>(this.urlCottageOwners + `upcomingReservations` + `/${id}`);
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
  /*sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottageOwner}/` + `profileDeleteRequest`, request);
  }
  sendReservationReport(report: CottageOwnerReport): Observable<CottageOwnerReport> {
    return this.http.post<CottageOwnerReport>(`${this.urlCottageOwner}/` + `sendReservationReport`, report);
  }
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottageOwner}/` + `setUnavailability` + `/${id}`, period);
  }
  getUnavailabilityByCottageOwner(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlCottageOwner}/` + `getUnavailability` + `/${id}`);
  }*/
  sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(this.urlCottageOwners + `profileDeleteRequest`, request);
  }
  sendReservationReport(report: CottageOwnerReport): Observable<CottageOwnerReport> {
    return this.http.post<CottageOwnerReport>(this.urlCottageOwners + `sendReservationReport`, report);
  }
  getUnavailabilityByCottageOwner(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlCottages}/` + `getUnavailability` + `/${id}`);
  }
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottages}/` + `setUnavailability` + `/${id}`, period);

  }
}
