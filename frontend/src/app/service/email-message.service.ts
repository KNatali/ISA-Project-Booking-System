import { RegistrationRequest } from './../model/registrationRequest';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';
import { User } from '../model/user';
import { EmailMessage } from '../model/emailMessage';
import { environment } from 'src/environments/environment';

@Injectable({
    providedIn: 'root'
})
export class EmailMessageService {

    adminMessages = environment.url+"admin/message";
    constructor(
        private http: HttpClient
    ) {
    }




    sendRegistrationRejectMessage(reject: EmailMessage) {
        return this.http.post<User>(this.adminMessages + "/registrationReject", reject);
    }



}