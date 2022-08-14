import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { BoatOwnerRevision } from '../model/boatOwnerRevision';
import { SpecificRevision } from '../model/specificRevision';

@Injectable({
  providedIn: 'root'
})
export class BoatOwnerRevisionService {
  url=environment.url+"client/makeNewBoatOwnerRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<BoatOwnerRevision>{
    return this.http.post<BoatOwnerRevision>(this.url,revision);
  }
}
