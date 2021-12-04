import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Boat } from '../model/boat';

@Injectable({
  providedIn: 'root'
})
export class BoatService {
  urlBoats = "http://localhost:8090/api/boats";

  constructor(private http: HttpClient) { }

  getBoats(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats);
  }
  getBoat(id:number):Observable<Boat>{
    return this.http.get<Boat>(`${this.urlBoats}/${id}`);
  }
  findBoatByMotorNumber(motorNumber:number):Observable<Boat[]>{
    const params:HttpParams=new HttpParams().append('motorNumber',motorNumber);
    return this.http.get<Boat[]>(this.urlBoats,{params});
  }
  findBoatByMotorPower(motorPower:number):Observable<Boat[]>{
    const params:HttpParams=new HttpParams().append('motorPower',motorPower);
    return this.http.get<Boat[]>(this.urlBoats,{params});
  }
  findBoatByMotorPowerAndMotorNumber(motorPower:number,motorNumber:number):Observable<Boat[]>{
    
    const params=new HttpParams()
      .set('motorPower',motorPower)
      .set('motorNumber',motorNumber);
      return this.http.get<Boat[]>(this.urlBoats,{params});
  }
  sortByName():Observable<Boat[]>{
    return this.http.get<Boat[]>(this.urlBoats+"/sort-by-name");
  }
  sortByGrade():Observable<Boat[]>{
    return this.http.get<Boat[]>(this.urlBoats+"/sort-by-grade");
  }
}
