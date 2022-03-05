import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Revision } from '../model/revision';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RevisionService {
  url="http://localhost:8090/api/revision";

  constructor(private http:HttpClient) { }

  save(newRevision:Revision):Observable<Revision>{
    return this.http.post<Revision>(this.url,newRevision);
  }

}
