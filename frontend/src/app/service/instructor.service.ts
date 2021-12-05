import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  urlInstructor = "http://localhost:8090/api/instructors";
  urlInstructor1 = "http://localhost:8090/api/instructors/adventures";
  urlInstructor_advetures = "http://localhost:8090/api/instructors/adventures/client";

  constructor(private http: HttpClient) { }
  getInstructors():Observable<Instructor[]>{
    return this.http.get<Instructor[]>(this.urlInstructor);
  }

  getById(id: number): Observable<Instructor> {
    return this.http.get<Instructor>(`${this.urlInstructor}/${id}`);
  }

  updateInstructor(id: number, editedInstructor: Instructor): Observable<Instructor> {
    return this.http.put<Instructor>(`${this.urlInstructor}/${id}`, editedInstructor);
  }
  getInstructorAdventures(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(`${this.urlInstructor1}/${id}`);
  }
  getInstructorAdventuresClient(id: number): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(`${this.urlInstructor_advetures}/${id}`);
  }
  sortByName():Observable<Instructor[]>{
    return this.http.get<Instructor[]>(this.urlInstructor+"/sort-by-name");
  }
  sortByGrade():Observable<Instructor[]>{
    return this.http.get<Instructor[]>(this.urlInstructor+"/sort-by-grade");
  }
  sortByCity():Observable<Instructor[]>{
    return this.http.get<Instructor[]>(this.urlInstructor+"/sort-by-city");
  }

}
