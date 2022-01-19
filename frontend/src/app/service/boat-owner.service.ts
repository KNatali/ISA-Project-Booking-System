import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
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
  urlBoatOwner = "http://localhost:8090/api/boatOwner";
  urlBoatOwner_boats = "http://localhost:8090/api/boatOwners/boats/client";

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
    return this.http.post<BoatOwner>(`http://localhost:8090/api/boatOwners/` + `changePassword` + `/${id}`, { newPassword });
  }
  getBoatOwnerBoats(id: number): Observable<Boat[]> {
    return this.http.get<Boat[]>(`http://localhost:8090/api/boatOwners/` + `boats` + `/${id}`);
  }

  getBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`http://localhost:8090/api/boatOwners/` + `reservations` + `/${id}`);
  }

  getBoatOwnerFastReservations(id: number): Observable<BoatFastReservation[]> {
    return this.http.get<BoatFastReservation[]>(`${this.urlBoatOwner}/` + `fastReservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(`http://localhost:8090/api/boatOwners/` + `reservationClient` + `/${clientId}`);
  }
  getBoatOwnerCottagesClient(id: number): Observable<Boat[]> {
    return this.http.get<Boat[]>(`${this.urlBoatOwner_boats}/${id}`);
  }

  getCompletedBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`http://localhost:8090/api/boatOwners/` + `completedReservations` + `/${id}`);
  }
  getActiveBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`http://localhost:8090/api/boatOwners/` + `activeReservations` + `/${id}`);
  }
  getUpcomingBoatOwnerReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`http://localhost:8090/api/boatOwners/` + `upcomingReservations` + `/${id}`);
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
    return this.http.post<ProfileDeleteRequest>(`http://localhost:8090/api/boatOwners/` + `profileDeleteRequest`, request);
  }
  sendReservationReport(report: BoatOwnerReport): Observable<BoatOwnerReport> {
    return this.http.post<BoatOwnerReport>(`http://localhost:8090/api/boatOwners/` + `sendReservationReport`, report);
  }
}
