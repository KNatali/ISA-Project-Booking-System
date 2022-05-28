import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';

@Injectable({
  providedIn: 'root'
})
export class BoatRuleService {
  urlBoat = "http://localhost:8090/api/boatOwner/boat";
  constructor(private http: HttpClient) { }


  saveBoatRule(id: number, data: BoatBehavioralRules): Observable<BoatBehavioralRules> {
    return this.http.post<BoatBehavioralRules>(`${this.urlBoat}/` + `boatRule` + `/${id}`, data);
  }
  updateBoatRule(id: number, data: BoatBehavioralRules): Observable<BoatBehavioralRules> {
    return this.http.post<BoatBehavioralRules>(`${this.urlBoat}/` + `boatRuleEdit` + `/${id}`, data);
  }
  deleteBoatRule(boatId: number, ruleId: number): Observable<BoatBehavioralRules> {
    return this.http.post<BoatBehavioralRules>(`${this.urlBoat}/${boatId}/${ruleId}`, null);
  }
}
