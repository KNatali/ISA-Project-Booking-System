import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';

@Injectable({
  providedIn: 'root'
})
export class AdventureService {
  urlAdventures = "http://localhost:8090/api/adventures";

  constructor(private http: HttpClient) { }

  getAdventures(): Observable<Adventure[]> {
    return this.http.get<Adventure[]>(this.urlAdventures);
  }
  getAdventure(id:number):Observable<Adventure>{
    return this.http.get<Adventure>(`${this.urlAdventures}/${id}`);
  }
  findByInstructorFirstAndLastName(firstName:string,lastName:string):Observable<Adventure[]>{
    const params=new HttpParams()
      .set('firstName',firstName)
      .set('lastName',lastName);
      return this.http.get<Adventure[]>(this.urlAdventures,{params});
  }
}