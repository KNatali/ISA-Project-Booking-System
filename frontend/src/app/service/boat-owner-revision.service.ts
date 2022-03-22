import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BoatOwnerRevision } from '../model/boatOwnerRevision';
import { SpecificRevision } from '../model/specificRevision';

@Injectable({
  providedIn: 'root'
})
export class BoatOwnerRevisionService {
  url="http://localhost:8090/api/client/makeNewBoatOwnerRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<BoatOwnerRevision>{
    return this.http.post<BoatOwnerRevision>(this.url,revision);
  }
}
