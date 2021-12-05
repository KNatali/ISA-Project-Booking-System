import { AdventureBehavioralRules } from './../model/adventureBehavioralRules';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdventureRuleService {
  urlAdventure = "http://localhost:8090/api/instructor/adventure";
  constructor(private http: HttpClient) { }


  saveAdventureRule(id: number, data: AdventureBehavioralRules): Observable<AdventureBehavioralRules> {
    return this.http.post<AdventureBehavioralRules>(`${this.urlAdventure}/` + `rule` + `/${id}`, data);
  }
  updateAdvenutureRule(id: number, data: AdventureBehavioralRules): Observable<AdventureBehavioralRules> {
    return this.http.post<AdventureBehavioralRules>(`${this.urlAdventure}/` + `ruleEdit` + `/${id}`, data);
  }
  deleteAdventureRule(adventureId: number, ruleId: number): Observable<AdventureBehavioralRules> {
    return this.http.post<AdventureBehavioralRules>(`${this.urlAdventure}/${adventureId}/${ruleId}`, null);
  }
}
