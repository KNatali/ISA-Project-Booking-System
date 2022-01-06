import { TimePeriod } from './../model/timePeriod';
import { HttpClient, HttpEvent, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class AnalyticsService {
    private baseUrl = 'http://localhost:8090/api';

    constructor(private http: HttpClient) { }

    getAdventurePeriodEarnings(period: TimePeriod): Observable<Number> {
        return this.http.post<Number>(`${this.baseUrl}/` + `adventureReservation/periodEarnings`, period);
    }
}
