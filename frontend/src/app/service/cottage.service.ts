import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cottage } from '../model/cottage';

@Injectable({
  providedIn: 'root'
})
export class CottageService {
  urlCottage="http://localhost:8090/api/cottages";

  constructor(private http:HttpClient) { }

  getCottages():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottage);
  }
  getCottage(id:number):Observable<Cottage>{
    return this.http.get<Cottage>(`${this.urlCottage}/${id}`);
  }
  findCottageByName(name:string):Observable<Cottage[]>{
    const params:HttpParams=new HttpParams().append('name',name);
    return this.http.get<Cottage[]>(this.urlCottage,{params});
  }
  findCottageByAddress(address:string):Observable<Cottage[]>{
    const params:HttpParams=new HttpParams().append('address',address);
    return this.http.get<Cottage[]>(this.urlCottage,{params});
  }
  sortByName():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottage+"/sort-by-name");
  }
  sortByGrade():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottage+"/sort-by-grade");
  }
  sortByCity():Observable<Cottage[]>{
    return this.http.get<Cottage[]>(this.urlCottage+"/sort-by-city");
  }

}
