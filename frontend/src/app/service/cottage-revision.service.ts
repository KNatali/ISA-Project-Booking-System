import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SpecificRevision } from '../model/specificRevision';
import { Observable } from 'rxjs';
import { CottageRevision } from '../model/cottageRevision';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CottageRevisionService {

  url=environment.url+"client/makeNewCottageRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<CottageRevision>{
    return this.http.post<CottageRevision>(this.url,revision);
  }
}
