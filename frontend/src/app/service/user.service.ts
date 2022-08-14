import { RegistrationRequest } from './../model/registrationRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';
import { User } from '../model/user';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    url = environment.url+"user/all"
    whoami_url = environment.url+"getLoggedIn";
    async_url =environment.url+"signup/async";
    sync_url = environment.url+"signup/sync";
    registrationUrl = environment.url+"register";
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