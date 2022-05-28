import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Complaint } from '../model/complaint';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ComplaintBoatReservationService {
  url="http://localhost:8090/api/client/makeNewBoatComplaint";
  url_owner="http://localhost:8090/api/client/makeNewBoatOwnerComplaint";
  constructor(private http: HttpClient) { }

  save(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url,com);
  }
  saveBoatOwnerComlaint(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url_owner,com);
  }
}
