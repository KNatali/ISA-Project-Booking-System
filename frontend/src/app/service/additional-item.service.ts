import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdditionalItem } from '../model/additionalItem';

@Injectable({
  providedIn: 'root'
})
export class AdditionalItemService {
  urlAdventure = "http://localhost:8090/api/instructor/adventure";
  urlCottage = "http://localhost:8090/api/cottageOwner/cottage";
  constructor(private http: HttpClient) { }

  saveAdventureAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlAdventure}/` + `additionalItem` + `/${id}`, data);
  }
  updateAdvenutureAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlAdventure}/` + `additionalItemEdit` + `/${id}`, data);
  }
  deleteAdventureAdditionalItem(adventureId: number, additionalItemId: number): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlAdventure}/${adventureId}/${additionalItemId}`, null);
  }

  saveCottageAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlCottage}/` + `additionalItem` + `/${id}`, data);
  }
  updateCottageAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlCottage}/` + `additionalItemEdit` + `/${id}`, data);
  }
  deleteCottageAdditionalItem(cottageId: number, additionalItemId: number): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlCottage}/${cottageId}/${additionalItemId}`, null);
  }
}
