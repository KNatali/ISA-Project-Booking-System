import { InstructorReport } from './../model/instructorReport';
import { AdventureReservation } from './../model/AdventureReservation';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { Client } from '../model/client';
import { AdventureFastReservation } from '../model/adventureFastReservation';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { TimePeriod } from '../model/timePeriod';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {

  urlInstructor =environment.url+"instructors";
  urlInstructor1 = environment.url+"instructors";


  urlInstructor_advetures =environment.url+"adventures/client";
  constructor(private http: HttpClient) { }
  getInstructors(): Observable<Instructor[]> {
    return this.http.get<Instructor[]>(this.urlInstructor);
  }

  getById(id: number): Observable<Instructor> {
    return this.http.get<Instructor>(`${this.urlInstructor}/${id}`);
  }

  updateInstructor(id: number, editedInstructor: Instructor): Observable<Instructor> {
    return this.http.put<Instructor>(`${this.urlInstructor}/${id}`, editedInstructor);
  }

  changePassword(id: number, newPassword: string): Observable<Instructor> {
    return this.http.post<Instructor>(`${this.urlInstructor}/` + `changePassword` + `/${id}`, { newPassword });
  }
  getInstructorAdventures(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(`${this.urlInstructor1}/` + `adventures` + `/${id}`);
  }



  getInstructorFastReservations(id: number): Observable<AdventureFastReservation[]> {
    return this.http.get<AdventureFastReservation[]>(`${this.urlInstructor1}/` + `fastReservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(`${this.urlInstructor1}/` + `reservationClient` + `/${clientId}`);
  }
  getInstructorAdventuresClient(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(`${this.urlInstructor_advetures}/${id}`);
  }
  getUpcomingInstructorReservations(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(`${this.urlInstructor1}/` + `upcomingReservations` + `/${id}`);
  }

  getCompletedInstructorReservations(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(`${this.urlInstructor1}/` + `completedReservations` + `/${id}`);
  }
  getActiveInstructorReservations(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(`${this.urlInstructor1}/` + `activeReservations` + `/${id}`);
  }
  sortByName(): Observable<Instructor[]> {
    return this.http.get<Instructor[]>(this.urlInstructor + "/sort-by-name");
  }
  sortByGrade(): Observable<Instructor[]> {
    return this.http.get<Instructor[]>(this.urlInstructor + "/sort-by-grade");
  }
  sortByCity(): Observable<Instructor[]> {
    return this.http.get<Instructor[]>(this.urlInstructor + "/sort-by-city");
  }

  sendDeleteRequest(request: ProfileDeleteRequest): Observable<ProfileDeleteRequest> {
    return this.http.post<ProfileDeleteRequest>(`${this.urlInstructor}/` + `profileDeleteRequest`, request);
  }


  sendReservationReport(report: InstructorReport): Observable<InstructorReport> {
    return this.http.post<InstructorReport>(`${this.urlInstructor}/` + `sendReservationReport`, report);
  }

  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<ProfileDeleteRequest>(`${this.urlInstructor}/` + `setUnavailability` + `/${id}`, period);

  }

  getUnavailabilityByInstructor(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlInstructor}/` + `getUnavailability` + `/${id}`);
  }



}
