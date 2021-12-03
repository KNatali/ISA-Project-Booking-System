import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';
import { User } from '../model/user';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    currentUser: any;
    whoami_url = "http://localhost:8090/api/getLoggedIn";
    async_url="http://localhost:8090/api/signup/async";
    sync_url="http://localhost:8090/api/signup/sync";
    sign_up_url="http://localhost:8090/auth/signup";
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
     sendEmail(newUser:User):Observable<User>{
        return this.http.post<User>(this.async_url,newUser);
     }
     signUp(newUser:User):Observable<User>{
        return this.http.post<User>(this.sign_up_url,newUser);
     }
}