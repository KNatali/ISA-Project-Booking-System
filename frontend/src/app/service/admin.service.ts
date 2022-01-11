import { AdventureRevision } from './../model/adventureRevision';
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
import { ProfileDeleteRequest } from '../model/profileDeleteRequest';
import { InstructorReport } from '../model/instructorReport';
import { SystemEarnings } from '../model/systemEarnings';
import { AdventureComplaint } from '../model/adventureComplaint';

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

    getPercentage(): Observable<SystemEarnings> {
        return this.http.get<SystemEarnings>(`${this.urlAdmin}/` + `getPercentage`);
    }
    setPercentage(percentage: SystemEarnings) {
        return this.http.post(`${this.urlAdmin}/` + `setPercentage`, percentage);
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
        return this.http.put<User>(`${this.urlAdmin}/acceptRegistrationRequest`, request);
    }
    rejectRegistrationRequest(request: RegistrationRequest): Observable<User> {
        return this.http.put<User>(`${this.urlAdmin}/rejectRegistrationRequest`, request);
    }
    getAllProfileDeleteRequests(): Observable<ProfileDeleteRequest[]> {
        return this.http.get<ProfileDeleteRequest[]>(`${this.urlAdmin}/allProfileDeleteRequests`);
    }
    acceptProfileDeleteRequests(request: ProfileDeleteRequest): Observable<User> {
        return this.http.put<User>(`${this.urlAdmin}/acceptProfileDeleteRequest`, request);
    }
    rejectProfileDeleteRequests(request: ProfileDeleteRequest, message: string): Observable<User> {
        const params: HttpParams = new HttpParams().append('message', message);
        return this.http.put<User>(`${this.urlAdmin}/rejectProfileDeleteRequest`, request, { params });
    }

    getAllReservationRrports(): Observable<InstructorReport[]> {
        return this.http.get<InstructorReport[]>(`${this.urlAdmin}/allReservationReports`);
    }
    acceptReservationReport(report: InstructorReport) {
        return this.http.put(`${this.urlAdmin}/acceptInstructorReport`, report);
    }
    rejectReservationReport(report: InstructorReport) {
        return this.http.put(`${this.urlAdmin}/rejectInstructorReport`, report);
    }
    getAllAdventureComplaints(): Observable<AdventureComplaint[]> {
        return this.http.get<AdventureComplaint[]>(`${this.urlAdmin}/getAdventureComplaints`);
    }
    answerComplaint(complaint: AdventureComplaint, message: string) {
        const params: HttpParams = new HttpParams().append('message', message);
        return this.http.post(`${this.urlAdmin}/answerComplaint`, complaint, { params });
    }
    getAllAdventureRevisions(): Observable<AdventureRevision[]> {
        return this.http.get<AdventureRevision[]>(`${this.urlAdmin}/allAdventureRevisions`);
    }
    acceptAdventureResvision(revision: AdventureRevision) {
        return this.http.post(`${this.urlAdmin}/acceptAdventureRevision`, revision);
    }
    rejectAdventureResvision(revision: AdventureRevision) {
        return this.http.post(`${this.urlAdmin}/rejectAdventureRevision`, revision);
    }

}
