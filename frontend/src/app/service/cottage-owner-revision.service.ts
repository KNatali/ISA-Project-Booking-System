import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { CottageOwnerRevision } from '../model/cottageOwnerRevison';
import { SpecificRevision } from '../model/specificRevision';

@Injectable({
  providedIn: 'root'
})
export class CottageOwnerRevisionService {

  url=environment.url+"client/makeNewCottageOwnerRevision";

  constructor(private http:HttpClient) { }

  save(revision:SpecificRevision):Observable<CottageOwnerRevision>{
    return this.http.post<CottageOwnerRevision>(this.url,revision);
  }
}
