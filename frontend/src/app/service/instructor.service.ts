import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Instructor } from '../model/instructor';

@Injectable({
  providedIn: 'root'
})
export class InstructorService {
  urlInstructor = "http://localhost:8090/api/instructors";

  constructor(private http: HttpClient) { }

  getById(id: number): Observable<Instructor> {
    return this.http.get<Instructor>(`${this.urlInstructor}/${id}`);
  }

  updateInstructor(id: number, editedInstructor: Instructor): Observable<Instructor> {
    return this.http.put<Instructor>(`${this.urlInstructor}/${id}`, editedInstructor);
  }

}
