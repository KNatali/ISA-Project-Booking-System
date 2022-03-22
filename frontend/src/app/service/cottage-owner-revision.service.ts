import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CottageOwnerRevision } from '../model/cottageOwnerRevison';
import { SpecificRevision } from '../model/specificRevision';

@Injectable({
  providedIn: 'root'
})
export class CottageOwnerRevisionService {

  url="http://localhost:8090/api/client/makeNewCottageOwnerRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<CottageOwnerRevision>{
    return this.http.post<CottageOwnerRevision>(this.url,revision);
  }
}
