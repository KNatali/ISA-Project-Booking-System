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

}
