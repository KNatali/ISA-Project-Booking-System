import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Revision } from '../model/revision';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class RevisionService {
  url=environment.url+"revision";

  constructor(private http:HttpClient) { }

  save(newRevision:Revision):Observable<Revision>{
    return this.http.post<Revision>(this.url,newRevision);
  }

}
