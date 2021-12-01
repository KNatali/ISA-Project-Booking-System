import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { map } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    currentUser: any;
    whoami_url = "http://localhost:8090/api/getLoggedIn";
    constructor(
        private http: HttpClient
    ) {
    }

    getLoggedInUser() {
        return this.http.get<User>(this.whoami_url);
    }/*
 
     getAll() {
         return this.apiService.get(this.config.users_url);
     }
 */
}