import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AdditionalItem, AdditionalItemInterface } from '../model/additionalItem';
import { Boat } from '../model/boat';
import { BoatReservation } from '../model/boat-reservation';
import { BoatBehavioralRules } from '../model/boatBehavioralRules';
import { BoatFastReservation } from '../model/boatFastReservation';
import { BoatRevision } from '../model/boatRevision';
import { NavigationEquipment } from '../model/navigationEquipment';
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { SearchAvailableBoatByPriceOrGrade } from '../model/searchAvailableBoatByGradeOrPrice';
import { SearchForReservation } from '../model/searchForReservation';
import { TimePeriod } from '../model/timePeriod';
import { UnsubscribedItem } from '../model/unsubscribedItem';

@Injectable({
  providedIn: 'root'
})
export class BoatService {
  urlBoats = environment.url+"boats";
  urlAdditionalItem = environment.url+"additional-items";
  urlBoat1 = environment.url+"boatOwners/boats";
  urlBoat = environment.url+"boatOwner/boat";
  urlSearchBoat = environment.url+"client/allAvailableBoats";

  constructor(private http: HttpClient) { }

  getBoats(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats);
  }
  getSubscribedBoats(id: number): Observable<Boat[]> {
    return this.http.get<Boat[]>(`${this.urlBoats}` + `/subscribed` + `/${id}`);
  }
  unsubscribe(obj: UnsubscribedItem): Observable<void> {
    return this.http.post<void>(this.urlBoats + "/unsubscribed", obj);
  }
  subscribe(obj: UnsubscribedItem): Observable<void> {
    return this.http.post<void>(this.urlBoats + "/subscribed", obj);
  }
  getBoat(id: number): Observable<Boat> {
    return this.http.get<Boat>(`${this.urlBoats}/${id}`);
  }
  findBoatByMotorNumber(motorNumber: number): Observable<Boat[]> {
    const params: HttpParams = new HttpParams().append('motorNumber', motorNumber);
    return this.http.get<Boat[]>(this.urlBoats, { params });
  }
  findBoatByMotorPower(motorPower: number): Observable<Boat[]> {
    const params: HttpParams = new HttpParams().append('motorPower', motorPower);
    return this.http.get<Boat[]>(this.urlBoats, { params });
  }
  findBoatByMotorPowerAndMotorNumber(motorPower: number, motorNumber: number): Observable<Boat[]> {

    const params = new HttpParams()
      .set('motorPower', motorPower)
      .set('motorNumber', motorNumber);
    return this.http.get<Boat[]>(this.urlBoats, { params });
  }
  sortByName(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats + "/sort-by-name");
  }
  sortByGrade(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats + "/sort-by-grade");
  }
  sortByGradeAvailableBoat(obj: Boat[]): Observable<Boat[]> {
    return this.http.post<Boat[]>(this.urlBoats + "/sort-by-grade", obj);
  }
  sortByPriceAvailableBoat(obj: Boat[]): Observable<Boat[]> {
    return this.http.post<Boat[]>(this.urlBoats + "/sort-by-price", obj);
  }
  sortByCity(): Observable<Boat[]> {
    return this.http.get<Boat[]>(this.urlBoats + "/sort-by-city");
  }
  findAllAdditionalItems(): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(this.urlAdditionalItem);
  }
  findByName(name: string): Observable<Boat[]> {
    const params: HttpParams = new HttpParams().append('name', name);
    return this.http.get<Boat[]>(this.urlBoats, { params });
  }
  findByCity(city: string): Observable<Boat[]> {
    const params: HttpParams = new HttpParams().append('city', city);
    return this.http.get<Boat[]>(this.urlBoats, { params });
  }
  deleteBoat(id: number) {
    return this.http.delete(`${this.urlBoats}/` + `delete` + `/${id}`);
  }
  getBoatReservations(id: number): Observable<BoatReservation[]> {
    return this.http.get<BoatReservation[]>(`${this.urlBoat}/` + `reservations` + `/${id}`);
  }

  getBoatFastReservations(id: number): Observable<BoatFastReservation[]> {
    return this.http.get<BoatFastReservation[]>(`${this.urlBoat}/` + `fastReservations` + `/${id}`);
  }
  getBehavioralRules(id: number): Observable<BoatBehavioralRules[]> {
    return this.http.get<BoatBehavioralRules[]>(`${this.urlBoat}/` + `boatRules` + `/${id}`);
  }
  getAdditionalItems(id: number): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(`${this.urlBoat}/` + `additionalItems` + `/${id}`);
  }
  getNavigationEquipment(id: number): Observable<NavigationEquipment[]> {
    return this.http.get<NavigationEquipment[]>(`${this.urlBoat}/` + `equipment` + `/${id}`);
  }
  updateBoat(id: number, data: Boat): Observable<Boat> {
    return this.http.post<Boat>(`${this.urlBoat}/${id}`, data);
  }
  getBoatAdditionalItems(id: number): Observable<AdditionalItem[]> {
    return this.http.get<AdditionalItem[]>(`${this.urlBoat}/` + `additionalItems` + `/${id}`);
  }
  addBoat(id: number, newBoat: Boat): Observable<Boat> {
    return this.http.put<Boat>(`${this.urlBoats}/` + `add` + `/${id}`, newBoat);
  }
  getUnavailabilityByBoat(id: number): Observable<TimePeriod[]> {
    return this.http.get<TimePeriod[]>(`${this.urlBoats}/` + `getUnavailability` + `/${id}`);
  }
  setUnavailability(period: TimePeriod, id: number) {
    return this.http.post<TimePeriod>(`${this.urlBoats}/` + `setUnavailability` + `/${id}`, period);
  }
  searchBoatsForReservation(obj: SearchForReservation): Observable<Boat[]> {
    return this.http.post<Boat[]>(`${this.urlBoats}/` + `allAvailableBoats`, obj);
  }
  findByGradeAvailable(obj: SearchAvailableBoatByPriceOrGrade): Observable<Boat[]> {
    return this.http.post<Boat[]>(this.urlBoats + "/find-available-by-grade", obj);
  }
  findByPriceAvailable(obj: SearchAvailableBoatByPriceOrGrade): Observable<Boat[]> {
    return this.http.post<Boat[]>(this.urlBoats + "/find-available-by-price", obj);
  }
  getAllBoatRevisionsByBoat(id: number): Observable<BoatRevision[]> {
    return this.http.get<BoatRevision[]>(`${this.urlBoat}/allBoatRevisionsByBoat` + `/${id}`);
  }
}
