import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Boat } from '../model/boat';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatOwner } from '../model/boatOwner';
import { BoatOwnerReport } from '../model/boatOwnerReport';
import { BoatReservation } from '../model/boatReservation';
import { Client } from '../model/client';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { TimePeriod } from '../model/timePeriod';

@Injectable({
  providedIn: 'root'
})
export class BoatOwnerService {
  urlBoatOwner = environment.url+"boatOwner";
  urlBoatOwner_boats = environment.url+"boatOwners/boats/client";
  urlBoatOwners=environment.url+'boatOwners/'

  constructor(private http: HttpClient) { }
  getBoatOwners():Observable<BoatOwner[]>{
    return this.http.get<BoatOwner[]>(this.urlBoatOwner);
  }

  getById(id: number): Observable<BoatOwner> {
    return this.http.get<BoatOwner>(`${this.urlBoatOwner}/${id}`);
  }

  updateBoatOwner(id: number, editedBoatOwner: BoatOwner): Observable<BoatOwner> {
    return this.http.put<BoatOwner>(`${this.urlBoatOwner}/${id}`, editedBoatOwner);
  }

  changePassword(id: number, newPassword: string): Observable<BoatOwner> {
    return this.http.post<BoatOwner>(this.urlBoatOwners + `changePassword` + `/${id}`, { newPassword });
  }
  getBoatOwnerBoats(id: number): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoatOwners + `boats` + `/${id}`);
  }

  getBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(this.urlBoatOwners + `reservations` + `/${id}`);
  }

  getBoatOwnerFastReservations(id: number): Observable<BoatFastReservation[]> {
    return this.http.get<BoatFastReservation[]>(this.urlBoatOwners + `fastReservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(this.urlBoatOwners + `reservationClient` + `/${clientId}`);
  }
  getBoatOwnerCottagesClient(id: number): Observable<Boat[]> {
    return this.http.get<Boat[]>(`${this.urlBoatOwner_boats}/${id}`);
  }

  getCompletedBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(this.urlBoatOwners + `completedReservations` + `/${id}`);
  }
  getActiveBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(this.urlBoatOwners + `activeReservations` + `/${id}`);
  }
  getUpcomingBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(this.urlBoatOwners + `upcomingReservations` + `/${id}`);
  }
  sortByName(): Observable<BoatOwner[]> {
    return this.http.get<BoatOwner[]>(this.urlBoatOwner + "/sort-by-name");
  }
  sortByGrade(): Observable<BoatOwner[]> {
    return this.http.get<BoatOwner[]>(this.urlBoatOwner + "/sort-by-grade");
  }
  sortByCity(): Observable<BoatOwner[]> {
    return this.http.get<BoatOwner[]>(this.urlBoatOwner + "/sort-by-city");
  }
  /*sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(`${this.urlCottageOwner}/` + `profileDeleteRequest`, request);
  }
  sendReservationReport(report: CottageOwnerReport): Observable<CottageOwnerReport> {
    return this.http.post<CottageOwnerReport>(`${this.urlCottageOwner}/` + `sendReservationReport`, report);
  }*/
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlBoatOwner}/` + `setUnavailability` + `/${id}`, period);
  }
  getUnavailabilityByBoatOwner(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlBoatOwner}/` + `getUnavailability` + `/${id}`);
  }
  sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(this.urlBoatOwners + `profileDeleteRequest`, request);
  }
  sendReservationReport(report: BoatOwnerReport): Observable<BoatOwnerReport> {
    return this.http.post<BoatOwnerReport>(this.urlBoatOwners+ `sendReservationReport`, report);
  }
}
