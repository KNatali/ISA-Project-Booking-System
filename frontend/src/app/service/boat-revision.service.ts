import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SpecificRevision } from '../model/specificRevision';
import { Observable } from 'rxjs';
import { BoatRevision } from '../model/boatRevision';

@Injectable({
  providedIn: 'root'
})
export class BoatRevisionService {

  url="http://localhost:8090/api/client/makeNewBoatRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<BoatRevision>{
    return this.http.post<BoatRevision>(this.url,revision);
  }
}
