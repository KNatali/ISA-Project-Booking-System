import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SpecificRevision } from '../model/specificRevision';
import { Observable } from 'rxjs';
import { CottageRevision } from '../model/cottageRevision';

@Injectable({
  providedIn: 'root'
})
export class CottageRevisionService {

  url="http://localhost:8090/api/client/makeNewCottageRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<CottageRevision>{
    return this.http.post<CottageRevision>(this.url,revision);
  }
}
