import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { NavigationEquipment } from '../model/navigationEquipment';

@Injectable({
  providedIn: 'root'
})
export class NavigationEquipmentService {
  urlBoat = "http://localhost:8090/api/boatOwner/boat";
  constructor(private http: HttpClient) { }
  saveBoatNavigationEquipment(id: number, data: NavigationEquipment): Observable<NavigationEquipment> {
    return this.http.post<NavigationEquipment>(`${this.urlBoat}/` + `equipment` + `/${id}`, data);
  }
  updateBoatNavigationEquipment(id: number, data: NavigationEquipment): Observable<NavigationEquipment> {
    return this.http.post<NavigationEquipment>(`${this.urlBoat}/` + `equipmentEdit` + `/${id}`, data);
  }
  deleteBoatNavigationEquipment(boatId: number, equipmentId: number): Observable<NavigationEquipment> {
    return this.http.post<NavigationEquipment>(`${this.urlBoat}/` + `equipment` + `${boatId}/${equipmentId}`, null);
  }
}
