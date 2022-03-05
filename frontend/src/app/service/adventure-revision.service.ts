import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Revision } from '../model/revision';
import { AdventureRevision } from '../model/adventureRevision';
import { AdventureReservation } from '../model/AdventureReservation';
import { SpecificRevision } from '../model/specificRevision';

@Injectable({
  providedIn: 'root'
})
export class AdventureRevisionService {

  url="http://localhost:8090/api/client/makeNewAdventureRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<AdventureRevision>{
    return this.http.post<AdventureRevision>(this.url,revision);
  }
}
