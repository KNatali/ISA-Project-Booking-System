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
  urlCottage1 = "http://localhost:8090/api/cottageOwner/cottage/cottageAdditionalItem";
  urlBoat = "http://localhost:8090/api/boatOwner/boat";
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
    return this.http.post<AdditionalItem>(`${this.urlCottage}/` + `cottageAdditionalItem` + `/${id}`, data);
  }
  updateCottageAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlCottage}/` + `cottageAdditionalItemEdit` + `/${id}`, data);
  }
  deleteCottageAdditionalItem(cottageId: number, additionalItemId: number): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlCottage1}/${cottageId}/${additionalItemId}`, null);
  }

  saveBoatAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlBoat}/` + `additionalItem` + `/${id}`, data);
  }
  updateBoatAdditionalItem(id: number, data: AdditionalItem): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlBoat}/` + `additionalItemEdit` + `/${id}`, data);
  }
  deleteBoatAdditionalItem(boatId: number, additionalItemId: number): Observable<AdditionalItem> {
    return this.http.post<AdditionalItem>(`${this.urlBoat}/${boatId}/${additionalItemId}`, null);
  }
}
