import { RegistrationRequest } from './../model/registrationRequest';
import { AdventureReservation } from './../model/AdventureReservation';
import { HttpClient, HttpClientModule, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Adventure } from '../model/adventure';
import { Instructor } from '../model/instructor';
import { Client } from '../model/client';
import { AdventureFastReservation } from '../model/adventureFastReservation';
import { Admin } from '../model/admin';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
})
export class AdminService {
    urlAdmin = "http://localhost:8090/api/admin";


    constructor(private http: HttpClient) { }
    getAdmins(): Observable<Admin[]> {
        return this.http.get<Admin[]>(this.urlAdmin);
    }
    getAllUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.urlAdmin}/allUsers`);
    }

    deleteUser(id: number) {
        return this.http.delete(`${this.urlAdmin}/` + `deleteUser` + `/${id}`);

    }

    addNewAdmin(newAdmin: User): Observable<User> {
        return this.http.post<User>(`${this.urlAdmin}/addAdmin`, newAdmin);
    }

    getById(id: number): Observable<Admin> {
        return this.http.get<Admin>(`${this.urlAdmin}/${id}`);
    }

    updateAdmin(id: number, editedAdmin: Admin): Observable<Admin> {
        return this.http.put<Admin>(`${this.urlAdmin}/${id}`, editedAdmin);
    }

    changePassword(id: number, newPassword: string): Observable<Admin> {
        return this.http.post<Admin>(`${this.urlAdmin}/` + `changePassword` + `/${id}`, { newPassword });
    }
    getAllRegistrationRequests(): Observable<RegistrationRequest[]> {
        return this.http.get<RegistrationRequest[]>(`${this.urlAdmin}/allRegistrationRequests`);
    }

    acceptRegistrationRequest(request: RegistrationRequest): Observable<User> {
        return this.http.put<User>(`${this.urlAdmin}/acceptRequest`, request);
    }

}
