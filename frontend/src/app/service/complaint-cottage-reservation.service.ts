import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Complaint } from '../model/complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintCottageReservationService {
  url="http://localhost:8090/api/client/makeNewCottageComplaint";
  url_owner="http://localhost:8090/api/client/makeNewCottageOwnerComplaint";
  constructor(private http: HttpClient) { }

  save(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url,com);
  }
  saveCottageOwnerComplaint(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url_owner,com);
  }
}
