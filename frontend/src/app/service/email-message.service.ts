import { RegistrationRequest } from './../model/registrationRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';
import { User } from '../model/user';
import { EmailMessage } from '../model/emailMessage';

@Injectable({
    providedIn: 'root'
})
export class EmailMessageService {

    adminMessages = "http://localhost:8090/api/admin/message";
    constructor(
        private http: HttpClient
    ) {
    }




    sendRegistrationRejectMessage(reject: EmailMessage) {
        return this.http.post<User>(this.adminMessages + "/registrationReject", reject);
    }



}