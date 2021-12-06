import { AdventureReservation } from './../model/AdventureReservation';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { Client } from '../model/client';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  urlInstructor = "http://localhost:8090/api/instructors";
  urlInstructor1 = "http://localhost:8090/api/instructors";


  urlInstructor_advetures = "http://localhost:8090/api/instructors/adventures/client";
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

  getInstructorReservations(id: number): Observable<AdventureReservation[]> {
    return this.http.get<AdventureReservation[]>(`${this.urlInstructor1}/` + `reservations` + `/${id}`);
  }

  getReservationClient(clientId: number): Observable<Client> {
    return this.http.get<Client>(`${this.urlInstructor1}/` + `reservationClient` + `/${clientId}`);
  }
  getInstructorAdventuresClient(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(`${this.urlInstructor_advetures}/${id}`);
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

}
