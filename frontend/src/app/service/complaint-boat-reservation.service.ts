import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Complaint } from '../model/complaint';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ComplaintBoatReservationService {
  url=environment.url+"client/makeNewBoatComplaint";
  url_owner=environment.url+"client/makeNewBoatOwnerComplaint";
  constructor(private http: HttpClient) { }

  save(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url,com);
  }
  saveBoatOwnerComlaint(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url_owner,com);
  }
}
