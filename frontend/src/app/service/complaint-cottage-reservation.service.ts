import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Complaint } from '../model/complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintCottageReservationService {
  url=environment.url+"client/makeNewCottageComplaint";
  url_owner=environment.url+"client/makeNewCottageOwnerComplaint";
  constructor(private http: HttpClient) { }

  save(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url,com);
  }
  saveCottageOwnerComplaint(com:Complaint):Observable<Complaint>{
    return this.http.post<Complaint>(this.url_owner,com);
  }
}
