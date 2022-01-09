import { TimePeriod } from './../model/timePeriod';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AdventureReservation } from '../model/AdventureReservation';
import { CottageReservation } from '../model/cottageReservation';

@Injectable({
    providedIn: 'root'
})
export class AnalyticsService {
    private baseUrl = 'http://localhost:8090/api';

    constructor(private http: HttpClient) { }

    getAdventurePeriodEarnings(period: TimePeriod): Observable<Number> {
        return this.http.post<Number>(`${this.baseUrl}/` + `adventureReservation/periodEarnings`, period);
    }
    getInstructorEarnings(period: TimePeriod, id: number): Observable<Number> {
        return this.http.post<Number>(`${this.baseUrl}/` + `adventureReservation/instructorEarnings/${id}`, period);
    }
    getInstructorAverageGrade(id: number): Observable<Number> {
        return this.http.get<Number>(`${this.baseUrl}/` + `instructor/averageGrade/${id}`);
    }
    getInstructorReservations(id: number): Observable<AdventureReservation[]> {
        return this.http.get<AdventureReservation[]>(`${this.baseUrl}/` + `instructor/reservations/${id}`);
    }
    getCottageOwnerReservations(id: number): Observable<CottageReservation[]> {
        return this.http.get<CottageReservation[]>(`${this.baseUrl}/` + `cottageOwner/reservations/${id}`);
    }
    getCottageOwnerAverageGrade(id: number): Observable<Number> {
        return this.http.get<Number>(`${this.baseUrl}/` + `cottageOwner/averageGrade/${id}`);
    }
    getCottageOwnerEarnings(period: TimePeriod, id: number): Observable<Number> {
        return this.http.post<Number>(`${this.baseUrl}/` + `cottageReservation/cottageOwnerEarnings/${id}`, period);
    }
}
