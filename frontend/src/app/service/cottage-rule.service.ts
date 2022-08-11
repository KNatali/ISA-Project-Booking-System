import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { CottageBehavioralRules } from '../model/cottageBehavioralRules';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CottageRuleService {
  urlCottage = "http://localhost:8090/api/cottageOwner/cottage";
  constructor(private http: HttpClient) { }


  saveCottageRule(id: number, data: CottageBehavioralRules): Observable<CottageBehavioralRules> {
    return this.http.post<CottageBehavioralRules>(`${this.urlCottage}/` + `cottageRule` + `/${id}`, data);
  }
  updateCottageRule(id: number, data: CottageBehavioralRules): Observable<CottageBehavioralRules> {
    return this.http.post<CottageBehavioralRules>(`${this.urlCottage}/` + `cottageRuleEdit` + `/${id}`, data);
  }
  deleteCottageRule(cottageId: number, ruleId: number): Observable<CottageBehavioralRules> {
    return this.http.post<CottageBehavioralRules>(`${this.urlCottage}/${cottageId}/${ruleId}`, null);
  }
}
