import { RegistrationRequest } from './../model/registrationRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    url = "http://localhost:8090/api/user/all"
    whoami_url = "http://localhost:8090/api/getLoggedIn";
    async_url = "http://localhost:8090/api/signup/async";
    sync_url = "http://localhost:8090/api/signup/sync";
    registrationUrl = "http://localhost:8090/api/register";
    constructor(
        private http: HttpClient
    ) {
    }

    getLoggedInUser() {
        return this.http.get<User>(this.whoami_url);
    }
    getAllUsers(): Observable<User[]> {
        return this.http.get<User[]>(`${this.url}`);
    }



    sendEmail(newUser: User): Observable<User> {
        return this.http.post<User>(this.async_url, newUser);
    }

    registerUser(newUser: RegistrationRequest): Observable<RegistrationRequest> {
        return this.http.post<RegistrationRequest>(this.registrationUrl, newUser);
    }

}